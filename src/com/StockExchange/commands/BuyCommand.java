package com.StockExchange.commands;

import com.StockExchange.StockRepo;
import com.StockExchange.exceptions.BadCommandException;
import com.StockExchange.stock.BuyStock;
import com.StockExchange.stock.SellStock;
import com.StockExchange.stock.Stock;

import java.util.List;

public class BuyCommand implements ICommand {


    private static BuyCommand buyCommandInstance;
    private StockRepo stockRepo;

    private BuyCommand() {
        stockRepo = StockRepo.getInstance();
    }

    public static synchronized BuyCommand getInstance() {
        if (buyCommandInstance == null) {
            buyCommandInstance = new BuyCommand();
        }
        return buyCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {
        if(cmd.length != 5){
            throw new BadCommandException("Bad Command");
        }
        String localTime = cmd[0];
        String stockName = cmd[1];
        Integer quantity = Integer.valueOf(cmd[3]);
        Double price = Double.valueOf(cmd[4]);
        List<SellStock> sortedEligibleStock = stockRepo.getSortedEligibleStock(localTime,stockName,price);
        Integer remainingStock = quantity;
        Integer index = 0;
        while(remainingStock > 0 && index < sortedEligibleStock.size()){
            Integer availableStock = Math.min(sortedEligibleStock.get(index).getQuantity(),remainingStock);
            BuyStock buyStock = new BuyStock(localTime,stockName,availableStock,sortedEligibleStock.get(index).getTotalPrice());
            stockRepo.successBuy(buyStock,sortedEligibleStock.get(index).getuId());
            index++;
            remainingStock = remainingStock - availableStock;
            System.out.println(buyStock.toString());
        }
        System.out.println("Buy Order Completed");
    }
}
