package dao;

import db.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import dto.PizzaDTO;
import model.PizzaModel;

public class PizzaDAO {

    public static ArrayList<PizzaModel> findAll() throws SQLException {
        Connection connection = DBConnector.getConnection();

        ArrayList<PizzaModel> listDB = new ArrayList<>();
        String query = "SELECT * FROM pizza";

        try {
            ResultSet result = connection.createStatement().executeQuery(query);

            while (result.next()) {
                listDB.add(new PizzaModel(
                        result.getInt("pizza_id"),
                        result.getString("name"),
                        result.getDouble("price")));
            }

            return listDB;
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return null;
        } finally {
            DBConnector.closeConnection();
        }
    }

    public static ArrayList<PizzaDTO> findQuantityPizza(int state) throws SQLException {
        Connection connection = DBConnector.getConnection();

        ArrayList<PizzaDTO> listDB = new ArrayList<>();
        String query = "SELECT p.`name`, count(p.`name`) as quantity "
                + "FROM `order` o "
                + "JOIN pizza p ON p.pizza_id = o.pizza_id "
                + "WHERE o.state = " + state + " "
                + "GROUP BY p.`name`;";

        try {
            ResultSet result = connection.createStatement().executeQuery(query);

            while (result.next()) {
                listDB.add(new PizzaDTO(result.getString("name"), result.getInt("quantity")));
            }

            return listDB;
        } catch (SQLException e) {
            System.out.println("GET error: " + e.getMessage());
            return null;
        } finally {
            DBConnector.closeConnection();
        }
    }
}
