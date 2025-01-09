
/*

    Problem Statement:  Given an integer array 'nums', return the length of the longest strictly increasing subsequence.

                        NOTE: The elements in the subsequence do not need to be contiguous, however, must appear in the
                              same relative order as in the original sequence.

    General Observations:

        - The task involves exploring all possible increasing subsequences.

        - For each 'nth' element, we have 2 choices:

            1. Include the 'nth' element: Add the 'nth' element to the subsequence (if it is greater than the previous
                                          element), extends the length of the increasing subsequence, and we move to the
                                          (n+1)th element.

            2. Exclude the 'nth' element: Skip the 'nth' element and move to the (n+1)th index.

        - The problem is naturally recursive in nature.

        - Recursive Approach:

            - Hypotheses: F(nums, previous_index, current_index) will return the longest strictly increasing subsequence
                          in 'nums' starting at the 'current_index'.

            - Recursive Steps:

                // Option 1: Include the current element (if valid)
                - include = 0 // assume current element cannot be included
                - if nums[current_index] > nums[previous_index]:
                    - include = 1 + F(nums, current_index, current_index + 1);

                // Option 2: Exclude the current element
                - exclude = F(nums, previous_index, current_index + 1);

                - return max(include, exclude);

            - Base Conditions:

                - if current_index == nums.length: return 0; // no elements to include in the subsequence.

            - Time Complexity: O(2^n) in worst-case scenario (nums is sorted).

            - Space Complexity: O(n).

            - Time-Based Optimizations (Memoization):

                - We may encounter overlapping sub-problems in the above recursive solution.

                - We can store the results of already-solved sub-problems in a cache (e.g., a map or an array) and reuse
                  them when the same sub-problem is encountered again.

                - [prevIndex, currIndex] uniquely identifies the LIS starting at 'currIndex' with the last included
                  element at 'prevIndex', where, we have:

                    - 'n' choices for the 'current_index' (from 0 to n-1), and
                    - 'n' choices for 'previous_index' (from -1 to n-2).

                 - NOTE: The 'previous_index' would always be less than the 'current_index'.

                 - The time complexity will reduce to O(n^2), however, the space complexity would increase to O(n^2).

        - In the above solution, the cache is filled while backtracking from previous_index = [n-2, -1] and
          current_index = [n-1, 0]

        - Iterative Approach:

            - Use Nested loop to fill the cache of size: [n+1][n+1] (extra row and column to handle the base condition).

            - Algorithm:

                // Base Conditions:
                - for previous_index = [-1, n-2]:
                    - cache[previous_index+1][n] = 0; // no elements to include in the subsequence.

                // Backtracking:
                - for previous_index = [n-2, -1]:

                    - for current_index = [n-1, 0]:

                        // Option 1: Include the current element (if valid)
                        - include = 0 // assume current element cannot be included
                        - if nums[current_index] > nums[previous_index]:
                            - include = 1 + cache[current_index, current_index + 1];

                        // Option 2: Exclude the current element
                        - exclude = cache[previous_index + 1, current_index + 1];

                        - cache[previous_index+1][current_index] = max(include, exclude);

                - return cache[0][0];

            - Time Complexity: O(n^2).

            - Space Complexity: O(n^2).

            - Space-Based Optimizations:

                - Each cache[previous_index][current_index] depends only on the values from the next column, i.e.,
                  [current_index + 1].


*/

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int helper(int[] nums, int previous_index, int current_index, int[][] cache) {

        // Base Conditions:
        if(current_index == nums.length) return 0; // no elements to include in the subsequence.

        // Optimizations:
        if(cache[previous_index+1][current_index] != -1) return cache[previous_index+1][current_index];

        // Recursive Steps:

        // Option 1: Include the current element (if valid)
        int include = 0; // assume current element cannot be included
        if(previous_index == -1 || nums[current_index] > nums[previous_index]) {
            include = 1 + helper(nums, current_index, current_index + 1, cache);
        }

        // Option 2: Exclude the current element
        int exclude = helper(nums, previous_index, current_index + 1, cache);

        return cache[previous_index+1][current_index] = Math.max(include, exclude);

    }

    public static int lengthOfLISRecursive(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(cache[i], -1);
        return helper(nums, -1, 0, cache);
    }

    public static int lengthOfLISIterative(int[] nums) {

        int n = nums.length;
        int[][] cache = new int[n+1][n+1]; // by default, base conditions: cache[:][n] = 0 is already fulfilled.

        for( int previous_index = n-2; previous_index >= -1; previous_index-- ) {

            // only solve valid sub-problems, i.e., where current_index > previous_index
            for(int current_index = n-1; current_index > previous_index; current_index-- ) {

                // Option 1: Exclude the current element
                int currentLIS = cache[previous_index + 1][current_index + 1];

                // Option 2: Include the current element (if valid)
                if(previous_index == -1 || nums[current_index] > nums[previous_index]) {
                    currentLIS = 1 + cache[current_index][current_index + 1];
                }

                cache[previous_index + 1][current_index] = currentLIS;

            }

        }

        return cache[0][0];

    }

    public static void main(String[] args) {
        //int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1,2,3};
        System.out.println(lengthOfLISIterative(nums));
    }

}
