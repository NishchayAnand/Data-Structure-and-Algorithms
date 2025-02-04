
/*

    Problem Statement:

        - Given an integers array 'nums' of length 'n' where each element nums[i] represents the maximum length of a
          forward jump from index 'i'.

        - In other words, if you are at nums[i], you can jump to any nums[i + j] where:
            1. 0 <= j <= nums[i] and
            2. i + j < n

        - Return the minimum number of jumps to reach nums[n - 1].

        NOTE: The test cases are generated such that you can reach nums[n - 1].

    General Observations:

        - At every index, we have a choice: We can jump anywhere within the range i + nums[i].

        - Recursive Intuition:
            - Explore all possible combinations of jumps that can take you to nums[n-1] from nums[0].

        - Recursive Approach:

            - Hypothesis:
                - F(nums, curr_index, n) will return the minimum number of jumps that can take you from index = 'curr_index'
                  to index = 'n-1'.

            - Recursive Steps:

                - min_jumps = Infinity;

                - min_next_index = curr_index + 1;
                - max_next_index = max(curr_index + nums[curr_index], n-1);

                - for next_Index = [ min_next_index, max_next_index ]:
                    - jumps = F(nums, next_index);
                    - if jumps != Infinity: min_jumps = min(min_jumps, 1 + jumps);

                - return min_jumps;

            - Base Conditions:
                - if curr_index == n-1: return 0; // reached the end index, hence, jumps required = 0

            - Space Complexity:
                - At most, 'n' recursive calls will exist in the call stack simultaneously.
                - Hence, Space Complexity = O(n).

            - Time Complexity:
                - Exponential, i.e., O(k^n) where k = Average maximum jumpLength possible from each index.

            - Optimizations:

                - Overlapping Sub-problems:
                    - Can use a cache (an array) to store the results of previously computed sub-problems.
                    - Would only solve n unique sub-problems.
                    - Hence, Time Complexity = O(k*n).

                - Call Stack Utilization:
                    - The cache is filled while backtracking from index = [n-1, 0].
                    - Can use a loop to fill cache using recursive steps:
                    - No stack overflow concerns.

*/

import java.util.Arrays;

public class JumpGameII {

    private static int helper(int[] nums, int index, int[] cache) {

        // Base Conditions:
        if(index == nums.length-1) return cache[index] = 0;

        // Optimizations:
        if(cache[index] != -1) return cache[index];

        // Recursive Steps:
        int minJumps = Integer.MAX_VALUE;
        int maxNextIndex = Math.min(index+nums[index], nums.length-1);
        for(int nextIndex = index+1; nextIndex <= maxNextIndex; nextIndex++) {
            int jumps = helper(nums, nextIndex, cache);
            if(jumps != Integer.MAX_VALUE) minJumps = Math.min(minJumps, 1+jumps);
        }

        return cache[index] = minJumps;

    }

    public static int jumpDPRecursive(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return helper(nums, 0, cache);
    }

    public static int jumpDPIterative(int[] nums) {

        int n = nums.length;
        if(n==1) return 0;

        int[] cache = new int[n];
        Arrays.fill(cache, Integer.MAX_VALUE);

        // Base Conditions:
        cache[n-1] = 0;

        // Backtracking:
        for(int index = n-2; index >=0; index--) {
            // Recursive Steps:
            int maxNextIndex = Math.min(index +nums[index], n-1);
            for(int nextIndex = index+1; nextIndex <= maxNextIndex; nextIndex++) {
                int jumps = cache[nextIndex]; // minimum jumps in which you can reach end index from 'nextIndex'
                if(jumps != Integer.MAX_VALUE) cache[index] = Math.min(cache[index], 1+jumps);
            }
        }

        return cache[0];

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpDPIterative(nums));
    }
}
