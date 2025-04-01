package slidingWindow;

/*

    Problem Statement:

        - Given an array of positive integers 'nums' and a positive integer 'target', return the minimal length of a
          subarray whose sum is greater than or equal to 'target'. If there is no such subarray, return 0 instead.

        - NOTE: A subarray is a contiguous non-empty sequence of elements within an array.

        - Sample Input: target = 7, nums = [2,3,1,2,4,3]; output = 2 (subarray [4,3] has the minimal length).

    General Observations:

        - The problem involves finding the shortest contiguous subarray in 'nums' whose sum >= 'target'.

        - Brute Force Approach:

            - Use nested loop to find the shortest subarrays starting from each integer whose sum >= 'target' and keep
              track of the smallest subarray length found.

            - Algorithm:
                - min_length = Infinity;
                - loop from i = [0, n) to iterate over all possible starting indices:
                    - curr_subarray_sum = 0;
                    - loop from j = [i, n) to expand the subarray one integer at a time starting from index = i:
                        - curr_subarray_sum += nums[j];
                        - if curr_subarray_sum >= target:
                            - min_length = max(min_length, j-i+1);
                            - break from the inner loop since we found the valid subarray for starting index = i;
                - return min_length;

            - Time Complexity:
                - In the worst case scenario (i.e., when no subarrays sum > target), the nested loops will run n^2 times.
                - Hence, time complexity = O(n^2).

            - Space Complexity: O(1).

            - Redundant Operations:
                - If nums[i,j] represents the shortest subarray starting at index = i whose sum >= k, all subarrays in
                  the range (i,j) will have sum < k. Hence, it would be redundant to explore these subarrays. For example,
                  if [2,3,1,2] represents the shortest subarray in the range [0,3] whose sum >= 7, then all subarrays in
                  range [1,2]: [3], [3,1] and [1] would have sum < 7.

        - The problem involves sliding across all possible substrings (window) whose sum >= 'target'.

        - Sliding Window Approach:

            - Use two pointers (left and right) to iterate over all substrings whose sum >= k.

            - Algorithm:
                - n = nums.length, left = 0, right = 0;
                - min_length = Infinity;
                - curr_subarray_sum = 0;
                - while right < n:
                    - curr_subarray_sum += nums[right];
                    - while curr_subarray_sum >= target:
                        - min_length = min(min_length, right - left + 1);
                        - curr_subarray_sum -= nums[left++];
                - return min_length;

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class MinimumSizeSubarraySum {

    public static int minSubArrayLenBF(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int currSubarraySum = 0;
            for(int j=i; j<nums.length; j++) {
                currSubarraySum += nums[j];
                if(currSubarraySum >= target) {
                    minLength = Math.min(minLength, j-i+1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int currSubarraySum = 0;
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        for(int right=0; right<nums.length; right++) {
            currSubarraySum += nums[right];
            while(currSubarraySum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currSubarraySum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
