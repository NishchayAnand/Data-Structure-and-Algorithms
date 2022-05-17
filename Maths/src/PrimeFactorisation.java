import java.util.Scanner;

public class PrimeFactorisation {
	
	public static void main(String args[]) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = scn.nextInt();
		
		System.out.println("Prime Factors: ");
		for(int i=2; i*i<=num; i++) {
			if(num==1) {
				break;
			}
			while(num%i==0) {
				num/=i;
				System.out.print(i+" ");
			}
		}
		
		if(num!=1) {
			System.out.print(num);
		}
		
		scn.close();
		
	}

}
