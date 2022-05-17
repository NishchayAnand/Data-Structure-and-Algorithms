import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter number 1: ");
		int n1 = scn.nextInt();
		System.out.print("Enter number 2: ");
		int n2 = scn.nextInt();
		
		while(n1%n2!=0){
			int rem = n1%n2;
			n1 = n2;
			n2 = rem;			
		}
		
		System.out.println("GCD: "+n2);
		
		scn.close();
		
	}

}
