# Stock Exchange Matching System

A stock exchange receives multiple orders per day. Traders can place orders of two types, ‘Buy’ and ‘Sell’. The stock exchange can fulfill a ‘Buy’ order at time ‘t’ by matching one or many preferred ‘Sell’ orders that arrived before time ‘t’. Implement an order matching system where the ‘Buy’ and ‘Sell’ orders are matched as they arrive.
Traders place Buy or Sell orders for a particular stock indicating the quantity and the price.


* Priority Criteria
    1. Criteria to buy a stock should give first preference to pricing (Lower the price the better)  
    2. In case of a tie, a timestamp of the order can be used.
    3. In case of a price and timestamp tie, divide the buy order proportionately among all the sell orders. 
* **Note**
    1. A given ‘Buy’ order can be partially fulfilled.
    2. A given ‘Buy’ order can be fulfilled by multiple ‘Sell’ orders.
    3. A ‘Buy’ order at time ‘t’ cannot be fulfilled by a ‘Sell’ order that arrived after ‘t’
    4. Selling price for a trade should always be less than or equal to the buying price


Write a program that accepts the following input and prints the orders that were filled in the format below:

#### Sample Input
```
format:<order-id> <time> <stock> <buy/sell> <qty> <price>

1 09:45 FK Sell 100 240.10
2 09:45 FK Sell 90 237.45
3 09:47 FK Buy 80 238.10
5 09:48 FK Sell 220 241.50
6 09:49 FK Buy 50 238.50
7 09:52 AZ Buy 10 100.10
8 10:01 FK Sell 20 240.10
9 10:02 FK Buy 150 242.70
```
#### Sample Output
```
format:<sell-order-id> <buy-order-id> <qty> <price>
2 3 80 237.45
2 6 10 237.45
1 9 100 240.10
8 9 20 240.10
5 9 30 241.50
```
#### Bonus
Assume that the buy orders are placed by a single trader. Print the portfolio of that trader in the end.

```
Output Format
Stock Name: FK
Total Stocks purchased: 10
Average buying price: 200.50
Min buying price: 190.00
Max buying price: 240.00

Stock Name: AZ
Total Stocks purchased: 30
Average buying price: 210.50
Min buying price: 180.00
Max buying price: 250.00
```

### Expectations
1. Code should be demoable (very important), either by using a main driver program or test cases.
2. Bonus questions should be attempted only after the main problem.
3. Code should handle edge cases properly and fail gracefully.
4. Create the sample data yourself to test your code. You can put it into a file, test case or main driver program itself.
5. Code should not be monolithic.
6. Code should be readable, extensible with proper naming conventions. Best practices followed.
7. Don’t use any database, store all the data in memory.

### Guidelines
1. Feel free to discuss the solution with an interviewer
2. Input can be read from file or can be hard coded/used.
3. You are free to use the language of your choice.