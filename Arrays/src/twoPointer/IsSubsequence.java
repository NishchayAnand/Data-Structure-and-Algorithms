package twoPointer;

/* Problem Statement: Given two strings 's' and 't', return true if 's' is a subsequence of 't', or false 
 * 					  otherwise.
 * 
 * 					  NOTE: A subsequence of a string is a new string that is formed from the original 
 * 							string by deleting some (can be none) of the characters without disturbing 
 * 						    the relative positions of the remaining characters. (i.e., "ace" is a 
 * 							subsequence of "abcde" while "aec" is not).
 * 
 * General Observations:
 * 
 * 	- Length of string 't' would be greater than or equal to string 's'.
 * 
 * 	- Use two pointers to traverse both strings 's' and 't'.
 * 
 *  - The idea is to iterate over 't' and check if all characters of 's' appear in 't' in the same order.
 *  
 *  - Algorithm:
 *  
 *  	- let pointer for iterating 's' be ps = 0;
 *  	- let pointer for iterating 't' be pt = 0;
 *  	- iterate over string 't' using pointer pt:
 *  		- if character at index ps of string 's' = character at index pt of string 't':
 *  			- increment ps++ and pt++;
 *  		- else :
 *  			- increment pt++;
 *  		- if pointer ps has reached the end of string 's':
 *  			- return true since string 's' is a subsequence of string 't';
 *  	- return false since we have iterating over string 't' and haven't reached the end of string 's'
 *  		
 * 
 * */

public class IsSubsequence {
	
	private static boolean isSubsequence(String s, String t) {
		int ps = 0;
		int pt = 0;
		while(ps<s.length() && pt<t.length()) {
			if(s.charAt(ps) == t.charAt(pt)) {
				ps++;
			}
			pt++;
		}
		return ps == s.length();
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("ace", "abcde"));
	}

}
