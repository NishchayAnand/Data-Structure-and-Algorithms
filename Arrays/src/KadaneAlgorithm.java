
/* Problem Statement: Given an integer array, find the contiguous sub-array (containing at least 1 number)
 * 					  which has the maximum sum and return its sum.
 * 
 * General Observations:
 * 
 * 	- Need to check all contiguous sub-arrays. 
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- Loop over each contiguous sub-array using 2 pointer nested loop and find the maximum sum.
 * 
 * 		- Time Complexity: O(n^2).
 * 
 * 		- Space Complexity: O(1). 
 * 
 * 	- Kadane's Algorithm:
 * 		
 * 		- Greedy Approach to select the best possible sub-array for the index under-consideration.
 * 
 * 		- global max: will give the maximum sum out of the sub-arrays observed till the index 
 * 					  under consideration.  
 * 		- local max: will give the maximum sum of a contiguous sub-array that will include the element
 * 				     at the index under consideration.  
 * 
 * */



public class KadaneAlgorithm {
	
	public static int getMaxSubArraySum(int[] arr) {
		
		int global_max = arr[0];
        int local_max = arr[0];
        
        for(int i=1; i<arr.length; i++){
            local_max = Math.max(local_max+arr[i], arr[i]);
            global_max = Math.max(global_max, local_max);
        }
        
        return global_max;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1,-2,3};
		System.out.println(getMaxSubArraySum(arr));
		
	}

}
