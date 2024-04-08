import java.util.HashMap;

/* Problem Statement: Given an array of integers 'nums' and an integer 'target', return indices of the two
 * 		 			  numbers such that they add up to target.
 * 
 * 					  Constraints:
 * 						- Only one valid answer exists.
 * 						- Don't use the same element twice.
 * 
 * 					  NOTE: Input array can contain duplicate elements. 
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach:
 * 		
 * 		- Use a nested loop such that:
 * 			- the outer loop iterates through each element in the array. 
 * 			- the inner loop iterates through all subsequent elements (after the current element) in the 
 * 			  array. 
 * 
 * 		- NOTE: The inner loop only needs to consider elements after the current element because 
 * 			    combinations involving elements before the current element have already been checked in 
 * 			    earlier iterations of the outer loop.
 * 
 * 		- Time Complexity: O(n^2).
 * 	
 * 		- Space Complexity: O(1).
 * 
 * 	- Optimized Approach: 
 * 
 * 		- Let [i,j] be the indices of the two numbers, such that (nums[i] + nums[j] = 'target') && (i<j).
 * 
 * 		- Iterate over the input array and use a HashMap to store each visited element and its 
 * 		  corresponding index.
 * 		
 * 		- For any 'jth' integer in the input array, if there exists a key = ('target'-nums[j]) in HashMap,
 * 		  then we have found the required pair of elements whose sum = 'target'.   
 *            
 *      - Time Complexity: O(1). 
 *      
 *      - Space Complexity: O(1). 
 * 		  
 * */

public class TwoSum {
	
	private static int[] twoSum(int[] nums, int target) {
		
		int[] output = new int[2];
		
		// To store each integer and its corresponding index.
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int j=0; j<nums.length; j++) {
			int alterElement = target - nums[j];
			if(hm.containsKey(alterElement)) {
				output[0] = hm.get(alterElement);
				output[1] = j;
				break;
			}
			hm.put(nums[j], j);
		}
		
		return output;
        
    }

	public static void main(String[] args) {
		
		int[] nums = {2,7,11,15};
		int target = 9;
		
		int[] pair = twoSum(nums, target);
		
		System.out.println("Pair whose sum = " + target + " is: [" + pair[0] + ", " + pair[1] + "]");

	}

}
