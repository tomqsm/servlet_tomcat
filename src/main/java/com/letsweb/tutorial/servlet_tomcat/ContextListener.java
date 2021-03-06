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
import javax.sql.DataSource;
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

    /**
     * Creates and preloads database on start of application.
     *
     * @param sce
     * @return
     */
    private DataSource initialiseDataBase(ServletContextEvent sce) {
        final ServletContext context = sce.getServletContext();
        final String createSqlFilePath = getContextParameter(context, "createSqlFilePath");
        final String loadSqlFilePath = getContextParameter(context, "loadSqlFilePath");
        final String dbConnectionUrl = getContextParameter(context, "dbConnectionUrl");
        final String dbUsername = getContextParameter(context, "dbUsername");
        final String dbPassword = getContextParameter(context, "dbPassword");
        final DataSourceable dataSourceable = new DataSourceProviderH2(dbConnectionUrl, dbUsername, dbPassword);
        final SqlFileLineReader readerToCreateTables = new SqlFileLineReader(context.getRealPath(createSqlFilePath));
        final SqlFileLineReader readerToLoadTables = new SqlFileLineReader(context.getRealPath(loadSqlFilePath));
        final ReadSqlResult readCreateSql = readSql(readerToCreateTables);
        final ReadSqlResult readLoadSql = readSql(readerToLoadTables);
        final DataSource dataSource = dataSourceable.getDataSource();
        final SqlExecutor sqlExecutor = new SqlExecutor(dataSource);
        if (readCreateSql.read && readLoadSql.read && runSql(sqlExecutor, readCreateSql.sqlLines, SqlPurpose.CREATE) && runSql(sqlExecutor, readLoadSql.sqlLines, SqlPurpose.LOAD)) {
            logger.info("Created and loaded database: {}", dbConnectionUrl);
        }
        return dataSource;
    }

    private String getContextParameter(final ServletContext context, final String paramName) {
        String param = "";
        param = context.getInitParameter(paramName);
        return param;
    }

    /**
     * Reads specified line numbers from an sql file.
     *
     * @param sqlFileLineReader
     * @param lineNumbers
     * @return
     */
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

    /**
     * Reads all lines from an sql file.
     *
     * @param sqlFileLineReader
     * @return
     */
    private ReadSqlResult readSql(SqlFileLineReader sqlFileLineReader) {
        final ReadSqlResult result = new ReadSqlResult();
        result.read = true;
        try {
            result.sqlLines = sqlFileLineReader.readAllLines();
        } catch (IOException ex) {
            logger.error("Error accessing database init files: {}", ex.getMessage());
            result.read = false;
        }
        return result;
    }

    private boolean runSql(SqlExecutor sqlExecutor, String[] sqlLines, SqlPurpose purpose) {
        boolean created = true;
        sqlExecutor.executeSql(sqlLines);
        return created;
    }

    /**
     * Structure for holding result of reading of sql file lines.
     */
    private class ReadSqlResult {

        boolean read;
        String[] sqlLines;
    }

    /**
     * Marks the purpose of sql lines read for error logging.
     */
    private enum SqlPurpose {

        CREATE, LOAD
    }
}
