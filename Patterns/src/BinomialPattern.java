import java.util.Scanner;

/* Problem Statement: Given the number of rows 'n', print:
 * 
 * 					1
 * 					1 1
 * 					1 2 1
 * 					1 3 3 1
 * 					1 4 6 4 1 
 * 									  
 * */

public class BinomialPattern {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int n = scn.nextInt();
		
		System.out.println("\nBinomial Pattern: \n");
		for(int i=0; i<n; i++) {
			int coeff = 1;
			for(int j=0; j<=i; j++) {
				System.out.print(coeff+"\t");
				coeff = (coeff*(i-j))/(j+1);
			}
			System.out.println();
		}
		
		scn.close();

	}

}
