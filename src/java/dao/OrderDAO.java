package dao;

import dto.OrderDTO;
import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.OrderModel;

public class OrderDAO {

    public static boolean create(OrderModel order) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "INSERT INTO `order` "
                + "(quantity, total, customer_id, pizza_id)"
                + " VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getQuantity());
            preparedStatement.setDouble(2, order.getTotal());
            preparedStatement.setInt(3, order.getCustomerID());
            preparedStatement.setInt(4, order.getPizzaID());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("POST error: " + e.getMessage());
            return false;
        }
    }

    public static ArrayList<OrderDTO> findAllByState(int state) throws SQLException {
        Connection connection = DBConnector.getConnection();

        ArrayList<OrderDTO> listDB = new ArrayList<>();
        String query = "SELECT o.order_id, c.full_name, p.`name`, o.quantity, o.total "
                + "FROM `order` o "
                + "JOIN customer c ON o.customer_id = c.customer_id "
                + "JOIN pizza p ON p.pizza_id = o.pizza_id "
                + "WHERE o.state = " + state + ";";

        try {
            ResultSet result = connection.createStatement().executeQuery(query);

            while (result.next()) {
                listDB.add(new OrderDTO(
                        result.getInt("order_id"),
                        result.getString("full_name"),
                        result.getString("name"),
                        result.getInt("quantity"),
                        result.getDouble("total"))
                );
            }

            return listDB;
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return null;
        } finally {
            DBConnector.closeConnection();
        }
    }

    public static void updateState(int id, int state) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "UPDATE `order` SET state = ? WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, state);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("UPDATE - UPDATED ");
            }
        } catch (SQLException e) {
            System.err.println("UPDATE - Error: " + e.getMessage());
        }
    }

    public static void updateAllState() throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "UPDATE `order` SET state = 3 WHERE state = 2";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("UPDATE - UPDATED ");
            }
        } catch (SQLException e) {
            System.err.println("UPDATE - Error: " + e.getMessage());
        }
    }
}
