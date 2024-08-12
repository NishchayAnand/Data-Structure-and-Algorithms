
/* Problem Statement: Given an array of positive integers nums and a positive integer target, return the 
 * 			 		  minimal length of a subarray whose sum is greater than or equal to target. If there 
 * 					  is no such subarray, return 0 instead.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- Use a nested loop to iterate over each possible subarray and find the subarray whose length is 
 * 		  minimum and sum of elements is less than or equal to the given target.
 * 
 * 		- Algorithm:
 * 
 * 			- minLength = Integer.MAX_VALUE;
 * 			- Loop from i = [0, n): -> i marks the start of a subarray.
 * 				- currSubArraySum = 0;
 * 				- Loop from j = [i, n) -> j marks the end of the subarray that starts with i.
 * 					- currSubArraySum += nums[j];
 * 					- if currSubArraySum >= target:
 * 						- minLength = min(minLength, j-i+1);
 * 						- break;
 * 
 * 			- if minLength == Integer.MAX_VALUE:
 * 				- return 0;
 * 			- else:
 * 				- return minLength;
 * 
 * 		- Time Complexity: O(n^2).
 * 
 * 		- Space Complexity: O(1).
 * 
 * 	- Let two pointers (i,j) represent the smallest subarray starting from index 'i' whose sum of element 
 *    is less than or equal to 'target'. This means the sum of elements in the range [i+1, j] would be
 *    less than 'target'. Hence, for finding the smallest subarray starting from index 'i+1', we can start
 *    exploring the subarrays from 'j+1' rather than starting from j=i. This approach is known as dynamic
 *    sliding window approach.
 * 
 * */

public class MinimumSizeSubarraySum {
	
	public static int minSubArrayLenBruteForce(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int currSubarraySum = 0;
            for(int j=i; j< nums.length; j++) {
                currSubarraySum += nums[j];
                if(currSubarraySum >= target) {
                    minLength = Math.min(minLength, (j-i+1));
                    break;
                }
            }
        }

        if(minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
        
    }
	
	public static int minSubArrayLen(int target, int[] nums) {
		
		int minLength = Integer.MAX_VALUE;
		int i=0;
		int currSubarraySum = 0;
		
		for(int j=0; j<nums.length; j++) {
			currSubarraySum += nums[j];
			while(currSubarraySum >= target) {
				minLength = Math.min(minLength, j-i+1);
				currSubarraySum -= nums[i];
				i++;
			}
		}
		
		if(minLength == Integer.MAX_VALUE) {
			return 0;
		}
		
		return minLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
