import java.util.Scanner;

/* Problem Statement: Given a non negative integer, express it in the exponential form as A^P
 * 					  where A>0 and P>1.
 * 
 * General Observation: 
 * 	- A will be a prime number. (Hence, this problem can be relate to prime factorization)
 * 	- A can at max be represent as sqrt(A)^2, because for any number 'K' greater than sqrt(A), K^2 > A
 * 	- We have to divide A from a prime number (if divisible), till A becomes 1.
 * */

public class ExponentialForm {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = scn.nextInt();
		
		if(n==1 || n==2) {
			System.out.println(n+" cannot be represented in exponential form.");
			scn.close();
			return;
		}
		
		boolean isPossible = false;
		for(int i=2; i*i<n; i++) {
			int temp = n;
			while(temp%i==0) {
				temp/=i;
			}
			if(temp==1) {
				isPossible = true;
				break;
			}
		}
		
		if(isPossible) {
			System.out.println(n+" can be represented in exponential form.");
		} else {
			System.out.println(n+" cannot be represented in exponential form.");
		}
		
		scn.close();

	}

}
