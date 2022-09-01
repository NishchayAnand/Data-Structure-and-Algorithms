import java.util.Scanner;

public class QuickSort {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static int partitionArray(int[] A, int start, int end) {
		
		int j=0, pivot = A[end];
		for(int i=0; i<=end; i++) {
			if(A[i]<=pivot) {
				swap(A, i, j);
				j++;
			}
		}
		
		return j-1;
		
	}
	
	public static void quickSort(int[] A, int start, int end) {
		
		if(start>=end) {
			return;
		}
		
		int pivot_idx = partitionArray(A, start, end);
		quickSort(A, start, pivot_idx-1);
		quickSort(A, pivot_idx+1, end);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		quickSort(A, 0, A.length-1);
		
		System.out.print("\nSorted Array: ");
		for(int i=0; i<size; i++) {
			System.out.print(A[i]+" ");
		}
		
		scn.close();

	}

}
