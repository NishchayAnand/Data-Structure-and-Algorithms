
/* Problem Statement: Given an integer array 'nums' where each element represents your maximum jump length at that
                      position, return true if you can reach the last index starting from the first index, or false
                      otherwise.

   General Observations:

    - For any nums[i]=k, we have k jump length choices for making a jump.

    - The problem can be broken down into smaller subproblems with similar structures, i.e., the problem is naturally
      recursive in nature.

    - Algorithm:

        - Hypothesis: F(idx, nums) will return true if we can reach index = (nums.length-1) starting from index = idx, or
                      false otherwise.

        - Recursive Steps:

            - isPossible = false;

            // explore all possible jump lengths.
            - for jumpLength = 1:nums[idx]:

                // check if jumpLength is in bound.
                - idx + jumpLength < nums.length:
                    - isPossible = isPossible || F(idx+jumpLength, nums);

            - return isPossible;

        - Base Condition:

            // check if we have reached the last index.
            - if idx == nums.length-1:
                - return true;

       - Optimization: Since the recursive solution may observe some overlapping sub-problems, we can use the concept of
                       memoization to optimize the solution.

    - For any start_index, if start_index + nums[start_index] >= end_index, then we can reach the end_index from that
      start_index.

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

    public static void main(String args[]) {

        int[] nums = {2,3,1,1,4};
        Boolean[] mem = new Boolean[nums.length];
        System.out.println(canJumpMemoized(nums, mem, 0));

    }
}