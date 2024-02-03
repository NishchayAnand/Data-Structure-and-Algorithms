import java.util.ArrayList;

/* Problem Statement: Given an array of unique integers, return all possible subsets a.k.a power set.
 * 
 * 					  NOTE: - The output can be returned in any order.
 * 							- The output shouldn't contain duplicate subsets.
 * 
 * General Observations:
 * 
 * 	- Subsets represent all possible combinations of integers that can be formed from the given array.
 * 
 *  - The empty set and the array itself are always included in the subsets.
 * 
 *  - For each element in the array, there are two choices: either (i) include it in a subset or 
 *  															  (ii) not include it.
 *  
 *  - The total number of combinations (subsets) is given by multiplying the number of choices for each element.
 *    If there are n elements in the array, each with two choices, the total number of subsets = 2^n.
 *    
 *  - The problem is naturally recursive in nature, i.e., you only have to make a decision for the integer 
 *    under consideration and trust the function to do the same for the remaining integers.
 *    
 *  - Hypothesis:
 *  
 *  	- F(arr, n, subset) will append all possible subsets that can be generated using the first n integers 
 *  	  of arr to the output a.k.a power set.
 *  		
 *  	  NOTE: The return type of the above function will be void.
 *  
 *  - Recursive Steps:
 *  
 *  	- F(arr, n-1, subset.clone().add(arr[n-1])); --> include the integer under consideration.
 *  	- F(arr, n-1, subset); 						 --> exclude the integer under consideration.
 *  
 *  - Base Condition:
 *  
 *  	- if n==0, i.e., no integer left to be explored, append the generated subset to the output, a.k.a power
 *        set.
 *        
 *  - Time Complexity Analysis:
 *  
 *  	- Let total number of operations performed by the above alogorithm be o(n), such that:
 *  		
 *  				-> o(n) = 2.o(n-1) + C
 *  				-> 2.o(n-1) = 2^2.o(n-2) + 2.C
 *  				-> 2^2.o(n-2) = 2^3.o(n-3) + 2^2.C
 *  				   .
 *  				   .
 *  				   .
 *  				-> 2^(n-1).o(1) = 2^n.o(0) + 2^(n-1).C
 *  
 *  				Summing all the equations, we get:
 *  
 *  				-> o(n) = C + 2.C + 2^2.C + 2^3.C + 2^4.C + .... + 2^(n-1).C
 *  						= 2^n.C
 *  
 *  	- Since total number of operations is order of 2^n, Time Complexity = O(2^n).
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- Maximum n stack frames will exist in the call stack simultaneously. In each stack frame, we are using
 *        a constant space. 
 *        
 *      - The maximum space utilized by the algorithm at any point of time will be of the order n. Therefore, 
 *        Space Complexity = O(n).				
 * 
 * */



public class Subsets {
	
	private static ArrayList<ArrayList<Integer>> powerSet;
	
	public static void getSubsets(int[] arr, int n, ArrayList<Integer> subset) {
		
		if(n==0) {
			ArrayList<Integer> ans = (ArrayList<Integer>) subset.clone();
			powerSet.add(ans);
			return;
		}
		
		// include the nth element in the subset.
		// ArrayList<Integer> include = (ArrayList<Integer>) subset.clone(); --> this will increase the 
		// 																		 space complexity from O(n)
		//																		 to O(n^2).
		subset.add(arr[n-1]); // --> Time Complexity = O(1).
		getSubsets(arr, n-1, subset);
		
		// exclude the nth element.
		subset.remove(subset.size()-1); // --> Time Complexity = O(1).
		getSubsets(arr, n-1, subset);
		
	}
	
	private static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
		
		ArrayList<Integer> subset = new ArrayList<>();
		getSubsets(arr, arr.length, subset);
		return powerSet;
		
	}

	public static void main(String[] args) {
		
		powerSet = new ArrayList<>();
		
		int[] input = {1,2,3};
		System.out.println(subsets(input));
		
		
	}

}
