
// Problem Statement: Given a number N, check if it is Prime or not.

/* General Observations:

    - For a number N to be prime, it should not be divisible by any number in the range [2, N-1].
    
    - Brute Force: Loop from i = [2, N-1] and check if N is divisible by i. -> time complexity = O(N), space complexity = O(1).
    
    - Every number can be represented as a product of 2 numbers., for example, 7 = 1x7, 6=2x3 etc.
    
    - Lets assume a number N which is the product of 2 numbers p and q, i.e., N = (p)x(q).
            - if we say that p > root(N) and q > root(N), then (p)x(q) > N, which is false (as N == (p)x(q)).
            - Therefore, we can say that either p < root(N) or q < root(N).
            - If there this no number from i = [2, root(N)] which divides N, then N is a prime number.
            
    - Optimized  Approach: Loop from i = [2, root(N)] and check if N is divisible by i. -> time complexity = O(root(N)), space complexity = O(1).

*/

public class IsPrime {
	
	private static int isPrime(int N){
        
        if(N==1){
            return 0;
        }
        
        int isNPrime = 1;
        
        for(int i = 2; i*i <= N; i++){
            if(N%i == 0){
                isNPrime = 0;
                break;
            }
        }
        
        return isNPrime;
        
    }

	public static void main(String[] args) {
		
		System.out.println(isPrime(8));

	}

}
