import java.util.Scanner;

/* Problem Statement: Given an integer array, its starting position "start" and its ending position "end",
 * 					  sort the array using merge sort algorithm.
 * 
 * General Observations:
 * 	
 * 	- The problem of sorting an array can be broken down into smaller sub-problems (for example, dividing 
 * 	  the array into 2 equal halves and sorting them individually) indicating a recursive nature.
 * 
 * 	- Ideology: 
 * 
 * 		- Divide the unsorted array into smaller sub-arrays, sort them, and then merge these sorted
 * 	 	  sub-arrays to obtain a fully sorted array. 
 * 
 * 	- Algorithm:
 * 
 * 		- Hypothesis: F(A, start, end) will sort the elements of array A in the range [start, end].
 * 
 * 		- Recursive Steps: - mid = (start+end)/2;
 * 						   - left_sorted_subarray = F(A, start, mid);
 * 						   - right_sorted_subarray = F(A, mid+1, end);
 * 						   - temp = merge(left_sorted_subarray, right_sorted_subarray);
 * 						   - copy temp into A[start....end];
 * 
 * 		- Base Condition: start == end, return; 	// an array with single element is always considered sorted.  
 * 
 * 	- Time Complexity Analysis:
 * 
 * 		- Let total operations performed for sorting an array of size n be TO(n) such that,
 * 
 * 				1. TO(n) = TO(n/2) + TO(n/2) + n  // Operations performed for merging 2 sorted arrays of length n/2 (each) is a polynomial of order n.
 * 						 = 2.TO(n/2) + n
 * 				2. TO(n) = 2.[2.TO(n/4) + n/2] + n = 2^2.TO(n/2^2) + 2.n
 * 				3. TO(n) = 2^2.[2.TO(n/2^3) + n/2^2] + 2.n = 2^3.TO(n/2^3) + 3.n
 *					.
 *					.
 *					.
 *				k. TO(n) = 2^k.TO(n/2^k) + k.n
 *
 *		- Considering kth step to be the termination step, n/2^k = 1 and TO(n/2^k) = 0. Therefore,
 *
 *				k. TO(n) = k.n, where k = logn
 *
 *		- Since, TO(n) turns out to be a polynomial of order n.logn, time complexity = O(n.logn).
 *
 * 	- Space Complexity Analysis:
 *
 *		- The recursive algorithm makes at most "logn" recursive calls consecutively, i.e., the 
 *		  algorithm will at most use "logn" call stack space. Hence, call stack space complexity = O(logn).
 *
 *		- Each recursive call creates a temporary array to store and merge the sub-arrays. However, as we 
 *		  are processing, i.e., merging the sub-arrays in post-order, the space used by temporary arrays
 *		  created in each recursive step will not add up in a cumulative manner. The maximum space the
 *		  algorithm will consume will depend on the largest stack frame, i.e., the one processing the 
 *		  main problem or the initial input. 
 *
 *		- Since, the largest stack frame will create a temporary array of size "n", the space complexity
 *		  = O(n).
 *
 * */

public class MergeSort {
	
	private static void merge(int[] arr, int start, int mid, int end) {
		
		int[] temp = new int[end-start+1];
		
		int i=start, j=mid+1;
		for(int k=0; k<temp.length; k++) {
			
			if(i<mid+1 && j<end+1) {
				
				if(arr[i]<=arr[j]) {
					temp[k] = arr[i];
					i++;
				} else {
					temp[k] = arr[j];
					j++;
				}
				
			} else if(i<mid+1) {
				
				temp[k] = arr[i];
				i++;
				
			} else {
				
				temp[k] = arr[j];
				j++;
				
			}
			
		}
		
		for(int k=0; k<temp.length; k++) {
			arr[start+k] = temp[k];
		}
		
	}
	
	public static void mergeSort(int[] arr, int start, int end) {	
		
		if(start==end) {
			return;
		}
		
		int mid = (start+end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
		merge(arr, start, mid, end);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = scn.nextInt();
		
		int[] A = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		mergeSort(A, 0, A.length-1);
		System.out.print("\nSorted array: ");
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		
		scn.close();

	}

}
