
/*

    Given: An array of length n sorted in ascending order, rotated between 1 and n times.

    NOTE: Rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
          [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    Required Output: Return the minimum element of this array.

    General Observations:

        - Brute Force Approach:

            - Linear Search: Loop over input array and find the minimum integer.

            - Time Complexity: O(n)

            - Space Complexity: O(1).

        - When you split a rotated array into two halves (with mid as the dividing point), at least
          one half will always be sorted.

            - If left half is sorted, minimum value in the left half = nums[left];
            - If right half is sorted, minimum value in the right half = nums[mid];

        - Binary Search Algorithm:

            - Take two pointers: left = 0 and right = n-1;
            - Let minimum_value = Infinity;
            - Loop while left <= right:
                - if left half is sorted, update minimum_value = min(minimum, nums[left]) and
                  reduce the search space to the right half.
                - if right half is sorted, update minimum_value = min(minimum, nums[mid]) and
                  reduce the search space to the left half.
            - return minimum_value;

            - Time Complexity: O(logn).

            - Space Complexity: O(1).

*/

public class MinimumRotatedSortedArray {

    private static int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            int mid = (left+right)/2;
            // left half is sorted
            if(nums[left]<=nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid+1;
            } else { // right half is sorted
                min = Math.min(min, nums[mid]);
                right = mid-1;
            }
        }

        return min;

    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,8,9,10,1,2,3,4}; // Output = 1
        System.out.println(findMin(nums));
    }
}
