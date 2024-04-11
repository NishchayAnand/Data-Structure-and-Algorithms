import java.util.HashSet;

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
 * 				- Else:
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
 * 		- If we know the starting element of each consecutive subsequence, we can easily figure out 
 * 		  the longest consecutive subsequence. 
 * 
 *  	- Algorithm:
 *  		
 *  		- Create a HashSet to store all the elements of the 'nums' array. (#1)
 *  
 *  		- Initialize longest_length = 0.
 *  
 *  		- Loop from i = [1, n) to iterate over the 'nums' array: (#2)
 *  			- If HashSet contains (nums[i]-1):
 *  				- Do nothing, since, nums[i] is part of a subsequence which would surely be explored in the else section.
 *  			- Else:
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
 *  			- first, to fill the HashSet. --> O(n)
 *  			- second, to find the length of the longest consecutive subsequence. --> O(n)
 *  
 *  		- In worst case scenario, i.e., when the entire array is a consecutive sequence, the while
 *  		  loop in (#2) will explore:
 *  			- all the (n-1) elements for the first iteration of (#2).
 *  			- no elements for the remaining iterations of (#3).
 *  
 *  		- The time complexity for the while loop could be considered as O(1) within the context of 
 *  		  (#2). 
 *
 *   		- Hence, overall time complexity = O(n).
 *   
 *   	- Space Complexity Analysis:
 *   
 *   		- We are creating a HashSet of size 'n'. Hence, overall space complexity = O(n).
 * 
 * */

public class LongestConsecutiveSequence {
	
	private static int longestConsecutive(int[] nums) {
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int el: nums) {
			hs.add(el);
		}
		
		int longest_length = 0;
		
		for(int el: nums) {
			// el marks the start of a subsequence.
			if(!hs.contains(el-1)) {
				int current_length = 1;
				int current_element = el;
				while(hs.contains(current_element+1)) {
					current_length++;
					current_element++;
				}
				longest_length = Math.max(longest_length, current_length);
			}
		}
		
		return longest_length;
		
	}

	public static void main(String[] args) {
		
		int[] nums = {100, 4, 200, 1, 3, 2};
		
		System.out.println("Length of the longest consecutive elements subsequence: " + longestConsecutive(nums));

	}

}
