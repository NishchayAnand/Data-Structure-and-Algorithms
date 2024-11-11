
/*

    Problem Statement: A conveyor belt has packages that must be shipped from one port to another
                       within 'days' days. The 'ith' package on the conveyor belt has a weight of
                       'weights[i]'. Each day, we load the ship with packages on the conveyor belt
                       (in the order given by weights). We may not load more weight than the maximum
                       weight capacity of the ship.

                       Return the least weight capacity of the ship that will result in all the
                       packages on the conveyor belt being shipped within 'days' days.

    General Observations

        - For any possible minimumWeightCapacity, we would be able to split the 'weights' array into
          'days' subarrays such that no subarray sum is greater than the selected minimumWeightCapacity.

        - Each element in 'weights' must be part of at least one subarray. This means that no matter
          how we split the array, every element needs to be included in some subarray.

        - For any minimumLargestSubarraySum < max(weights), it would be impossible to create a
          subarray that contains max(weights) element without exceeding that minimumLargestSubarraySum.

        - Brute Force Approach: Linear Search

            - Start from minimumLargestSubarraySum = max(weights) and continue incrementing it till we
              reach a minimumLargestSubarraySum such that we can divide the 'weights' array into
              'days' subarrays and no subarray sum greater than minimumLargestSubarraySum.

            - Time Complexity: O(rangeOfMinimumLargestSubarraySum*n).

            - Space Complexity: O(1).

        - Optimized Approach: Binary Search

            -

*/

public class CapacityToShipPackagesDDays {

    private static int getMax(int[] weights) {
        int maxi = Integer.MIN_VALUE;
        for(int weight: weights) {
            maxi = Math.max(maxi, weight);
        }
        return maxi;
    }

    private static boolean canSplit(int[] weights, int days, int minLargestCapacity) {
        int dayCount = 1;
        int currCapacity = 0;
        for(int weight: weights) {
            if(currCapacity + weight <= minLargestCapacity) {
                currCapacity += weight;
            } else {
                dayCount++;
                currCapacity = weight;
            }
        }
        return dayCount == days;
    }

    private static int bruteForce(int[] weights, int days) {
        int minLargestCapacity = getMax(weights);
        int output = -1;
        while(true) {
            if(canSplit(weights, days, minLargestCapacity)) {
                output = minLargestCapacity;
                break;
            } else {
                minLargestCapacity++;
            }
        }
        return output;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int output = -1;
        return output;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(bruteForce(weights, days));
    }
}
