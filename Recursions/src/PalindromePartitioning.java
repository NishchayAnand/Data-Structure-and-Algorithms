
/* Problem Statment: Given a string 's', partition 's' such that every substring of the partition is a 
 * 				     palindrome. Return all possible palindrome partitioning of s.
 * 
 * General Observations:
 * 
 *  - The task is "explore different ways of partitioning the given string into substrings" (visualize 
 *    using recursion tree) such that "each substring is a palindrome". 
 * 
 * 	- For every nth letter in the given string 's', there can be 'n' substrings ending with the nth 
 *    letter. Example, for s = 'aab',
 *    	- substrings ending with the 1st letter ('a') -> 'a'
 *    	- substrings ending with the 2nd letter ('a') -> 'aa', 'a'
 *    	- substrings ending with the 3rd letter ('b') -> 'aab', 'ab', 'b'
 * 
 *  - The problem is naturally recursive in nature, i.e., we can explore all substrings ending with the 
 *    letter under-consideration and trust the procedure to do the same with the remaining (un-explored)
 *    letters of the input string. 
 * 
 * */

public class PalindromePartitioning {

	public static void main(String[] args) {

	}

}
