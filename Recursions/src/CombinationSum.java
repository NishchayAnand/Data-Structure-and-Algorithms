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
 *  - Hypothesis:
 *  
 *  	- F(arr, n, T) will append all unique combinations that can be generated using the first 'n' 
 *  	  integers of array arr such that each combination's aggregated sum = 'T'.
 *        
 *  - Recursive Steps:  
 *      
 *      - subset.add(arr[n-1]); 		// --> include the nth integer in the subset. 
 *      - F(arr, n, T-arr[n-1]);		// --> nth integer can be included again in the subset. 
 *      
 *      - subset.remove(arr.size-1);	// --> exclude the nth integer from the subset.							
 *      - F(arr, n-1, T); 				// --> nth integer can't be included again in the subset.
 *      
 * 	- Base Condition:
 *  
 *  	- if T == 0:	// --> we have obtained a subset whose aggregated sum = T.
 *  		- output.add(subset.clone());
 *  		- return;
 *  
 *  	- if n == 0;	// --> no integer left in arr to be considered. 
 *  		- return;
 *  
 *  	- if T < 0:
 *  		- return; 	// --> negative target cannot be achieved using positive integers.
 *  
 *  - Reducing the amount of recursive calls made in the above algorithm can improve the space and time 
 *    complexities of the algorithm.  
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
		
		if(arr[n-1]<=T) { 	// --> no need to include an integer which is greater than T. 
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
