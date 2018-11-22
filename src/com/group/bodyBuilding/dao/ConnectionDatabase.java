package com.group.bodyBuilding.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://127.0.0.1:3306/bodyBuilding";
    public static String USER = "root";
    public static String PASSWORD = "000000";
    public Connection conn;

    public ConnectionDatabase() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnnection() {
        return conn;
    }
}
