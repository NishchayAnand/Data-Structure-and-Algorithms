import java.util.Scanner;

/* Problem Statement: Given 2 numbers n and k, rotate n k times to:
 						- right: if k is positive
 						- left: if k is negative
 
 					  NOTE: Absolute value of k can be larger than number of digits in n.
 
 
   General Observations:
   
   - For a given number N, for example, N = 56789 (length = 5), K can be:
        
        -k=0, return N.
        
        - for k>0,
            
              - k<length, for example, k=4:
                    56789 -1-> 9|5678 => N%pow(10,1)*pow(10, 4) + N/pow(10,1) 
                          -2-> 89|567 => N%pow(10,2)*pow(10, 3) + N/pow(10,2)
                          -3-> 789|56 => N%pow(10,1)*pow(10, 4) + N/pow(10,1)
                          -4-> 6789|5 => N%pow(10,4)*pow(10, 1) + N/pow(10,4)
                          
              - k=length,
                          -5-> 56789 => N, therefore for k = multiples of length, return N.
            
              - k>length, 
                          - can be represented as k = q*length + r which is equivalent to k=r where 0<r<length.
            
        - k<0,
            
              - k>(-length), for example, k=-4:
                    56789 -(-1)-> 6789|5 => k=4  
                          -(-2)-> 789|56 => k=3
                          -(-3)-> 89|567 => k=2
                          -(-4)-> 9|5678 => k=1
                          
              - k=(-length), 
                          -(-5)-> 56789 => N therefore for k = multiples of (-length), return N.
                          
              - k<(-length), 
                          - can be represented as k = (-q)*length + (-r) which is equivalent to k=(-r) where (-length)<r<0.
                          
   Algorithm:
   
   - reduce k to k%length such that either (0<k<length) || ((-length)<k<0).
     - if k < 0, do k = length+k to convert k to positive rotations.
     - if k = 0:
           - return N
     - else:
           - return N%pow(10,k)*pow(10, length-k) + N/pow(10,k)
                    
*/

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
	    int num = scn.nextInt();
	    System.out.print("Enter number of rotations: ");
	    int k = scn.nextInt();
	    
	    if(k==0) {
	    	System.out.println("Rotated Number: "+num);
	    	return;
	    }
	    	    
	    int temp = num; 
	    int len = 0;
	    while(temp>0){
	      len++;
	      temp/=10;
	    }
	    
	    k = k%len;
	    
	    if(k<0) {
	    	k = k+len;
	    }
	    
	    if(k==0) {
	    	System.out.println("Rotated Number: "+num);
	    	return;
	    }
	    
	    int div = (int) Math.pow(10, k);
	    int mul = (int) Math.pow(10, len-k);
	    int rev = (num%div)*mul + (num/div);
	    
	    System.out.println("Rotated Number: "+rev);
	    
	    scn.close();

	}

}
