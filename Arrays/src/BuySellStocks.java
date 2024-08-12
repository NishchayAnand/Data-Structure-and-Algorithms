
/* Problem Statement: Given an array 'prices' where prices[i] is the price of a given stock on the ith day.
 * 					  You want to maximize your profit by choosing a single day to buy one stock and 
 * 				      choosing a different day in the future to sell that stock (single transaction 
 * 				      allowed).
 * 
 * 					  Return the maximum profit you can achieve from this transaction. 
 * 
 * 				      NOTE: If you cannot achieve any profit, return 0.
 * 
 * General Observations:
 * 
 * 	- We need to find a pair of prices: {prices[i], prices[j]} such that prices[j]-prices[i] is maximum, 
 *    where i<=j.
 *    
 *  - NOTE: prices[i] will always represent the buying price and prices[j] will always represent the 
 *  		selling price. 
 * 
 *  - Brute Force Approach:
 *  
 *  	- Use a nested loop {i, j} to explore all possible pairs. 
 *  
 *  	- Time Complexity: O(n^2).
 *  
 *  	- Space Complexity: O(1).
 *  
 *  - The maximum profit one can generate by selling at prices[j] would be by buying at the minimum
 *    prices[i] in the range [0,..j]. 
 *    
 *  - The idea to iterate over the prices array and maintain the minimum buying price seen so far.
 * 
 * 	- Two Pointers Approach:
 * 
 * 		- We can maintain 2 pointers:
 * 			- first to represent the index of the lowest price seeing so far.
 * 			- second to represent the index of the current price.
 * 	
 * 		- The 2 pointers can be used to calculate the maximum profit one can generate by selling at any 
 * 		  current price and buying at the lowest price observed so far.
 * 
 * 		- Algorithm:
 * 
 * 			- min_buy_idx = 0;  
 * 			- curr_sell_idx = 0;
 * 
 * 			- maxProfit = 0;
 * 
 * 			- while curr_sell_idx < prices.length:
 * 
 * 				- if prices[curr_sell_idx] < prices[min_buy_idx]:
 * 					- min_buy_idx = curr_sell_idx;
 * 
 * 				- currProfit = prices[curr_sell_idx] - prices[min_buy_idx];
 * 				- maxProfit = max(maxProfit, currProfit);
 * 
 * 			- return maxProfit;
 * 
 * 		- Time Complexity: O(n).
 * 	
 * 		- Space Complexity: O(1).
 * 
 * */


public class BuySellStocks {
	
	private static int maxProfit(int[] prices) {
		
		int maxProfit = Integer.MIN_VALUE;
		int minPrice = Integer.MAX_VALUE;
		
		for(int price: prices) {
			minPrice = Math.min(price, minPrice);
			int profit = price - minPrice;
			maxProfit = Math.max(maxProfit, profit);	
		}
		
		return maxProfit;
		
	}

    public static void main(String[] args) throws Exception {
    	int[] prices = {7,1,5,3,6,4};
    	int profit = maxProfit(prices);
    	System.out.println("Maximum Profit: " + profit);
    }

}