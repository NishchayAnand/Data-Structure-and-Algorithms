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
 * 		
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
 *		
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
