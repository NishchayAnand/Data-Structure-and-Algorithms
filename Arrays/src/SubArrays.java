import java.util.Scanner;

public class SubArrays {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		System.out.println("\nPlease provide the elements of the array.");
		for(int i=0; i<size; i++) {
			System.out.print("Enter element "+(i+1)+" :");
			A[i] = scn.nextInt();
		}
		
		System.out.println("\nSubarrays of the array are:");
		for(int i=0; i<size; i++) {
			for(int end=i+1; end<=size; end++) {
				for(int j=i; j<end; j++) {
					System.out.print(A[j]+"\t");
				}
				System.out.println();
			}
		}
		
		scn.close();
		
		
	}

}
