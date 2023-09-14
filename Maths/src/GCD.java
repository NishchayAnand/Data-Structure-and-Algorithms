import java.util.Scanner;

/* 
General Observations:

    - GCD is the largest common factor. For 2 number A and B, the GCD will always be <= min(A,B).
    - Brute Force Approach:
                    - Loop from i = [min(A,B), 1]: # Time Complexity = O(n) where n = min(A,B)
                        - check if (A%i==0) and (B%i==0) = true: -> i.e., whether i is the factor of A and B
                            - return i                         -> i.e., i is the GCD of A and B.
    
    - Given 2 non-negative integers A and B such that A>B and B!=0, A can be written as A = BQ + R, where  0<=R<=B.
    - Euclidean Division Method: 
                - If x = GCD(A, B), then:
                    -> A%x == 0 and B%x == 0
                    -> (BQ+R)%x == 0 and B%x == 0
                    -> R%x == 0 and B%x == 0
                    -> x = GCD(B, R)
                - GCD(A, B) = GCD(B, R1) = GCD(R1, R2) ..................... GCD(Rn, 0) -> will always end up making the smaller number 0. 
    
    - If one of the numbers is zero, the greatest common divisor is the other number. 
                    
*/

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
