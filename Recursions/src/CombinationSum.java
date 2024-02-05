import java.util.ArrayList;
import java.util.List;

/* Problem Statment: Given an array 'arr' of distinct integers and a target integer 'T', return a list of 
 * 					 all unique combinations of integers where the chosen numbers sum to target. 
 * 
 * 					 NOTE: - You may return the combinations in any order.
 * 						   - The same number may be chosen an unlimited number of times. 
 * 
 * General Observations:
 * 
 * 	- For each element in the array, there are two choices: either (i) include it in a subset or 
 *  														or	  (ii) not include it.
 *  
 *  - The problem is naturally recursive in nature, i.e., you only have to make a decision for the integer 
 *    under consideration and trust the function to do the same for the remaining integers.
 *    
 *  - Approach 1:
 *    
 *  	- Hypothesis:
 *  
 *  		- F(arr, n, T) will append all unique combinations that can be generated using the first 'n' 
 *  	  	  integers of array arr such that each combination's aggregated sum = 'T'.
 *        
 *      	- Recursive Steps:  
 *      
 *      		- if arr[n-1] <= T:
 *      			- subset.add(arr[n-1]); 	// --> arr[n-1] can be included in the subset. 
 *      			- F(arr, n, T-arr[n-1]);	// --> arr[n-1] can again be considered for inclusion 
 *      										   	   in the subset. 
 *      			- subset.remove(arr.size-1);// --> remove arr[n-1] from subset for the exclusion 
 *      											   condition.
 *      										
 *      		- F(arr, n-1, T); 				// --> no need to consider arr[n-1] again. 
 *      
 *  	- Base Condition:
 *  
 *  		- if T == 0:	// --> we have obtained a subset whose aggregated sum = T.
 *  			- output.add(subset.clone());
 *  			- return;
 *  
 *  		- if n == 0;	// --> no integer left in arr to be considered. 
 *  			- return;
 *  
 *  - Issue with this approach: 
 * 
 * */

public class CombinationSum {
	
	static List<List<Integer>> output;
	static ArrayList<Integer> subset; 
	
	@SuppressWarnings("unchecked")
	private static void combinationSum(int[] arr, int n, int T) {
		
		if(T==0) {
			List<Integer> cln = (ArrayList<Integer>) subset.clone();
			output.add(cln);
			return;
		}
		
		if(n==0) {
			return;
		}
		
		if(arr[n-1]<=T) {
			subset.add(arr[n-1]);
			combinationSum(arr, n, T-arr[n-1]);
			subset.remove(subset.size()-1);
		}
		
		combinationSum(arr, n-1, T);
		
	}

	public static void main(String[] args) {
		
		output = new ArrayList<>();
		subset = new ArrayList<>();
		
		int[] input = {2,3,6,7};
		int T = 7;
		
		combinationSum(input, input.length, T);
		
		System.out.println(output);

	}

}
