import java.util.Scanner;

public class PrimeFactorisation {
	
	public static void main(String args[]) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = scn.nextInt();
		
		System.out.print("Prime Factors: ");
		
		/* This code shows that the conditional variable of the for loop can be changed
		for(int i=2; i<=num; i++) {
			while(num%i==0) {
				num/=i;
				//System.out.print(i+" ");
			}
		}
		*/
		
		// In case code, calculating time complexity will be difficult, i.e., can't be deduced 
		// by just seeing the code  
		int i = 2;
		while(i*i<num) {
			if(num%i==0) {
				num/=i;
				System.out.print(i+" ");
			} else {
				i++;
			}
		}
		
		if(num!=1) {
			System.out.print(num);
		}
		
		scn.close();
		
	}

}
