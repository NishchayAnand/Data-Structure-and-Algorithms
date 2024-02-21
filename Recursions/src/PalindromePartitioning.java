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
 *  - At each of the partition index, we have the option to either add the partition or ignore it. 
 *    
 *  - Approach 1: Explore "do partition - don't do no partition" (include-exlude approach) at each 
 *                possible index. 
 * 
 * 	- For every nth letter in the given string 's', there can be 'n' substrings ending with the nth 
 *    letter. Example, for s = 'aab',
 *    	- substrings ending with the 1st letter ('a') -> 'a'
 *    	- substrings ending with the 2nd letter ('a') -> 'aa', 'a'
 *    	- substrings ending with the 3rd letter ('b') -> 'aab', 'ab', 'b'
 * 
 *  - Approach 2: Explore all substrings ending with the letter under-consideration and trust the 
 *    			  procedure to do the same with the remaining (un-explored) letters of the input string. 
 *    
 *  - The problem is naturally recursive in nature. 
 *    
 *  - Hypothesis: 
 *  	
 *  	- F(s, n) will explore all possible palindrome partitions that can be formed using the first 'n'
 *   	  letters of the input string.
 *   
 *  - Recursive Steps:
 *  
 *  	- Loop start = 0 : n (excluded)
 *  		- substring = s[start:n]; (will not include the letter on the nth index) --> TC: O(n)
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
 *  	- In worst case scenario, each substring of the given input string would be a palindrome.
 *  
 *  	- Let total number of operations performed by the above alogorithm be o(n), such that:
 *  
 *  		- o(n) = o(n-1) + C + [o(n-2) + 2.C + ... + o(1) + (n-1).C + o(0) + n.C]
 *  		 	   = o(n-1) + C + o(n-1)
 *  			   = 2.o(n-1) + C
 *  
 *  		- 2.o(n-1) = 2^2.o(n-2) + 2.C.2^1
 *  
 *  		- 2^2.o(n-2) = 2^3.n(n-3) + 3.C.2^2
 *  
 *  		- 2^3.o(n-3) = 2^4.o(n-4) + 4.C.2^3
 *  
 *  		- .
 *  		- .
 *  		- .
 *  		
 *  		- 2^(n-1).o(1) = 2^n.o(0) + n.C.2^(n-1)
 *  
 *  		- o(0) = 0
 *  
 *  	- Summing up all the equations, we get:
 *  
 * 			-> o(n) = C + 2.C.2^1 + 3.C.2^2 + 4.C.2^3 + ... + n.C.2^(n-1)
 * 					= C[1 + 2.2^1 + 3.2^2 + 4.2^3 + ... + n.2^(n-1)]
 * 
 * 		- Since the highest order term in o(n) is of the order n.2^(n-1), time complexity = O(n.2^n).
 * 					
 *  - Space Complexity Analysis:
 *  
 *  	- Maximum 'n' stack frames will exist in the call stack simultaneously. 
 *        
 *      - The output array will store 2^n partitions each of size n.
 *      
 *      - Total space consumed would be of the order n.2^(n) + n. Hence, space complexity = O(n.2^n).
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
