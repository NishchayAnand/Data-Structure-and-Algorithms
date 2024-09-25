
/*

    Problem Statement: Given an integer array nums, find the subarray with the largest sum, and return its sum.

    General Observations:

        - Brute Force Approach:

            - Use a nested loop to iterate over all possible subarrays and find the largest attainable subarray sum.

            - Example: nums = [-2,-1,0,3,4]

                - subarrays ending from -2: [-2]
                - subarrays ending from -1: [-2,-1]         < [-1]
                - subarrays ending from 0 : [-2,-1,0]       < [-1,0]        < [0]
                - subararys ending from 3 : [-2,-1,0,3]     < [-1,0,3]      < [0,3]     = [3]
                - subarrays ending from 4 : [-2,-1,0,3,4]   < [-1,0,3,4]    < [0,3,4]   = [3,4] (Answer) > [4]

            - Time Complexity: O(n^2).

            - Space Complexity: O(1).

        - Every integer in the input array 'nums' can either be a part of a subarray or start of a subarray.

        - Greedy Approach:

            - Loop over each num in 'nums':
                maxSumEndingWithNum = max(num+maxSumEndingWithNum, num);
                globalMax = max(maxSumEndingWithNum, globalMax);

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class MaximumSubarray {

    public static int maxSubarraySum(int[] nums) {

        int globalMax = nums[0];
        int localMax = nums[0];

        for(int i=1; i<nums.length; i++) {
            localMax = Math.max(nums[i] + localMax, nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;

    }

    public static void main(String args[]) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarraySum(nums));
    }

}
