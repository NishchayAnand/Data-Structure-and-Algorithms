
/*

    Problem Statement:

        - Given an integer array 'nums' sorted in non-decreasing order and possibly rotated k times (1 <= k < nums.length),
          and an integer 'target', return true if 'target' exists in 'nums', or false otherwise.

        - Example: nums = [2,2,2,3,4,2], target = 3; output = true


    General Observations - to confirm the constraints before proceeding, so as to design a solution that best fits the problem space:

        Q. Can there be duplicate, possibly even all identical values in 'nums'?
        A. Yes

        Q. Can 'nums' be empty?
        A. No

        Q. What is the maximum length of 'nums'?
        A. The length of 'nums' can go upto 5000.


    Binary Search Approach:

        - Trick: For a rotated sorted array, one half is always sorted and the other half can be treated as a smaller
                   rotated sorted array.

        - Key Observation: (nums[left] == nums[mid]) can happen even when (left != mid).

        - Algorithm:
            - low = 0, high = n-1;
            - while low <= high, the binary search doesn't converge:
                - mid = (low + high) / 2;
                - if nums[mid] == target, target exists: return true;
                - if nums[low] < nums[mid], left half is sorted:
                    - if nums[low] <= target < nums[mid], target lies in the left half: high = mid - 1;
                    - else target lies in the right half: low = mid + 1;
                - if nums[low] > nums[mid], right half is sorted:
                    - if nums[mid] < target <= nums[high], target lies in the right half: low = mid + 1;
                    - else target lies in the left half: high = mid - 1;
                - if nums[low] = nums[mid], nums[low] can be safely ignored:
                    - low++;

        - Time Complexity:
            - Average Time Complexity: O(logn).
            - In the worst-case scenario, i.e., when the entire nums[] array contains the same element != target, the
              algorithm will run n iterations. Hence, time complexity = O(n).

        - Space Complexity: O(1).

*/


public class SearchRotatedSortedArrayII {
}
