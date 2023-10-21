import java.util.Scanner;

/* Problem Statement: Given an integer array A and a number a.k.a pivot element, rearrange the elements in 
 * 					  the array A such that all elements less than the pivot are on the left side, and all 
 * 					  elements greater than the pivot are on the right side. 
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- Algorithm:
 * 
 * 			- Create an auxiliary array of size = (size of array A).
 * 			- Loop over array A and add all elements less than or equal to pivot element to the auxiliary 
 * 		  	  array.
 * 			- Loop over array A and add all elements greater than pivot element to the auxiliary array.
 * 
 * 		- Time Complexity Analysis:
 * 
 * 			- Since, we are iterating over array A twice and filling the auxiliary array, time complexity
 * 			  = O(n).
 * 
 * 		- Space Complexity Analysis:
 * 	
 * 			- Since, we are using an auxiliary array of size n, i.e., size of the input array A, space
 * 			  complexity = O(n).
 * 		
 * 
 * 	- Optimized Approach:
 * 
 * 		- Algorithm:
 * 		
 * 			- Let "idx=0" be the index marking the start of elements greater than the pivot element.
 * 			- Loop from i=[idx, n): 		// check if all elements in the range [idx, n-1] are greater than pivot.
 * 				- check if A[i] <= pivot:	// if A[i] is less than pivot, it should be in the left sub-array. 
 * 					- swap(A[i], A[idx]); 	// move A[i] to the end of the left sub-array (containing elements <= pivot). 
 * 					- idx++;				// decrease the length of right sub-array (containing elements > pivot).
 * 
 * 		- Time Complexity Analysis:
 * 
 * 			- Since, we are only iterating over array A once, time complexity = O(n).
 * 			
 * 		- Space Complexity Analysis:
 * 
 *  		- Since, we are not using only auxiliary space (rearranging in-place), space complexity = O(1).
 *   
 * */

public class PartitionArray {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void partition(int[] A, int pivot) {
		
		int idx=0;
		for(int i=0; i<A.length; i++) {
			if(A[i]<=pivot) {
				swap(A, i, idx);
				idx++;
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		System.out.print("\nEnter the pivot element: ");
		int pivot = scn.nextInt();
		
		partition(A, pivot);
		System.out.print("\nArray after partition using approach 1: ");
		for(int i=0; i<size; i++) {
			System.out.print(A[i]+" ");
		}
		
		scn.close();

	}

}
