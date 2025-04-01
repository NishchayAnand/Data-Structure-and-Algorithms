
/*

    Problem Statement: A conveyor belt has packages that must be shipped from one port to another
                       within 'days' days. The 'ith' package on the conveyor belt has a weight of
                       'weights[i]'. Each day, we load the ship with packages on the conveyor belt
                       (in the order given by weights). We may not load more weight than the maximum
                       weight capacity of the ship.

                       Return the least weight capacity of the ship that will result in all the
                       packages on the conveyor belt being shipped within 'days' days.

    General Observations

        - For any WeightCapacity, if we can split the 'weights' array into 'days' subarrays
          such that no subarraySum > WeightCapacity, then WeightCapacity is a possible solution.

        - We are required to find the minimumWeightCapacity satisfying the above requirement.

        - Each element in 'weights' must be part of at least one subarray. This means that no matter
          how we split the array, every element needs to be included in some subarray.

        - For any minimumWeightCapacity < max(weights), it would be impossible to create a
          subarray that contains max(weights) element without exceeding that minimumWeightCapacity.

        - Brute Force Approach: Linear Search

            - Start from minimumWeightCapacity = max(weights) and continue incrementing it till
              we reach a minimumWeightCapacity such that we can divide the 'weights' array into
              'days' subarrays and no subarray sum greater than minimumWeightCapacity.

            - Time Complexity: O(rangeOfMinimumWeightCapacity * n).

            - Space Complexity: O(1).

        - Optimized Approach: Binary Search

            - minimumWeightCapacity = sum(weights) is the largest possible value of
              minimumWeightCapacity that would allow us to ship the all packages on 1 day.

            - Perform binary search on minimumWeightCapacity in the range [max(weights), sum(weights)].

            - Algorithm:

                - Take 'mid = (left+right)/2' as minimumWeightCapacity and try to split 'weights'
                  into 'k' subarrays such that no SubarraySum exceeds 'mid':

                - if k < days: All values in the range [mid, right] will lead to a split less than
                               'days'. Hence, reduce the search space by setting right = mid-1.

                - if k = days: 'mid' is a feasible minimumWeightCapacity value. However, reduce the
                               search space by setting right = mid-1 to check if there's another
                               minimumWeightCapacity < 'mid'.

                - if k > days: All values in the range [left, mid] will lead to split greater than
                               'days'. Hence, reduce the search space by setting left = mid+1.

            - left == right is the condition when all possible minimumWeightCapacity in the range
              [left, mid-1] and [mid+1, right] would have been explored, and 'mid' would be
              representing the smallest feasible minimumWeightCapacity.

            - Time Complexity: O((sum(weights)-max(weights)) * n).

            - Space Complexity: O(1).

        - NOTE:

            - The largestSubarraySum is the maximum load of any single day, which represents the
              weightCapacity of the ship.

            - For all feasibleMinimumWeightCapacity (i.e., where k = days):
                    - the subarray split would be the same, and
                    - feasibleMinimumWeightCapacity >= largestSubarraySum.

            - The smallest feasibleMinimumWeightCapacity would represent the actual
              largestSubarraySum, i.e., when feasibleMinimumWeightCapacity = largestSubarraySum.

*/

public class CapacityToShipPackagesDDays {

    private static int getMax(int[] weights) {
        int maxi = Integer.MIN_VALUE;
        for(int weight: weights) {
            maxi = Math.max(maxi, weight);
        }
        return maxi;
    }

    private static int getSum(int[] weights) {
        int sum = 0;
        for(int weight: weights) {
            sum += weight;
        }
        return sum;
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
        int minWeightCapacity = getMax(weights);
        int output = -1;
        while(true) {
            if(canSplit(weights, days, minWeightCapacity)) {
                output = minWeightCapacity;
                break;
            } else {
                minWeightCapacity++;
            }
        }
        return output;
    }

    private static boolean isFeasible(int[] weights, int days, int minWeightCapacity) {
        int dayCount = 1;
        int currCapacity = 0;
        for(int weight: weights) {
            if(currCapacity + weight <= minWeightCapacity) {
                currCapacity += weight;
            } else {
                dayCount++;
                currCapacity = weight;
            }
        }
        return dayCount <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights);
        int right = getSum(weights);
        int output = -1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(isFeasible(weights, days, mid)) {
                output = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
