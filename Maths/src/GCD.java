
/* General Observations:

    - Greatest Common Divisor (GCD) of 2 numbers = Largest/Highest Common Factor of the 2 numbers. 
    
    - Brute Force Approach:
    
    	- GCD cannot be greater than the smaller of the two numbers, i.e, 
    				- for 2 number: A and B, GCD <= min(A,B).
    				
    	- Algorithm:
    	
    		- Loop over each num from min(A,B) to 1: 
            	- If (A%num==0) and (B%num==0): 
            		- return num;
            		
        - Time Complexity: O(min(A,B)).
        
        - Space Complexity: O(1).
        
    - Optimized Approach (Euclidean algorithm):
    
    	- Euclid's Division Lemma states that for any two positive integers: A and B (A > B), there exist 
    	  unique integers Q and R such that:
							- A = B*Q + R, where 0 <= R < B.
    								 
        - Let x = GCD(A, B), then:
        
        	-> [A%x == 0] and [B%x == 0],
        	
            -> [(BQ+R)%x == 0] and [B%x == 0],
            
            -> [(BQ)%x == 0] and [R%x == 0] and [B%x == 0]
            
            -> x = GCD(R, B)
            
        - Finding GCD is recursive in nature, where GCD(A,B) = GCD(B, A%B), where A%B < B. 
       
        - GCD of 0 and any number is the number itself. 
        
        - Recursive Algorithm:
        
        	- Hypothesis: 
        		
        		- GCD(a,b) will return the GCD of a and b, where b = min(A,B).
        	
        	- Recursive Steps:
        	
        		- Find the GCD of b and (a%b) and return it (since it will be the GCD of a and b). 
        			- return GCD(a, a%b);
        	
        	- Base Condition:
        	
        	 		- If b becomes 0, a is the required GCD. 
        	 		 	- If b == 0:
        	 		 		- return a;
        	 		 	 
        	- Time Complexity Analysis:
        		
        		- The Euclidean algorithm has a proven time complexity of O(log(b)) = O(log(min(A,B))).
        		
        		- The logarithmic complexity holds because the size of the problem (represented by b) is 
        		  demonstrably reduced with each iteration, even if not by half in each step.  
        		        	
        	- Space Complexity Analysis:
        	
        		- The space complexity is related to the number of recursive calls on the stack.
        		
        		- Since, the number of recursive calls is proportional to the logarithm of min(A, B), 
        		  space complexity = O(log(min(A,B))).
        	
        - Iterative Algorithm:
        
        	- while b!=0:
        		- make a = b and b = a%b.
        			- int temp = b;
        			- b = a%b;
        			- a = temp;	
        	- return a;
        			
        	- Time Complexity = O(log(min(A,B))).
        	
        	- Space Complexity = O(1).
    
    - GCD has the following property: GCD(a,b,c) = GCD(GCD(a,b),c). Since, the GCD can be calculated 
      "two at a time", almost all algorithms focus on the simplest case of determining the GCD of two 
      numbers. 
      
      For example: if we wanted to find the GCD of 20, 28, and 24, we could first find the GCD of 20 and 
      28 (which is 4) and then the GCD of 4 and 24 (which is also 4). 
                    
*/

public class GCD {
	
	private static int getGCDRecursive(int a, int b) {
		if(b==0) return a;
		return getGCDRecursive(b, a%b);
	}
	
	private static int getGCDIterative(int a, int b) {
		while(b!=0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		
		int a = 12;
		int b = 48;
		
		System.out.println("GCD of " + a + " and " + b + "using recursion: " + getGCDRecursive(a,b));
		System.out.println("GCD of " + a + " and " + b + "using iteration: " + getGCDIterative(a,b));
		
	}

}
