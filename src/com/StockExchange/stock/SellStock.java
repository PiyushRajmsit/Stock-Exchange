package com.StockExchange.stock;

import java.time.LocalDateTime;

public class SellStock extends Stock{

    private final StockType stockType = StockType.SELL;

    public SellStock(String localTime, String stockName, Integer quantity, Double totalPrice) {
        super(localTime, stockName, quantity, totalPrice);
    }

    public StockType getStockType() {
        return stockType;
    }

    public int compareTo(Stock sellStock){
        if(this.getTotalPrice().equals(sellStock.getTotalPrice())){
            return this.getLocalTime().compareTo(sellStock.getLocalTime());
        }
        return this.getTotalPrice().compareTo(sellStock.getTotalPrice());
    }

    @Override
    public String toString() {
        return "SellStock{" +
                "stockName=" + this.getStockName() + ", " +
                "LocalTime=" + this.getLocalTime() + ", " +
                "quantity=" + this.getQuantity() + ", " +
                "totalPrice=" + this.getTotalPrice() + ", " +
                "stockType=" + stockType + " " +
                '}';
    }
}
