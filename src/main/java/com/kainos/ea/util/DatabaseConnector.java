package com.kainos.ea.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnector {
    private static Connection conn;

    public static Connection getConnection() throws IOException {
        String user;
        String password;
        String host;

        FileInputStream propsStream = new FileInputStream("employeesdb.properties");

        Properties props = new Properties();
        props.load(propsStream);

        user            = props.getProperty("user");
        password        = props.getProperty("password");
        host            = props.getProperty("host");

        if (user == null || password == null || host == null)
            throw new IllegalArgumentException(
                    "Properties file must exist and must contain "
                            + "user, password, and host properties.");
        if (conn != null) {
            return conn;
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/JavaProjectG_KewinA?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
