package dao;

import db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.TicketModel;

public class TicketDAO {

    public static boolean create(TicketModel order) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "INSERT INTO ticket (serie, order_id) VALUES (?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, order.getSerie());
            preparedStatement.setInt(2, order.getOrderID());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("POST error: " + e.getMessage());
            return false;
        }
    }
}
