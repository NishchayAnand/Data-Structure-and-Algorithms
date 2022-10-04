
public class CoinChangeCombination {
	
	public static void coinChangeApproach1(int i, int[] coins, int amtsf, int tamt, String asf){
        
        if(amtsf == tamt){
            System.out.println(asf+".");
            return;
        }
        
        if(i==coins.length){
            return;
        }
        
        for(int k = i; k<coins.length; k++){
            coinChangeApproach1(k+1, coins, amtsf+coins[k], tamt, asf+coins[k]+"-");
        }
        
    }
	
	public static void coinChangeApproach2(int i, int[] coins, int amtsf, int tamt, String asf){
        
        if(i==coins.length){
        	if(amtsf == tamt){
                System.out.println(asf+".");
            }
        	return;
        }
        
        // include
        if(amtsf+coins[i]<=tamt){
            coinChangeApproach2(i+1, coins, amtsf+coins[i], tamt, asf+coins[i]+"-");
        }
        
        //exclude
        coinChangeApproach2(i+1, coins, amtsf, tamt, asf);
            
	}
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
