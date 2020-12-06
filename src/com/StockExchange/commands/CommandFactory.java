package com.StockExchange.commands;

import com.StockExchange.exceptions.BadCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements ICommand{


    private static CommandFactory commandFactoryInstance;
    private Map<String,ICommand> commandMap;

    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("Sell",SellCommand.getInstance());
        commandMap.put("Buy",BuyCommand.getInstance());
    }

    public static synchronized CommandFactory getInstance() {
        if (commandFactoryInstance == null) {
            commandFactoryInstance = new CommandFactory();
        }
        return commandFactoryInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {
        if(!commandMap.containsKey(cmd[2])) {
            throw new BadCommandException("InCorrect/Illegal Command ->" + cmd[2]);
        }

        commandMap.get(cmd[2]).executeCommand(cmd);

    }
}
