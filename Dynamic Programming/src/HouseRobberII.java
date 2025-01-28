
/*

    Problem Statement:

        - Given an integer array 'nums' of length 'n' representing the amount of money stashed in 'n' houses. Consider
          all houses to be arranged in a circle such that the first houses is the neighbour of the last house, and you
          cannot rob 2 adjacent houses, return the maximum amount of money you can rob.

    General Observations:

        - Since, the first and the last houses are neighbours, i.e., are adjacent to each other, you can either:
            - rob houses from n = [0, n-2], or
            - rob houses from n = [1, n-1].

        - Maximum amount that can be robbed = max(getMaxAmount(0, n-2), getMaxAmount(1, n-1)), where getMaxAmount is
          the classical house robber solution that will return maximum amount of money that can be robbed from a linear
          subarray.

        - Time Complexity: O(n).

        - Space Complexity: O(1).

*/

public class HouseRobberII {

    public static int getMaxAmount(int[] nums, int start, int end) {
        int n = end - start + 1;
        // Base Conditions:
        int prev2 = 0; // cache[n-2]
        int prev1 = nums[start]; // cache[n-1]
        for(int i=2; i<=n; i++) {
            int current = Math.max(prev1, nums[start + i-1] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(getMaxAmount(nums, 0, n-2), getMaxAmount(nums, 1, n-1));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3}; //{2,3,2};
        System.out.println(rob(nums));
    }

}
