
/* Problem Statement: - Given an array containing 'n' elements (integers), return the maximum profit that 
 * 					    can be generated by removing elements from the array.
 * 
 * 					  - NOTE:
 * 
 * 					  	- Removing the ith element from the {modified} array will make you the following
 * 						  profit:
 * 			
 * 							- A[i] + A[i-1]^A[i+1] - GCD(A[i-1], A[i+1]), if both (i-1) and (i+1) are in 
 * 							  the array bounds, where ^ represents the XOR operation.
 * 
 * 							- A[i], if (i-1) or (i+1) goes beyond the array bounds.
 * 
 * 					  - Example:
 * 
 * 							- A = [1, 2, 3]
 * 
 * 							- Steps:
 * 				
 * 								1. Remove the 2nd element to generate profit = 2 + 1^3 - GCD(1,3) = 
 * 								   2 + 2 - 1 = 3, leaving the remaining array as [1, 3].
 * 
 * 								2. Remove the 2nd element to generate profit = 3 (Total Profit = 6), 
 * 								   leaving the remaining array as [1].
 * 
 * `							3. Remove the 1st element to generate profit = 1 (Total Profit = 7),
 *								   leaving the remaining array as [].
 * 					
 * General Observations:
 * 
 * 	- No. of ways to generating profit = No. of possible permutations of the elements in the input array. 
 * 
 * 	- Optimization Problem: Can be solved using Dynamic Programming. 
 * 
 * 	- Recursive Approach:
 * 
 * 		- Hypothesis: F(A) will return the maximum profit that can be generated by removing all available
 * 					  elements in array 'A'.
 * 
 * 		- Recursive Steps:
 * 
 * 			- Loop from i = [0, A.length-1]:
 * 
 * 				- if isAvailable[i] == True: --> A[i] hasn't been selected before. 
 * 
 * 					- isAvailable[i] = False;
 * 					- deletedElementCount++;
 * 
 * 					- profit = getProfit(A, i) + getMaximumProfit(A);
 * 
 *  				- maxProfit = Max(maxProfit, profit);
 * 
 * 					- isAvailable[i] = True;
 * 					- deletedElementCount--;
 * 
 * 		- NOTE: getProfit(A, i) will if (i-1) and (i+1) are valid elements and return the profit that can 
 * 			    be generated by removing the 'ith' element. 
 * 
 * 		- Base Condition:
 * 	
 * 			- if deletedElementCount == A.length:
 * 				- return 0; --> No elements are available, hence, maximumn profit = 0. 
 * 
 * */

public class Test1 {
	
	private static boolean[] isAvailable;
	private static int deletedElementCount;
	
	private static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	private static int getProfit(int[] A, int i) {
		
		int profit = A[i];
		
		boolean isLeftValidIndex = (i-1)>=0 && isAvailable[i-1]; 
		boolean isRightValdIndex = (i+1)<A.length && isAvailable[i+1];
		
		if( isLeftValidIndex && isRightValdIndex ) {
			int xor = A[i-1]^A[i+1];
			//System.out.println("XOR of " + A[i-1] + " and " + A[i+1] + ": " + xor);
			profit += xor - gcd(A[i-1], A[i+1]);
		}
		
		return profit;
		
	}

	private static int getMaximumProfit(int[] A) {
		
		if(deletedElementCount == A.length) {
			return 0;
		}
		
		int maxProfit = 0;
		for(int i=0; i<A.length; i++) {
			if(isAvailable[i]) {
				
				isAvailable[i] = false;
				deletedElementCount++;
				
				int currElementProfit = getProfit(A, i);
				// System.out.println(currElementProfit);
				
				int profit = currElementProfit + getMaximumProfit(A);
				maxProfit = Math.max(maxProfit, profit);
				
				isAvailable[i] = true;
				deletedElementCount--;
				
			}
		}
		
		return maxProfit; 
		
	}
	
	public static void main(String[] args) {
		
		int[] A = {1,2,3};
		
		isAvailable = new boolean[A.length];
		for(int i=0; i<isAvailable.length; i++) {
			isAvailable[i] = true;
		}
		
		int profit = getMaximumProfit(A);
		
		System.out.println("Maximum Profit = " + profit);

	}

}