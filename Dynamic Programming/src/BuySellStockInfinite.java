import java.util.Arrays;

public class BuySellStockInfinite {
    
    public int getMaximumProfit(int[] prices, int index, int isBuyPossible, int[][] mem){
        
        if(index == prices.length){
            return mem[index][isBuyPossible] = 0;
        }
        
        if(mem[index][isBuyPossible] != -1){
            return mem[index][isBuyPossible];
        }
        
        int subProfit = 0;
        
        if(isBuyPossible == 1){
            int buyProfit = getMaximumProfit(prices, index+1, 0, mem) - prices[index];
            int noBuyProfit = getMaximumProfit(prices, index+1, 1, mem);
            subProfit = Math.max(buyProfit, noBuyProfit);
        } else {
            int sellProfit = getMaximumProfit(prices, index+1, 1, mem) + prices[index];
            int noSellProfit = getMaximumProfit(prices, index+1, 0, mem);
            subProfit = Math.max(sellProfit, noSellProfit);
        }  
        
        return mem[index][isBuyPossible] = subProfit;
        
    }
    
    public int maxProfitRecursive(int[] prices) {   
        int[][] mem = new int[prices.length+1][2];
        
        for(int i=0; i<=prices.length; i++){
           Arrays.fill(mem[i], -1); 
        }
               
        return getMaximumProfit(prices, 0, 1, mem);        
    }
    
    public int maxProfitTabulation(int[] prices) { 
        
        int n = prices.length;
        
        int[][] dp = new int[n+1][2];
        
        for(int i=0; i<=n; i++){
           Arrays.fill(dp[i], -1); 
        }
        
        dp[n][0] = dp[n][1] = 0;
        
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j==1) { // we have the option to buy
                    dp[i][j] = Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
                } else { // we have the option to sell
                    dp[i][j] = Math.max(dp[i+1][1]+prices[i], dp[i+1][0]);
                }
            }
        }
        
               
        return dp[0][1];
        
    }
    
    public int maxProfitTabulationSpaceOptimized(int[] prices) { 
        
        int n = prices.length;
        
        int buyOptionProfit = 0;
        int sellOptionProfit = 0;
        
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j==1) { // we have the option to buy
                    buyOptionProfit = Math.max(sellOptionProfit-prices[i], buyOptionProfit);
                } else { // we have the option to sell
                    sellOptionProfit = Math.max(buyOptionProfit+prices[i], sellOptionProfit);
                }
            }
        }
        
               
        return buyOptionProfit;
        
    }
    
}