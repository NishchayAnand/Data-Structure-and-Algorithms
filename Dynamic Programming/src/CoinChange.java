
/*

	Given: An integer array 'coins' representing coins of different denominations and an integer 'amount' representing a
		   total amount of money.

 	Output: Return the fewest (minimum) number of coins that you need to make up 'amount'. If 'amount' cannot be made
 			up by any combination of the coins, return -1.

	NOTE: You may assume that you have an infinite number of each kind of coin.

	General Observations:

		- We need to iterate over all possible combination of coins and find the combination whose combined value =
		  'amount' and count of selected coins is minimum.

		- Brute Force Approach:

			- The problem can be broken down into smaller sub-problems, i.e, the problem is naturally recursive.

	    	- Hypothesis: F(coins, n, amount) will return the minimum number of coins that you can select from the first
	    			      'n' denominations to reach the target sum of 'amount'.

	    	- For each coin, we can either include it in the selection (if the denomination <= targeted amount) or exclude
	    	  it from the selection.

	    	- Recursive Steps:

	    		- exclude = F(coins, n-1, amount);

	    		- if coins[n-1] <= amount:
	    			- include = F(coins, n, amount-coins[n-1]);

				- return min(exclude, include);

			- If amount == 0, we don't need any coins, i.e., 0 coins, since we have already reached the targeted
			  amount.

			- If n == 0, we don't have enough coins, i.e., we may require infinite coins to reach the targeted sum.

			- Base Conditions:

				- if amount == 0: return 0;

				- if n == 0: return Integer.MAX_VALUE;

			- Time Complexity: Exponential.

			- Space Complexity: O(n).

		- We may encounter overlapping sub-problems in the recursive brute-force approach.

		- Optimization - Memoization Approach:

			- Each sub-problem can be represented using 2 varying parameters: 'n' and 'amount'.

			- We can use a 2D array (matrix): mem[n+1][amount+1] to cache the result of each sub-problem.

			- Every mem[0][amount] = Integer.MAX_VALUE;

			- Every mem[n][0] = 0;

			- mem[0][0] = 0;

			- Time Complexity: O(n^2).

			- Space Complexity: O(n^2).






*/

public class CoinChange {
	
	private static int coinChangeRecursive(int[] coins, int n, int amount) {

		if(amount == 0) return 0;

		if(n == 0) return Integer.MAX_VALUE;

		// Exclude Condition
		int exclude = coinChangeRecursive(coins, n-1, amount);

		// Include Condition
		int include = Integer.MAX_VALUE;
		if (coins[n - 1] <= amount) {
			int res = coinChangeRecursive(coins, n, amount - coins[n - 1]);
			// to make sure res does not give incorrect result due to overflow.
			if (res != Integer.MAX_VALUE) {
				include = 1 + res;
			}
		}

		return Math.min(exclude, include);

	}

	private static int coinChangeMemoized(int[] coins, int n, int amount, int[][] mem) {

		if(amount == 0) return 0;

		if(n == 0) return Integer.MAX_VALUE;

		if(mem[n][amount] != -1) {
			return mem[n][amount];
		}

		// Exclude Condition
		int exclude = coinChangeMemoized(coins, n-1, amount, mem);

		// Include Condition
		int include = Integer.MAX_VALUE;
		if (coins[n - 1] <= amount) {
			int res = coinChangeMemoized(coins, n, amount - coins[n - 1], mem);
			// to make sure res does not give incorrect result due to overflow.
			if (res != Integer.MAX_VALUE) {
				include = 1 + res;
			}
		}

		return mem[n][amount] = Math.min(exclude, include);

	}

	public static int coinChange(int[] coins, int amount) {
		int n = coins.length;

		// Brute Force - Simple Recursion
		//int result = coinChangeRecursive(coins, n, amount);

		// Optimized - Memoization
		int[][] mem = new int[n+1][amount+1];
		for(int r=0; r<=n; r++){
			for(int c=0; c<=amount; c++) {
				mem[r][c] = -1;
			}
		}
		int result = coinChangeMemoized(coins, n, amount, mem);

		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}

}
