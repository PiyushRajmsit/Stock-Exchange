package com.StockExchange;

import com.StockExchange.commands.CommandFactory;
import com.StockExchange.exceptions.BadCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        CommandFactory commandFactory = CommandFactory.getInstance();


        File input = new File("/home/piyush-pc/Downloads/Machine_coding/StockExchange/src/com/StockExchange/input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            System.out.print("->");
            String[] cmd = sc.nextLine().split(" ");
            try {
                commandFactory.executeCommand(cmd);
            } catch (BadCommandException b){
                System.out.println("BadCommand Exception due to ==>" + b.getCause());
            }
        }
    }
}

