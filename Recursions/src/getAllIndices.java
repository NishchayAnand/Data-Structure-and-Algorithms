import java.util.Scanner;

/* Problem Statement: Given an array and a number, return a simple array containing all indices 
 * 					  where element occurs in the array.
 * 
 * NOTE: If the number is not present in the given array, print "Number not present in the given array"
 * 
 * */


public class getAllIndices {
	
	public static int[] getAllIndx(int[] A, int n, int len, int idx) {
		
		if(idx == A.length) {
			int[] indices = new int[len];
			return indices;
		}
		
		if(A[idx]==n) {
			len++;
		}
		
		int[] indices = getAllIndx(A, n, len, idx+1);
		
		if(A[idx]==n) {
			indices[len-1] = idx;
		}
		
		return indices;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter elements at index "+i+": ");
			A[i] = scn.nextInt();
		}
		
		System.out.print("\nEnter the element whose indices needs to be printed: ");
		int n = scn.nextInt();
		
		int[] indices = getAllIndx(A, n, 0, 0);
		
		if(indices.length == 0) {
			System.out.println("\n"+n+" doesn't in the provided array.");
			scn.close();
			return;
		}
		
		System.out.println("\nIndices where "+n+" occurred: ");
		for(int idx: indices) {
			System.out.print(idx+" ");
		}
		
		scn.close();
		
	}

}
