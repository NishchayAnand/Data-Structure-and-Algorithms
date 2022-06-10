import java.util.Scanner;

/* Problem Statement: Rearrange the elements of an array to get the numerically next greater 
 * 					  permutation.
 * 
 * 					  NOTE: In case the permutation is not possible, the array must be returned 
 * 						    in the lowest possible order i.e., sorted in an ascending order. 
 * 
 * */


public class NextPermutation {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void reverse(int[] A, int start, int end) {
		while(start<end) {
			swap(A, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scn.nextInt();
		
		System.out.println();
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter Element at index "+i+": ");
			A[i] = scn.nextInt();
		}
		
		// to check if next greater permutation is possible or not.
		boolean isPossible = false;
		
		for(int i=size-2; i>=0; i--) {
			
			if(A[i]<A[i+1]) {
				
				isPossible = true;				
				int nextGreatestIdx = i+1;
				for(int k=i+2; k<size; k++) {
					if(A[k]>A[i]) {
						nextGreatestIdx = k;
					}
				}
				
				swap(A, i, nextGreatestIdx);
				reverse(A, i+1, size-1);
				
				break;
				
			}
			
		}
		
		if(!isPossible) {
			reverse(A, 0, size-1);
		}
		
		System.out.print("\nNext Permutation: ");
		for(int i=0; i<size; i++) {
			System.out.print(A[i]+" ");
		}
		
		scn.close();
		
	}

}
