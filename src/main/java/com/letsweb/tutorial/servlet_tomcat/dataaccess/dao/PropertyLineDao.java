package com.letsweb.tutorial.servlet_tomcat.dataaccess.dao;

import com.letsweb.tutorial.servlet_tomcat.dataaccess.model.PropertyLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class PropertyLineDao {

    public static final Logger logger = LoggerFactory.getLogger(PropertyLineDao.class);
    private DataSource ds;

    public PropertyLineDao() {
        try {
            Context initContext = new InitialContext();
            this.ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/h2/makumba");
        } catch (NamingException ex) {
            logger.error("{}", ex.getMessage());
        }
    }

    public PropertyLine findRecordByName(String name) {
        final PropertyLine line = new PropertyLine();
        ResultSet rs = null;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from property where name=?");) {
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                line.setId(rs.getInt("id"));
                line.setName(rs.getString("name"));
                line.setValue(rs.getString("value"));
                line.setInserted(rs.getTimestamp("inserted"));
            }
        } catch (SQLException ex) {
            logger.error("{}", ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                }
            }
        }
        return line;
    }

    public List<PropertyLine> findAllRecords() {
        final List<PropertyLine> recordLines = new ArrayList<>();
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from property");
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                final PropertyLine line = new PropertyLine();
                line.setId(rs.getInt("id"));
                line.setName(rs.getString("name"));
                line.setValue(rs.getString("value"));
                line.setInserted(rs.getTimestamp("inserted"));
                recordLines.add(line);
            }
        } catch (SQLException ex) {
        }
        return recordLines;
    }

    public int insertNewRecord(PropertyLine line) {
        int rowNr = 0;
        String sql = "insert into property (name, value) values (?, ?)";
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(2, line.getName());
            ps.setString(3, line.getValue());
            rowNr = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Application couldn't get a connection from the pool. ", ex);
        }
        return rowNr;
    }

    public int deleteRecord(PropertyLine recordLine) {
        int rowNr = 0;
        final int idToDelete = recordLine.getId();
        if (idToDelete == 0) {
            throw new RuntimeException("Unset id: " + idToDelete);
        }
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement("delete from chronicle where id = ?");) {
            ps.setInt(1, idToDelete);
            rowNr = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Application couldn't get a connection from the pool. ", ex);
        }
        return rowNr;
    }
}
