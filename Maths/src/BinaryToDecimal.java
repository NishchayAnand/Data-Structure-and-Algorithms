import java.util.Scanner;

/* General Observations:

- A number can be considered as a container divided into multiple chambers (in linear order) where each chamber has the capacity to hold some quantity of a given 
  entity (for example, bamboos).

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
                                                              
- Converting a binary number into decimal number can be thought of as moving bamboos from a binary-type container to decimal-type container.

- Consider binary number N = 110110,
                                               ___
                        110110 = 10*(11011) + | 0 | -> 0 bamboos in the 1st chamber
                                              |   |    
                                              |___|
                        11011 = 10*(1101) +   | 1 | -> 1 bundle in 2nd chamber containing 2 bamboos. 
                                              |   |    
                                              |___|  
                        1101 = 10*(110)  +    | 1 | -> 1 bundle in 3rd chamber containing 4 bamboos.
                                              |   |    
                                              |___|  
                        110 = 10*(11)   +     | 0 | -> 0 bundle in 4th chamber containing 8 bamboos.
                                              |   |    
                                              |___|  
                        11 = 10*(1)   +       | 1 | -> 1 bundle in 5th chamber containing 16 bamboos.
                                              |   |  
                                              |___|
                        1 = 10*(0)   +        | 1 | -> 1 bundle in 6th chamber containing 32 bamboos.
                                              |   | 
                                              |___|                  

- Therefore, binary number N = 110110 can be represented as 0x1 + 1x2 + 1x(2x2) + 0x(2x2x2) + 1x(2x2x2x2) + 1x(2x2x2x2x2) => 54.                   

*/

public class BinaryToDecimal {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a binary number: ");
		int N = scn.nextInt(); 
		
		int decimal_num = 0;
		
		for(int mul = 1; N!=0; mul*=2) {	
			int rem = N%10;
			decimal_num+=rem*mul;
			N/=10;	
		}
		
		System.out.print("Its decimal equivalent is: " + decimal_num);	
		
		scn.close();

	}

}
