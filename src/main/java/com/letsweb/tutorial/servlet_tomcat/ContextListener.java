package com.letsweb.tutorial.servlet_tomcat;

import biz.letsweb.research.dblink.DataSourceProviderH2;
import biz.letsweb.research.dblink.DataSourceable;
import biz.letsweb.research.dblink.SqlExecutor;
import biz.letsweb.research.dblink.SqlFileLineReader;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener()
public class ContextListener implements ServletContextListener {

    final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        initialiseDataBase(sce);
        logger.debug("Context initialised {}", context.getEffectiveMajorVersion());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("Context destroyed.");
    }

    private void initialiseDataBase(ServletContextEvent sce) {
        final ServletContext context = sce.getServletContext();
        final String sqlFilePath = context.getInitParameter("sqlFilePath");
        final String dbConnectionUrl = context.getInitParameter("dbConnectionUrl");
        final String dbUsername = context.getInitParameter("dbUsername");
        final String dbPassword = context.getInitParameter("dbPassword");
        final DataSourceable dataSourceable = new DataSourceProviderH2(dbConnectionUrl, dbUsername, dbPassword);
        final SqlFileLineReader fileLineReader = new SqlFileLineReader(context.getRealPath(sqlFilePath));
        final int[] createLines = new int[]{2, 6};
        final int[] insertLines = new int[]{3, 4, 5, 7};
        final ReadSqlResult loadCreateLinesResult = readSql(fileLineReader, createLines);
        final ReadSqlResult loadInsertLinesResult = readSql(fileLineReader, insertLines);
        final SqlExecutor sqlExecutor = new SqlExecutor(dataSourceable.getDataSource());
        if (loadCreateLinesResult.read && loadInsertLinesResult.read && runSql(sqlExecutor, loadCreateLinesResult.sqlLines, SqlPurpose.CREATE) && runSql(sqlExecutor, loadInsertLinesResult.sqlLines,SqlPurpose.LOAD)) {
            logger.info("Created and loaded database: {}", dbConnectionUrl);
        }
    }

    private ReadSqlResult readSql(SqlFileLineReader sqlFileLineReader, int[] lineNumbers) {
        final ReadSqlResult result = new ReadSqlResult();
        result.read = true;
        try {
            result.sqlLines = sqlFileLineReader.readLines(lineNumbers);
        } catch (IOException ex) {
            logger.error("Error accessing database init files: {}", ex.getMessage());
            result.read = false;
        }
        return result;
    }

    private boolean runSql(SqlExecutor sqlExecutor, String[] sqlLines, SqlPurpose purpose) {
        boolean created = true;
        try {
            sqlExecutor.executeSql(sqlLines);
        } catch (SQLException | NamingException | IOException ex) {
            logger.warn("Executing {} SQL problem. Error: {}", purpose, ex.getMessage());
            created = false;
        }
        return created;
    }

    class ReadSqlResult {

        boolean read;
        String[] sqlLines;
    }

    enum SqlPurpose {

        CREATE, LOAD
    }
}
