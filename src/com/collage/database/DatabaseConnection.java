package com.collage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_URL = "jdbc:mysql://localhost/collage";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private Connection connection;
    private Statement statement;

    private static DatabaseConnection instance;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connection Created");
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return resultSet;
    }

    public int updateQuery(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Exception" + e);
            return 0;
        }
    }
}
