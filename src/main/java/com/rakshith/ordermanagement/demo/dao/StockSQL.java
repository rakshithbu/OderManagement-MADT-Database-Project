/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.dao;

import com.mysql.cj.protocol.Resultset;
import com.rakshith.ordermanagement.demo.domain.Stocks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StockSQL {

    public ArrayList<Stocks> getAllStocks() {
        String query = "SELECT * FROM stocks";
        ArrayList<Stocks> stocks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    DatabaseConnect.getConnection().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Stocks stock = new Stocks();
                stock.setName(rs.getString("stock_name"));
                stock.setCost(rs.getInt("stock_cost"));
                stock.setIsInStock(rs.getInt("is_in_stock"));
                stock.setStockId(rs.getInt("stock_id"));
                stocks.add(stock);
            }
            return stocks;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String updateStockStatus(String stockName, String stockValue) {
        String result = null;
        System.out.println(stockName);
        System.out.println(stockValue);
        try {
            String query = "UPDATE stocks SET is_in_stock = ? WHERE stock_name = ?";
            PreparedStatement preparedStatement = DatabaseConnect.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(stockValue));
            preparedStatement.setString(2, stockName);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                result = "success";
            } else {
                result = "failure";
            }
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }
}
