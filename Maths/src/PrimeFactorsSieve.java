import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsSieve {
	
	static int n = 200000;
    static int[] spf = new int[n+1];
    
    // pre-compute the least/smallest prime factor of all numbers till n. 
    static void sieve() {
        
        for(int i=0; i<=n; i++){
            spf[i] = i;
        }
        
        for(int i=2; i*i<=n; i++){
            if(spf[i] == i){
                for(int j=i*i; j<=n; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
        
    }
    
    static {
        sieve();
    }

    static List<Integer> findPrimeFactors(int N) {
        
        List<Integer> prime_factors = new ArrayList<>();
        
        while(N>1){
            prime_factors.add(spf[N]);
            N = N/spf[N];
        }
        
        return prime_factors;
        
    }

	public static void main(String[] args) {
		
		System.out.println(findPrimeFactors(6));

	}

}
