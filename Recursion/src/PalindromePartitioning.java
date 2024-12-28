import java.util.ArrayList;
import java.util.List;

/*

	Problem Statement: Given a string 's', partition 's' such that every substring of the partition
					   is a palindrome. Return all possible palindrome partitioning of s.

 	General Observations:

 		- The problem is naturally recursive in nature, i.e., find all palindrome substrings starting
 		  with the letter under-consideration, i.e., at index = 'index' and trust the recursive
 		  function to do the same with the remaining letters of the input string.

 		- Hypothesis:

 	 		- F(s, index, partition, partitions) will find all possible palindrome partitions in the
 	 		  range [index, s.length-1].

		- Recursive Steps:

 			- Loop from i = [index, s.length):
 	 			- substring = s[index:i];
 	 			- if substring is palindrome:
 	 				- partition.add(substring);
 	 				- F(s, i+1, partition, partitions);
 	 				- partition.remove(substring);

 		- Base Condition:

 		  	- if index == s.length, i.e., we have a palindromic partitioning of input string 's':
 				- partitions.add(partition.clone());
 				- return;

		- Time Complexity Analysis:

			- In worst case scenario, each substring of the given input string would be a palindrome.

 		  	- Let total number of operations performed by the above algorithm be o(n), such that:

		 		- o(n) = [o(n-1)+C] + [o(n-2)+2.C] + ... + [o(1)+(n-1).C] + [o(0)+n.C]
 	    			   = [o(n-1) + C] + [o(n-2) + C + ... + o(1) + (n-2).C + o(0) + (n-1).C] +
 	    			     [C + C + C + ... + C (n-1) times]
 	    			   = 2.o(n-1) + n.C

 		 		- 2.o(n-1) = 2^2.o(n-2) + 2.(n-1).C
 		 		- 2^2.o(n-2) = 2^3.o(n-3) + 2^2.(n-2).C

				- .
				- .
				- .

				- 2^(n-1).O(1) = 2^n.o(0) + 2^(n-1).C
 				- o(0) = 0 (assumed for simplicity)

 				- Summing up all the equations, we get:

		 		- o(n) = n.C + 2.(n-1).C + 2^2.(n-2).C + .... + 2^(n-1).C
		 			   = C.[n + 2.(n-1) + 2^2.(n-2) + ... + 2^(n-1).1]
		 			   = C.( summation of 2^k.(n-k) where k = [0, n-1] )

 			- Time Complexity = O(n.2^n).

 		- Space Complexity Analysis:

 		  	- Maximum 'n' stack frames will exist in the call stack simultaneously. Therefore,
 		  	  Space Complexity = O(n).

*/

public class PalindromePartitioning {

	private static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length()-1;
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

	private static void getPalindromePartitions(String s, int index, List<String> partition, List<List<String>> partitions) {

		if(index == s.length()) {
			partitions.add(new ArrayList<>(partition));
			return;
		}

		for(int i = index; i<s.length(); i++) {
			String substring = s.substring(index, i+1);
			if(isPalindrome(substring)) {
				partition.add(substring);
				getPalindromePartitions(s, i+1, partition, partitions);
				partition.removeLast();
			}
		}
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> partitions = new ArrayList<>();
		getPalindromePartitions(s, 0, new ArrayList<>(), partitions);
		return partitions;
	}

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));
	}

}
