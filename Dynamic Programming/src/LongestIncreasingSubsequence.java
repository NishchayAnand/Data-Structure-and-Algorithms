
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
                - if nums[current_index] > nums[previous_index]:
                    - include = 1 + F(nums, current_index, current_index + 1);

                // Option 2: Exclude the current element
                - exclude = F(nums, previous_index, current_index + 1);

                - return max(include, exclude);

            - Base Conditions:

                - if current_index == nums.length: return 0; // no elements to include in the subsequence.

            - Time Complexity: O(2^n) in worst-case scenario (nums is sorted).

            - Space Complexity: O(n).

            - Time-Based Optimization (Memoization):

*/


public class LongestIncreasingSubsequence {

    private static int helper(int[] nums, int previous_index, int current_index) {

        // Base Conditions:
        if(current_index == nums.length) return 0; // no elements to include in the subsequence.

        // Recursive Steps:

        // Option 1: Include the current element (if valid)
        int include = Integer.MIN_VALUE;
        if(previous_index == -1 || nums[current_index] > nums[previous_index]) {
            include = 1 + helper(nums, current_index, current_index + 1);
        }

        // Option 2: Exclude the current element
        int exclude = helper(nums, previous_index, current_index + 1);

        return Math.max(include, exclude);

    }

    public static int lengthOfLISRecursive(int[] nums) {
        return helper(nums, -1, 0);
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISRecursive(nums));
    }
}
