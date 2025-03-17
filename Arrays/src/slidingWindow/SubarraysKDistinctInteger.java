package slidingWindow;

/*

    Problem Statement:

        - Given an integer array 'nums' and an integer 'k', return the number of subarrays containing exactly 'k'
          different integers.

        - Sample Input: nums = [1,2,1,2,3], k = 2; output: 7 ([1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2])

    General Observations:

        - The problem involves finding subarrays in 'nums' containing exactly 'k' distinct integers.

        - Brute Force Approach:

            - Use nested loop [i,j] to iterate over all subarrays and keep count of subarrays containing exactly 'k'
              distinct integers.

            - Algorithm:
                - count = 0;
                - loop from i = [0, n) to iterate over all starting indices:
                    - uniqueSet = [];
                    - loop from j = [i, n) to iterate over all subarrays starting from the ith index:
                        - uniqueSet.add(nums[j]);
                        - if uniqueSet.size > k: break; (optimization) -> once the number of unique integers exceed k, further extension of the subarray will also exceed k.
                        - if uniqueSet.size == k: count++;
                - return count;

            - Time Complexity:
                - In the worst-case scenario, i.e., when the number of distinct integers in the entire 'nums' array <= k,
                  the number of operations executed will be of the order n^2.
                - Hence, time complexity = O(n^2).

            - Space Complexity:
                - In the worst-case scenario, i.e., when the number of distinct integers in the entire 'nums' array <= k,
                  the HashSet will store at most n elements simultaneously.
                - Hence, space complexity = O(n).

            - Redundant Operations:
                - While iterating over all subarrays, if we encounter a subarray whose size of the frequency map > k,
                  rather than re-starting the iteration from the next starting index, we can shrink the subarray (window)
                  from left to

*/

public class SubarraysKDistinctInteger {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }


}
