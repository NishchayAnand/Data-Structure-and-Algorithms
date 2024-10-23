
/*

    Given: A 0-indexed integer array nums which may contains multiple peaks.

    Required Output: Return the index of any one of the peak elements.

    NOTE:
        - A peak element is an element that is strictly greater than its neighbors.
        - Imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be
          strictly greater than a neighbor that is outside the array.

    General Observations:

        - For corner elements, i.e., nums[0] and nums[n-1] we need to consider only one neighbor,
          i.e., if nums[0] > nums[1] and nums[n-1] > nums[n-2].

        - If the array has only one element, that element is a peak.

        - Brute Force Approach:

            - Perform a linear search to find the first peak element.

            - Time Complexity: O(n).

            - Space Complexity: O(1).

        - For an array sorted in ascending (increasing) order, nums[n-1] would be the peak element.
          Similarly, for an array sorted in descending (decreasing) order, nums[0] would be the
          peak element.

        - Binary Search Approach:

            - In a rising (increasing) sequence, at some point, the upward trend must either stop
              (creating a peak) or we reach the array boundary, which also counts as a peak.

            - In short, the peak would always lie in the direction of rising/increasing sequence.

            - Take two pointers: left = 0 and right = n-1;
            - Loop while left <= right:
                - mid = (left+right)/2;
                - If nums[mid] is the peak element, return mid;
                - If nums[mid] < nums[mid+1], we have a rising sequence in the right half, hence,
                  reduce the search space to the right half.
                - If nums[mid-1] > nums[mid], we have a rising sequence in the left half, hence,
                  reduce the search space to the left half.

            - Time Complexity: O(logn).

            - Space Complexity: O(1).

*/


public class FindPeakElement {

    private static int findPeakElementBruteForce(int[] nums) {

        int n = nums.length;

        int output = -1;
        for(int i=0; i<nums.length; i++) {
            if((i==0 || nums[i-1]<nums[i]) && (i==n-1 || nums[i]>nums[i+1])) {
                output = i;
                break;
            }
        }

        return output;
    }

    private static int findPeakElement(int[] nums) {

        int n = nums.length;
        int output = -1;

        int left = 0;
        int right = n-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==n-1 || nums[mid]>nums[mid+1])) {
                output = mid;
                break;
            } else if(mid>0 && nums[mid-1]>nums[mid]) { // left half is the rising sequence
                // NOTE: checking mid>0 is important to avoid array out of bound. Consider,
                // nums = [2,2].
                right = mid-1;
            } else { // right half is the rising sequence
                left = mid+1;
            }
        }

        return output;

    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,1}; // Output = 2.
        System.out.println(findPeakElementBruteForce(nums));

    }
}
