/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.domain;

public class Stocks {
    public String name;
    public int cost;
    public int isInStock;
    public int stockId;
    public int userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getIsInStock() {
        return isInStock;
    }

    public void setIsInStock(int isInStock) {
        this.isInStock = isInStock;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", isInStock=" + isInStock +
                ", stockId=" + stockId +
                ", userId=" + userId +
                '}';
    }
}
