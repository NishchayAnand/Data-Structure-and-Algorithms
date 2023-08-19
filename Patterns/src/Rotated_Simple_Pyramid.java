import java.util.Scanner;

/* Problem Statement: Given number of rows, print the rotated simple pyramid.
 * 					  For example, n = 5,
 * 
 * 										_ _ _ _ * -> i = 1, nsp = 4, nst = 1 
 * 										_ _ _ * * -> i = 2, nsp = 3, nst = 2
 * 										_ _ * * * -> i = 3, nsp = 2, nst = 3
 * 										_ * * * * -> i = 4, nsp = 1, nst = 4
 * 										* * * * * -> i = 5, nsp = 0, nst = 5
 * 
 * General Observations:
 * 1. We can define nsp = (n-1) and nst = 1 at the start and keep [decrementing nsp by 1, 
 * 	  incrementing nst by 1] in each iteration.
 * 2. Another approach is to use i to calculate nsp (n-i) and nst (i) in each iteration.
 * 
 */

public class Rotated_Simple_Pyramid {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		// get the number of rows as input from user.
		System.out.print("Enter the number of rows: ");
		int n = scn.nextInt();
		
		System.out.println();
		
		// loop to print the pattern.
		for(int i=1; i<=n; i++) {
			
			// loop to print the required spaces.
			for(int j=1; j<=(n-i); j++) {
				System.out.print(" ");
			}
			
			// loop to print the required stars.
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		// closing the scanner object.
		scn.close();

	}

}
