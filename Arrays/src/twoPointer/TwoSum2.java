package twoPointer;

/* Problem Statement: Given an array of integers 'nums' that is already sorted in non-decreasing order,
 * 					  find two numbers such that they add up to a specific 'target' number. 
 * 
 * 					  NOTE:
 * 					
 * 						- There is exactly one solution. 
 * 						- Do not use the same element twice.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: Nested loop approach of time complexity = O(n).
 * 
 *  - Optimized Approach (Two Pointers Technique):
 *  
 *  	- Assume nums[start = 0] and nums[end = n-1] to be the two numbers in the required pair. 
 *  
 *  	- Since, 'nums' is sorted in the ascending order:
 *  		- Incrementing 'start' pointer will increase the sum of the two numbers (nums[start]+nums[end]) 
 *  	  	  in the required pair.
 *  		- Decrementing 'end' pointer will decrease the sum of two numbers (nums[start]+nums[end]) in 
 *  		  the required pair. 
 *  
 *  	- Algorithm:
 *  
 *  		- let start = 0, end = n-1;
 *  
 *  		- while start < end:
 *  			- if (nums[start] + nums[end]) == target:
 *  				- return [start, end];
 *  
 *  			- else if (nums[start] + nums[end]) > target:
 *  				- decrement 'end' by 1 so that the sum of the numbers in the pair decreases.
 *  
 *   			- else if (nums[start] + nums[end]) < target:
 * 					- increment 'end' by 1 so that the sum of the numbers in the pair increases.
 * 
 * 		- Time Complexity: O(n).
 * 		
 * 		- Space Complexity: O(1).
 * */




public class TwoSum2 {
	
	private static int[] twoSum(int[] numbers, int target) {
		
		int[] output = new int[2];
		
		int start = 0;
		int end = numbers.length-1;
		
		while(start<end) {
			
			int sum = numbers[start]+numbers[end];
			
			if(sum == target) {
				output[0] = start+1;
				output[1] = end+1;
				break;
			} 
			else if(sum>target) {
				end--;
			} 
			else {
				start++;
			}
			
		}
		
		return output;
        
    }

	public static void main(String[] args) {
		
		int[] numbers = {2,7,11,15};
		int target = 9;
		
		int[] pair = twoSum(numbers, target);
		
		System.out.println("Indices of numbers whose sum = "+target+" are: ["+pair[0]+", "+pair[1]+"]");
 
	}

}
