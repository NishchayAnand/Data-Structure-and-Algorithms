package slidingWindow;

/*

    Problem Statement:

        - Given an array containing positive elements, return the length of the longest subarray containing at most two
          distinct integers.

        - Sample Input: arr = [3,3,1,1,2]; output = 4 ([3,3,1,1])

    General Observations:

        - The problem involves finding the longest subarray whose frequency map's size = 2.

        - Brute Force Approach:

            - Use a nested loop [i,j] to iterate over all subarrays and keep track of the longest subarray whose
              frequency map's size = 2.

            - Algorithm:
                - max_length = 0;
                - loop from i = [0, n) to iterate over each possible starting index:
                    - unique_set = [];
                    - loop from j = [i, n) to expand the subarray starting from ith index one element at a time:
                        - unique_set.add(arr[j]);
                        - if unique_set.size <=2: max_length = max(max_length, j-i+1);
                        - if unique_set.size > 2: break; (optimisation) -> once the count of unique integers exceeds 2,
                                                                           further extension of the subarray would also
                                                                           exceed k.

            - Time Complexity:
                - In the worst-case scenario, i.e., when the number of unique integers in the entire 'arr' array < k,
                  the number of operations executed will be of the order n^2.
                - Hence, time complexity = O(n^2).

            - Space Complexity:
                - The HashSet will only store 2 distinct integers.
                - Hence, space complexity = O(2) ~ O(1).

            - Redundant Operations:
                - For each new starting index i, we rebuild the set of unique elements from scratch in the inner loop.
                - If arr[i,j] represents the longest subarray containing at most 2 distinct integers, rechecking [i+1,j]
                  is unnecessary since length of all subarrays in the range [i+1, j] would be less than arr[i,j].

        - Sliding Window Approach:

            - Use two pointers (left, right) and a frequency map to maintain a dynamic window with at most two distinct
              integers, expanding right to grow the window and shrinking left when a third integer appears.

            - Algorithm:
                - left = 0, right = 0;
                - max_length = 0;
                - while right < n:
                    - frequency_map[arr[right]]++;
                    - while window is not valid, i.e., frequency_map.size > 2:
                        - decrement the count of arr[left] in the frequency_map;
                        - if count of arr[left] in the frequency_map becomes 0:
                            - remove arr[left] from the frequency_map;
                        - do left++ to shrink the window;
                    - update max_length = max(max_length, right-left+1);
                    - right++;

            - NOTE: For each iteration of the right pointer, we are trying to find the longest subarray with at most 2
                    distinct integers ending at index = right.

            - Time Complexity:
                - Each element is processed at most twice (once when added to frequency_map, once when removed from the frequency_map).
                - Hence, time complexity = O(2*n) ~ O(n).

            - Space Complexity:
                - The frequency_map will at most store 2 keys simultaneously.
                - Hence, space complexity = O(2) ~ O(1).

*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayAtMost2DistinctInteger {

    public static int totalElements(Integer[] arr) {
        int maxLength = 0, left = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0)+1);
            while(freqMap.size() > 2) {
                freqMap.put(arr[left], freqMap.get(arr[left])-1);
                if(freqMap.get(arr[left]) == 0) freqMap.remove(arr[left++]);
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,3,1,1,2};
        System.out.println(totalElements(arr));
    }

}
