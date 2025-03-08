package slidingWindow;

/*

    Problem Statement:

        - Given an integer array 'nums' and an integer 'k', return true if there are two distinct indices 'i' and 'j'
          in the array such that nums[i] == nums[j] and abs(i - j) <= k.

    General Observations:

        - Brute Force Approach:

            - Use a nested loop to iterate over each {nums[i], nums[j]} pair and check if abs(i-j) <= k.

            - Algorithm:
                - loop from i = [0, n):
                    - loop from j = [i, n):
                        - if nums[i] == nums[j] && abs(i-j) <= k: return true;
                - return false;

            - Time Complexity: O(n^2).

            - Space Complexity: O(1).

        - For any nums[j], we only need to check if it was seen before within the last k indices, i.e., if there existed
          a nums[i] before nums[j] such that nums[i] == nums[j] and j-i <= k.

        - Map Approach:

            - Iterate over all nums[j] and use a map to keep track of the 'latest index' of each 'element'.

            - Algorithm:
                - loop from j = [0, n):
                    - element = nums[j];
                    - if (element in map) and (j - map[element] <= k): return true;
                    - map[element] = j;
                - return false;

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - The problem involves finding duplicate elements in all possible windows of length = k+1.

        - Sliding Window Approach:

            - Explore all possible windows of length = k+1. Use a set to keep track of at most k+1 recent elements.

*/

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicateMap(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicateMap(nums, k));
    }
}
