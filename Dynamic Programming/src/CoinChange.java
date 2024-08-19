
/* Given: An integer array 'coins' representing coins of different denominations and an integer 'amount' 
 * 		  representing a total amount of money.
 * 
 * Output: Return the fewest (minimum) number of coins that you need to make up 'amount'. If 'amount' 
 * 		   cannot be made up by any combination of the coins, return -1.
 * 
 * NOTE: You may assume that you have an infinite number of each kind of coin.
 * 
 * General Observations:
 * 
 * 	- We need to iterate over all possible combination of coins whose combined value = amount and find the 
 *    combination where count of selected coins is minimum.
 *    
 *  - The Include-Exclude technique would not work over here since the exclude condition would always 
 *    give us minimum coins.
 * 
 * 	- 
 * 
 *  - The problem is recursive in nature. 
 * 
 *  - Hypothesis: F(coins, n, amount) will return the minimum number of coins that can be included from
 *  			  the first n coins to achieve the combined denomination = amount. 
 *  
 *  - Recursive Steps:
 *  	- exc = F(coins, n-1, amount);
 *  	- if coins[n-1] <= amount:
 *  		- inc = 1 + F(coins, n, amount-coins[n-1]);
 *  	- return min(exc, inc);
 *  
 *  - Base Condition:
 *  	- if n==0:
 *  		- return 0; -> no coin remaining that can be added.
 *  	- if amount==0;
 *  		- return 0; -> amount already satisfied, no coin can be added.
 *  
 * 
 * */

public class CoinChange {
	
	private static int coinChange(int[] coins, int amount) {
		
		if(amount == 0) return 0;
		
		int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
        	if(coin<=amount) {
        		int result = coinChange(coins, amount - coin);
        		if (result != -1) {
                    minCoins = Math.min(minCoins, result + 1);
                }
        	}
        }
		return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
		
	}
	
	public static void main(String[] args) {
		
		int[] coins = {2};
		int amount = 3;
		System.out.println(coinChange(coins, amount));
		
	}

}
