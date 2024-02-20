import java.util.ArrayList;
import java.util.List;

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
 *    letter under-consideration and trust the recursive procedure to do the same with the remaining 
 *    (un-explored) letters of the input string. 
 *    
 *  - Hypothesis: 
 *  	
 *  	- F(s, n) will explore all possible palindrome partitions that can be formed using the first 'n'
 *   	  letters of the input string.
 *   
 *  - Recursive Steps:
 *  
 *  	- Loop start = 0 : n (excluded)
 *  		- substring = s[start:n]; (will not include the letter on the nth index)
 *  		- if substring is palindrome:
 *  			- partition.add(substring);
 *  			- F(s, start);
 *  			- partition.remove(substring);
 *  
 *  - Base Condition:
 *  
 *  	- if n == 0:	--> input string has been partitioned into a collection of palindromic substrings.
 *  		- output.add(partition.clone());
 *  		- return;
 *    
 *  - Time Complexity Analysis:
 *  
 *  	- 
 *  
 *  - Space Complexity Analysis:
 * 
 * */

public class PalindromePartitioning {
	
	private static List<List<String>> output;
	private static ArrayList<String> partition;
	
	private static boolean isPalindrome(String substr) {
		
		int size = substr.length();
		int mid = size/2;
		
		for(int i=0; i<mid; i++) {
			if(substr.charAt(i) != substr.charAt(size-1-i)) {
				return false;
			}
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private static void getPalindromePartitions(String s, int n) {
		
		if (n==0) {
			List<String> ans = (ArrayList<String>) partition.clone();
			output.add(ans);
			return;
		}
		
		for(int i=0; i<n; i++) {
			
			String substr = s.substring(i, n);
			
			if(isPalindrome(substr)) {
				partition.add(substr);
				getPalindromePartitions(s, i);
				partition.remove(partition.size()-1);
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		String s = "aab";
		int n = s.length();
		
		output = new ArrayList<>();
		partition = new ArrayList<>();
		
		getPalindromePartitions(s, n);
		
		System.out.println(output);

	}

}
