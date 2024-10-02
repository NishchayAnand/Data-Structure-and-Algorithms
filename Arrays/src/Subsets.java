import java.util.Scanner;

public class Subsets {

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
		
		System.out.println("\nSubsets1 of the array are:");
		int rows = (int) Math.pow(2, size);
		int temp, rem;
		String str;
		
		for(int i=0; i<rows; i++) {
			
			temp=i;
			str="";
			
			for(int j=size-1; j>=0; j--) {
				
				rem = temp%2;
				
				if(rem==0) {
					str = "-\t"+str;
				} else {
					str = A[j]+"\t"+str;
				}
				
				temp/=2;
				
			}
			
			System.out.println(str);
			
		}
		
		scn.close();

	}

}
