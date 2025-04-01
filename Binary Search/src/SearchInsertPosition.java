
/*

    Problem Statement:

        - Given a sorted array of distinct integers 'nums' and a 'target' value, return the index if the target is found.

        - If not, return the index where it would be if it were inserted in order.

    General Observations:

        Q. What would be the output of the following input: nums = [1,3,5,6], target = 5?
        A. Output = 2.

        Q. What would be the output of the following input: nums = [1,3,5,6], target = 2?
        A. The method should return the first ith index from the left where nums[i] > target. Hence, output = 1.

        Q. What would be the output of the following input: nums = [1,3,5,6], target = 7?
        A. Output = 7.

    Brute Force Approach:

        - Loop over the nums[] array and return the first ith index where nums[i] > target.

        - Algorithm:
            - loop from i = [0, n):
                - if nums[i] > target: return i;
            - return nums.length;

        - Time Complexity:
            - In the worst-case scenario, i.e., when the max(nums) < target, the loop will execute for n times.
            - Hence, time complexity = O(n).

        - Space Complexity: O(1).

    Binary Search Approach:

        - When the binary search algorithm converges, we have 2 possible outcomes:
            - the 'target' element was found at index = 'mid' (where 'left' == 'right'), or
            - the 'target' element was not found and the 'left' pointer moved past the 'right pointer'

        - If the 'target' element was not found and the 'left' pointer moved past the 'right pointer':
            - all the elements in the range [0, right] will be smaller than the 'target' element, and
            - all the elements in the range [left, n) will be greater than the 'target' element.

        - Algorithm:
            - left = 0, right = n-1;
            - while left <= right:
                - mid = (left + right) / 2;
                - if nums[mid] == target: return mid;
                - if nums[mid] > target: right = mid-1 to explore the left search space;
                - if nums[mid] < target: left = mid+1 to explore the right search space;
            - return left;

        - Time Complexity: O(logn).

        - Space Complexity: O(1).

*/

public class SearchInsertPosition {

    public static int searchInsertBF(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid-1; // explore the left search space
            else left = mid+1; // explore the right search space
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }

}
