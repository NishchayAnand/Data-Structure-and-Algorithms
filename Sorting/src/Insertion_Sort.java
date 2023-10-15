
/*
 * General Observations:
 * 
 * 		- Ideology:
 * 
 * 			- Consider the array as 2  halves: 
 *    			(i) a group of sorted elements a.k.a "sorted sub-array"
 *          	(ii) a group of unsorted elements a.k.a "unsorted sub-array".
 *  
 *  		- While the size of the unsorted array is not reduced to 0:
 *  			- Take the first element from the unsorted sub-array and place it at the correct location 
 *  		  	  in the sorted sub-array.
 *  	
 *  		- Taking the first element from the unsorted sub-array and repeatedly swapping it with 
 *  		  elements greater than it in the sorted sub-array will always end up placing the element at 
 *  		  the correct position in the sorted sub-array, increasing/decreasing the size of sorted / 
 *  		  unsorted sub-array by 1.
 *  
 *      - An array with single element is always considered sorted.
 *  
 *  
 *  	- Iterative Algorithm:
 *       
 *      	- Consider A[0] as sorted array and A[1.....n-1] as unsorted array.
 *           
 *	             1. Loop from i = [1:n-1]: 
 *	             	2. Loop from j = [i:1]:
 *	                     3. if A[j] < A[j-1]:
 *	                     	4. swap(A[j], A[j-1]); #1
 *	                     5. else: 
 *	                     	6. break;
 *                   
 *          - Time Complexity Analysis (for worst case scenario, i.e., when A is reverse sorted):
 *          
 *          	- #1 : for i=1, 1 swap.
 *          			   i=2, 2 swaps.
 *          			   i=3, 3 swaps.
 *          			   .
 *          			   .
 *          			   i=n-1, n-1 swaps.
 *          
 *              - Total operations: 1 + 2 + 3 + .... + (n-1) = n(n+1)/2. Since, total operations is a 
 *                polynomial of order n^2, therefore, time complexity = O(n^2).
 *          
 *          - Space Complexity Analysis: no auxiliary space is used, therefore, space complexity = O(1).
 *          
 *          	              
 *     - Recursive Algorithm:
 *     
 *     		- Hypothesis: F(A, n) will sort the first n elements of array A.
 *     
 *     		- Recursive Steps: - F(A, n-1) #1: go and sort the first (n-1) elements.
 *     						   - Loop from j=[n-1, 1]: #2: place the nth element at the correct position in the sorted sub-array A[0...n-2].
 *     						   		- if A[j] < A[j-1]:
 *     									- swap(A[j], A[j-1]);
 *     								- else:
 *     									- break;
 *     
 *     		- Base Condition: n==0 || n==1, return; i.e, an empty array or an array with single element 
 *     												     is always considered sorted, therefore, no 
 *     												     actions required. 
 *     
 *     		- Time Complexity Analysis (for worst case scenario, i.e., when A is reverse sorted):
 *     
 *      		- Considering TO(n) be the total number of operations that will be performed to sorted 
 *      		  an array of size n, we can say:
 *      
 *      				- TO(n) = TO(n-1) + (n-1) = 
 *      				- TO(n) = [TO(n-2) + (n-2)] + (n-1)
 *      				- TO(n) = [TO(n-3) + (n-3)] + (n-2) + (n-1)
 *      				- TO(n) = [TO(n-4) + (n-4)] + (n-3) + (n-2) + (n-1)
 *      				- .
 *      				- .
 *      				- TO(n) = [TO(2) + 2] + ..... + (n-4) + (n-3) + (n-2) + (n-1)
 *      				- TO(n) = [TO(1) + 1] + 2 + ..... + (n-4) + (n-3) + (n-2) + (n-1)
 *      
 *      		- TO(1) is the base condition, hence, no operations performed. Therefore, 
 *      
 *      				- TO(n) = 1 + 2 + ...... + (n-2) + (n-1) = n(n+1)/2
 *    			
 *    			- Since, total number of operations is a polynomial of order n^2, therefore, time 
 *    			  complexity = O(n^2).
 *    
 *    		- Space Complexity Analysis:
 *    
 *				- Since F(A, n) --> F(A, n-1) --> F(A, n-2) --> F(A, n-3) --> .... --> F(A, 1), the 
 *				  function call stack will at max store the variables for (n+1) function calls. 
 *
 * 				- No auxiliary space is used in the function.
 * 
 * 				- Hence, space complexity: - O(1), when not considering the function call stack.
 * 										   - O(n), when considering the function call stack.
 *     
 *     
 *     - NOTE:
 *     
 *     		- Best case scenario:
 *				- For already sorted array, for example, A = [1,2,3,4,5], the algorithm will perform 1 
 *				  pass through the data, therefore, time complexity = O(n).
 *				- For nearly sorted array, for example, A = [2,1,3,4,5], the algorithm will perform 1
 *				  pass through the data, therefore, time complexity = O(n).  
 *  
 * */

public class Insertion_Sort {
	
	public static void IterativeInsertionSort(int[] arr, int n) {
		for(int i=1; i<n; i++) {
			for(int j=i; j>0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else {
					break;
				}
			}
		}
	}
	
	public static void RecursiveInsertionSort(int[] arr, int n) {
		// base condition:
		if(n<=1) {
			return;
		}
		// Recursive Steps:
		RecursiveInsertionSort(arr, n-1); // go and sort the first (n-1) elements of arr.
		for(int j=n-1; j>0; j--) { 		  // insert the nth element at the correct position in the sorted subarray A[0...n-2].
			if(arr[j]<arr[j-1]) {
				// swap operation.
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			} else {
				break;
			}
		}
	}
	
	

	public static void main(String[] args) {

		int[] arr = {2,3,5,4,1};
		
		// Iterative solution.
		//IterativeInsertionSort(arr, 5);
		
		// Recursive solution.
		RecursiveInsertionSort(arr, 5);
		
		for(int el: arr) {
			System.out.print(el+" ");
		}

	}

}
