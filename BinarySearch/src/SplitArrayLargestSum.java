
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

            - Time Complexity: O(n^2.k)

            - Space Complexity: O(n.k) + O(k) = O(n.k)

        - Minimum Largest Subarray Sum when we can split array into:
                - k = n subarrays (each element in its own subarray) = min(nums).
                - k = 1 subarray (one subarray containing all elements) = sum(nums).

        - MinLargestSubarraySum for any 'k' would lie between [min(nums), sum(nums)].

        - For any minLargestSubarraySum, if we can split the array into 'k' subarrays s.t. no
          subarray sum exceeds minLargestSubarraySum, then the largestSubarraySum is the required
          answer.

        - Greedy Approach: Binary Search

                - Perform a binary search on minLargestSubarraySum in the range [max(nums), sum(nums)].

            - Take 'mid = (left+right)/2' as LargestPossibleSubarraySum and try to split 'nums'
              into 'm' subarrays such that no SubarraySum exceeds 'mid':

                - if m < k: All values in the range [mid, right] will lead to a split less than k.
                            Hence, reduce the search space by setting right = mid-1.

                - if m = k: 'mid' is a feasible minLargestSubarraySum value. However, reduce the
                            search space by setting right = mid-1 to check if there's another
                            minLargestSubarraySum < 'mid'.

                - if m > k: All values in the range [left, mid] will lead to split greater than k.
                            Hence, reduce the search space by setting left = mid+1.

            - left == right is the condition when all possible minLargestSubarraySum in the range
              [left, mid-1] and [mid+1, right] would have been explored, and 'mid' would be
              representing the smallest feasible minLargestSubarraySum.

            - Time Complexity: O(log(sum(nums))).

            - Space Complexity: O(1).

*/

public class SplitArrayLargestSum {

    private static boolean isFeasible(int[] nums, int mid, int k) {
        int count = 1;
        int currSum = 0;
        for(int num: nums) {
            if(currSum+num <= mid) {
                currSum+= num;
            } else {
                currSum = num;
                count++;
            }
        }
        return count <= k;
    }

    public static int splitArray(int[] nums, int k) {

        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int num: nums) {
            left = Math.max(left, num);
            right += num;
        }

        int output = -1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(isFeasible(nums, mid, k)) {
                output = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return output;

    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

}
