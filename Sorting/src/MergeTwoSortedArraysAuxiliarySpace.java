import java.util.Scanner;

/* Problem Statement: Given 2 non-decreasing arrays: A (size m) and B (size n), merge them into a single
 * 					  sorted array of length (m+n).
 * 
 * NOTE: We are allowed to use an auxiliary array of size (m+n).
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- Add all elements of A in the first m slots of the auxiliary array AUX.
 * 		- Add all elements of B in the last n slots of the auxiliary array AUX.
 * 		- Loop from i=[m, m+n) and insert every AUX[i] at the correct position in the left sorted 
 *        sub-array AUX[0....i-1].
 *         
 *         
 *      - Time Complexity Analysis: 
 *      
 *      	- Considering worst-case scenario, for example, A=[4,5,6] and B=[1,2,3], the algorithm will 
 *      	  perform m swaps to insert every element of B at the correct position in AUX. 
 *      	- The total number of operations will be a polynomial of order m*n.
 *      	- Therefore, time complexity = O(m*n).
 *      
 *      
 *      - Space Complexity Analysis:
 *      	
 *      	- Since, we are using an auxiliary array of size (m+n), space complexity = O(m+n).
 *      
 *      
 *	- Two Pointers Approach:
 *
 *		- initialize a pointer "k" pointing to the start of array AUX. // pointer will be used to iterate over the AUX array.
 *
 *		- initialize 2 pointers "i" and "j" pointing to the start of arrays A and B. // these pointers will be used to iterate over arrays A and B.
 * 
 *		- while both A[i] and B[j] exist, compare the elements A[i] and B[j]:
 *			- if A[i] <= B[j], put AUX[k] = A[i] and increment pointers "i" and "k" by 1.
 *			- if B[j] < A[i], put AUX[k] = B[j] and increment pointers "j" and "k" by 1.
 *
 *		- while A[i] exist: // in case size of A, i.e., m is greater than size of B, i.e., n.
 *			- put AUX[k] = A[i] and increment pointers "i" and "k" by 1.
 *
 *		- while B[j] exist: // in case size of B, i.e., n is greater than size of A, i.e., m.
 *			- put AUX[k] = B[j] and increment pointers "j" and "k" by 1.
 *
 *
 *		- Time Complexity Analysis: Since, we will only iterate over arrays A and B one time, time 
 *									complexity = O(m+n).
 *
 *		
 *		- Space Complexity Analysis: Since, we are using an auxiliary array to store the resultant
 *									 sorted array, space complexity = O(m+n). 
 * 
 * */

public class MergeTwoSortedArraysAuxiliarySpace {
	
	public static int[] mergeTwoSortedArrays(int[] A, int[] B) {
		
		int[] ans = new int[A.length+B.length];
		
		int i=0, j=0, k=0; 

		while(i<A.length && j<B.length) {
			if(A[i]<B[j]) {
				ans[k] = A[i];
				i++;
			} else {
				ans[k] = B[j];
				j++;
			}
			k++;
		}
		
		while(i<A.length) {
			ans[k] = A[i];
			i++;
			k++;
		}
		
		while(j<B.length) {
			ans[k] = B[j];
			j++;
			k++;
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of sorted array 1: ");
		int n = scn.nextInt();
		
		int[] A = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		System.out.print("\nEnter size of sorted array 2: ");
		int m = scn.nextInt();
		
		int[] B = new int[m];
		for(int i=0; i<m; i++) {
			System.out.print("Enter B["+i+"]: ");
			B[i] = scn.nextInt();
		}
		
		int[] ans = mergeTwoSortedArrays(A, B);
		System.out.print("\nMerged Sorted array: ");
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
		scn.close();
		
	}

}
