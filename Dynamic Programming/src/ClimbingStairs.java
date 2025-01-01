
/*

    Problem Statement: It takes 'n' steps to reach the top of a staircase. Each time you can either climb 1 or 2 steps.
                       Return number of distinct ways you can climb to the top.

    General Observations:

        - Considering we are only allowed to climb at max 2 steps at a time, we can only reach the (n)th step from the
          (n-1)th or (n-2)th step.

        - Distinct ways to reach the (n)th step = (Distinct ways to reach the (n-1)th step) +
                                                  (Distinct ways to reach the (n-2)th step).

        - The recursion reflects the natural choices available at each step, i.e., to get to the (n)th step, the last
          move could only have come from (n−1)th or (n−2)th step. By solving smaller sub-problems for (n−1) and (n−2),
          we inherently solve the problem for (n).

        - Recursive Approach:

            - Hypotheses:
                - F(n) will return the number of distinct ways to climb to the (n)th step.

            - Recursive Steps:
                - return F(n-1) + F(n-2);

            - Base Conditions:
                - if n == 1: return 1; // there's only 1 way to reach the 1st step, i.e., climb 1 step from the ground.
                - if n == 0: return 1; // there's only 1 way to reach the ground, i.e., not climb at all.

            - Time Complexity Analysis:

                - The time complexity can be analyzed by understanding how many sub-problems are solved.

                    - Level 1: F(n)                                                            -> 1 = 2^0 function call
                                |
                    - Level 2: F(n-1)----------F(n-2)                                          -> 2 = 2^1 function calls
                                |               |
                    - Level 3: F(n-2)----------F(n-3)----------F(n-3)----------F(n-4)          -> 4 = 2^2 function calls
                                |               |               |               |
                    - Level 4: F(n-3)--F(n-4)  F(n-4)--F(n-5)  F(n-4)--F(n-5)  F(n-5), F(n-6)  -> 8 = 2^3 function calls
                    - .
                    - .
                    - .

                - Total sub-problems  = 2^0 + 2^1 + 2^2 + 2^3 + .... + 2^(n-1) = 2^n - 1.

                - Since, the highest order term in the above expression is of the order 2^n, Time Complexity = O(2^n).

            - Space Complexity Analysis:

                - At max 'n' recursive calls will exist in the recursive call stack simultaneously. Hence, Space
                  Complexity = O(n).

        - Many sub-problems are solved multiple times in the above recursive approach.

        - Memoization Approach:

            - We can store the results of previously computed sub-problems in a cache (e.g., a map or an array). This
              would allow us to reuse the result of previously computed sub-problems instead of recalculating it.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - In the memoized solution, the cache is getting filled while backtracking from n = [2, n].

        - Iterative Approach:

            - Use iteration to fill the cache (or memoization array) from the smallest sub-problems F(0) and F(1)
              up to F(n).

            - Algorithm:

                // Base Conditions:
                - dp[0] = 1;
                - dp[1] = 1;

                // Backtracking:
                for i = [2, n]:
                    - dp[i] = dp[i-1] + dp[i-2];

                return dp[n];

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - For n>=2, F(n) is only dependent on the last two computed values: F(n−1) & F(n−2).

        - Optimized Iterative Approach:

            - In the iterative approach, rather than maintaining an entire array, just maintain two variables to store
              the last two results.

            - Algorithm:

                // Base Conditions:
                - second_last = 1; // dp[0] = dp[n-2]
                - last = 1;        // dp[1] = dp[n-1]

                // Backtracking:
                for i = [2, n]:
                    - current = last + second_last;
                    - second_last = last;
                    - last = current;

                return last; // dp[n]

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class ClimbingStairs {

    private static int helper(int n, int[] memo) {
        // Base Conditions:
        if (n==1 || n==0) return 1;
        // Recursive Steps:
        if (memo[n] != -1) return memo[n];
        return memo[n] = helper(n-1, memo) + helper(n-2, memo);
    }

    private static int climbStairsMemoized(int n) {
        int[] memo = new int[n+1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return helper(n, memo);
    }

    private static int climbStairsIterative(int n) {
        int second_last = 1; // memo[0] = memo[n-2]
        int last = 1;        // memo[1] = memo[n-1]
        for(int i = 2; i<=n; i++) {
            int current = last + second_last;
            second_last = last;
            last = current;
        }
        return last;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairsIterative(n)); // Output = 3
    }
}
