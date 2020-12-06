package com.StockExchange.stock;

import java.time.LocalDateTime;

public class BuyStock extends Stock {

    private final StockType stockType = StockType.BUY;
    public BuyStock(String localTime, String stockName, Integer quantity, Double totalPrice) {
        super(localTime, stockName, quantity, totalPrice);
    }
    public StockType getStockType() {
        return stockType;
    }


    @Override
    public String toString() {
        return "BuyStock{" +
                "stockName=" + this.getStockName() +  ", " +
                "LocalTime=" + this.getLocalTime() +  ", " +
                "quantity=" + this.getQuantity() +  ", " +
                "totalPrice=" + this.getTotalPrice()+  ", " +
                '}';
    }
}
