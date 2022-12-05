import java.util.Arrays;

public class BurstBalloon {
    
    public int getMaximumCoins(int[] nums, int i, int j, int[][] dp){
        
        if(i>j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int maxCoins = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            
            int leftCoins = getMaximumCoins(nums, i, k-1, dp);
            int rightCoins = getMaximumCoins(nums, k+1, j, dp);
            
            int coins = nums[k];
            if(i-1>=0){
                coins = coins*nums[i-1];
            }
            if(j+1<nums.length){
                coins = coins*nums[j+1];
            }
            
            coins += leftCoins + rightCoins;
            
            maxCoins = Math.max(maxCoins, coins);
            
        }
        
        return dp[i][j] = maxCoins;
        
    }
    
    public int maxCoinsRecursive(int[] nums) {
    	
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return getMaximumCoins(nums, 0, nums.length-1, dp);
        
    }
 
    public int maxCoinsTabulation(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 0);
        }        
        
        for(int i=n-1; i>=0; i--){ 
        	
            for(int j=i; j<n; j++){ 
            	
                dp[i][j] = Integer.MIN_VALUE;
                
                for(int k=i; k<=j; k++){ 
                    
                    
                    // calculating coins that can be accumulated by bursting [i,k-1] coins.
                    int leftCoins = k-1>=0 ? dp[i][k-1] : 0;                    
                    
                    // calculating coins that can be accumulated by bursting [k+1,j] coins.
                    int rightCoins = k+1<n ? dp[k+1][j] : 0 ;                  
                    
                    // calculating coins that can be accumulated by bursting kth coin
                    int coins = nums[k];
                    if(i-1>=0){
                        coins = coins*nums[i-1];
                    }
                    if(j+1<n){
                        coins = coins*nums[j+1];
                    }       
                    
                    coins += leftCoins + rightCoins;
                                        
                    dp[i][j] = Math.max(dp[i][j] , coins); 
                    
                }
                
            }
            
        }        
        
        return dp[0][nums.length-1];
    }
}