import java.util.Scanner;

/* Problem Statement: Given 2 numbers n and k, rotate n k times to:
 * 						- right: if k is positive
 * 						- left: if k is negative
 * 
 * 					  NOTE: Absolute value of k can be larger than number of digits in n.
 * 
 */

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
	    int num = scn.nextInt();
	    System.out.print("Enter number of rotations: ");
	    int k = scn.nextInt();
	    	    
	    int temp = num; 
	    int len = 0;
	    while(temp>0){
	      len++;
	      temp/=10;
	    }
	    
	    while(k<0) {
	    	k = len+k;
	    }
	    
	    while(k>len) {
	    	k = k-len;
	    }
	    
	    int div = (int) Math.pow(10, k);
	    int mul = (int) Math.pow(10, len-k);
	    
	    int rem = num%div;
	    int quo = num/div;
	    num = rem*mul + quo;
	    
	    System.out.println("Rotated Number: "+num);
	    
	    scn.close();

	}

}
