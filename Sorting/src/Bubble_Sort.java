
/* General Observations:
 * 
 * 	- Ideology:
 * 
 * 		- Consider the array as 2  halves: 
 *    		(i) a group of sorted elements a.k.a "sorted sub-array"
 *          (ii) a group of unsorted elements a.k.a "unsorted sub-array".
 *  
 *  	- While the size of the unsorted array is not reduced to 0:
 *  		- Take the minimum element from the unsorted sub-array and place it at the end of the sorted 
 *   		  sub-array. 
 *     
 *  - For an array A[0....n-1], looping from j=[n-1:1] and swapping the A[j] element with A[j-1] element 
 *    (i.e., element to its immediately left) if A[j] is smaller than A[j-1] will always end up placing 
 *    the minimum element at A[0], i.e., start of the array.
 *    
 *  - Algorithm:
 *  	- 
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
        for(int i=0; i<n-1; i++){
            boolean swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
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
