package dao;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.OrderModel;

public class OrderDAO {

    public static void create(OrderModel order) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "INSERT INTO order "
                + "(quantity, total, customer_id, pizza_id)"
                + " VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getOrderID());
            preparedStatement.setDouble(2, order.getTotal());
            preparedStatement.setInt(3, order.getCustomerID());
            preparedStatement.setInt(4, order.getPizzaID());

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
