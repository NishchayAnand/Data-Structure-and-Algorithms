import java.util.Scanner;

public class PartitionArray {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void partitionArrayApproach2(int[] A, int pivot) {
		
		int j=A.length-1, i=0;
		while(i<j) {
			if(A[i]>pivot) {
				swap(A, i, j);
				j--;
			} else {
				i++;
			}
		}
		
	}
	
	public static void partitionArrayApproach1(int[] A, int pivot) {
		
		int j=0;
		for(int i=0; i<A.length; i++) {
			if(A[i]<=pivot) {
				swap(A, i, j);
				j++;
			}
		}
		
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
		
		System.out.print("\nEnter the pivot element: ");
		int pivot = scn.nextInt();
		
		// creating a copy of A.
		int[] C = new int[size];
		for(int i=0; i<size; i++) {
			C[i] = A[i];
		}
		
		partitionArrayApproach1(A, pivot);
		System.out.print("\nArray after partition using approach 1: ");
		for(int i=0; i<size; i++) {
			System.out.print(A[i]+" ");
		}
		
		partitionArrayApproach2(C, pivot);
		System.out.print("\nArray after partition using approach 2: ");
		for(int i=0; i<size; i++) {
			System.out.print(C[i]+" ");
		}
		
		scn.close();

	}

}
