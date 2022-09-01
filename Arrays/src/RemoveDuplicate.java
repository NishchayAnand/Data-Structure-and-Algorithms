import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array:");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		System.out.println("Enter array elements:");
		for(int i=0; i<size; i++) {
			A[i] = scn.nextInt();
		}
		
		// time complexity : nlogn 
		Arrays.sort(A);
		
		// space complexity : 
		boolean[] isDuplicate = new boolean[size];
		isDuplicate[0] = false;
		
		int len = 1;
		// time complexity : O(n)
		for(int i=1; i<size; i++) {
			if(A[i]==A[i-1]) {
				isDuplicate[i] = true;
			} else {
				len++;
				isDuplicate[i] = false;
			}
		}
		
		int[] temp = new int[len];
		int j = 0;
		// time complexity : O(n)
		for(int i=0; i<size; i++) {
			if(!isDuplicate[i]) {
				temp[j] = A[i];
				j++;
			}
		}
		
		A = temp;
		
		System.out.println(Arrays.toString(A));
		
		scn.close();

	}

}
