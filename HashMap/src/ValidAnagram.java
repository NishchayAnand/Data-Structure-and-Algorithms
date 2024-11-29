import java.util.HashMap;

/* Problem Statement: Given two strings 's' and 't', return true if 't' is an anagram of 's', and false 
 * 					  otherwise.
 * 
 * General Observations:
 * 
 * 	- Anagrams are strings that contain the same characters with the exact same frequencies, but
 *    possibly in a different order.
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
 *  		- Create two HashMap to store characters of the two input strings ('s' and 't') along with 
 *  		  their frequency. 
 *  
 *  		- NOTE: Above HashMaps are usually called Frequency HashMaps.
 *  
 *  		- If Frequency HashMap of string 's' == Frequency HashMap of string 't', then 't' is a 
 *  		  anagram of 's'.
 *  
 *  		- NOTE: The built-in equals() method for HashMaps can be used to check if both Frequency 
 *  			    HashMaps have the exact same key-value pairs.
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
			Character key = s.charAt(i);
			s_hm.put(key, s_hm.getOrDefault(key, 0)+1);
		}
		
		// populating t_hm
		for(int i=0; i<t.length(); i++) {	
			char key = t.charAt(i);		
			t_hm.put(key, t_hm.getOrDefault(key, 0)+1);		
		}
		
		return s_hm.equals(t_hm);
		
	}

	public static void main(String[] args) {
		
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println("t an anagram of s: " + isAnagram(s, t));

	}

}
