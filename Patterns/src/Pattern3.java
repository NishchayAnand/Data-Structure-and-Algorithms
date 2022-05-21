import java.util.Scanner;

/* Problem Statement: Given the number of rows 'n', print:
 * 
 * 					  *
 * 					 * *
 * 					*   *
 * 					 * *
 * 					  *
 * */

public class Pattern3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		int n = scn.nextInt();
		
		int nisp = n/2;
		int nosp = -1;
		
		System.out.println("\nRequred pattern:\n");
		for(int row=1; row<=n; row++) {
			
			for(int isp=1; isp<=nisp; isp++) {
				System.out.print("\t");
			}
			
			System.out.print("*\t");
			
			for(int osp=1; osp<=nosp; osp++) {
				System.out.print("\t");
			}
			
			if(row>1 && row<n) {
				System.out.print("*\t");
			}
			
			System.out.println();
			
			if(row<=n/2) {
				nisp--;
				nosp+=2;
			} else {
				nisp++;
				nosp-=2;
			}
		}
		
		scn.close();

	}

}
