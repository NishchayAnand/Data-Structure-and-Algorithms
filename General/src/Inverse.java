import java.util.Scanner;

/* Problem Statement: 
   Print inverse of a number following certain constraints:
		1. The key constraint is if the number is 5 digits long, it'll contain all the digits 
		   from 1 to 5 without missing any and without repeating any. 
		2. The inverse of a number is defined as the number created by interchanging the face 
		   value and index of digits of number. For example, 426135 (reading from right to left, 
		   5 is in place 1, 3 is in place 2, 1 is in place 3, 6 is in place 4, 2 is in place 5 
		   and 4 is in place 6), the inverse will be 416253 (reading from right to left, 3 is in 
		   place 1, 5 is in place 2,2 is in place 3, 6 is in place 4, 1 is in place 5 and 4 is 
		   in place 6)     
 */

public class Inverse {
	
	public static int getInverseUsingString(int num) {
		
		String numStr = Integer.toString(num);
		int size = numStr.length();
		char[] arr = new char[size];

		for(int i=0; i<size; i++){
			int index = size-Character.getNumericValue(numStr.charAt(i));
		    arr[index] = Integer.toString(size-i).charAt(0);
		  }

		return Integer.parseInt(String.valueOf(arr));
	}
	
	public static int getInverse(int num) {
		
		int digit=0, pos;
		int inverse = 0;
		
		while(num>0) {
			pos = num%10;
			digit++;
			inverse+=digit*Math.pow(10,pos-1);
			num/=10;			
		}
		
		return inverse;
	}

	public static void main(String[] args) {
		
		System.out.print("Enter a number: ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		System.out.println("Inverse number using string manipulation: "+getInverseUsingString(num));
		System.out.println("Inverse number using math: "+getInverse(num));
		
		scn.close();

	}

}
