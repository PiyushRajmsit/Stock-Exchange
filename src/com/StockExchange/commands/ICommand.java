package com.StockExchange.commands;

import com.StockExchange.exceptions.BadCommandException;

public interface ICommand {

    public void executeCommand(String cmd[]) throws BadCommandException;
}
