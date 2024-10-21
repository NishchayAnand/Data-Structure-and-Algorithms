
/*

    Given: A 0-indexed integer array nums which may contains multiple peaks.

    Required Output: Return the index of any one of the peak elements.

    NOTE:
        - A peak element is an element that is strictly greater than its neighbors.
        - Imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be
          strictly greater than a neighbor that is outside the array.

    General Observations:

        - Brute Force Approach:

            - Loop over input array 'nums' and check for any element nums[i], s.t.,
              nums[i-1] < nums[i] < nums[i+1].

            - Time Complexity: O(n).

            - Space Complexity: O(1).

        -

*/


public class FindPeakElement {

    private static int findPeakElement(int[] nums) {
        return -1;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,1}; // Output = 2.
    }
}
