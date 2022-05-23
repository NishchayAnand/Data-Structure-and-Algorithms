import java.util.Scanner;

public class AddDecimals {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		int n1 = scn.nextInt();
		System.out.print("Enter number 2: ");
		int n2 = scn.nextInt();
		
		int out = 0;
		int mul = 1;
		int carr = 0;
		int rem1, rem2, sum;
		
		while(n1>0 || n2>0 || carr>0) {
			
			rem1 = n1%10;
			rem2 = n2%10;
			
			if(n1>0) {
				n1/=10;
			}
			
			if(n2>0) {
				n2/=10;
			}
			
			sum = rem1 + rem2 + carr;
			carr = sum/10;
			sum%=10;
			
			out+= sum*mul;
			
			mul*=10;
			
		}
		
		System.out.print("Sum: "+out);
		
		scn.close();
		
	}

}
