import java.util.Scanner;

public class MergeSort {
	
	public static int[] mergeSort(int[] A, int lo, int hi) {
		
		if(lo==hi) {
			int[] arr = new int[1];
			arr[0] = A[lo];
			return arr;
		}
		
		int mid = (lo+hi)/2;
		int[] left = mergeSort(A, lo, mid);
		int[] right = mergeSort(A, mid+1, hi);
		
		int[] ans = Merge2SortedArrays.mergeTwoSortedArrays(left, right);
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = scn.nextInt();
		
		int[] A = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Enter A["+i+"]: ");
			A[i] = scn.nextInt();
		}
		
		int[] ans = mergeSort(A, 0, A.length-1);
		System.out.print("\nSorted array: ");
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
		scn.close();

	}

}
