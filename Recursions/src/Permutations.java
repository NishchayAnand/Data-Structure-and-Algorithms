import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* Problem Statement: Given an array of 'n' distinct integers, return all the possible permutations. 
 * 
 * 					  NOTE: You can return the answer in any order.
 * 
 * General Observations:
 * 
 * 	- Find all ways of filling 'n' spaces with 'n' integers of the input array 'nums'.
 *  
 *  - The problem is naturally recursive in nature, i.e., you only need to fill the space
 *    under-consideration and trust the recursive function to do the same for the remaining spaces.
 *
 *  - Brute Force Approach:
 *    
 *  	- Hypothesis: F(nums, isSelected, permutation, permutations) will find all possible
 *        permutations of filling spaces 'n' spaces.
 *
 * 		- NOTE: 'isSelected' could be a boolean array or a HashSet, required to keep track of the
 * 			    integers that are currently selected in 'permutation'.
 *  
 *  - Recursive Steps:
 *  	
 *  	- For index = [0, nums.length):
 *
 *  		- if !isSelected[index]:
 *
 *  			- permutation.add(nums[index]);
 *  			- isSelected[index] = true;
 *
 *  			- F(nums, isSelected, permutation, permutations);
 *
 * 				- permutation.removeLast();
 *  			- isSelected[index] = false;
 *
 * 		- NOTE: For generating permutations, exclusion calls are not relevant.
 *  
 *  - Base Condition:
 *  
 *  	- if permutation.size() == nums.length, i.e., we have a valid permutation:
 *  		- permutations.add(permutations.clone());
 *  		- return; 
 *  
 *  - Time Complexity Analysis:
 *  
 *   	- Let total number of operations performed by the above algorithm be o(n), such that:
 *  
 *   		- o(n) = n.o(n-1) + n.C
 *   		- n.o(n-1) = n.(n-1).o(n-2) + n.(n-1).C
 *   		- n.(n-1).o(n-2) = n.(n-1).(n-2).o(n-2) + n.(n-1).(n-2).C
 *   		- .
 *   		- .
 *   		- .
 *   		- n.(n-1).(n-2)....2.[o(1)] = n.(n-1).(n-2)....2.[o(0)] + n.(n-1).(n-2)....2.[C]
 *   		- o(0) = 0
 *   
 *   		-> o(n) = n.C + n.(n-1).C + n.(n-1).(n-2).C + ... + n.(n-1).(n-2)....2.C
 *   				= C.[n + n.(n-1) + ... + n.(n-1).(n-2)...3.2 + n.(n-1).(n-2)...2.1]
 *   				= C.[n!/(n-1)! + n!/(n-2)! + ... + n!/3! + n!/2! + n!/1! + n!]
 *   				= C.n!.[1/(n-1)! + 1/(n-2)! + ... + 1/2! + 1/1! + 1]
 *   				~ C.n! 
 *   
 *   	- Since, the total operations performed by the algorithm is approx. C.n!, the time complexity
 *   	  of the algorithm is O(n!).
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- Maximum auxiliary space used by the recursive call stack will be of the order 'n'.
 *  
 *  	- The 'chosen' hashset will store at maximum 'n' integers.
 *  
 *  	- The output list will store 'n!' array lists each of size 'n'. Hence, size of the output list 
 *        will be 'n!*n'.
 *  
 *  	- Since, the total space consumption  theby algorithm will be proportional to (n + n + n!*n), the 
 *        space complexity of the algorithm will be O(n!*n).
 * 
 * */


public class Permutations {

	private static void getAllPermutations(int[] nums, boolean[] isSelected, List<Integer> permutation, List<List<Integer>> permutations) {

		if(permutation.size() == nums.length) {
			permutations.add(new ArrayList<>(permutation));
			return;
		}

		for(int i=0; i<nums.length; i++) {
			if(!isSelected[i]) {
				permutation.add(nums[i]);
				isSelected[i] = true;
				getAllPermutations(nums, isSelected, permutation, permutations);
				permutation.removeLast();
				isSelected[i] = false;
			}
		}

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		boolean[] isSelected = new boolean[nums.length];
		getAllPermutations(nums, isSelected, new ArrayList<>(), permutations);
		return permutations;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}

}
