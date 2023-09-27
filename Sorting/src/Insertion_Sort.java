
/*
    General Observations:
    
        - An array with 1 element is always sorted.
    
        - Assuming the array as 2  halves: 
            (i) a group of sorted elements a.k.a "sorted subarray".
            (ii) a group of unsorted elements a.k.a "unsorted subarray".
            
        - The idea is to iterate over each element in the unsorted array and placing the element at the current position in the sorted array.
        
        - Algorithm:
        
            - Consider A[0] as sorted array and A[1.....n-1] as unsorted array.
            - Loop from i = [1:n-1]: --> will be executed n-1 times.
            -   Loop from j = [i:1]: --> #1
                    - if A[j] < A[j-1]:
                        swap(A[j], A[j-1]);
                    - else: 
                        break;
            
        - Runtime Complexities in worst case:
        
            - #1: for i=1, loop will run for 1 time.
                  for i=2, loop will run for 2 times.
                  for i=3, loop will run for 3 times.
                  .
                  .
                  for i=n-1, loop will run for n-1 times.
                  
                  Total operations = 1 + 2 + 3 + ..... + (n-1) = (n-1)/2*(1+n-1)
                  
            - Total Time Complexity: O(n^2)
            
            - Extra Space Complexity: O(1)
            
        - NOTE:
            - Adaptive Sorting Algorithm: performs well when the input data is partially sorted or already nearly sorted. In such cases, its time complexity can 
                                          approach O(n), making it significantly faster than its worst-case time complexity.
        
*/

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
