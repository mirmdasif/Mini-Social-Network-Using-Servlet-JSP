package com.hossain.asif.main.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by asif.hossain on 9/18/14.
 */
public class DatabaseConnectionPool {
    private static DataSource dataSource;
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;


    static {
        final ResourceBundle config = ResourceBundle.getBundle("db");
        DRIVER_NAME = config.getString("jdbc.driver");
        URL = config.getString("jdbc.url.address");
        USER_NAME = config.getString("db.user");
        PASSWORD = config.getString("db.password");



        try {
            dataSource = setUpDataSource();
        }
        catch (PropertyVetoException ex) {

            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    private static DataSource setUpDataSource() throws PropertyVetoException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(DRIVER_NAME);
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(USER_NAME);
        comboPooledDataSource.setPassword(PASSWORD);

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(20);
        return comboPooledDataSource;
    }
}
