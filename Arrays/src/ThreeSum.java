import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* Problem Statement: Given an integer array 'nums', return all the triplets [nums[i], nums[j], nums[k]]
 * 					  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * 					  NOTE: The output should not contain duplicate triplets.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Use "3 Nested Loops - {i,j,k}" to check every possible triplet. 
 * 
 * 		- Time Complexity: O(n^3).
 * 
 * 		- Space Complexity: O(1). 
 * 
 * 		- NOTE: Duplicate integers in the input array can lead to duplicate triplets (if order of integers
 * 			    in the triplet does not matter). 
 * 
 * 				Example, for nums = [-1, 0, 1, 2, -1, 4, 1], the below mentioned triplets are all 
 * 				duplicates. 
 * 				
 * 					1. [nums[0] = '-1', nums[1] = '0', nums[2] = '1'] 
 * 					2. [nums[0] = '-1', nums[1] = '0', nums[6] = '1'] 
 * 					3. [nums[1] = '0', nums[2] = '1', nums[4] = '-1']
 * 		
 * 		- Sorting the input array will get all the duplicate elements next to each other. 
 * 
 * 		- If the input array is sorted,
 *  
 * 			- we can skip finding the triplets whose first element = nums[i] if nums[i] == nums[i-1] 
 *            (considering nums[i-1] exists) since those would have been explored in the previous ith iteration.
 * 
 * 			- we can skip finding the triplets whose middle element = nums[j] if nums[j] == nums[j-1] 
 * 			  (considering nums[j-1] exists) since those would have been explored in the previous jth 
 * 			  iterations. 
 * 
 * 			- we can skip finding the triplets whose last element = nums[k] if nums[k] = nums[k-1]
 * 			  considering nums[k-1] exists) since those would have been explored in the previous kth
 * 			  iterations. 
 * 			
 * 			  
 * 
 */

public class ThreeSum {
	
	private static List<List<Integer>> threeSumBruteForce(int[] nums) {
		
		List<List<Integer>> output = new ArrayList<>();
		
		return output;
		
	}
	
	private static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> output = new ArrayList<>();
		
		Arrays.sort(nums);
		
		int n = nums.length;
		
		for(int i=0; i<n; i++) {
			
			if(i>0 && nums[i] == nums[i-1]) continue;
			
			int j = i+1;
			int k = n-1;
			
			while(j<k) {
				
				int sum = nums[i] + nums[j] + nums[k];
				
				if(sum == 0) {
					
					List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[i]);
					triplet.add(nums[j]);
					triplet.add(nums[k]);
					output.add(triplet);
					
					j++;
					while(j<k && nums[j] == nums[j-1]) {
						j++;
					}
					
					k--;
					while(nums[k] == nums[k-1]) {
						k--;
					}
					
				} 
				else if (sum < 0) {
					j++;
				} 
				else {
					k--;
				}
			}
			
		}
		
		return output;
        
    }

	public static void main(String[] args) {
		
		int[] nums = {-1,0,1,2,-1,-4};
		
		System.out.println("Triplets having sum = 0 using brute force approach: " + threeSumBruteForce(nums));	

	}

}
