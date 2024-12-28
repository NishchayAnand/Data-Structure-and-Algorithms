import java.util.ArrayList;
import java.util.List;

/* Problem Statement: Given an array of unique integers, return all possible subsets a.k.a power set.
 * 
 * 					  NOTE: - The output can be returned in any order.
 * 							- The output shouldn't contain duplicate subsets.
 * 
 * General Observations:
 * 
 * 	- The power set represents the list of all possible combinations of integers that can be formed
 *    from the input array 'nums'.
 * 
 *  - The empty set and the array itself are always included in the subsets.
 * 
 *  - For each integer in the array, we have two choices: either (i) include it in a subset or
 *  															 (ii) not include it.
 *
 *  - The total number of combinations (subsets) if there are n elements in the array = 2^n.
 *    
 *  - The problem is naturally recursive in nature, i.e., you only have to decide whether you
 *    want to include or exclude the integer under consideration in the subset and trust the
 *    function to do the same for the remaining integers.
 *    
 *  - Hypothesis:
 *  
 *  	- F(arr, index, subset, subsets) will add all possible subsets that can be generated
 *        using the integers in range[index, arr.length-1] in 'subsets'.
 *  		
 *  	  NOTE: The return type of the above function will be void.
 *  
 *  - Recursive Steps:
 *
 * 		// include integer at index
 * 		- subset.add(arr[index]);
 *  	- F(arr, index+1, subset, subsets);
 *
 * 		// exclude integer at index
 * 		- subset.removeLast();
 *  	- F(arr, index+1, subset, subsets);
 *  
 *  - Base Condition:
 *  
 *  	- if index == arr.length, i.e., no integer left to be explored:
 * 			- subsets.add(subset.clone());
 *        
 *  - Time Complexity Analysis:
 *  
 *  	- Let total number of operations performed by the above algorithm be o(n), such that:
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
 *  				-> o(n) = C + 2.C + 2^2.C + 2^3.C + 2^4.C + .... + 2^(n-1).C + 2^(n).C
 *  						= 2^(n+1).C
 *  
 *  	- Since total number of operations is order of 2^n, Time Complexity = O(2^n).
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- Maximum 'n' stack frames will exist in the call stack simultaneously. In each stack frame,
 *        we are using a constant space. Hence, Space Complexity: O(n).
 *
 *  - Optimized Approach:
 *
 * 		- In the above inclusion-exclusion approach, the exclusion calls are redundant. The
 *  	  exclusion calls essentially skip an element, but this can be achieved by iterating over
 * 		  the elements in the range [index, arr.length-1] in a loop in each recursive call.
 *
 * 		- Hypothesis: F(arr, index, subset, subsets) will add all possible subsets that can be
 * 					  generated using the integers in range[index, arr.length-1] in 'subsets'.
 *
 * 		- Recursive Steps:
 *
 * 			- subsets.add(subset);
 * 			- Loop from i = [index, arr.length):
 * 				- subset.add(arr[i]);
 * 				- F(arr, i+1, subset, subsets);
 * 				- subset.removeLast();
 *
 * 		- Base Conditions: All base conditions would implicitly be handled by the recursive steps.
 *
 * 		- Time Complexity Analysis:
 *
 * 			- Let total number of operations performed by the above algorithm be o(n), such that:
 *
 * 				- o(n) = o(n-1) + C + o(n-2) + C + o(n-3) + C + ... + o(1) + C + o(0) + C.
 * 					   = o(n-1) + c1 + [o(n-2) + C + o(n-3) + C + ... + o(1) + C + o(0) + C].
 * 					   = o(n-1) + C + o(n-1)
 * 					   = 2.(n-1) + C
 *
 * 			- Total number of operations would be of the order of 2^n, Time Complexity = O(2^n).
 *
 * 		- Space Complexity Analysis:
 *
 * 			- Maximum Auxiliary recursive stack space consumed would be of the order 'n'. Hence,
 *            Space Complexity = O(n).
 *
 * */

public class Subsets {

	private static void getAllSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {

		if(index == nums.length) {
			subsets.add(new ArrayList<>(subset));
			return;
		}

		// include
		subset.add(nums[index]);
		getAllSubsets(nums, index+1, subset, subsets);
		subset.removeLast();

		// exclude
		getAllSubsets(nums, index+1, subset, subsets);

	}

	private static void getAllSubsetsOptimized(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(subset));
		for(int i = index; i<nums.length; i++) {
			subset.add(nums[i]);
			getAllSubsetsOptimized(nums, i+1, subset, subsets);
			subset.removeLast();
		}
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		getAllSubsetsOptimized(nums, 0, new ArrayList<>(), subsets);
		return subsets;
	}

	public static void main(String[] args) {
		int[] input = {1,2,3};
		System.out.println(subsets(input));
	}

}
