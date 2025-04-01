
/* Problem Statement: Given an array of integers 'nums' which is sorted in ascending order, and an
                      integer 'target', write a function to search 'target' in 'nums'. If 'target'
                      exists, then return its index. Otherwise, return -1.

   General Observations:

    - The key idea behind binary search is to repeatedly divide the search space in half.

    - Time Complexity Analysis:

        1. T(n) = T(n/2) + C
        2. T(n/2) = T(n/4) + C
        3. T(n/4) = T(n/8) + C
        .
        .
        .
        .
        k. T(1) = T(0) + C, n/(2^(k-1)) = 1

        - Summing all steps: T(n) = k.C = C.(logn+1) = O(logn).

    - Space Complexity: O(1).

*/

public class BinarySearch {

    private static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else { // nums[mid] > target
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
