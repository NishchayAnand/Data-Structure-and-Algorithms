
/*
	Problem Statement: Given an integer n, return the number of trailing zeroes in n!.

	General Observations:

		- A trailing zero is produced by multiplying 10, which is the product of 2 and 5.

		- In the factorial of a number, there are usually more factors of 2 than factors of 5. Therefore, the number of
		  trailing zeroes is determined by the number of times 5 appears as a factor in the numbers from 1 to n.

		- Higher powers of 5, for example 5*5=25 and it multiples 5*5*2=50, 5*5*3=5, etc., would contribute additional
		  factors of 5.

		- Therefore, Trailing Zeroes in n! = [n/5] + [n/5*2] + [n/5^3] + ..... + [n/5^k] such that 5^k <= n.

*/

public class FactorialTrailingZeroes {

	private static int trailingZeroes(int n) {
		int count = 0;
		int divisor = 5;
		while(divisor<=n) {
			count += n/divisor;
			divisor *= 5;
		}
		return count;
	}


	public static void main(String[] args) {
		System.out.println(trailingZeroes(30));
	}

}
