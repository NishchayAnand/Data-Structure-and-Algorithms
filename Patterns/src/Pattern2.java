import java.util.Scanner;

/* Problem Statement: Given the number of rows 'n', print:
 * 
 * 					*** ***
 * 					**   **
 * 					*     *
 * 					**   **
 * 					*** ***
 * */

public class Pattern2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number of rows:");
		int n = scn.nextInt();
		
		int nsp = 1;
		int nst = n/2+1;
		
		for(int row=1; row<=n; row++) {
			
			for(int st=1; st<=nst; st++) {
				System.out.print("*\t");
			}
			
			for(int sp=1; sp<=nsp; sp++) {
				System.out.print("\t");
			}
			
			for(int st=1; st<=nst; st++) {
				System.out.print("*\t");
			}
			
			System.out.println();
			
			if(row<=n/2) {
				nst--;
				nsp+=2;
			} else {
				nst++;
				nsp-=2;
			}
			
		}
		
		scn.close();

	}

}
