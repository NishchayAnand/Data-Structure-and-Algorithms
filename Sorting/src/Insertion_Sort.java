
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
 *  	- Algorithm:
 *       
 *      	- Consider A[0] as sorted array and A[1.....n-1] as unsorted array.
 *           
 *           1. Loop from i = [1:n-1]: 
 *           	2. Loop from j = [i:1]:
 *                   3. if A[j] < A[j-1]:
 *                   	4. swap(A[j], A[j-1]);
 *                   5. else: 
 *                   	6. break;
 *     
 *     - Time Complexity:
 *     
 *     		- Best case scenario:
 *				- For already sorted array, for example, A = [1,2,3,4,5], the algorithm will perform 1 
 *				  pass through the data, therefore, time complexity = O(n).
 *				- For nearly sorted array, for example, A = [2,1,3,4,5], the algorithm will perform 1
 *				  pass through the data, therefore, time complexity = O(n).
 *		
 *			- Worst case scenario:
 *				- Reverse sorted array, for example, A = [5,4,3,2,1], the algorithm will perform n^2 
 *				  of swaps, therefore, time complexity = O(n^2).   
 *  
 * */

public class Insertion_Sort {
	
	public static void insertionSort(int arr[], int n) {
	      for(int i=1; i<n; i++){
	    	  for(int j=i; j>0; j--){
	              if(arr[j] < arr[j-1]){
	                  int temp = arr[j];
	                  arr[j] = arr[j-1];
	                  arr[j-1] = temp;
	              } else {
	                  break;
	              }
	          }
	      }
	  }

	public static void main(String[] args) {

		int[] arr = {2,3,5,4,1};
		insertionSort(arr, 5);
		
		for(int el: arr) {
			System.out.print(el+" ");
		}

	}

}
