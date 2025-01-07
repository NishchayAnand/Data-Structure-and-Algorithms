
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
	    			- if coin <= 'amount':
	    				- count = F(coins, amount-coin);
	    				- if count != Infinity: minCount = min(minCount, 1 + count);
	    		- return minCount;

			- Base Conditions:
				- if 'amount' == 0: return 0; // no coins needed to achieve 'amount' = 0.

			- Time Complexity Analysis:

			- Space Complexity Analysis: O(n).

		- We may encounter overlapping sub-problems in the above recursive approach.

		- Memoization Approach:

			- Each sub-problem can be represented using 2 varying parameters: 'n' and 'amount'.

			- We can use a 2D array (matrix): mem[n+1][amount+1] to cache the result of each sub-problem,
			  where each cell represents a unique sub-problem.

			- Time Complexity: O(n*amount).

			- Space Complexity: O(n*amount).

		- The 2D memoization array is getting fill from bottom to top, i.e., from smallest
		  sub-problem to the largest sub-problem.

		- Tabulation (Iterative) Approach:

			- We can use a nested loop and the recursive steps to fill the 2D memoization array.

			- Every mem[0][amount] = Integer.MAX_VALUE;

			- Every mem[n][0] = 0;

			- mem[0][0] = 0;

			- Time Complexity: O(n*amount).

			- Space Complexity: O(n^amount) -> We won't have the overhead associated with
											   recursive call stack.

		- For any mem[r][c], we only need to know mem[r-1][c] and mem[r][c-coins[r-1]], mem[r-1][c]
		  and mem[r][c-coins[r-1]] has already been computed in the previous iteration.

		- Optimization - 1D Tabulation Approach:

			- Use two 1D arrays to keep track of the mem[r-1][c] and mem[r][c-coins[r-1]]
			  sub-problem.

			- Time Complexity: O(n*amount).

			- Space Complexity: O(amount).

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

	private static int coinChangeTabulation(int[] coins, int n, int amount, int[][] mem) {
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=amount; c++) {
				int exclude = mem[r-1][c];
				int include = Integer.MAX_VALUE;
				if(coins[r-1]<=c){
					include = mem[r][c-coins[r-1]];
					if(include != Integer.MAX_VALUE) {
						include+=1;
					}
				}
				mem[r][c] = Math.min(exclude, include);
			}
		}
		return mem[n][amount];
	}

	private static int coinChange1DTabulation(int[] coins, int n, int amount, int[] mem) {
		int[] curr = new int[amount+1];
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=amount; c++) {
				int exclude = mem[c];
				int include = Integer.MAX_VALUE;
				if(coins[r-1]<=c){
					include = curr[c-coins[r-1]];
					if(include != Integer.MAX_VALUE) {
						include+=1;
					}
				}
				curr[c] = Math.min(exclude, include);
			}
			mem = curr.clone();
		}
		return mem[amount];
	}

	private static int coinChange(int[] coins, int amount) {
		int n = coins.length;

		// Brute Force - Simple Recursion
		//int result = coinChangeRecursive(coins, n, amount);

		// Optimized - Memoization
		int[][] mem2D = new int[n+1][amount+1];
		for(int r=0; r<=n; r++){
			for(int c=0; c<=amount; c++) {
				mem2D[r][c] = -1;
			}
		}
		//int result = coinChangeMemoized(coins, n, amount, mem2D);

		// Optimized - 2D Tabulation
		for(int c=0; c<=amount; c++) {
			mem2D[0][c] = Integer.MAX_VALUE;
		}
		for(int r=0; r<=n; r++) {
			mem2D[r][0] = 0;
		}
		//int result = coinChangeTabulation(coins, n, amount, mem2D);

		// Optimized - 1D Tabulation
		int[] mem1D = new int[amount+1];
		//curr[0] = 0; will be set by default.
		for(int c=1; c<=amount; c++) {
			mem1D[c] = Integer.MAX_VALUE;
		}
		int result = coinChange1DTabulation(coins, n, amount, mem1D);

		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coins, amount)); // output = 3
	}

}
