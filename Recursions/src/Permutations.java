
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
 *   	NOTE: 'chosen' is a hashset that will be used to mark the integers that have been chosen in the 
 *   		  previous recursive calls. 
 *  
 *  - Recursive Steps:
 *  	
 *  	- Loop 'num' in arr:
 *  		- if !chosen.contains(num):
 *  			- permutation[n] = num;  // --> the permutation will be overridden in each branch in such
 *  										    a way that we will always get a unique permutation when
 *  											all spaces are filled.								
 *  			- chosen.add(num);
 *  			- F(arr, n-1, chosen);
 *  			- chosen.remove(num);
 *  
 *  - Base Condition:
 *  
 *  	- if n==0: 	
 *  		- todo: change permutation from array to arraylist. 
 *  		- return; 
 * 
 * 
 * */


public class Permutations {

	public static void main(String[] args) {
		
		

	}

}
