package dao;

import db.DBConnector;
import dto.TicketDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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

    public static ArrayList<TicketDTO> findAll() throws SQLException {
        Connection connection = DBConnector.getConnection();

        ArrayList<TicketDTO> listDB = new ArrayList<>();
        String query = "SELECT t.serie, c.full_name, c.dni, t.created_at, o.total "
                + "FROM ticket t "
                + "JOIN `order` o ON o.order_id = t.order_id "
                + "JOIN customer c ON o.customer_id = c.customer_id "
                + "WHERE t.state = 0;";

        try {
            ResultSet result = connection.createStatement().executeQuery(query);

            while (result.next()) {
                LocalDateTime createdAt = result.getTimestamp("created_at")
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                listDB.add(new TicketDTO(
                        result.getString("serie"),
                        result.getString("full_name"),
                        result.getString("dni"),
                        createdAt,
                        result.getDouble("total")
                ));
            }

            return listDB;
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return null;
        } finally {
            DBConnector.closeConnection();
        }
    }

    public static void updateAllState() throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "UPDATE ticket SET state = 1 WHERE state = 0";
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
