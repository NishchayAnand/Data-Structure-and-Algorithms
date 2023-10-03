
/*
 * General Observations:
 * 
 * - Ideology:
 * 
 * 		- Consider the array as 2  halves: 
 *    		(i) a group of sorted elements a.k.a "sorted sub-array"
 *          (ii) a group of unsorted elements a.k.a "unsorted sub-array".
 *  
 *  	- While the size of the unsorted array is not reduced to 0:
 *  		- Take the minimum element from the unsorted sub-array and place it at the end of the sorted 
 *   		  sub-array.
 *  
 * 		- Simply finding the minimum element in the unsorted array and swapping it with its first element 
 *        will do the trick, increasing/decreasing the size of sorted/unsorted array by 1.
 *        
 * - Algorithm:
 * 	
 * 		1. Loop from i = [0, n-2]:--> for i=n-1, left sorted sub-array = A[0...n-2] and right unsorted 
 * 												 sub-array = A[n-1] where A[n-1] is greater than all 
 * 												 elements in left sub-array, therefore, at the correct 
 * 												 location.
 * 			2. min_val_idx = i;
 * 		 ---------------------------------------
 * 		|	3. Loop from j = [i+1, n):          |
 * 		|		4. if A[j] < A[min_val_idx]:    |
 * 		|			5. min_val_idx = j;         |
 * 		 ---------------------------------------
 * 			6. if min_val_idx != i:
 * 				7. swap(min_val_idx, i); 
 * 
 *  - Time Complexity:
 *  
 *  	- For every scenario, 3rd code block, i.e., the most time intensive block will run for n^2 times.
 *  	  Since, the algorithm does not adapt to the data in any way, its runtime is always quadratic, 
 *        i.e, time complexity = O(n^2).
 *		
 *	NOTE: - The algorithm will at max perform n-1 swaps (for example, consider A = [4,1,5,3,2]).
 *
 * */



/*
    General Observations:
    
    - The ideology is to consider the array as 2  halves: 
            (i) a group of sorted elements a.k.a "sorted subarray"
            (ii) a group of unsorted elements a.k.a "unsorted subarray".
            
    - The idea is to  --> Repeat this until the length of the unsorted array becomes 0.
      
    - All the elements in the sorted array will be less or equal to the elements in th unsorted array.
      
    Algorithm: 
    
        - Loop from i = [1:n-2] --> n is the length of array --> consider A[0...i-1] as sorted array and A[i....n-1] as unsorted array --> will run for n-1 times.
        
            - min_el_idx = i --> will run for n-1 times.
            
            - Loop from j = [i+1:n-1]:  --> #1: will run for n^2 times.
                - if A[j] < A[min_val_idx]: --> will run for n^2 times.
                    - min_val_idx = j --> worst case (reverse): n^2 times, best case: 0 times. 
                     
            - if min_el_idx != i: --> will run for n-1 times.
                - swap(min_val_idx, i) --> worst case (reverse): n-1 times, best case: 0 times.
            
    Time Complexity Analysis:
        
        
        - Additional Space Complexity = O(1)
        
    Advantage:
        - Has the property of minimizing the number of swaps. In applications where the cost of swapping items is high, selection sort very well may be the algorithm of
          choice.

*/

public class Selection_Sort {
	
	private static void selectionSort(int arr[], int n) {
		
	    for(int i=0; i<n-1; i++){
	    	
	    	int min_val_idx = i;
	    	
	    	// find minimum element in arr[i....n-1].
	        for(int j=i+1; j<arr.length; j++){
	            if(arr[j]<arr[min_val_idx]){
	                min_val_idx = j;
	            }
	        }
	        
	        // swap if minimum element is not at position i.
	        if(min_val_idx != i){
	            int temp = arr[i];
	            arr[i] = arr[min_val_idx];
	            arr[min_val_idx] = temp;
	        }
	    }
	}

	public static void main(String[] args) {
		
		int[] arr = {2,1,3,5,4};
		selectionSort(arr, 5);
		
		for(int el: arr) {
			System.out.print(el + " ");
		}
		
	}

}
