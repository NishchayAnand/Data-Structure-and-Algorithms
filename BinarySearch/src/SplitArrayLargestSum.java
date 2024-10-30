
/*

    Problem Statement: Given an integer array 'nums' and an integer 'k', split 'nums' into 'k'
                       non-empty subarrays such that the largest sum of any subarray is minimized.

                       Return the minimized largest sum of the split.


    General Observations:

        - Brute Force Approach:

            - We can recursively iterate over each possible subarray combinations and compute the
              minimum largest subarray sum possible.

            - Hypothesis: F(nums, n, k) will return the minimized largest subarray sum possible
                          when we optimally split the first 'n' elements into 'k' subarrays.

            - We need at least 'k' elements to partition an array into 'k' subarrays.

            - Recursive Steps:
                - currSum = 0;
                - minLargestSubarraySum = Infinity;
                - Loop from i = [n-1, k-1]: // 'k' elements exist between indices [0,k-1].
                    - currSum += nums[i]; // hold sum of the 'kth' subarray.
                    - largestSubarraySum = max(currSum, F(nums, i, k-1));
                    - minLargestSubarraySum = min(minLargestSubarraySum, largestSubarraySum);

            - Base Condition:
                - If k==1: // no partition required
                    - return sum(nums[0,n-1]);

            - NOTE: The recursive solution can be memoized by using a cache: mem[n+1][k+1].

            - Time Complexity:

            - Space Complexity:

        - Binary Search Approach:

            -


*/

public class SplitArrayLargestSum {

    public static void main(String[] args) {

    }

}
