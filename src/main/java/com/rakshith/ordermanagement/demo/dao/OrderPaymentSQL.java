/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderPaymentSQL {

    public void placeOrder(String userName, String stockCost, String stockId) {
        try {
            String query = "INSERT INTO orders (order_date_time, " +
                    "order_placed_by, order_cost,stock_id)" +
                    " VALUES (now(),?,?,?);";

            PreparedStatement preparedStmt = DatabaseConnect.getConnection().
                    prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, getUserIdBasedOnUserEmailId(userName));
            preparedStmt.setInt(2, Integer.parseInt(stockCost));
            preparedStmt.setInt(3, Integer.parseInt(stockId));
            preparedStmt.execute();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            while (rs.next()) {
                insertIntoPayments(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getUserIdBasedOnUserEmailId(String emailId) {
        try {
            String query = "SELECT user_id FROM users WHERE user_email = ?;";
            PreparedStatement preparedStatement = DatabaseConnect.
                    getConnection().prepareStatement(query);
            preparedStatement.setString(1, emailId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public void insertIntoPayments(int orderId) {
        try {
            String query = "INSERT INTO payments (order_id, is_payment_success) VALUES (?,?);";

            PreparedStatement preparedStmt = DatabaseConnect.getConnection().
                    prepareStatement(query);
            preparedStmt.setInt(1, orderId);
            preparedStmt.setInt(2, 1);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
