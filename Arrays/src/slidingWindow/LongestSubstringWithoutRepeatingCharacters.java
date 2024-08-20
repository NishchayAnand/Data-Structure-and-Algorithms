package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Problem Statement: Given a string 'S', find the length of the longest substring without repeating 
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
 * 		- Space Complexity: O(n).
 * 
 *  - If two pointers (i,j) represent the longest possible substring starting from index 'i', this means
 *    the character at index 'j+1' already exists in the window [i,j]. 
 *    
 *  - If character at index 'j+1' = character at some index 'k', where i<=k<=j, we don't need to explore 
 *    substrings in the window [i<=k, j+1] as they will contain duplicate characters. We can focus on 
 *    exploring the window starting from [k+1, j+1] because any potential longer substring without 
 *    duplicates must start after this point. 
 *    
 *  - Sliding Window Approach:
 *  
 *  	- Algorithm:
 *  
 *  		- Use a HashMap: 'hm' to store the last index of each character seen.
 *  		- Let 'i' represent the beginning of the current window.
 *  
 *  		- Loop j = [0, n-1]: -> iterate through the string S
 *  
 *  			- if (hm contains S[j]) and (hm.get(S[j]) >= i): -> a duplicate character found in the current window
 *  				- i = hm.get(S[j]) + 1;
 *  
 *  			- else:
 *  				- maxLength = max(maxLength, j-i+1); -> compare the current window length (j - i + 1) 
 *  				  									    with the previously found maximum length. 
 *  
 *  			- hm.put(S[j], j); -> stores the last index of S[j].
 *  			
 *  		- return maxLength;
 *  
 *  	- Time Complexity: O(n).
 *  
 *  	- Space Complexity: O(n).
 * 
 * */

public class LongestSubstringWithoutRepeatingCharacters {
	
	private static int lengthOfLongestSubstringBF(String str) {
		
		int n = str.length();
		int maxLength = 0;
		
		for(int start=0; start<n; start++) {
			
			Set<Character> hs = new HashSet<>();
			int currLength = 0;
			
			for(int end=start; end<n; end++) {
				
				char ch = str.charAt(end);
				
				if(hs.contains(ch)) {
					break;
				}
				
				hs.add(ch);
				currLength = end-start+1;
			
			}
			
			maxLength = Math.max(maxLength, currLength);
		}
		
		return maxLength;
		
	}
	
	private static int lengthOfLongestSubstring(String s) {
		
		Map<Character, Integer> hm = new HashMap<>();
		int maxLength = 0;
		int i=0;
		
		for(int j=0; j<s.length(); j++) {
			
			char ch = s.charAt(j);
			if( hm.containsKey(ch) && hm.get(ch) >= i) {
				i = hm.get(ch) + 1;
			} else  {
				maxLength = Math.max(maxLength, j-i+1);
			}
			
			hm.put(s.charAt(j), j);
		}
		
		return maxLength;
    }

	public static void main(String[] args) {
		
		String s = "tmmzuxt"; //abcbcabb
		int len = lengthOfLongestSubstringBF(s);
		System.out.println("Length of longest substring in " + s + " without duplicate character: " + len);

	}

}
