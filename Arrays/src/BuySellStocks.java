
/* Problem Statement: Given an array 'prices' where prices[i] is the price of a given stock on the ith day.
 * 					  You want to maximize your profit by choosing a single day to buy one stock and 
 * 				      choosing a different day in the future to sell that stock.
 * 
 * 					  Return the maximum profit you can achieve from this transaction. 
 * 
 * 				      NOTE: If you cannot achieve any profit, return 0.
 * 
 * General Observations:
 * 
 * 	- We need to find the pair of prices: {prices[i], prices[j]} whose difference is maximum, where i<j.
 * 
 *  - Brute Force Approach:
 *  
 *  	- Use a nested loop {i, j} to explore all possible pairs. 
 *  
 *  	- Time Complexity: O(n^2).
 *  
 *  	- Space Complexity: O(1).
 *  
 *  - 
 * 
 * 	- Sliding Window Technique:
 * 
 * */


public class BuySellStocks {

    public static void main(String[] args) throws Exception {
        
    }

}