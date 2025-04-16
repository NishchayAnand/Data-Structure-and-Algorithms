
/*

    Problem Statement:

        - Given two sorted arrays 'nums1' and 'nums2' of size m and n respectively, return the median of the two sorted arrays.

        - Example: nums1 = [1,2], nums2 = [3,4]; Output = 2.5 (merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5)

    General Observations:

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

            - If (m+n) is odd, median = max(max_nums1_left, max_nums2_left)

        - Key Observation: Once we choose a partition index in one array, the corresponding partition index in the other
                           array can be automatically determined (since we know how many elements should be on the left half
                           of the merged array).

        - Use binary search to find the valid partition index such that the max(nums1_left) <= min(nums2_right) and
          max(nums2_left) <= min(nums1_right).

        - NOTE:





            4. To reduce the time complexity, we can run binary search on the smaller array (since the time complexity
               depends on the length of the array we search).

        - Algorithm:

            -

        - Time Complexity: O( log(min(m,n)) ).

        - Space Complexity: O(1).

*/

public class MedianTwoSortedArray {
}
