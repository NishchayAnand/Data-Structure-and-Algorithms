
/*

    Problem statement: Give the count of all prime number strictly less than a given number n.

    General Observations:

        - Brute Force Approach:

            - Loop from num = [2,n) and check if num is prime or not.

            - Time Complexity: O(sqrt(n)).

            - Space Complexity: O(1).

        - Sieve of Eratosthenes Approach:

            - The idea behind the sieve is:

                - Create a boolean array 'isPrime' of size 'n' where each entry initially marks the number as prime (True).

                - Start from the first prime number (2) and mark all of its multiples as non-prime (False).

                - Move to the next number that is still marked as prime and repeat the process for its multiples.

                  NOTE: For any prime number 'p', all the composite numbers in the range [p, p*2], i.e., [p*2, p*3, p*4
                  ......, p*(p-1)] have already been marked as false by previous smaller prime numbers.

                - Continue until you've processed numbers up to the square root of n (since any composite number larger
                  than sqrt(n) must have a factor smaller than sqrt(n)).

            - Time Complexity: summation of i=2 to sqrt(n) : n/i -> (nlog(logn)) -> complex to derive

            - Space Complexity: O(n).

 */

public class CountPrimes {
	
	public static int countPrimes(int n) {

        if(n<2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n+1];
        for(int i=0; i<=n; i++) isPrime[i] = true;

        for(int i=2; i<Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j = i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
        
    }

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}

}
