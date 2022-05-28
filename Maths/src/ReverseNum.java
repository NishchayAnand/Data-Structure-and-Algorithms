import java.util.Scanner;

/* General Observations: 
 * 	- One of the approach would be to:
 * 				- take mul = Math.pow(10, len-1)
 * 				- for each iteration, calculate the rem and add rem*mul to the reverse number
 * 				- decrease the mul by 10 times, i.e., mul/10
 * */



public class ReverseNum {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number:");
		int n = sc.nextInt();
		
		int num=0;
		int rem;
		
		while(n>0) {
			rem = n%10;
			num = num*10 + rem;
			n/=10;
		}
		
		System.out.println("Reversed number: "+num);
		
		sc.close();
		
	}

}
