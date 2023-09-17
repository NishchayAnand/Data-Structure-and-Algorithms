
/* Problem Statement: Given a number N, find the least prime factors for all numbers from 1 to N.
 * */

public class LeastPrimeFactor {
	
	private static int[] leastPrimeFactor(int n) {
        // create an array of size n+1.
        int[] sieve = new int[n+1];
        
        // initialize sieve assuming the corresponding index to be the smallest prime factor.
        // For example, i=2, the least prime factor = 2
        //              i=3, the least prime factor = 3
        for(int i=0; i<=n; i++){
            sieve[i] = i;
        }
        
        // loop over every prime number (#1) and for its unchanged (#2) multiples <= n, change the least prime factor value in sieve = prime number. 
        for(int i=2; i*i<=n; i++){
            if(sieve[i] == i) { // #1
                for(int j=i*i; j<=n; j+=i){
                    if(sieve[j] == j) { // #2
                        sieve[j] = i;
                    }
                }
            }
        }
        
        return sieve;
        
    }

	public static void main(String[] args) {
		
		int[] arr = leastPrimeFactor(6);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
