
/* Problem Statement: Given an array containing only 0s, 1s, and 2s, sort the array in ascending order.
 * 
 * General Observations:
 * 	
 * 	- Brute Force Approach: - Use any optimal sorting algorithm.
 * 
 * 	- Better Approach: - Can count the number of 0s, 1s and 2s and then override the array using the 
 * 						 counts obtained. 
 * 
 * 					   - Time Complexity = O(2*N) = O(N).
 * 
 * 	- Optimized Approach (Dutch National Flag Algorithm): 
 * 
 * 		- use partition using a pivot concept.  
 * 
 * */

public class Sort012 {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void sort(int[] A) {
		
		int j=0, k=A.length-1, i=0;
		while(i<=k) {
			if(A[i]==2) {
				swap(A, i, k);
				k--;
			} else if(A[i]==0) {
				swap(A, i, j);
				j++;
				i++;
			} else {
				i++;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0, 2, 1, 2, 0};
		
		System.out.print("Original Array: ");
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		
		sort(A);
		
		System.out.print("\nSorted Array: ");
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}

	}

}
