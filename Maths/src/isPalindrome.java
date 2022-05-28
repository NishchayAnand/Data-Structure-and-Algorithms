import java.util.Scanner;

public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = scn.nextInt();
		int orn = n;
		
		if(n<0 || (n%10==0 && n!=0)) {
			System.out.println(orn+" is not a palindrome");
			return;
		}
		
		int rem, rev=0;
		while(n>rev) {
			rem=n%10;
			rev=rev*10+rem;
			n=n/10;
		}
		
		if(n==rev || n==rev/10) {
			System.out.println(orn+" is a palindrome");
		} else {
			System.out.println(orn+" is not a palindrome");
		}

	}

}
