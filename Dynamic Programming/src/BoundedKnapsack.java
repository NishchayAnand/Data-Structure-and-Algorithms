
/*

    Problem Statement: Given a bag  (knapsack) with weight capacity 'capacity' and a list of 'n' items, each having a
                       value 'vi' and weight 'wi', return the maximum value that can be obtained by placing a subset
                       of items in the knapsack such that the total weight of the selected items does not exceed
                       'capacity'.

					   NOTE: Each item can be included only once.

    General Observations:

        - The problem involves exploring all combinations of items whose combined weight is less than or equal to
          'capacity'.

        - For any 'nth' item, we have two choices:

            1. Include the 'nth' item:
                    - Add the 'nth' item's value to the total value.
                    - Reduce the remaining 'capacity' of the knapsack by the weight of the 'nth' item.
                    - Solve the problem for the remaining 'n−1' items with the reduced 'capacity'.

            2. Exclude the 'nth' item:
                    - Skip the 'nth' item entirely.
                    - Solve the problem for the remaining 'n−1' items with the same 'capacity'.

        - The problem is naturally recursive in nature.

        - Recursive Approach:

            - Hypotheses:
                - F(val, n, wt, capacity) will return the maximum value that can be obtained by selecting a subset
                  of items from the first 'n' items such that the total weight of the selected items does not exceed
                  'capacity'.

            - Recursive Steps:

                // Option 1: Include the 'nth' item
                - includeMaxVal = -1;
                - if wt[n-1] <= capacity:
                    - includeMaxVal = vals[n-1] + F(val, n-1, wt, capacity - wt[n-1]);

                // Option 2: Exclude the 'nth' item
                - excludeMaxVal = F(val, n-1, wt, capacity);

                - return max(includeMaxVal, excludeMaxVal);

            - Base Conditions:
                - if (n == 0), i.e., no items left or (capacity == 0), i.e., knapsack is full: return 0;

            - Time Complexity Analysis:

                - In worst case scenario, the knapsack would be able to accommodate all the available items.

                - Let total operations performed by the above algorithm in worst case be o(n), such that:

                    1. o(n)       = 2.o(n-1) + C
                    2. 2.o(n-1)   = 2^2.o(n-2) + 2.C
                    3. 2^2.o(n-2) = 2^3.o(n-3) + 2^2.C

                    .
                    .
                    .

                    n. 2^(n-1).o(1) = 2^n.o(0) + 2^(n-1).C

                    -> o(n) = C + 2.C + 2^2.C + ... + 2^(n-1).C
                            = [1 + 2 + 2^2 + ... + 2^(n-1)].C
                            = [2^n-1].C

   		        - Since, the total operations performed in worst case scenario is of the order 2^n, hence,
   		          Time Complexity = O(2^n).

            - Space Complexity Analysis:

                - At max 'n' recursive calls will exist in the recursive call stack simultaneously. Hence, Space
                  Complexity = O(n).

        - Overlapping Sub-problems:

            - Consider val = [1,1,1], wt = [1,1,1], capacity = 3:

                Level 1: F(3,3)
                           |
                Level 2: F(2,2)-------------------------------F(2,3)
                           |                                    |
                Level 3: F(1,1)-------------F(1,2)            F(1,2)-------------F(1,3)
                           |                  |                 |                  |
                Level 4: F(0,0)---F(0,1)    F(0,1)---F(0,2)   F(0,1)---F(0,2)    F(0,2)---F(0,3)

            - Sub-problem F(1,2) is solved multiple times in the above recursive algorithm.

        - Memoization Approach:

            - Each combination of 'n' and 'capacity' in F(val, n, wt, capacity) forms a unique sub-problem.

            - We can store the results of previously computed sub-problems in a cache (e.g., a map or a 2-D array). This
              would allow us to reuse the result of previously computed sub-problems instead of recalculating it.

            - Time Complexity: O(n*capacity).

            - Space Complexity: O(n*capacity).


*/

public class BoundedKnapsack {

    private static int helper(int[] val, int n, int[] wt, int capacity, int[][] memo) {
        // Base Conditions:
        if(n == 0 || capacity == 0) return 0;

        // Optimizations:
        if(memo[n][capacity] != -1) return memo[n][capacity];

        // Recursive Steps:

        // Option 1: Include the 'nth' item
        int includeMaxValue = -1;
        if(wt[n-1] <= capacity) {
            includeMaxValue = val[n-1] + helper(val, n-1, wt, capacity - wt[n-1], memo);
        }

        // Option 2: Exclude the 'nth' item
        int excludeMaxValue = helper(val, n-1, wt, capacity, memo);

        return memo[n][capacity] = Math.max(includeMaxValue, excludeMaxValue);

    }

    private static int knapSackRecursive(int capacity, int[] val, int[] wt) {
        int n = val.length;
        int[][] memo = new int[n+1][capacity+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=capacity; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(val, n, wt, capacity, memo);
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;
        System.out.println(knapSackRecursive(capacity, val, wt));
    }
}
