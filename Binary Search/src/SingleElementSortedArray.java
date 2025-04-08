
/*

    Problem Statement:

        - Given a sorted array where every element appears exactly twice, except for one element which appears exactly
          once. Return the single element that appears only once.

    General Observations:

        Q. What would be the output of the following input: nums = [1,1,2,3,3,4,4]?
        A. Output = 2.

        Q. What would be the output of the following input: nums = [1]?
        A. Output = 1.

    Brute Force Approach:

        - Iterate over all elements in the nums[] array and find the element nums[i] such that nums[i-1] != nums[i]
          and nums[i] != nums[i+1].

        - Algorithm:
            - Base Condition: if n == 1: return nums[0];
            - Edge Case: if nums[0] != nums[1]: return nums[0]:
            - Edge Case: if nums[n-1] != nums[n-2]: return nums[n-1];
            - run loop for i in range [2, n-2):
                - if nums[i-1] != nums[i] and nums[i] != nums[i+1]: return nums[i];

        - Time Complexity: O(n).

        - Space Complexity: O(1).

    Optimization:

        - The single element is guaranteed to be present at an even index.

        - Algorithm:
            - Base Condition: if n == 1: return nums[0];
            - Edge Case: if nums[n-1] != nums[n-2]: return nums[n-1];
            - run loop for i in range [0, steps = 2, n-2) to iterate over all even indexes:
                - if nums[i] != nums[i+1]: return nums[i];

        - Time Complexity: O(n/2) ~ O(n).

        - Space Complexity: O(1).

    Binary Search Approach:

        - Before the single element, pairs start at even indexes, i.e., the first occurrence of a number is at an even
          index and the second occurrence is at an odd index.

        - After the single element, the pattern reverses, i.e., the first occurrence comes at an odd index and the second
          occurrence is at an even index.

        - Algorithm:
            - Base Condition: if n == 1: return nums[0];
            - Edge Case: if nums[0] != nums[1]: return nums[0]:
            - Edge Case: if nums[n-1] != nums[n-2]: return nums[n-1];
            - low = 2, high = n-3;
            - while low <= high:
                - mid = (low + high) / 2;
                - if (nums[i-1] != nums[i]) and (nums[i] != nums[i+1]): return nums[i];
                - if (mid is even) and (nums[mid] == nums[mid+1]): low = mid + 2;
                - if (mid is even) and nums[mid] != nums[mid+1]): high = mid - 2;
                - if (mid is odd) and (nums[mid] == nums[mid+1]): high = mid - 1;
                - if (mid is odd) and (nums[mid] != nums[mid+1]):  low = mid + 1;

        - Time Complexity: The search space is getting reduced to half in each iteration. Hence, time complexity = O(logn).

        - Space Complexity: O(1).

*/


public class SingleElementSortedArray {

    public static int singleNonDuplicateBF(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Base Condition
        for(int i=0; i<n; i++) {
            if ((i-1 < 0 || nums[i-1] != nums[i]) && (i+1 == n || nums[i] != nums[i+1])) return nums[i];
        }
        return -1; // Should not reach here if input is valid
    }

    public static int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0]; // Base Condition

        if (nums[0] != nums[1]) return nums[0]; // Edge Case
        if (nums[n-1] != nums[n-2]) return nums[n-1]; // Edge Case

        int low = 2, high = n-3;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if ((nums[mid-1] != nums[mid]) && (nums[mid] != nums[mid+1])) return nums[mid];
            else if (mid % 2 == 0) { // mid is even
                if ((nums[mid] == nums[mid+1])) low = mid + 2; // pair ordering (even, odd) matches before the single element
                else high = mid - 2; // pair ordering (odd, even) matches after the single element
            } else { // mid is odd
                if (nums[mid] == nums[mid+1]) high = mid - 1; // pair ordering (odd, even) matches after the single element
                else low = mid + 1; // pair ordering (even, odd) matches before the single element
            }
        }

        return -1; // Should not reach here if input is valid
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4};
        System.out.println(singleNonDuplicate(nums));
    }
}
