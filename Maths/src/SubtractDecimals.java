import java.util.Scanner;

public class SubtractDecimals {

	public static void main(String[] args) {
		
		System.out.println("NOTE: Number 1 should be greater than or equal to Number 2.\n");
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		int n1 = scn.nextInt();		
		System.out.print("Enter number 2: ");
		int n2 = scn.nextInt();
		
		int out=0, mul=1, borr=0, rem1, rem2, diff;
		
		while(n1>0 || n2>0) {
			
			rem1 = n1%10;
			rem2 = n2%10;
			
			if(n1>0) {
				n1/=10;
			}
			
			if(n2>0) {
				n2/=10;
			}
			
			diff = rem1-rem2+borr;
			if(diff<0) {
				diff+=10;
				borr=-1;
			} else {
				borr=0;
			}
			
			out+=diff*mul;
			
			mul*=10;
			
		}
		
		System.out.print("Difference: "+out);
		
		scn.close();
		
	}

}
