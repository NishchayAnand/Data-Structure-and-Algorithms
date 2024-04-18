import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* Problem Statement: Given an integer array 'nums', return all the triplets [nums[i], nums[j], nums[k]]
 * 					  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * 					  NOTE: The solution set must not contain duplicate triplets.
 * 
 * General Observations:
 * 
 * 	- 
 * 
 */

public class ThreeSum {
	
	private static List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		
		int n = nums.length;
		
		List<List<Integer>> output = new ArrayList<>();
		
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
		
		System.out.println("Triplets having sum = 0: " + threeSum(nums));	

	}

}
