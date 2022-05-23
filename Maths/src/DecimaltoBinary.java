import java.util.Scanner;

public class DecimaltoBinary {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = scn.nextInt(); 
		
		int out = 0;
		int mul = 1;
		int rem;
		
		while(n>0) {
			
			rem = n%2;
			n/=2;
			
			out+=rem*mul;
			
			mul*=10;
		
		}
		
		System.out.print("Its binary equivalent is: "+out);	
		
		scn.close();
	
	}

}
