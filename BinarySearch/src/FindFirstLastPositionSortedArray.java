
/*

    Given: An array of integers 'nums' sorted in non-decreasing order and an integer 'target'.

    Required Output: Find the starting and ending position of a given 'target' value.

    NOTE: If 'target' is not found in the array, return [-1, -1].

    General Observations:

        - Brute Force Approach:

            - Start loop from the left of 'nums' and find the first occurrence of 'target'.
              Similarly, start loop from the right of 'nums' and find the first occurrence of
              'target'.

            - Time Complexity: O(n).

            - Space Complexity: O(1).

       - Binary Search Approach:

            - To find the first occurrence, when nums[mid]==target, continue searching in the left
              half, i.e., set right = mid-1, to see if there's another occurrence of the 'target'
              earlier in the array.

            - Similarly, to find the last occurrence, when nums[mid]==target, continue searching in
              the right half, i.e., set left=mid+1, to see if there's another occurrence of the
              'target' later in the array.

            - Time Complexity: O(logn) + O(logn) = O(logn).

            - Space Complexity: O(n).

*/


public class FindFirstLastPositionSortedArray {

    private static int getFirstOccurrence(int[] nums, int target) {

        int index = -1;

        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target) {
                index = mid;
                right = mid-1; // first occurrence could lie in the left half.
            } else if (target<nums[mid]) { // first occurrence could lie in the left half,
                right = mid-1;
            } else { // first occurrence could lie in the right half.
                left = mid+1;
            }
        }

        return index;

    }

    private static int getLastOccurrence(int[] nums, int target) {

        int index = -1;

        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target){
                index = mid;
                left=mid+1; // last occurrence could lie in the right half.
            } else if(target>nums[mid]) { // last occurrence could lie in the right half.
                left = mid+1;
            } else { // last occurrence could lie in the left half.
                right = mid-1;
            }
        }

        return index;

    }

    private static int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = getFirstOccurrence(nums, target);
        output[1] = getLastOccurrence(nums, target);
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,8,8,10};
        int target = 8;
        int[] output = searchRange(nums, target);
        System.out.println("["+output[0]+","+output[1]+"]");
    }
}
