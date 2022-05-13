import java.util.Scanner;

public class ReverseNum {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String reversedstr = "";
		int digit;
		
		System.out.print("Enter a number:");
		int num = sc.nextInt();
		
		while(num>0) {
			digit = num%10;
			reversedstr+=Integer.toString(digit);
			num= num/10;
		}
		
		System.out.println("Reversed number: "+reversedstr);
		
		sc.close();
		
	}

}
