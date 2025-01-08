
/*

	Problem Statement: Given an integer array 'coins' representing coins of different denominations and an integer 'amount'
	 				   representing a total amount of money, return the fewest (minimum) number of coins that you need to
	 				   make up 'amount'.

	 				   NOTE:
	 				   		- If 'amount' cannot be made up by any combination of the coins, return -1.
							- You may assume that you have an infinite number of each kind of coin.

	General Observations:

		- The task involves exploring all possible combination of coins whose combined value = 'amount'.

		- The problem is naturally recursive in nature, i.e., for any given 'amount', include each available coin,
		  subtract its value from the 'amount' and recursively solve for the reduced 'amount'.

		- Recursive Approach:

	    	- Hypotheses: F(coins, amount) will return the minimum number of coins that you need to make up 'amount'.

	    	- Recursive Steps:

	    		- minCount = Infinity; // assume it is impossible to achieve 'amount' with the available coins

	    		- for each coin in 'coins':
	    			- if coin <= 'amount': // Explore only the available coins
	    				- count = F(coins, amount-coin);
	    				- if count != Infinity: minCount = min(minCount, 1 + count);
	    		- return minCount;

			- Base Conditions:
				- if 'amount' == 0: return 0; // no coins needed to achieve 'amount' = 0.


			- Space Complexity Analysis:

				- In worst-case scenario (when the smallest coin is 1), each recursive call reduces the 'amount' by at
				  least one. At max 'amount' recursive calls will exist in the recursive call stack simultaneously.

				- Hence, Space Complexity = O(amount).

			- Time Complexity Analysis:

				- The time complexity is dependent on the total number of operations, which is dependent on the total
				  number of sub-problems.

					- At level 0: There is 1 sub-problem.
					- At level 1: There are n sub-problems (one for each coin).
					- At level 2: There are n^2 sub-problems.
					- .
					- .
					- .
					- At level d: There will be n^d sub-problems

				- Since, max depth 'd' of the recursive tree is proportional to the 'amount', the number of
				  sub-problems = n^amount.

				- Total sub-problems = n^0 + n^1 + n^2 + ..... + n^amount ~ n^amount (for large 'amount').

				- Hence, Time Complexity = O(n^amount).

		- We may encounter overlapping sub-problems in the above recursive approach.

		- Memoization Approach:

			- Storing the results of already-solved sub-problems in a cache (e.g., a map or an array) and reuse them
			  when the same sub-problem is encountered again.

			- Time Complexity Analysis:

				- There is one unique sub-problem for each 'amount' (from 0 to 'amount'). For each sub-problem, we try
				  all n coins.

				- Hence, Time Complexity = O(n*amount).

			- Space Complexity: O(amount).

		- In the memoized solution, the cache is getting filled from bottom to top, i.e., while backtracking from
		  amount = [1, amount].

		- Tabulation (Iterative) Approach:

			- Use iteration to fill the cache.

			- Algorithm:

				// Base Conditions:
				- memo[0] = 0; // no coins needed to achieve 'amount' = 0.

				// Backtracking:
				- for i = [1, amount]:
					- minCount = Infinity; // assume it is impossible to achieve 'amount = i' with the available coins
	    			- for each coin in 'coins':
	    				- if coin <= i: // Explore only the available coins
	    					- count = memo[i-coin];
	    					- if count != Infinity: minCount = min(minCount, 1 + count);
	    					- memo[i] = minCount;

	    		- return minCount;

*/

import java.util.Arrays;

public class CoinChange {
	
	private static int helper(int[] coins, int amount, int[] memo) {

		// Base Conditions
		if(amount == 0) return 0; // no coins needed to achieve 'amount' = 0.

		// Optimization
		if(memo[amount] != -1) return memo[amount];

		// Recursive Steps
		int minCount = Integer.MAX_VALUE; // assume it is impossible to achieve 'amount' with the available coins
		for(int coin: coins) {
			if(coin <= amount) { // Explore only the available coins
				int count = helper(coins, amount-coin, memo);
				if(count != Integer.MAX_VALUE) minCount = Math.min(minCount, count+1);
			}
		}
		return memo[amount] = minCount;

	}

	private static int coinChangeMemoized(int[] coins, int amount) {
		int[] memo = new int[amount+1];
		Arrays.fill(memo, -1);
		int result = helper(coins, amount, memo);
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int coinChange(int[] coins, int amount) {

		int[] memo = new int[amount+1]; // by default, base condition: memo[0] = 0 is already fulfilled.

		// Backtracking:
		for(int i=1; i<=amount; i++) {
			memo[i] = Integer.MAX_VALUE; // assume it is impossible to achieve 'amount = i' with the available coins
			for(int coin: coins) {
				if(coin <= i) {
					int count = memo[i-coin];
					if(count != Integer.MAX_VALUE) memo[i] = Math.min(memo[i], count+1);
				}
			}
		}

		return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];

	}
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coins, amount)); // output = 3
	}

}
