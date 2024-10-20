
/* Given: An integer array 'nums' sorted in ascending order (with distinct values), rotated at an
          unknown pivot index k (1 <= k < nums.length) such that the resulting array is
          [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]], and an integer
          'target'.

   Required Output: Return the index of 'target' if it is in 'nums', or -1 if it is not in 'nums'.

   General Observations:

    - Brute Force Approach:

        - Loop over input array 'nums' and check if nums[i] == target.

        - Time Complexity: O(n).

        - Space Complexity: O(1).

    - When you split a rotated sorted array of size = n into two halves (with mid as the dividing
      point):

        - for k = [1, n/2], the left half will always be sorted.
        - for k = [n/2+1, n-1], the right half will always be sorted.

        - For example, nums = [0,1,2,3,4,5], n = 6

                        k=1 = [1,2,3,4,5,0], nums[left] = 1 < nums[mid] = 3
                        k=2 = [2,3,4,5,0,1], nums[left] = 2 < nums[mid] = 4
                        k=3 = [3,4,5,0,1,2], nums[left] = 3 < nums[mid] = 5

                        k=4 = [4,5,0,1,2,3], nums[mid] = 0 < nums[right] = 3
                        k=5 = [5,0,1,2,3,4], nums[mid] = 1 < nums[right] = 4

    - Binary Search Approach:

        - If left half is sorted, i.e., nums[left] <= nums[mid] and nums[left] <= target < nums[mid],
          then target lies in the left half, else, target lies in the right half.

        - If right half is sorted, i.e., nums[mid] <= nums[right] and nums[mid] < target <= nums[right],
          then target lies in the right half, else, target lies in the right half.

        - Time Complexity: O(logn).

        - Space Complexity: O(1).

        NOTE: For cases like nums = [3,1], nums[left] = nums[mid].

*/

public class SearchRotatedSortedArray {

    private static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left <= right) {

            int mid = (left+right)/2;

            if(nums[mid]==target) {
                return mid;
            }
            // if left half is sorted
            else if(nums[left] < nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            // right half is sorted
            else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2}; // rotated at pivot index 3
        int target = 0;
        System.out.println(search(nums, target));
    }

}
