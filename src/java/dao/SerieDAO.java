package dao;

import db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SerieDAO {

    public static int findQuantityByName(String name) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "SELECT quantity FROM serie WHERE `name` = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("quantity");
            }

            return -1;
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return -1;
        }
    }

    public static void updateQuantity(String name, int quantity) throws SQLException {
        Connection connection = DBConnector.getConnection();

        String query = "UPDATE serie SET quantity = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, name);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("UPDATE - UPDATED ");
            }
        } catch (SQLException e) {
            System.err.println("UPDATE - Error: " + e.getMessage());
        }
    }

}
