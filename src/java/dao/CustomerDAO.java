package dao;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CustomerModel;

public class CustomerDAO {

    public static int findByDNI(int dni) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "SELECT customer_id FROM customer WHERE customer_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dni);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("customer_id");
            }

            return -1;
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return -1;
        }
    }

    public static void create(CustomerModel customer) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "INSERT INTO customer (dni, full_name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getDni());
            preparedStatement.setString(2, customer.getFullName());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("POST - CREATED");
            } else {
                System.out.println("POST - NOT CREATED");
            }
        } catch (SQLException e) {
            System.err.println("POST error: " + e.getMessage());
        }
    }

}
