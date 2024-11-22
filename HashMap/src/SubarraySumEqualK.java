
/*

    Problem Statement: Given an array of integers 'nums' and an integer 'k', return the total number
                       of subarrays whose sum equals to 'k'.

                       For example: nums = {1, -1, 1, 1, 1, 1}, k = 3, output = 4

    General Observations:

        - Brute Force Approach:

            - Use a nested loop to iterate over all subarrays.

            - Time Complexity: O(n^2).

            - Space Complexity: O(1).

        - For any index 'i', we can have multiple subarrays ending at index 'i' whose sum = 'k'.

                        |------------------------|--------|
                index = 0                        i      (n-1)

                                         |-------| -> sum = k

                        |------------------------| -> sum = k


        - Instead of recalculating the sum for every possible subarray, use prefix sums to
          efficiently calculate the subarray sums using differences.

                        |------------------------|--------|
                index = 0                        i      (n-1)

                        |---------------||-------| -> prefix(i) - k = prefix(j)
                                        j        i

                        |------------------------| -> prefix(i) - k = 0
                        0                        i

        - Prefix Sum Approach:

            - For each index 'i', find count of subarrays in the range [0, i) whose prefix sum
              = prefixSum(i) - k.

            - Use a HashMap 'map' to store {prefixSum: count of subarrays with prefix sum = prefixSum}.

            - NOTE: For any index 'i', map.get(prefixSum(i) - k) will tell us the count of subarrays
                    ending at 'i' with sum = 'k'.

            - For num in 'nums':
                - prefixSum = prefixSum + num;
                - count += map.get(prefixSum - k, 0);
                - map.put(prefixSum, map.get(prefixSum, 0)+1);

            - NOTE: We need to add {prefix=0: count=1} in the map before starting computation to
                    handle cases where prefixSum == k.

*/

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int num: nums) {
            prefixSum += num;
            count += map.getOrDefault(prefixSum-k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,1};
        int k = 1;
        System.out.println(subarraySum(nums, k));

    }
}
