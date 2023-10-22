
/* Problem Statement: Given an array A, its starting position "start" and its ending position "end", sort
 * 					  the array using quick sort algorithm. 
 * 
 * General Observations:
 * 
 * 	- Partitioning an array using a pivot element positions the pivot element at its appropriate index in 
 *    the resulting sorted array.
 * 
 * 	- Ideology: 
 * 
 * 		- Repeatedly divide the unsorted array into two sub-arrays (one containing elements less than a 
 * 		  chosen pivot, and the other containing elements greater than the pivot) and apply the same 
 * 		  sorting algorithm to these sub-arrays until the entire array is sorted.
 * 
 * 	- Algorithm:
 * 
 * 		- Hypothesis: F(A, start, end) will sort the elements of array A in the given range [start, end].
 * 
 * 		- Recursive Steps: - choose A[end] as the pivot element and re-arrange sub-array A[start, end]
 * 							 such that all elements less than or equal to pivot lie on the left side of 
 * 							 pivot and all elements greater than pivot lie on the right side of pivot. 
 * 							 
 * 							 	-> pivot_idx = partition(A, start, end);
 * 						   
 * 						   - go and sort left sub-array.
 * 
 *    							-> F(A, start, pivot_idx-1);
 *    
 * 						   - go and sort the right sub-array.
 * 
 * 								-> F(A, pivot_idx+1, end);
 * 
 * 		- Base Condition: - pivot element in an array of size 1 will already be at the correct position, 
 * 							hence no operation required. 
 * 				
 * 								-> if start == end, return;
 * 
 * 						  - no operations needed if sub-array reduces to an empty array (consider the 
 * 							right sub-array of an already sorted array).
 * 
 * 								-> if start > end, return; 
 * 
 *  - Time Complexity Analysis:
 *  
 *  	- Average-Case Time Complexity: O(nlogn)
 *  	- Worst-Case (for example, already sorted array, reverse sorted array) Time Complexity: O(n^2)
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- Since, it is an in-place sorting algorithm, the space complexity will depend on the depth of
 *        the recursive call stack. 
 *  	  
 *  		- Average-Case Space Complexity: O(logn)
 *  		- Worst Case (for example, already sorted array, reverse sorted array) Space Complexity: O(n)
 *  
 * */

public class QuickSort {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	
	public static int partitionArray(int[] A, int start, int end) {
		
		int pivot = A[end];
		
		int idx = start; // idx represent the start of elements greater than the pivot element.
		for(int i=start; i<end; i++) {
			if(A[i]<=pivot) {
				swap(A, i, idx);
				idx++;
			}
		}
		
		swap(A, idx, end);
		
		// return the position of the pivot element.
		return idx;
		
	}
	
	
	public static void quickSort(int[] A, int start, int end) {
		
		if(start>=end) {
			return;
		}
		
		int pivot_idx = partitionArray(A, start, end);
		quickSort(A, start, pivot_idx-1);
		quickSort(A, pivot_idx+1, end);
		
	}

	
	public static void main(String[] args) {
		
		int[] A = {4, 1, 3, 9, 7};
		
		quickSort(A, 0, A.length-1);
		
		System.out.print("Sorted Array: ");
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}

	}
	

}
