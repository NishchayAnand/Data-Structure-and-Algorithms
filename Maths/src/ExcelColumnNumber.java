import java.util.Scanner;

/* Problem Statement: Given a column title, for example, "AB", return its corresponding 
 * 					  column number.
 * 
 * 					  Output: 28
 * 
 * General Observation: - Think of it as converting a 26 base number to decimal number
 * 
 * */


public class ExcelColumnNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a column title: ");
		String str = scn.next();
		
		int len = str.length();
		int num=0, mul=1, dig;
		for(int i=len-1; i>=0; i--) {
			dig = (int) str.charAt(i);
			num+=(dig-64)*mul;
			mul*=26;
		}
		
		System.out.println("\nIts equivalent column number: "+num);
		
		scn.close();

	}

}
