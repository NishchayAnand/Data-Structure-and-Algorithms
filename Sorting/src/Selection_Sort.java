
/*
    General Observations:
    
    - The ideology is to consider the array as 2  halves: 
            (i) a group of sorted elements a.k.a "sorted subarray"
            (ii) a group of unsorted elements a.k.a "unsorted subarray".
            
    - The idea is to find the minimum element in the unsorted array and place it at the start of it, increasing the length of sorted array by 1 and decreasing
      the length of unsorted array by 1. --> Repeat this until the length of the unsorted array becomes 0.
      
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
        
        #1: for i = 0, it will run for n-1 times.
            for i = 1, it will run for n-2 times.
            .
            .
            for i=n-2, it will run for 1 time.
            
            Therefore, total operations: (n-1) + (n-2) + ...... + 1 = (n-1)/2*(2 + n-1) = f(n^2).
            
        - Time Complexity = O(n^2)
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
