import java.util.ArrayList;
import java.util.List;

public class PrimeFactorisation {
	
	private static List<Integer> uniquePrimeFactorsBruteForce(int N){
        
        List<Integer> arr = new ArrayList<>();
        
        int prime_factor = 2;
        
        while(N>1){
            if(N%prime_factor==0){
                arr.add(prime_factor);
                while(N%prime_factor==0){
                    N = N/prime_factor;
                }
            } else {
                prime_factor++;
            }
        }
        
        return arr;
    }
    
    private static List<Integer> uniquePrimeFactorsBruteForceRefactored(int N){
        
        List<Integer> arr = new ArrayList<>();
        
        for(int prime_factor = 2; prime_factor <=N; prime_factor++){
            if(N%prime_factor==0){
                arr.add(prime_factor);
                while(N%prime_factor==0){
                    N = N/prime_factor;
                }
            }
        }
        
        return arr;
    }
    
    private static List<Integer> uniquePrimeFactorsOptimized(int N){
        
        List<Integer> arr = new ArrayList<>();
        
        for(int pf = 2; pf*pf <=N; pf++){
            if(N%pf==0){
                arr.add(pf);
                while(N%pf==0){
                    N = N/pf;
                }
            }
        }
        
        if(N>1) arr.add(N);
        
        return arr;
    }
    
	public static void main(String args[]) {
		
		System.out.println(uniquePrimeFactorsOptimized(15));
		
	}

}
