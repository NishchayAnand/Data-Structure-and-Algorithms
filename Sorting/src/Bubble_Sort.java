
/* General Observations:
 * 
 * 	- Ideology:
 * 
 * 		- Consider the array as 2  halves: 
 *    		(i) a group of sorted elements a.k.a "sorted sub-array" (initially consider first element as part of sorted sub-array).
 *          (ii) a group of unsorted elements a.k.a "unsorted sub-array" (initially consider all elements expect the first element as part of the un-sorted sub-array). 
 *  
 *  	- While the size of the unsorted array is not reduced to 0:
 *  		- Take the minimum element from the unsorted sub-array and place it at the start of the 
 *            unsorted sub-array such that it becomes the last element of the sorted sub-array. 
 *     
 *  	- For an array A[0....n-1], looping from j=[n-1:1] and swapping the A[j] element with A[j-1] 
 *        element (i.e., element to its immediately left) if A[j] is smaller than A[j-1] will always end 
 *        up placing the minimum element at A[0], i.e., start of the array.
 *    
 *  - Algorithm:
 *  
 *  	- Loop from i = [0, n-2] to fill the 'ith' position of the sorted sub-array:
 *      	- Loop from j=[n-1, i+1] to find the minimum element in the unsorted sub-array and place it 
 *      	  at the 'ith' index:
 *      		- if A[j] < A[j-1]:
 *      			- swap A[j], A[j-1] 
 *      
 *  	- NOTE:
 *  
 *  		- For i=(n-1), left sorted sub-array = A[0...n-2] and right unsorted sub-array = A[n-1], such
 *  					   that A[n-1] is greater than all elements in left sorted sub-array, therefore, 
 *  					   at the correct location.

 *      
 *	- Optimization: For any ith iteration, if no swaps happens, then we can say that the array is already 
 *					sorted and there is no need to process further.
 *
 *	- Time Complexity:
 *
 *		- Best case scenario:
 *				- For already sorted array, for example, A = [1,2,3,4,5], the algorithm will perform 1 
 *				  pass through the data, therefore, time complexity = O(n).
 *				- For nearly sorted array, for example, A = [2,1,3,4,5], the algorithm will perform 2
 *				  passes through the data, therefore, time complexity = O(n).
 *		
 *		- Worst case scenario:
 *				- Reverse sorted array, for example, A = [5,4,3,2,1], the algorithm will perform n^2 
 *				  of swaps, therefore, time complexity = O(n^2).   
 *   
 * */

public class Bubble_Sort {
	
	private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        for(int i=0; i<n; i++){
            boolean swapped = false;
            for(int j=n-1; j>i; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                    swapped= true;
                }
            }
            if(!swapped) break;
        }
    }

	public static void main(String[] args) {
		int[] arr = {4,1,3,9,7};
		bubbleSort(arr, 5);
		for(int el: arr) {
			System.out.print(el+" ");
		}
	}

}
