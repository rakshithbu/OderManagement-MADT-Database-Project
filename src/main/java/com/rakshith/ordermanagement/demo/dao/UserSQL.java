/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.dao;

import com.rakshith.ordermanagement.demo.domain.User;
import com.rakshith.ordermanagement.demo.domain.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSQL {


    public String insertIntoUsers(User user) {

        try {
            String query = "INSERT INTO users (user_name, " +
                    "user_age, user_address, user_contact_number, user_email, user_password)" +
                    " VALUES (?,?,?,?,?,?);";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = DatabaseConnect.getConnection().
                    prepareStatement(query);
            preparedStmt.setString(1, user.getUserName());
            preparedStmt.setInt(2, user.getAge());
            preparedStmt.setString(3, user.getAddress());
            preparedStmt.setInt(4, user.getContactNumber());
            preparedStmt.setString(5, user.getEmail());
            preparedStmt.setString(6, user.getPassword());
            preparedStmt.execute();
            return "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }

    }

    public String checkLogin(String userName, String password) {
        System.out.println(userName);
        System.out.println(password);
        String result = null;
        int isManager = 0;
        try {
            String query = "SELECT is_manager FROM users WHERE user_email =? and  user_password=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStatement = DatabaseConnect.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                result = "no user";
            } else {

                while (resultSet.next()) {
                    isManager = resultSet.getInt(1);
                }
                if (isManager == 0) {
                    result = "customer login";
                } else {
                    result = "manager login";
                }

            }

            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }

}
