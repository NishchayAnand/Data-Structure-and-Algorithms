


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
