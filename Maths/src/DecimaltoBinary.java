import java.util.Scanner;

/* General Observations:

- A number can be considered as a container divided into multiple chambers (in linear order) where each 
  chamber has the capacity to hold some quantity of a given entity (for example, bamboos).

- Different number systems have different ways of filling the chambers. For example, 

        - In decimal number system (uses 10 digits/symbols to represent quantity):
    
                          7    6     5    4    3    2    1
                    ----------------------------------------
                        |    |    |    |    |    |    |    | -> Chamber 1 has the capacity to hold 9 bamboos. 
                    ----------------------------------------                    
                                              |     |
                                              |     -> Chamber 2 has the capacity to hold 9 bundles each containing 10 bamboos.
                                              |
                                              -> Chamber 3 has the capacity to hold 9 bundles each containing 100 (10x10) bamboos.

        - In binary number system (uses 2 digits/symbols to represent quantity):
    
                          7    6     5    4    3    2    1
                    ----------------------------------------
                        |    |    |    |    |    |    |    | -> Chamber 1 has the capacity to hold 1 bamboo. 
                    ----------------------------------------                    
                                              |     |
                                              |     -> Chamber 2 has the capacity to hold 1 bundle each containing 2 bamboos.
                                              |
                                              -> Chamber 3 has the capacity to hold 1 bundle each containing 4 (2x2) bamboos.
                                              
- Converting a decimal number into binary number can be thought of as moving bamboos from a decimal-type 
  container to binary-type container.                                                              
                                                                                                                          
                                                              
*/

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
