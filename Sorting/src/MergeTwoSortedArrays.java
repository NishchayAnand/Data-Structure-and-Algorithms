
/* Problem Statement: Given 2 non-decreasing arrays: A (containing m integers) and B (containing n 
 * 					  integers), merge them into a single non-decreasing array of length (m+n).
 * 
 * NOTE: The final sorted array should not be returned by the function, but instead be stored inside the 
 * 		 array A. To accommodate this, A has a length of (m + n), where the first m elements denote 
 * 		 the elements that should be merged, and the last n elements are set to 0.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 	
 * 		- Ideology: 
 * 		
 * 			- Use insertion sort technique to place each element of array B at the current position in 
 * 			  array A. 
 * 
 * 		- Algorithm: 
 * 
 * 			- Add all elements of B in the last n slots of array A.
 * 			- Loop from i=[m, m+n) and insert every A[i] at the correct position in the left sorted 
 *        	  sub-array A[0....i-1].
 * 
 * 		- Time Complexity Analysis (worst-case scenario): 
 * 
 * 			- Considering worst-case scenario, for example, A=[4,5,6] and B=[1,2,3], the algorithm will 
 *      	  perform m swaps to insert each element of B at the correct position in A. 
 *      	- The total number of operations will be a polynomial of order m*n.
 *      	- Therefore, time complexity = O(m*n).
 * 
 * 		- Space Complexity: O(1).
 * 
 * 
 * 	- Two Pointers Approach: 
 * 
 * 		- Ideology:
 * 			
 * 			- While elements exist in array A and B:
 * 				- pick the smallest element out of the two arrays A and B and place it in an auxiliary
 * 				  array.
 * 
 * 		- Algorithm:
 * 		
 * 			- let temp = array[m+n] 		// auxiliary array to temporarily store the output.
 * 
 *			- let i=0, j=0; 				// Two pointers to iterate over arrays A and B.
 *
 *			- Loop from k = [0, m+n):   	// loop to fill the auxiliary array.
 *
 *				- if i<m && j<n:	    	// check if both A[i] and B[j] exist.
 *
 *					- if A[i] <= B[j]:		// finding the smallest element and filling it at kth index in the auxiliary array.
 *						- temp[k] = A[i];
 *						- i++;
 *					- else:
 *						- temp[k] = B[j];
 *						- j++;
 *
 *				- else if i<m:				// in case array A has more elements than array B.
 *					- temp[k] = A[i];
 *					- i++;
 *
 *				- else if j<n:				// in case array B has more elements than array A.
 *					- temp[k] = B[j];
 *					- j++;
 *
 * 		- Time Complexity Analysis: Since, the algorithm is only responsible for filling an auxiliary 
 * 									array of size (m+n), time complexity = O(m+n).
 *	
 *		- Space Complexity Analysis: Since, we are using an auxiliary array to store the resultant
 *									 sorted array, space complexity = O(m+n). 
 * 				
 * */

public class MergeTwoSortedArrays {
	
	public static void mergeUsingTwoPointers(int[] A, int m, int[] B, int n) {
		
		// auxiliary array to temporarily store the output.
		int[] temp = new int[m+n];
		
		// Two pointers to iterate over arrays A and B.
		int i=0, j=0;
		
		// loop to fill the auxiliary array.
		for(int k=0; k<temp.length; k++) {
			
			
			if(i<m && j<n) {			// check if both A[i] and B[j] exist.
				
				
				if(A[i] <= B[j]) { 		// finding the smallest element and filling it at kth index in the auxiliary array.
					temp[k] = A[i];
					i++;
				} else {
					temp[k] = B[j];
					j++;
				}
				
			} else if(i<m) { 			// in case array A has more elements than array B.
				
				temp[k] = A[i];
				i++;
				
			} else {					// in case array B has more elements than array A.
				
				temp[k] = B[j];
				j++;
				
			}
			
		}
		
		// copying the output from temp array to A as asked in the problem statement.
		for(int k=0; k<temp.length; k++) {
			A[k] = temp[k];
		}
		
	}
	
	public static void mergeUsingInsertionSort(int[] A, int m, int[] B, int n) {
		
		for(int i=m; i<(m+n); i++){
			
			// element to be inserted.
            int num = B[i-m];
            
            // index where we need to insert the element: B[i-m] 
            int index = i;
            
            // making place in A for element: B[i-m]
            for(int j=i-1; j>=0; j--){
                if(num < A[j]){
                    A[j+1] = A[j];
                    index = j; 
                } else {
                    break;
                }
            }
            
            // insert element: B[i-m] at correct index.
            A[index] = num;
             
        }
		
    }

	public static void main(String[] args) {
		
		int[] A = {4,6,18};
		int[] B = {3,7,10,17,20};
		
		int m = A.length;
		int n = B.length;
		
		int[] ans = new int[m+n];
		for(int i=0; i<m; i++) {
			ans[i] = A[i];
		}
		
		//mergeUsingInsertionSort(ans, m, B, n);
		mergeUsingTwoPointers(ans, m, B, n);
		
		System.out.print("Sorted Array: ");
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}

	}

}
