package com.StockExchange.commands;

import com.StockExchange.StockRepo;
import com.StockExchange.exceptions.BadCommandException;
import com.StockExchange.stock.SellStock;

public class SellCommand implements ICommand {


    private static SellCommand sellCommandInstance;
    private StockRepo stockRepo;
    private SellCommand() {
        stockRepo = StockRepo.getInstance();
    }

    public static synchronized SellCommand getInstance() {
        if (sellCommandInstance == null) {
            sellCommandInstance = new SellCommand();
        }
        return sellCommandInstance;
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
        SellStock sellStock = new SellStock(localTime,stockName,quantity,price);
        stockRepo.addSellStock(sellStock);

    }
}
