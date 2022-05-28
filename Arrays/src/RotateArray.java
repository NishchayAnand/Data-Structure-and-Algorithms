import java.util.Scanner;

public class RotateArray {
	
	public static void reverse(int[] A, int start, int end) {
		
		int temp;
		while(start<end) {
			
			temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			
			start++;
			end--;
		}
		
	}
	
	public static void printRotatedArrayUsingReverseAlgo(int[] A, int k) {
		
		reverse(A, 0, A.length-1);
		reverse(A, 0, k-1);
		reverse(A, k, A.length-1);
		
		System.out.print("\nRotated Array (using reversal algorithm): ");
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		
	}
	
	public static void printRotatedArrayUsingExtraArray(int[] A, int k) {
		
		int[] R = new int[A.length];
		int idx;
		
		for(int i=0; i<A.length; i++) {
			idx = (i+k)%A.length;
			R[idx] = A[i];
		}
		
		System.out.print("\nRotated Array (using additional array): ");
		for(int i=0; i<A.length; i++) {
			System.out.print(R[i]+" ");
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		System.out.println("\nPlease input the elements of the array:");
		for(int i=0; i<size; i++) {
			System.out.print("Enter Element "+(i+1)+" : ");
			A[i] = scn.nextInt();
		}
		
		System.out.print("\nEnter the number of rotations: ");
		int k = scn.nextInt();
		
		k = k%size;
		if(k<0) {
			k = k + size;
		}
		
		printRotatedArrayUsingExtraArray(A, k);
		
		printRotatedArrayUsingReverseAlgo(A, k);
		
		scn.close();

	}

}
