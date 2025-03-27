package dao;

import db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;

public class UserDAO {

    public static boolean findUser(UserModel userModel) throws SQLException {

        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userModel.getUsername());
            statement.setString(2, userModel.getPassword());
            System.out.println(query);
            ResultSet result = statement.executeQuery();

            return result.next();
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return false;
        }
    }
}
