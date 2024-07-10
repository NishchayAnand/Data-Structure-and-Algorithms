package slidingWindow;

/* Problem Statement: Given a string 's', find the length of the longest substring without repeating 
 * 					  characters.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Algorithm: Use a nested loop {i,j} to iterate over all longest possible substrings starting from
 * 					 every ith character and return the length of the longest among them all. 
 * 
 * 					 NOTE: Hashset can be used to handle duplicacy.
 * 
 * 		- Time Complexity: O(n^2).
 * 		
 * 		- Space Complexity: O(1).
 * 
 *  - Let two pointers (i,j) represent the starting and ending indices of the longest possible substring 
 *    in the window [i,j]. This means that:
 *    
 *    		(i) all characters in the range {0,j} have already been explored.
 *    	   (ii) the character at index 'j+1' already exists in the window [i,j]. 
 *    
 *  - Let (character at index 'j+1') = (character at index 'k'), where i<=k<=j. This means ...   
 *    
 *  - To find the longest 
 *    possible substring starting from index 'i+1', we only need explore the substrings starting from the 
 *    window [i+1, j>=k+1] (don't need to explore the substrings in the window [i+1, k]).
 *    
 *  - Sliding Window Approach:
 * 
 * */

public class LongestSubstringWithoutRepeatingCharacters {
	
	private static int lengthOfLongestSubstring(String s) {
		return s.length();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
