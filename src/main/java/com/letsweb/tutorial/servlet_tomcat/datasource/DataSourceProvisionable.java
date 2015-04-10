package com.letsweb.tutorial.servlet_tomcat.datasource;

import javax.sql.DataSource;

/**
 *
 * @author toks
 */
public interface DataSourceProvisionable {
    DataSource getDataSource();
}
