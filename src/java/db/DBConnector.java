package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection cn = null;
    public static String databaseURL = "jdbc:mysql://localhost:3306/pizzeriadb";
    public static String databaseUser = "root";
    public static String databasePassword = "root";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
            System.out.println("MYSQL: Successful connection");
        } catch (ClassNotFoundException e) {
            System.out.println("Error DB: " + e.getMessage());
        }
        return cn;
    }

    public static void closeConnection() {
        try {
            if (cn != null) {
                cn.close();
                System.out.println("MYSQL: Connection closed");
            }
        } catch (Exception e) {
            System.out.println("Error DB: Don't close. " + e.getMessage());
        }
    }
}
