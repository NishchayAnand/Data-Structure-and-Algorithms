import java.util.Scanner;

/* Problem Statement: Given the number of rows 'n', print:
 * 
 * 					  *
 * 					 ***
 * 					*****
 * 					 ***
 * 					  *
 * */

public class Pattern1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int n = sc.nextInt();
		
		int nsp = n/2;
		int nst = 1;
		
		for(int row=1; row<=n; row++) {
			
			for(int sp=1; sp<=nsp; sp++) {
				System.out.print("\t");
			}
			
			for(int st=1; st<=nst; st++) {
				System.out.print("*\t");
			}
			
			System.out.println();
			
			if(row<=n/2) {
				nsp--;
				nst+=2;
			} else {
				nsp++;
				nst-=2;
			}
			
		}
		
		sc.close();

	}

}
