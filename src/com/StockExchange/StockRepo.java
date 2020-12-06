package com.StockExchange;

import com.StockExchange.stock.BuyStock;
import com.StockExchange.stock.SellStock;
import com.StockExchange.stock.Stock;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class StockRepo {

    private static StockRepo stockRepoInstance;
    private Map<Long,SellStock> sellStockList;
    private Map<Long,BuyStock> buyStockRequest;

    private StockRepo() {
        sellStockList = new HashMap<>();
        buyStockRequest = new HashMap<>();
    }
    public static synchronized StockRepo getInstance() {
        if (stockRepoInstance == null) {
            stockRepoInstance = new StockRepo();
        }
        return stockRepoInstance;
    }

    public List<SellStock> getSellStockList() {
        List<SellStock> allStocks = new ArrayList<>(sellStockList.values());
        return allStocks;
    }

    public void addSellStock(SellStock stock){
        sellStockList.put(stock.getuId(),stock);
        System.out.println(stock.toString());
        System.out.println("Successfully Added");
    }

    public void successBuy(BuyStock buyStock,Long uId) {
        // Updating quantity
        buyStockRequest.put(buyStock.getuId(),buyStock);
        Integer currentQuantity = sellStockList.get(uId).getQuantity();
        Integer deductQuantity = buyStock.getQuantity();
        Integer newQuantity = currentQuantity - deductQuantity;
        if(newQuantity.equals(0)){
            sellStockList.remove(uId);
            return;
        }
        sellStockList.get(uId).setQuantity(currentQuantity-deductQuantity);
    }
    public List<SellStock> getSortedEligibleStock(String localTime, String stockName, Double price) {

        List<SellStock> eligibleStock = new ArrayList<>();
        LocalTime time = LocalTime.parse(localTime);
        for(SellStock s: sellStockList.values()){
            if(s.getStockName().equals(stockName) && s.getLocalTime().isBefore(time) && s.getTotalPrice().compareTo(price) == -1){
                eligibleStock.add(s);
            }
        }
        Collections.sort(eligibleStock, new Comparator<SellStock>() {
            @Override
            public int compare(SellStock o1, SellStock o2) {
                return o1.compareTo(o2);
            }
        });
        return eligibleStock;
    }
}
