package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection connection = null;

    private static Connection connectToDB() throws SQLException, ClassNotFoundException {
        String databaseURL = "jdbc:mysql://localhost:3306/pizzeriadb";
        String databaseUser = "root";
        String databasePassword = "root";

        connection = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
        System.out.println("Successful connection");
        String databaseName = connection.getMetaData().getDatabaseProductName();
        String databaseVersion = connection.getMetaData().getDatabaseProductVersion();
        System.out.println(databaseName + " " + databaseVersion);
        return connection;
    }

    public static Connection getConnection() {
        return DBConnector.getConnection();
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
