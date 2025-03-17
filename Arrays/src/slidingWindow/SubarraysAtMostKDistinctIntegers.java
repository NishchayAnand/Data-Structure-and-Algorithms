package slidingWindow;

/*

    Problem Statement:

        - Given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the
          count of distinct integers is at most k.

        - Sample Input: arr = [3,3,1,1,1,2], k = 2; output = 19

    General Observations:

        - The problem involves finding all subarrays whose frequency map's size <= k.

        - Brute Force Approach:

            - Use nested loop {i,j} to iterate over all subarrays and maintain count of the subarrays whose frequency
              map's size <= k.

            - Algorithm:
                - count = 0;
                - loop from i = [0, n) to iterate over all starting indices:
                    - unique_set = [];
                    - loop from j = [i, n) to explore all subarrays starting from index = i:
                        - unique_set.add(arr[j]);
                        - if unique_set.size <= k: count++;
                        - if unique_set.size > k: break; (optimization) -> once the count of unique integers exceeds k,
                                                                           further extensions of the subarray would also
                                                                           exceed k.

            - Time Complexity:
                - In the worst-case scenario, i.e., when the number of unique integers in the entire arr[] array <= k,
                  the number of operations executed will be of the order n^2.
                - Hence, time complexity = O(n^2).

            - Space Complexity:
                - The unique_set will hold at most k integers.
                - Hence, space complexity = O(k).

        - For a window [i, j] that contains at most k distinct integers, there exist (j−i+1) valid subarrays ending
          at 'j' whose frequency map's size <= k.

        - Sliding Window Approach:

            - Use two pointers (left, right) and a frequency map to iterate over all windows that contain at most k
              unique integers (expand right to grow the window, shrink left to make the window valid) and keep count of
              (right - left + 1) valid subarrays at each step.

            - Algorithm:
                - count = 0;
                - left = 0, right = 0;
                - while right < n:
                    - frequency_map[arr[right]]++;
                    - while window is not valid, i.e., frequency_map.size > k:
                        - frequency_map[arr[left]]--;
                        - if frequency_map[arr[left]] == 0: frequency_map.remove(arr[left]);
                        - left++;
                    - count += (right-left+1);
                - return count;

            - Time Complexity:
                - Each integer will be processed at most twice (once when added to the window, once when removed from the window).
                - Hence, time complexity = O(2*n) = O(n).

            - Space Complexity:
                - The frequency_map will store at most k integers.
                - Hence, space complexity: O(k).

*/

import java.util.HashMap;
import java.util.Map;

public class SubarraysAtMostKDistinctIntegers {

    public static int atMostK(int arr[], int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0, left = 0;
        for(int right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            while(freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if(freqMap.get(arr[left]) == 0) freqMap.remove(arr[left]);
                left++;
            }
            count += (right-left+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,1,1,1,2};
        int k = 2;
        System.out.println(atMostK(arr, k));
    }
}
