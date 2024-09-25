
/* Problem Statement: Given an integer array 'nums' where each element represents your maximum jump length at that
                      position, return true if you can reach the last index starting from the first index, or false
                      otherwise.

   General Observations:

    - At any index = i such that nums[i]=k, we can make a jump of 1 step or 2 steps ... or k steps.

    - The problem can be broken down into smaller subproblems with similar structures, i.e., the problem is naturally
      recursive in nature.

    - Algorithm:

        - Hypothesis: F(nums, idx) will return true if we can reach index = (nums.length-1) starting from index = idx, or
                      false otherwise.

        - Recursive Steps:

            - isPossible = false;

            // explore all possible jump lengths.
            - for jumpLength = 1:nums[idx]:

                // check if jumpLength is in bound.
                - idx + jumpLength < nums.length:
                    - isPossible = isPossible || F(nums, idx+jumpLength);

            - return isPossible;

        - Base Condition:

            // check if we have reached the last index.
            - if idx == nums.length-1:
                - return true;

       - Optimization: Since the recursive solution may observe some overlapping sub-problems, we can use the concept of
                       memoization (DP) to optimize the solution.

    - For any [start_index, end_index], if start_index + nums[start_index] >= end_index, then we can reach the end_index
      from the start_index (don't need to explore all possible jump lengths from start_index that will lead us to the
      end_index).

    - Greedy Approach:

        - let target_index = nums.length - 1;
        - Loop from i = [target_index-1, 0]:
            - if target index is reachable from index i, i.e., i + nums[i] >= target_index:
                - set i as the new target index, i.e., target_index = i;

        - If target_index has reached 0, we can reach the end index starting from the first index.

        - Time Complexity: O(n).

        - Space Complexity: O(1).

*/

public class JumpGame {

    private static boolean canJumpRecursive(int[] nums, int idx) {
        if(idx == nums.length-1) {
            return true;
        }

        boolean isPossible = false;
        for(int jumplength = 1; jumplength<=nums[idx]; jumplength++) {
            if(idx + jumplength < nums.length) {
                isPossible = isPossible || canJumpRecursive(nums, idx+jumplength);
            }
        }

        return isPossible;
    }

    private static boolean canJumpMemoized(int[] nums, Boolean[] mem, int idx) {
        if(idx == nums.length-1) {
            return true;
        }

        if(mem[idx] != null) {
            return mem[idx];
        }

        boolean isPossible = false;
        for(int jumplength = 1; jumplength<=nums[idx]; jumplength++) {
            if(idx + jumplength < nums.length) {
                isPossible = isPossible || canJumpRecursive(nums, idx+jumplength);
            }
        }

        return mem[idx] = isPossible;
    }

    private static boolean canJump(int nums[]) {
        int target_index = nums.length-1;
        for(int i=target_index; i>=0; i--) {
            if(i+nums[i]>=target_index) {
                target_index = i;
            }
        }
        return target_index == 0 ? true : false;
    }

    public static void main(String args[]) {

        int[] nums = {2,3,1,1,4};
        //Boolean[] mem = new Boolean[nums.length];
        //System.out.println(canJumpMemoized(nums, mem, 0));
        System.out.println(canJump(nums));

    }
}