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
  
- Consider decimal number N = 54,
                                                   ___
                                    54 = 2*(27) + | 0 | -> 54 bamboos can be packed into 27 bundles each containing 2 bamboos with 0 unpacked bamboos to be placed in 
                                                  |   |    the 1st chamber.
                                                  |___|
                                    27 = 2*(13) + | 1 | -> 27 bundles each containing 2 bamboos can be packed into 13 bundles such that each bundle contains 4 bamboos 
                                                  |   |    leaving behind 1 unpacked bundle containing 2 bamboos which can be placed in the 2nd chamber. 
                                                  |___|  
                                    13 = 2*(6)  + | 1 | -> 13 bundles each containing 4 bamboos can be packed into 6 bundles such that each bundle contains 8 bamboos 
                                                  |   |    leaving behind 1 unpacked bundle containing 4 bamboos which can be placed in the 3nd chamber.
                                                  |___|  
                                    6 = 2*(3)   + | 0 | -> 6 bundles each containing 8 bamboos can be packed into 3 bundles such that each bundle contains 16 bamboos 
                                                  |   |    leaving behind 0 unpacked bundle which can be placed in the 4th chamber.
                                                  |___|  
                                    3 = 2*(1)   + | 1 | -> 3 bundles each containing 16 bamboos can be packed into 1 bundle containing 32 bamboos leaving behind 1  
                                                  |   |    unpacked bundle containing 16 bamboos which can be placed in the 5th chamber.
                                                  |___|
                                    1 = 2*(0)   + | 1 | -> No bundles containing 32 bamboos can be packed further leaving behind 1 unpacked bundle containing 32 bamboos 
                                                  |   |    which can be placed in the 6th chamber.
                                                  |___|                                                                        

- Therefore, decimal number N = 54 can be represented as 0x1 + 1x10 + 1x100 + 0x1000 + 1x10000 + 1x100000 => 110110.                                                                                                                     
                                                              
*/

public class DecimaltoBinary {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int N = scn.nextInt(); 
		
		int binary_num = 0;
		for(int mul=1; N!=0; mul*=10){
		    int rem = N%2;
		    binary_num += rem*mul;
		    N/=2;
		}
		
		System.out.print("Its binary equivalent is: " + binary_num);	
		
		scn.close();
	
	}

}
