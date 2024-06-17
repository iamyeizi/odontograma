package com.odontograma.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/odontograma";
    private static final String USER = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
    	
    	if (USER == null || PASSWORD == null) {
            throw new ExceptionInInitializerError("Database credentials are not set in environment variables.");
        }
    	
        try { 	
        	 Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        } 
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}