import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* Problem Statement: Given an array of 'n' distinct integers, return all the possible permutations. 
 * 
 * 					  NOTE: You can return the answer in any order.
 * 
 * General Observations:
 * 
 * 	- Find the number of ways of filling 'n' spaces with 'n' integers of the input array.  
 * 
 *  - Considering we start filling the spaces from 'right to left':
 *  	- for filling the 'nth' space, we have 'n' choices, i.e., can choose any integer out of the n 
 *  	  integers.
 *  	- for filling the '(n-1)th' space, we have 'n-1' choices, i.e., can choose any integer out of the 
 *        n-1 available integers.
 *  	- .
 *  	- .
 *  	- .
 *  	- for filling the '2nd' space, we have '2' choices, i.e., the last 2 unchosen integers.
 *  	- for filling the '1st' space, we have only '1' choice, i.e., the last unchosen integer.
 *  
 *  - The choices of filling a space is dependent on the choices made for filling the previous space. 
 *  
 *  - The problem is naturally recursive in nature, i.e., you only have to worry about filling the space 
 *    under-consideration and trust the algorithm to do the same for the remaining spaces.
 *    
 *  - Hypothesis:
 *  
 *  	- F(arr, n, chosen) will explore all possible ways of filling the first 'n' spaces.
 *  
 *   	NOTE: - Since we don't have an idea what would be the values of the integers in the input array,
 *   			it is better use a hashset than a boolean array to mark the integers that have been 
 *   		    'chosen' in the previous recurive calls. 
 *  
 *  - Recursive Steps:
 *  	
 *  	- Loop 'num' in arr:
 *  		- if !chosen.contains(num):
 *  			- permutation[n-1] = num;  // --> the permutation will be overridden in each branch in 
 *  											  such a way that we will always get a unique permutation
 *  											  when all spaces are filled.								
 *  			- chosen.add(num);
 *  			- F(arr, n-1, chosen);
 *  			- chosen.remove(num);
 *  
 *  - Base Condition:
 *  
 *  	- if n==0: 	
 *  		- output.append(Arrays.asList(permutation)); 
 *  		- return; 
 *  
 *  - Time Complexity Analysis:
 *  
 *   	- Let total number of operations performed by the above alogorithm be o(n), such that:
 *  
 *   		- o(n) = n.o(n-1) + n.C
 *   		- n.o(n-1) = n.(n-1).o(n-2) + n.(n-1).C
 *   		- n.(n-1).o(n-2) = n.(n-1).(n-2).o(n-2) + n.(n-1).(n-2).C
 *   		- .
 *   		- .
 *   		- .
 *   		- n.(n-1).(n-2)....2.[o(1)] = n.(n-1).(n-2)....2.[o(0)] + n.(n-1).(n-2)....2.[C]
 *   		- o(0) = 0
 *   
 *   		-> o(n) = n.C + n.(n-1).C + n.(n-1).(n-2).C + ... + n.(n-1).(n-2)....2.C
 *   				= C.[n + n.(n-1) + ... + n.(n-1).(n-2)...3.2 + n.(n-1).(n-2)...2.1]
 *   				= C.[n!/(n-1)! + n!/(n-2)! + ... + n!/3! + n!/2! + n!/1! + n!]
 *   				= C.n!.[1/(n-1)! + 1/(n-2)! + ... + 1/2! + 1/1! + 1]
 *   				~ C.n! 
 *   
 *   	- Since, the total operations performed by the algorithm is approx. C.n!, the time complexity
 *   	  of the algorithm is O(n!).
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- Maximum auxiliary space used by the recursive call stack will be of the order 'n'.
 *  
 *  	- The 'chosen' hashset will store at maximum 'n' integers.
 *  
 *  	- The output list will store 'n!' array lists each of size 'n'. Hence, size of the output list 
 *        will be 'n!*n'.
 *  
 *  	- Since, the total space consumption  theby algorithm will be proportional to (n + n + n!*n), the 
 *        space complexity of the algorithm will be O(n!*n).
 * 
 * */


public class Permutations {
	
	private static List<List<Integer>> output;
	private static Integer[] permutation;
	
	private static void getPermutations(int[] arr, int n, HashSet<Integer> chosen) {
		
		if(n==0) {
			List<Integer> ans = new ArrayList<>(Arrays.asList(permutation));
			output.add(ans);
			return;
		}
		
		for(int num: arr) {
			if(!chosen.contains(num)) {
				permutation[n-1] = num;		// --> override the value at nth place of permutation array.				
				chosen.add(num);
				getPermutations(arr, n-1, chosen);
				chosen.remove(num);				
			}	
		}
			
	}
	
	/* TODO: to be explored further...
	private static void getPermutationsWithoutChosenHashSet(ArrayList<Integer> arr) {
		
		if(perm.size() == arr.size()) {
			List<Integer> ans = (ArrayList<Integer>) perm.clone();
			output.add(ans);
			return;
		}
		
		for(int i=0; i<arr.size(); i++) {	
			int num = arr.remove(0);
			perm.add(num);
			getPermutationsWithoutChosenHashSet(arr);
			num = perm.remove(perm.size()-1);
			arr.add(num);	
		}
			
	}
	*/

	public static void main(String[] args) {
		
		int[] input = {1,2,3};
		
		permutation = new Integer[input.length];
		output = new ArrayList<>();
		
		HashSet<Integer> chosen = new HashSet<>();		
		getPermutations(input, input.length, chosen);
		System.out.println(output);

	}

}
