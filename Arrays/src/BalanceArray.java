import java.util.Scanner;

/* Problem Statement: Given an integer array A of size N. You need to count the number of special 
 * elements in the given array. 
 * 		- A element is special if removal of that element make the array balanced.
 * 		- Array will be balanced if sum of even index element equal to sum of odd index element.
 * 
 * General Observation: For any element under consideration, the even indexed elements to the right 
 * 						of the element will become odd indexed and vice versa. 
*/

public class BalanceArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scn.nextInt();
		
		System.out.println();
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter Element at index "+i+": ");
			A[i] = scn.nextInt();
		}
		
		int left_odd_sum = 0;
		int left_even_sum = 0;
		int right_odd_sum=0;
		int right_even_sum = 0;
		int count = 0;
		
		for(int i=1; i<size; i++) {
			if(i%2==0) {
				right_even_sum+=A[i];
			} else {
				right_odd_sum+=A[i];
			}
		}
		
		System.out.println();
		// right odd indexed element's sum actually equals to right even indexed element's sum.
		if(right_even_sum == right_odd_sum) {
			System.out.println("Special element index = "+ 0);
			count++;
		}
		
		for(int i=1; i<size; i++) {
			if(i%2==0) {
				right_even_sum-=A[i];
				left_odd_sum+=A[i-1];
			} else {
				right_odd_sum-=A[i];
				left_even_sum+=A[i-1];
			}
			
			if((left_odd_sum+right_even_sum)==(left_even_sum+right_odd_sum)) {
				System.out.println("Special element index = "+ i);
				count++;
			}
		}
		
		System.out.println("\nNumber of special elements = "+ count);
				
		scn.close();
		

	}

}
