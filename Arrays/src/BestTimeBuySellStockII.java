
/*

    Problem Statement:

        - Given an integer array 'prices' where prices[i] represent the price of a given stock on the ith day, return
          the maximum profit one can achieve if multi transactions are allowed.

        - NOTE: You cannot start another transaction in case you already have an ongoing transaction. In simple terms,
                we must sell before buying again.

        - For example, prices = [7,1,5,3,6,4] -> output = 7 (Buy at 1, Sell at 5; Buy at 3, Sell at 6)

    General Observations:

        - Basic Intuition:
            - Explore all possible combinations of profitable transactions and find the combination which returns the
              highest total profit.

        - On each day, we need to decide whether to buy the stock (if we don’t already have one), sell the stock (if we
          already own one) or do nothing and move to the next day.

        - Recursive Approach - Brute Force

            - Recursively explore all possible decisions: {buy, sell, do nothing} on every day, and keep track of the
              maximum profit along the way.

            - Hypothesis: F(prices, index, hasStock) will return the maximum profit one can make starting from the
                          'index' day.

            - Recursive Steps:

                // Option 1: do nothing
                - doNothingProfit = F(prices, index + 1, hasStock);

                // Option 2: if transaction is in process, sell the stock and collect the profit
                - if hasStock == true: sellProfit = F(prices, index + 1, true) + prices[index];

                // Option 3: if no transaction is in process, buy the stock and reduce the profit
                - if hasStock == false: buyProfit = F(prices, index + 1, false) - prices[index];

                - return max(doNothingProfit, sellProfit, buyProfit);


            - Base Conditions:
                // No profit can be made if no days are left
                - if index == prices.length: return 0;

            - Time Complexity:
                - We have n days in total, and for each day, we can make 2 choices: (i) do nothing, (ii) buy/sell.
                - Hence, time complexity = (2^n).

            - Space Complexity:
                - The recursive call stack will hold at max n recursive calls simultaneously.
                - Hence, space complexity = O(n).

            - Redundant Operations - Overlapping Sub-problems:
                - [index, hasStock] uniquely identifies each function call.
                - We can use a cache (map or an array) to store the results of previously computed sub-problems.
                - Hence, reduced time complexity = O(2*n) ~ O(n).

        - Considering multiple transactions are allowed, any increase in stock prices can be captured immediately.

        - NOTE: If prices keep rising, selling today and re-buying tomorrow is equivalent to holding. Waiting does not
                provide additional profit.

        - Greedy Approach:

            - Iterate over the 'prices' array and collect profit whenever prices[i] > prices[i - 1].

            - Algorithm:
                - maxProfit = 0;
                - loop from i = [1, n):
                    - if prices[i] > prices[i-1]:
                        maxProfit += prices[i] - prices[i-1];
                - return maxProfit;

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

import java.util.Arrays;

public class BestTimeBuySellStockII {

    private static int helper(int[] prices, int index, int hasStock, int[][] cache) {

        // Base Conditions:
        if(index == prices.length) return 0;

        if(cache[index][hasStock] != -1) return cache[index][hasStock];

        // Recursive Steps:

        // Option 1: do nothing
        int maxProfit = helper(prices, index + 1, hasStock, cache);

        if(hasStock == 1) {
            // Option 2: if transaction is in process, sell the stock and collect the profit
            maxProfit = Math.max(maxProfit, helper(prices, index + 1, 0, cache) + prices[index]);
        } else {
            // Option 3: if no transaction is in process, buy the stock and reduce the profit
            maxProfit = Math.max(maxProfit, helper(prices, index + 1, 1, cache) - prices[index]);
        }

        return cache[index][hasStock] = maxProfit;

    }

    public static int maxProfitRecursive(int[] prices) {
        int[][] cache = new int[prices.length][2];
        for(int[] row: cache) Arrays.fill(row, -1);
        return helper(prices, 0, 0, cache);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for(int i=1; i<n; i++) {
            if (prices[i] > prices[i-1]) maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }



    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
