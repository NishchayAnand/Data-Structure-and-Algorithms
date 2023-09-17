
/* Problem statement: Give the count of all prime number strictly less than a given number n.
 * */

public class CountPrimes {
	
	public static int countPrimes(int n) {

        boolean[] isPrime = new boolean[n+1];

        for(int i=0; i<=n; i++) isPrime[i] = true;
        
        isPrime[0] = isPrime[1] = false;

        for(int i=2; i<n; i++){ // time complexity = O(N)
            if(isPrime[i] && (long)i*i<n){  // NOTE: explore (long)i*i<n in the next iteration
                for(int j = i*i; j<n; j+=i){ // time complexity = ?
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
