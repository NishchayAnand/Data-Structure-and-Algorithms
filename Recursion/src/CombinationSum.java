import java.util.ArrayList;
import java.util.List;

/*

	Problem Statement: Given an array of distinct integers 'candidates' and a target integer
					   'target', return a list of all unique combinations of candidates where the
					   chosen numbers sum to target.

 					   NOTE:
 					  	 - You may return the combinations in any order.
						 - The same number may be chosen from candidates an unlimited number of
						   times.

 	General Observations:

		- For each element in the input array 'candidates', there are two choices:
				(i) either include it in a subset, or
			   (ii) not include it.

 	  	- The problem is naturally recursive in nature, i.e., you only have to decide whether you
     	  want to include or exclude the integer under consideration in the subset and trust the
     	  recursion function to do the same for the remaining integers.

     	- NOTE: An integer included in the subset can again be included.

    	- Hypothesis:

 	  		- F(candidates, index, target, subset, subsets) will add all possible subsets
 	  		  (combinations) that can be generated using the integers in
 	  		  range [index, candidates.length-1] in 'subsets' such that each subset's
 	  		  aggregated sum = 'target'.

 	 	- Recursive Steps:

 	 		// include the integer at index
 	      	- subset.add(candidates[index]);
 	     	- F(candidates, index, target-candidates[index], subset, subsets);

 	     	// exclude the integer at index
 	      	- subset.removeLast;
     		- F(candidates, index+1, target, subset, subsets);

 		- Base Condition:

 	 		- if target == 0, i.e., we have obtained a subset whose aggregated sum = target:
 				- subsets.add(subset.clone());
 				- return;

 			- if index == candidates.length, i.e., no integer left in candidates to be considered:
 				- return;

 			- if target < 0, i.e., negative target cannot be achieved using positive integers:
 				- return;

 		- Time Complexity Analysis:

 			- In worst case scenario, the sum of all possible combinations is less than 'target'.
 			  Hence, Time Complexity = O(2^n).

	 	- Space Complexity Analysis:

	 		- Space Complexity: O(target/min(candidates));

*/

public class CombinationSum {

	private static void getAllSubsets(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> combinations) {

		// Base Condition
		if(target==0) {
			combinations.add(new ArrayList<>(combination));
			return;
		}

		// Recursive Steps
		for(int i = index; i<candidates.length; i++) {
			if(candidates[i]<=target) {
				combination.add(candidates[i]);
				getAllSubsets(candidates, i, target-candidates[i], combination, combinations);
				combination.remove(combination.size()-1);
			}
		}

	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		getAllSubsets(candidates, 0, target, new ArrayList<>(), combinations);
		return combinations;
	}

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}

}
