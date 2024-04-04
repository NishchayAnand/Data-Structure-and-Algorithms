import java.util.HashMap;

/* Problem Statement: Given two strings 's' and 't', return true if 't' is an anagram of 's', and false 
 * 					  otherwise.
 * 
 * General Observations:
 * 
 * 	- An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, with
 * 	  a condition that, "All Original Letters Must Be Used Exactly Once" to create the anagram. 
 * 
 * 	  For Example: 't' = "nagaram" is an anagram of 's' = "anagram". 
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Sort the two strings 's' and 't'. If sorted 's' == sorted 't', then 't' is an anagram of 's'.
 * 
 *  	- Time Complexity: O(n*logn).
 *  
 *  	- Space Complexity: O(1).
 *  
 *  - Optimized Approach (Reduced Time Complexity):
 *  
 *  	- Algorithm:
 *  		
 *  		- Store each character and its count in the two strings ('s' and 't') as key-value pairs 
 *  		  in two hashmaps ('s_hm' and 't_hm').
 *  
 *  		- Iterate through each 'key' in 's_hm':
 *  			- If (key does not exist in 't_hm') or (value of key in s_hm != value of key in t_hm):
 *  				- return false as 't' is not an anagram of 's';
 *  
 * 			- return true since all characters in 's' exist in 't'; 
 * 
 * 		- Time Complexity = O(n) where n = length of 's' and 't'.
 * 
 * 		- Space Complexity = O(n) where n = length of 's' and 't'.
 *  
 * */

public class ValidAnagram {
	
	private static boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Integer> s_hm = new HashMap<>();
		HashMap<Character, Integer> t_hm = new HashMap<>();
		
		// populating s_hm
		for(int i=0; i<s.length(); i++) {
			
			char key = s.charAt(i);
			
			if(s_hm.containsKey(key)) {
				s_hm.put(key, s_hm.get(key)+1);
			} else {
				s_hm.put(key, 1);
			}
			
		}
		
		// populating t_hm
		for(int i=0; i<t.length(); i++) {
					
			char key = t.charAt(i);
					
			if(t_hm.containsKey(key)) {
				t_hm.put(key, t_hm.get(key)+1);
			} else {
				t_hm.put(key, 1);
			}
					
		}
		
		for(Character key: s_hm.keySet()) {
			// check if key character does not exist in 't' or if the count of key character in 's' does 
			// not equal to its count in 't'
			if( !t_hm.containsKey(key) || !s_hm.get(key).equals(t_hm.get(key)) ) {
				return false;
			}
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println("t an anagram of s: " + isAnagram(s, t));

	}

}
