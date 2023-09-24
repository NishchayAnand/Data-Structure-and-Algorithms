
/*
    General Observations:
    
    - The ideology behind bubble sort is to push the heaviest bubble / largest value at the end of the list under consideration.
    
    - For arr = {4,1,3,9,7}:
            
                                0 1 2 3 4
                        i = 1, [4 1 3 9 7] -> max = 9(j=3), n-i = 4 -> swap(arr[j], arr[n-i]) -> [4 1 3 7 9]
                        i = 2, [4 1 3 7|9] -> max = 7(j=3), n-i = 3 -> no swap required
                        i = 3, [4 1 3|7 9] -> max = 4(j=0), n-i = 2 -> swap(arr[j], arr[n-i]) -> [3 1 4 7 9]
                        i = 4, [3 1|4 7 9] -> max = 3(j=0), n-i = 1 -> swap(arr[j], arr[n-i]) -> [1 3 4 7 9]
    
    Algorithm:    
        - Loop from i = [1:n-1]: 
    
            - assume max_val_idx = 0; -> will be executed (n-1) times.
            
            - Loop from j = [0:n-i]: 
                - A[j] > A[max_val_idx];
                    - max_val_idx = j; -> in worst case, this will be executed [i=1, 5] + [i=2, 4] + [i=3, 3] + [i=4, 2] -> n + (n-1) + (n-2) + .... + 2  
                                                                                                                             = ((n-1)/2)*(4 + n-2)) = O(N^2)
         
            - swap(A, max_val_idx, n-i); -> will be executed (n-1) times.
        
    - Time Complexity = O(N^2).
    - Space Complexity = O(N).

*/

public class Bubble_Sort {
	
	private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //Function to sort the array using bubble sort algorithm.
	private static void bubbleSort(int arr[], int n)
    {
        for(int i=1; i<n; i++){
            int max_idx = 0;
            for(int j=0; j<=(n-i); j++){
                if(arr[j] > arr[max_idx]) max_idx = j;
            }
            if(max_idx != (n-i)) swap(arr, max_idx, n-i);
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
