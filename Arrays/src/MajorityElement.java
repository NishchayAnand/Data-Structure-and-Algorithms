
/*

    - Problem Statement: Given an array 'nums' of size n, return the majority element.

                         NOTE: The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
                               that the majority element always exists in the array.

    - General Observations:

        - Count of the majority element in 'nums' array would be > n/2, where n = nums.length.

        - Brute Force Approach #1:

            - Sorting 'nums' array will guarantee that the element at index = n/2 will always be the majority element.

            - Time Complexity: O(nlogn).

            - Space Complexity: O(1).

        - Brute Force Approach #2:

            - Create a frequency map and return the element with frequency > n/2.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

       - Boyer-Moore Voting Algorithm:

            - Maintain a 'candidate' element and a 'count' of how many times this candidate has been "supported"
              (reoccurrence) or "rejected" (occurrence of another possible candidate) during the iteration over the
              array.

           - Time Complexity: O(n).

           - Space Complexity: O(1).

*/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    private static int majorityElementBruteForce(int[] nums) {

        int mElement = Integer.MIN_VALUE;
        Map<Integer, Integer> fMap = new HashMap<>();

        for(int num: nums) {
            fMap.put(num, fMap.getOrDefault(num, 0)+1);
            if(fMap.get(num) > nums.length/2) {
                mElement = num;
                break;
            }
        }

        return mElement;

    }

    private static int majorityElement(int[] nums) {

        int candidate = Integer.MIN_VALUE;
        int count = 0;

        for(int num: nums) {
            if(count == 0) candidate = num;
            count = num == candidate ? count + 1 : count - 1;
        }

        return candidate;

    }

    public static void main(String[] args) {

        int[] nums = {3,2,3}; // output: 3
        System.out.println(majorityElement(nums));

    }
}
