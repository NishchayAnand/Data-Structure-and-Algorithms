import java.util.Scanner;

public class MultiplyDecimal {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = scn.nextInt();
		System.out.print("Enter a digit: ");
		int d = scn.nextInt();
		
		int out = 0;
		int mul = 1;
		int carr = 0;
		int rem, prod;
		
		while(n>0 || carr>0) {
			
			rem = n%10;
			n/=10;
			
			prod = rem*d + carr;
			carr = prod/10;
			prod%=10;
			
			out+= prod*mul;
			
			mul*=10;			
			
		}
		
		System.out.print("Product: "+out);
		
		scn.close();

	}

}
