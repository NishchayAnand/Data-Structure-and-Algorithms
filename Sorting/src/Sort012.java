import java.util.Scanner;

public class Sort012 {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void sort(int[] A) {
		
		int j=0, k=A.length-1, i=0;
		while(i<=k) {
			if(A[i]==2) {
				swap(A, i, k);
				k--;
			} else if(A[i]==0) {
				swap(A, i, j);
				j++;
				i++;
			} else {
				i++;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("NOTE: The array can only contain 0, 1 and 2.\n");
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		sort(A);
		System.out.print("\nSorted Array: ");
		for(int i=0; i<size; i++) {
			System.out.print(A[i]+" ");
		}
		
		scn.close();

	}

}
