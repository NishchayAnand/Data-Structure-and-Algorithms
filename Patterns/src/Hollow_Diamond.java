import java.util.Scanner;

/* Problem Statement: Given the number of rows, print a hollow diamond.
 * 					  For example, n = 5, 
 * 
 * 					  			_ _ _ _ *			-> i = 1, nisp = 4, nosp = 0, nst = 1
 * 					 			_ _ _ * _ *			-> i = 2, nisp = 3, nosp = 1 (1st odd number), nst = 2
 * 								_ _ * _ _ _ *       -> i = 3, nisp = 2, nosp = 3 (2nd odd number), nst = 2
 * 					 			_ * _ _ _ _ _ *		-> i = 4, nisp = 1, nosp = 5 (3rd odd number), nst = 2
 * 					  			* _ _ _ _ _ _ _ *   -> i = 5, nisp = 0, nosp = 7 (4th odd number), nst = 2
 * 
 * 					  General observation for the upper half:
 * 					  - nisp = n-i
 * 					  - nosp = 2*(i-1)-1
 * 					  - nst = nosp == 0 ? 1 : 2
 * 
 * 								_ * _ _ _ _ _ *     -> i = 1, nisp = 1, nosp = 5 (3rd odd number), nst = 2
 * 								_ _ * _ _ _ *		-> i = 2, nisp = 2, nosp = 3 (2nd odd number), nst = 2
 * 								_ _ _ * _ *			-> i = 3, nisp = 3, nosp = 1 (1st odd number), nst = 2
 * 								_ _ _ _ *			-> i = 4, nisp = 4, nosp = 0, nst = 1
 * 
 * 					  General observation for the lower half:
 * 					  - nisp = i
 * 					  - nosp = 2*(n-i-1)-1
 * 					  - nst = nosp == 0 ? 1 : 2 
 * */

public class Hollow_Diamond {
	
	// function to print a given row.
	private static void printRow(int nisp, int nosp, int n) {
		
		// print the inner spaces.
		for(int j=1; j<=nisp; j++) {
			System.out.print(" ");
		}
		
		// print the first star
		System.out.print("*");
		
		// print the outer spaces.
		for(int j=1; j<=nosp; j++) {
			System.out.print(" ");
		}
		
		// print the last star, if required.
		if(nosp>0){
			System.out.print("*");
		}
		
		System.out.println();
		
	}
	
	// function to print the upper half.
	private static void printUpperHalf(int n) {
		for(int i=1; i<=n; i++) {
			printRow(n-i, 2*(i-1)-1, n);
		}
		
	}
	
	private static void printLowerHalf(int n) {
		for(int i=1; i<n; i++) {
			printRow(i,2*(n-i-1)-1,n);
		}
		
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		// take number of rows as input.
		System.out.print("Enter number of rows: ");
		int n = scn.nextInt();
		
		// print the upper half.
		printUpperHalf(n);
		
		// print the lower half.
		printLowerHalf(n);
		
		scn.close();

	}

}
