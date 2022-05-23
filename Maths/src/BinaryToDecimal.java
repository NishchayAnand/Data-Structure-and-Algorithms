import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a binary number: ");
		int n = scn.nextInt(); 
		
		int out = 0;
		int mul = 1;
		int rem;
		
		while(n>0) {
			
			rem = n%10;
			n/=10;
			
			out+=rem*mul;
			
			mul*=2;	
			
		}
		
		System.out.print("Its decimal equivalent is: "+out);	
		
		scn.close();

	}

}
