
/* Problem Statement: Given an unsorted array of integers 'nums', return the length of the longest 
 * 					  consecutive elements sequence.
 * 
 * 					  For example, for nums = [100,4,200,1,3,2], the LCS = [1,2,3,4]. Hence, the length
 * 					  of the longest consecutive elements subsequence is 4.
 * 
 * General Observaions:
 * 
 * 	- If all elements in the 'nums' array is unique, the length of the longest consecutive elements
 * 	  sequence = 1. 
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Algorithm:
 * 
 * 			- Sort the 'nums' array.
 * 				- sorted_nums = [1,2,3,4,100,200];
 * 
 * 			- Initialize two variables: 
 * 				- First, to store the length of the current subsequence.
 * 						- current_length = 1;
 * 			  	- Second, to store the length of the longest subsequence found so far.
 * 						- longest_length = 1;
 * 
 * 			- Loop from i = [1, n) to iterate over the sorted 'nums' array:
 * 				- If nums[i] == nums[i-1] + 1:
 * 					- Increment current_length by 1;
 * 				- Otherwise:
 * 					- Update longest_length = max(longest_length, current_length);
 * 					- Reset current_length = 1;
 * 
 * 			- return longest_length;
 *
 * 		- Time Complexity Analysis:
 * 			
 * 			- The number of operations performed in:
 * 				- sorting the 'nums' array will be of the order (n*logn).
 * 				- looping over the sorted 'nums' array will be of order (n).
 * 			
 * 			- Hence, overall time complexity = O(n*logn).
 * 
 * 		- Space Complexity = O(1). 
 * 
 * 	- Optimized Approach:
 * 
 * 		- Each element can either be the "starting element of a subsequence" or "part of a subsequence".
 * 
 *  	- Algorithm:
 *  		
 *  		- Create a HashSet to store all the elements of the 'nums' array.
 *  
 *  		- Initialize longest_length = 0.
 *  
 *  		- Loop from i = [1, n) to iterate over the 'nums' array:
 *  			- If HashSet contains (nums[i]-1):
 *  				- Do nothing, since, nums[i] is part of a subsequence.
 *  			- Otherwise:
 *  				- current_element = nums[i];
 *  				- while HashSet contains (current_element+1): // explore the consecutive sequence starting from nums[i].
 *  					- Increment current_length by 1;
 *  					- Increment curr_element by 1;
 *  				- Update longest_length = max(longest_length, current_length);
 *  
 *  		- return longest_length;
 *  
 *  	- Time Complexity Analysis:
 *  		
 *  		- We are iterating over the input 'nums' array two times:
 *  			- first, to fill the HashSet.
 *  			- second, to find the length of the longest consecutive subsequence. 
 *  
 *   		- Hence, overall time complexity = O(n).
 *   
 *   	- Space Complexity Analysis:
 *   
 *   		- We are creating a HashSet of size 'n'. Hence, overall space complexity = O(n).
 * 
 * */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
