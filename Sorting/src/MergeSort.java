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
 *		- Since the recursive algorithm will at max make k, i.e, logn recursive calls, the algorithm will 
 *		  at max use "logn" space of the call stack. Hence, call stack space complexity = O(logn).
 *
 *		- In each recursive call, we are creating a temporary array to store the merged array. The largest 
 *		  temporary array that will be created by the algorithm will be of size n. Therefore, the maximum
 *		  space that will be used by any stack frame is "n". Hence, space complexity = O(n). 
 *
 * */

public class MergeSort {
	
	private static void merge(int arr[], int start, int mid, int end) {
	}
	
	public static int[] mergeSort(int[] A, int start, int end) {	
		return new int[A.length];
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
		
		int[] ans = mergeSort(A, 0, A.length-1);
		System.out.print("\nSorted array: ");
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
		scn.close();

	}

}
