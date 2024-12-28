
/*

    Problem Statement: You are a professional robber planning to rob houses along a street. Each house has a certain
                       amount of money stashed. The only constraint stopping you from robbing each of them is that
                       adjacent houses have security systems connected, and it will automatically contact the police if
                       two adjacent houses were broken into on the same night.

                       Given an integer array 'nums' representing the amount of money of each house, return the maximum
                       amount of money you can rob tonight without alerting the police.

    General Observations:

        - We are required to explore all possible combinations of houses the robber can rob.

        - Brute Force Approach:

            - Use nested loops to evaluate the sums for all possible sequences starting from each house and keep track
              of the maximum sum across all starting points.

            - Time Complexity: O(n^2).

            - Space Complexity: O(1).

        - For any 'nth' house, the robber has 2 choices:

            i. Rob the house: If the robber chooses to rob the 'nth' house, they cannot rob the adjacent (n−1)th house.
                              Thus, the maximum money accumulated is the money in the 'nth' house plus the maximum money
                              that can be robbed from the first (n−2) houses.

           ii. Skip the house: If the robber skips the 'nth' house, the maximum money accumulated would be the maximum
                               amount that can be robbed from the first (n−1) houses.

        - The problem is naturally recursive in nature.

        - Recursive Approach:

            - Hypotheses:
                - F(n) will return the maximum amount of money the robber can accumulate from the first 'n' houses.

            - Recursive Steps:
                - return max(
                    F(n-1),             // Skip the nth house
                    nums[n-1] + F(n-2)  // Rob the nth house
                );

            - Base Conditions:
                - if n <= 0: return 0; // no money can be accumulated if no houses are left to be robbed

            - Time Complexity: O(2^n). --> for explanation, refer climbingStairs

            - Space Complexity: O(n).

        - Many sub-problems are solved multiple times in the above recursive approach.

        - Memoization Approach:

            - We can store the results of previously computed sub-problems in a cache (e.g., a map or an array). This
              would allow us to reuse the result of previously computed sub-problems instead of recalculating it.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - In the memoized solution, the cache is getting filled while backtracking from n = [1, n].

        - Iterative Approach:

            - Use iteration to we fill the cache (or memoization array) from the smallest sub-problems F(0) and F(1)
              up to F(n).

            - Algorithm:

                // Base Conditions:
                - memo[0] = 0;
                - memo[1] = nums[0]; // If there is only one house, the maximum amount robbed is the money in the first house.

                // Backtracking:
                for i = [2, n]:
                    - memo[i] = Math.max(memo[i-1], nums[i-1] + dp[i-2];

                return memo[n];

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - For n>=2, F(n) is only dependent on the last two computed values: F(n−1) & F(n−2).

        - Optimized Iterative Approach:

            - In the iterative approach, rather than maintaining an entire array, just maintain two variables to store
              the last two results.

            - Algorithm:

                // Base Conditions:
                - second_last = 0; // memo[0] = memo[n-2]
                - last = nums[0];  // memo[1] = memo[n-1]

                // Backtracking:
                for i = [2, n]:
                    - current = max(last, nums[i-1] + second_last);
                    - second_last = last;
                    - last = current;

                return last; // memo[n]

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class HouseRobber {

    private static int getMaxAmount(int[] nums, int n, int[] memo) {
        // Base Conditions
        if (n <= 0) return 0;
        // Recursive Steps:
        if (memo[n] != -1) return memo[n];
        return memo[n] = Math.max(getMaxAmount(nums, n-1, memo), nums[n-1] + getMaxAmount(nums, n-2, memo));
    }

    private static int robMemoized(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+1];
        for(int i=0; i<n; i++) memo[i] = -1;
        return getMaxAmount(nums, nums.length, memo);
    }

    private static int robIterative(int[] nums) {

        int n = nums.length;
        if(n==0) return 0;

        int second_last = 0; // memo[0] = memo[n-2]
        int last = nums[0];        // memo[1] = memo[n-1]
        for(int i = 2; i<=n; i++) {
            int current = Math.max(last, nums[i-1] + second_last);
            second_last = last;
            last = current;
        }

        return last;

    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(robIterative(nums));
    }
}
