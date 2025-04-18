
/*

    Problem Statement:

        - Given two sorted arrays 'nums1' and 'nums2', return the median of the two arrays.

        - Example: nums1 = [1,2], nums2 = [3,4]; Output = 2.5 (merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5)

    General Observations:

        - Can 'nums1' and 'nums2' be of varying length?
        - Yes, 'nums1' and 'nums2' can have different numbers of elements.

        - Can there be duplicate elements in 'nums1' and 'nums2'?
        - Yes, the two arrays can have duplicate among themselves.

        - Can there be common elements in 'nums1' and 'nums2'?
        - Yes, the two arrays can have duplicates across each other.

    Brute Force Approach:

        - Merge 'nums1' and 'nums2', sort the merged array and find the median.

        - Algorithm:
            - merged = nums1 + nums2;
            - sort(merged);

            - n = merged.length;
            - mid = n / 2;
            - if n % 2 == 0, the length of the merged array is even:
                - return ( merged[mid - 1] + merged[mid] ) / 2;
            - else, the length of the merged array is odd:
                - return merged[mid];

        - Time Complexity:
            - The number of operations performed for merging 'nums1' and 'nums2' will be of the order (m+n).
            - The number of operations performed for sorting the merged array will be of the order (m+n)*log(m+n).
            - Hence, time complexity = O( (m+n)*log(m+n) ).

        - Space Complexity:
            - The space consumed by the merged array will be of the order (m+n).
            - Hence, space complexity = O(m+n).

    - Two Pointers Approach:

            - Considering 'nums1' and 'nums2' are sorted, we can use two pointers to create the merged sorted array.

            - Time Complexity: O(m+n).

            - Space Complexity: O(m+n).

    - Binary Search Approach:

        - Intuition:

            - The two sorted arrays can be partitioned such that the left half of the merged array consists of elements
              from the left side of the partition in both arrays (nums1_left and nums2_left), and the right half consists
              of elements from the right side of the partition in both arrays (nums1_right and nums2_right).

            - If (m+n) is even, median = ((max(max_nums1_left, max_nums2_left) + min(min_nums1_right, min_nums2_right)) / 2

            - If (m+n) is odd, median = min(min_nums1_right, min_nums2_right)

        - NOTE: Always consider the middle element in the merged array to be part of the right half.

        - Key Observation: Once we choose a partition index in one array, the corresponding partition index in the other
                           array can be automatically determined (since we know how many elements should be on the left half
                           of the merged array).

        - Run binary search on the smaller array (since the time complexity depends on the length of the array we search)
          to find the valid partition such that (max_nums1_left <= min_nums2_right) and (max_nums2_left <= min_nums1_right).

        - Algorithm:
            - let nums1 = smaller array, nums2 = larger array;
            - m = nums1.length, n = nums2.length;
            - total = m + n;
            - half = total / 2;

            - left = 0, right = m;
            - while left <= right:
                - i = (left + right) / 2; // nums1's partition (number of elements in left part)
                - j = total - i; // nums2's partition

                - max_nums1_left = if i == 0: Integer.MIN_VALUE; else: nums1[i-1];
                - min_nums1_right = if i == m: Integer.MAX_VALUE; else: nums1[i];

                - max_nums2_left = if j == 0: Integer.MIN_VALUE; else: nums2[j-1];
                - min_nums2_left = if j == n: Integer.MAX_VALUE; else: nums2[j];

                - if (max_nums1_left <= min_nums2_right) and (max_nums2_left <= min_nums1_right), found the valid partition:
                    - if total is even: return ((max(max_nums1_left, max_nums2_left) + min(min_nums1_right, min_nums2_right)) / 2;
                    - else: return min(min_nums1_right, min_nums2_right);

                - if max_nums1_left > min_nums2_right, increase elements in the left part of nums2 by decreasing elements in the left part of nums1:
                    - right = i - 1;

                - if max_nums2_left > min_nums1_right, decrease elements in the left part of num2 by increasing elements in the left part of nums1:
                    - left = i + 1;

        - Time Complexity: O( log(min(m,n)) ).

        - Space Complexity: O(1).

        - NOTE: Where right = m - 1 Fails: nums1 = [1, 2] nums2 = [3, 4, 5, 6]. Here, the optimal partition is taking all
                2 elements from nums1 on the left — i.e., i = 2 — and the rest from nums2. But if right = 1, your binary
                search will never try i = 2, and you'll miss the correct partition.

*/

public class MedianTwoSortedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int total = m + n;
        int half = total / 2;

        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2;      // nums1's partition (number of elements in left part)
            int j = half - i;                // nums2's partition

            int maxNums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minNums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxNums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minNums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxNums1Left <= minNums2Right && maxNums2Left <= minNums1Right) {
                // Found valid partition
                if (total % 2 == 0) {
                    return (Math.max(maxNums1Left, maxNums2Left) + Math.min(minNums1Right, minNums2Right)) / 2.0;
                } else {
                    return Math.min(minNums1Right, minNums2Right);
                }
            } else if (maxNums1Left > minNums2Right) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        // Fallback (should never hit this line if input is valid)
        return -1.0;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
