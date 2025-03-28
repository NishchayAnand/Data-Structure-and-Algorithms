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
 *  - Approach 1: Using Cache Memory
 *    
 *  	- Hypothesis: F(nums, isSelected, permutation, permutations) will find all possible
 *        permutations of filling spaces 'n' spaces.
 *
 * 		- NOTE: 'isSelected' could be a boolean array or a HashSet, required to keep track of the
 * 			    integers that are currently selected in 'permutation'.
 *  
 *  	- Recursive Steps:
 *  	
 *  		- For index = [0, nums.length):
 *
 *  			- if !isSelected[index]:
 *
 *  				- permutation.add(nums[index]);
 *  				- isSelected[index] = true;
 *
 *  				- F(nums, isSelected, permutation, permutations);
 *
 * 					- permutation.removeLast();
 *  				- isSelected[index] = false;
 *
 * 			- NOTE: For generating permutations, exclusion calls are not relevant.
 *  
 *  	- Base Condition:
 *  
 *  		- if permutation.size() == nums.length, i.e., we have a valid permutation:
 *  			- permutations.add(permutations.clone());
 *  			- return;
 *  
 *  	- Time Complexity Analysis:
 *  
 *   		- Let total number of operations performed to fill 'n' spaces be o(n). Then:
 *  
 *   		- o(n) = n.o(n-1) + n.C
 *   		- n.o(n-1) = n.(n-1).o(n-2) + n.(n-1).C
 *   		- n.(n-1).o(n-2) = n.(n-1).(n-2).o(n-3) + n.(n-1).(n-2).C
 *   		- .
 *   		- .
 *   		- .
 *   		- n.(n-1).(n-2)....2.o(1) = n.(n-1).(n-2)....2.1.o(0) + n.(n-1).(n-2)....2.1.C
 *   		- o(0) = n.C1
 *   
 *   		-> o(n) = [n.C + n.(n-1).C + n.(n-1).(n-2).C + ... + n.(n-1).(n-2)....2.1.C] + n.(n-1).(n-2)....2.1.n.C1
 *   				= C.[n + n.(n-1) + ... + n.(n-1).(n-2)...3.2 + n.(n-1).(n-2)...2.1] + n!.n.C1
 *   				= C.[n!/(n-1)! + n!/(n-2)! + ... + n!/3! + n!/2! + n!/1! + n!] + n!.n.C1
 *   				= C.n!.[1/(n-1)! + 1/(n-2)! + ... + 1/2! + 1/1! + 1] + n!.n.C1
 *   				~ C.n! + C1.n!.n
 * 					~ n!(C + C1.n)
 *   
 *   		- Since, the total operations is of the order 'n!', Time Complexity = O(n!).
 *  
 *  	- Space Complexity Analysis:
 *  
 *  		- The maximum recursion depth would be 'n'. Both 'permutation' and 'isSelected'
 * 			  require 'n' space. Hence, Space Complexity = O(n).
 *
 *	- At each recursive level, we are basically filling a space.
 *
 * 	- Approach 2: Using Swapping Logic
 *
 * 		- Hypothesis: F(nums, index, permutations) will find all possible permutations of
 * 					  filling spaces 'n' spaces.
 *
 * 		- Recursive Steps:
 *
 * 			- For i = [index, nums.length):
 * 				1. swap(nums, index, i); // will place 'ith' element at 'index' space
 * 				2. F(nums, index, permutations) // will generate all permutations with nums[i] placed at 'index' space
 * 				3. swap(nums, index, i); // will revert the swapping done at step 1
 *
 * 		- Base Conditions:
 *
 * 			- if index == nums.length, i.e., all spaces have been filled:
 * 				- permutations.add(nums.clone());
 *
 * 		- Time Complexity: O(n!).
 *
 * 		- Space Complexity: O(n).
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
				permutation.remove(permutation.size()-1);
				isSelected[i] = false;
			}
		}

	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void getAllPermutations2(int[] nums, int index, List<List<Integer>> permutations) {

		if(index == nums.length) {
			List<Integer> permutation = new ArrayList<>();
			for(int num: nums) permutation.add(num);
			permutations.add(new ArrayList<>(permutation));
			return;
		}

		// filling the 'index' space
		for(int i=index; i<nums.length; i++) {
			swap(nums, index, i);
			getAllPermutations2(nums, index+1, permutations);
			swap(nums, index, i);
		}

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		//boolean[] isSelected = new boolean[nums.length];
		//getAllPermutations(nums, isSelected, new ArrayList<>(), permutations);
		getAllPermutations2(nums, 0, permutations);
		return permutations;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}

}
