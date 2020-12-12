package yuhnim.server;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String DB_URL = "jdbc:mysql://localhost:3306/software-licence";
    private static String USER_NAME = "root";
    private static String PASSWORD = "madafakas";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            throw new RuntimeException("connect failure!", ex);
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}