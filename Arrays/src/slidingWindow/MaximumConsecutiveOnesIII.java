package slidingWindow;

/*

    Problem Statement:

        - Given a binary array 'nums' and an integer 'k', return the maximum number of consecutive 1's in the array if
          you can flip at most 'k' 0's.

        - Sample Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2; Output: 6 ([1,1,1,0,1,1,1,1,1,1,0])
                                                                                   - -
                                                                                   ___________

    General Observations:

        - The problem involves exploring all subarrays where the count of 0's <= k and keeping track of the longest one.

        - Brute Force Approach:

            - Use nested loop (i,j) to iterate over all subarrays and keep track of the longest subarray where the count
              of 0's <= k.

            - Algorithm:
                - maxLength = 0;
                - loop from i = [0,n) to iterate over all starting indices:
                    - count = 0;
                    - loop from j = [i,n) to explore all subarrays starting from index = i:
                        - if nums[j] == 0: count++;
                        - if count <= k: maxLength = max(maxLength, j-i+1);
                        - if count > k: break; (optimization) -> once the count of 0's exceed k, count of 0's in
                                                                 further subarrays starting at i would also exceed k.
                - return count;

            - Time Complexity:
                - In the worst-case scenario, i.e., when the entire nums[] array only contains 1, the number of operations
                  executed will be of the order n^2.
                - Hence, time complexity = O(n^2).

            - Space Complexity: O(1).

            - Redundant Operations:
                - If nums[i, j] represents the longest valid subarray starting from index i, then any subarray that starts
                  between (i, j] and ends at j will be shorter than nums[i, j] and recomputing the number of 0s for these
                  subarrays would be redundant. (no need to reset j pointer after every ith iteration)

        - Sliding Window Approach:

            - Use two pointers (left, right) to expand the window while counting 0s and shrink from the left whenever 0s
              exceed k to maintain validity, keeping track of the longest valid subarray.

            - Algorithm:
                - maxLength = 0;
                - count = 0;
                - left = 0, right = 0;
                - while right < n:
                    - if nums[right] == 0: count++;
                    - while(count > k):
                        - if nums[left] == 0: count--;
                        - left++;
                    - maxLength = max(maxLength, right-left+1);
                - return maxLength;

            - Time Complexity:
                - Each integer in the nums[] array would be processed at most twice.
                - Hence, time complexity = O(2*n) ~= O(n).

            - Space Complexity: O(1).

*/

public class MaximumConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0, count = 0, left = 0;
        for(int right=0; right<nums.length; right++) {
            if( nums[right] == 0 ) count++;
            while(count > k) {
                if(nums[left] == 0) count--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k)); // Output: 6
    }
}
