package com.StockExchange.stock;

import com.StockExchange.DBObject;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Stock extends DBObject {

    private final LocalTime localTime;
    private final String stockName;
    private Integer quantity;
    private final Double totalPrice;

    public Stock(String localTime, String stockName, Integer quantity, Double totalPrice) {
        this.localTime = LocalTime.parse(localTime);
        this.stockName = stockName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public String getStockName() {
        return stockName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
