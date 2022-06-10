import java.util.Scanner;

public class TrailingZeros {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = scn.nextInt();
		
		int count = 0, temp;
		for(int i=5; i<=n; i+=5) {
			temp=i;
			while(temp%5==0) {
				count++;
				temp/=5;
			}
		}
		
		System.out.println("Number of trailing zeros in "+n+" factorial: "+count);
		
		scn.close();

	}

}
