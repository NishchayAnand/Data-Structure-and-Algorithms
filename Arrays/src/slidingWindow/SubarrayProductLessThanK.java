package slidingWindow;

/*

    Problem Statement:

        - Given an array of integers nums and an integer k, return the number of subarrays where the product of all the
          elements < k.

        - Sample Input: [10,5,2,6], k = 100; Output = 8 ([10], [10,5], [5], [5,2], [5,2,6], [2], [2,6], [6])

    General Observations:

        - The problem involves finding all subarrays where the product of all the elements < k.

        - Brute Force Approach:

            - Use nested loop {i,j} to iterate over all subarrays and keep count of subarrays where product of all the
              elements < k.

            - Algorithm:
                - count = 0;
                - loop from i = [0, n) to iterate over all starting indices:
                    - product = 1;
                    - loop from j = [i, n) to iterate over all subarrays starting from index = i:
                        - product = product * nums[j];
                        - if product < k: count++;
                        - if product >= k: break; (optimization) -> once the product exceeds k, product of further
                                                                    extensions of the subarray would also exceed k.
                - return count;

            - Time Complexity:
                - In the worst case scenario, i.e., when the product of the entire nums[] array < k, the number of operations
                  executed will be of the order n^2.
                - Hence, time complexity = O(n^2).

            - Space Complexity: O(1).

        - For a window [i,j] where the product of all the elements < k, there exist (j-i+1) valid subarrays ending at
          index = 'j' where the product of all the elements < k.

        - Sliding Window Approach:

            - Use two pointers (left, right) to iterate over all valid windows (where the product of all the elements < k)
              ending at each index = 'right', keeping count of (right-left+1) valid subarrays at each step.

            - Algorithm:
                - count = 0, product = 1, left = 0, right = 0;
                - while right < n:
                    - product = product * nums[right];
                    - while the window is invalid, i.e., product >= k:
                        - product = product / nums[left];
                        - left++;
                    - count += (right-left+1);
                    - right++;
                - return count;

            - Time Complexity:
                - Each integer would be processed at most twice (once when added to the product, once when removed from the product).
                - Hence, time complexity = O(2*n) ~ O(n).

            - Space Complexity: O(1).

*/

public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0; // edge case: product of all the elements of a subarray cannot be less than 1
        int count = 0, product = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while(product >= k) product /= nums[left++];
            count += (right-left+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
