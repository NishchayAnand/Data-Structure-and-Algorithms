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
 * 	- Approach 1:
 * 
 * 		- For each element in the array, there are two choices: either (i) include it in a subset or 
 *  															or	  (ii) not include it.
 *  
 *  	- The problem is naturally recursive in nature, i.e., you only have to make a decision for the 
 *  	  integer under consideration and trust the function to do the same for the remaining integers.
 *    
 *  	- Hypothesis:
 *  
 *  		- F(arr, n, T) will explore all unique combinations that can be generated using the first 'n' 
 *  	  	  integers of the input array such that each combination's aggregated sum = 'T'.
 *        
 *  	- Recursive Steps:  
 *   
 *      	- subset.add(arr[n-1]); 		// --> include the nth integer in the subset. 
 *      	- F(arr, n, T-arr[n-1]);		// --> nth integer can be included again in the subset. 
 *      
 *      	- subset.remove(arr.size-1);	// --> exclude the nth integer from the subset.							
 *      	- F(arr, n-1, T); 				// --> nth integer can't be included again in the subset.
 *      
 * 		- Base Condition:
 *  
 *  		- if T == 0:	// --> we have obtained a subset whose aggregated sum = T.
 *  			- output.add(subset.clone());
 *  			- return;
 *  
 *  		- if n == 0;	// --> no integer left in arr to be considered. 
 *  			- return;
 *  
 *  		- if T < 0:
 *  			- return; 	// --> negative target cannot be achieved using positive integers.
 *  
 *  	- Time Complexity Analysis:
 *  
 *  		- Since the "number of recursive calls" in the above algorithms are dependent on the integers
 *            in the input array, it is very difficult to analyse the time complexity of the algorithm.
 *  
 *  	- Space Complexity Analysis:
 *  		
 *  		- Since the "depth of the recursion trees" in the above algorithms, the total number
 *            of possible combinations and the length of each combination is dependent on the integers in
 *            the input array, it is very difficult to analyse the space complexity of the algorithm.
 * 
 *  	- NOTE: We are making some redundant recursive calls in the above approach. Reducing the number 
 *  			of recursive calls can improve the space complexity of the algorithm. For example, not 
 *  			including integers greater than 'T' will help us avoid the recursive calls where 'T' 
 *              becomes less than 0.   
 *  
 *  - Approach 2:
 *  	
 *  	- In each recursive call, explore all possible combinations that can be achieved by appending 
 *        each available integer to the subset. 
 *        
 *      - At any level 'l' of the recursion tree, we will be exploring all integers that can fill the 
 *        'lth position' in the subset such that aggregated sum of the subset remains less than or equal
 *        to the original target. --> (this point is better understood by generating the recursion tree)
 *        
 *      - Hypothesis:
 *  
 *  		- F(arr, n, T) will append all unique combinations that can be generated using the first 'n' 
 *  	  	  integers of array 'arr' such that each combination's aggregated sum = 'T'.
 *        
 *  	- Recursive Steps:  
 *      
 *      	- Loop N = n:1: 				// --> exploring the first n (available) integers. 
 *				if arr[N-1] <= T:
 *					- subset.add(arr[N-1]); 
 *      			- F(arr, N, T-arr[N-1]);	 
 *      			- subset.remove(arr.size-1);						
 *      
 * 		- Base Condition:
 *  
 *  		- if T == 0:	// --> we have obtained a subset whose aggregated sum = T.
 *  			- output.add(subset.clone());
 *  			- return;
 *  
 *  	- Time Complexity Analysis:
 *  
 *  		- Since the "number of recursive calls" in the above algorithms are dependent on the integers
 *            in the input array, it is very difficult to analyse the time complexity of the algorithm.
 *  
 *  - Space Complexity Analysis:
 *  		
 *  	- In worst case scenario, i.e., when we have "1" in the input array, the depth of the recursion 
 *        trees will be 'T'. However, the total number of possible combinations and the length of each
 *        combination are still dependent on the integers in the input array. Hence, it is still very
 *        difficult to analyse the space complexity of the algorithm. 
 * 
 * */

public class CombinationSum {
	
	static List<List<Integer>> output;
	static ArrayList<Integer> subset; 
	
	@SuppressWarnings("unchecked")
	private static void combinationSum1(int[] arr, int n, int T) {
		
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
			combinationSum1(arr, n, T-arr[n-1]);
			subset.remove(subset.size()-1);
		}
		
		combinationSum1(arr, n-1, T);
		
	}
	
	@SuppressWarnings("unchecked")
	private static void combinationSum2(int[] arr, int n, int T) {
		
		if(T==0) {
			List<Integer> cln = (ArrayList<Integer>) subset.clone();
			output.add(cln);
			return;
		}
		
		for(int N=n; N>=1; N--) {
			if(arr[N-1]<=T) { 
				subset.add(arr[N-1]);
				combinationSum2(arr, N, T-arr[N-1]);
				subset.remove(subset.size()-1);
			}
		}
		
	}

	public static void main(String[] args) {
		
		output = new ArrayList<>();
		
		int[] input = {2,3,6,7};
		int T = 7;
		
		// Approach 1:
		subset = new ArrayList<>();
		combinationSum1(input, input.length, T);
		System.out.println(output);
		
		// Approach 2:
		subset = new ArrayList<>();
		combinationSum2(input, input.length, T);
		System.out.println(output);

	}

}
