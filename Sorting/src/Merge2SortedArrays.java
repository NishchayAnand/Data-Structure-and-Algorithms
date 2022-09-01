import java.util.Scanner;

public class Merge2SortedArrays {
	
	public static int[] mergeTwoSortedArrays(int[] A, int[] B) {
		
		int[] ans = new int[A.length+B.length];
		int i=0, j=0, k=0; 
		
		while(i<A.length && j<B.length) {
			if(A[i]<B[j]) {
				ans[k] = A[i];
				i++;
			} else {
				ans[k] = B[j];
				j++;
			}
			k++;
		}
		
		for(; i<A.length; i++, k++) {
			ans[k] = A[i];
		}
		
		for(; j<B.length; j++, k++) {
			ans[k] = B[j];
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of sorted array 1: ");
		int n = scn.nextInt();
		
		int[] A = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		System.out.print("\nEnter size of sorted array 2: ");
		int m = scn.nextInt();
		
		int[] B = new int[m];
		for(int i=0; i<m; i++) {
			System.out.print("Enter B["+i+"]: ");
			B[i] = scn.nextInt();
		}
		
		int[] ans = mergeTwoSortedArrays(A, B);
		System.out.print("\nMerged Sorted array: ");
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
		scn.close();
		
	}

}
