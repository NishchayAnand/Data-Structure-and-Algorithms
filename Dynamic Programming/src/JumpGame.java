
/* Problem Statement: Given an integer array 'nums' where each element represents your maximum jump length at that
                      position, return true if you can reach the last index starting from the first index, or false
                      otherwise.

   General Observations:

    - At any index = i such that nums[i]=k, we can make a jump of 1 step or 2 steps ... or k steps.

    - The problem can be broken down into smaller sub-problems with similar structures, i.e., the problem is naturally
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

    - Greedy Approach:

        - Considering 3 indices: start_index, mid_index and end_index such that there exist a path between mid_index and
          end_index, and we need to check if there exists a path from start_index to end_index.

                start_index                     mid_index-----------|---------|----------end_index

        - If start_index + nums[start_index] >= mid_index, then we can reach mid_index and ultimately end_index from the
          start_index (no need to explore every possible path from start_index that can lead you to the end_index).

        - Algorithm:
            - last_good_index = nums.length - 1;
            - Loop from i = [last_good_index-1, 0]:
                - if i + nums[i] >= last_good_index:
                    - last_good_index = i; // Update the last index that can reach the end index

            - if last_good_index == 0: return true; // end index reachable from the start index
            - else: return false;

        - Time Complexity: O(n).

        - Space Complexity: O(1).

*/

public class JumpGame {

    private boolean helper(int[] nums, int index, Boolean[] cache) {

        // Base Conditions
        if(index == nums.length-1) {
            return cache[index] = true;
        }

        // Optimizations
        if(cache[index] != null) {
            return cache[index];
        }

        // Recursive Steps
        int maxJumpIndex = Math.min(index+nums[index], nums.length-1); // Avoid out-of-bounds
        for(int nextIndex = index+1; nextIndex<= maxJumpIndex; nextIndex++) {
            if(helper(nums, nextIndex, cache)) return cache[index] = true;
        }

        return cache[index] = false;

    }

    public boolean canJumpMemoized(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return helper(nums, 0, cache);
    }

    private static boolean canJump(int nums[]) {
        int lastGoodIndex = nums.length-1;
        for(int i=lastGoodIndex-1; i>=0; i--) {
            if(i+nums[i] >= lastGoodIndex) lastGoodIndex = i; // update the last index that can reach the end index
        }
        return lastGoodIndex == 0;
    }

    public static void main(String args[]) {

        int[] nums = {2,3,1,1,4};
        //Boolean[] mem = new Boolean[nums.length];
        //System.out.println(canJumpMemoized(nums, mem, 0));
        System.out.println(canJump(nums));

    }
}