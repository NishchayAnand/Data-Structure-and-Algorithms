import java.util.Arrays;

public class BuySellStockCooldown {
    
    public static int getMaximumProfit(int[] prices, int index, int isBuyPossible, int[][] mem){
        
        if(index >= prices.length){
            return 0;
        }
        
        if(mem[index][isBuyPossible] != -1){
            return mem[index][isBuyPossible];
        }
        
        if(isBuyPossible == 1){
            int buyProfit = getMaximumProfit(prices, index+1, 0, mem) - prices[index];
            int noBuyProfit = getMaximumProfit(prices, index+1, 1, mem);
            return mem[index][isBuyPossible] = Math.max(buyProfit, noBuyProfit);    
        } else {
            int sellProfit = getMaximumProfit(prices, index+2, 1, mem) + prices[index];
            int noSellProfit = getMaximumProfit(prices, index+1, 0, mem);
            return mem[index][isBuyPossible] = Math.max(sellProfit, noSellProfit);
        }
        
    }
    
    public int maxProfitRecursion(int[] prices) {
        
        int n = prices.length;
        int[][] mem = new int[n+1][2];
        
        for(int i=0; i<=n; i++){
            Arrays.fill(mem[i], -1);
        }
        
        return getMaximumProfit(prices, 0, 1, mem);
    }
    
    public int maxProfitTabulation(int[] prices) {
        
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        
        for(int i=0; i<=n+1; i++){
            Arrays.fill(dp[i], 0);
        }
        
        for(int i= n-1; i>=0; i--){
            // Maximum profit from ith day with buy option
            dp[i][1] = Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
            // Maximum profit from ith day with sell option
            dp[i][0] = Math.max(dp[i+2][1]+prices[i], dp[i+1][0]);            
        }
        
        return dp[0][1];
        
    }
    
    public int maxProfitSpaceOptimized(int[] prices) {
        
        int n = prices.length;
        int buy = 1;
        int sell = 0;
        
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2];
        int[] curr = new int[2];
        
        for(int i= n-1; i>=0; i--){            
            // Maximum profit from ith day with buy option
            curr[buy] = Math.max(ahead1[sell]-prices[i], ahead1[buy]);
            // Maximum profit from ith day with sell option
            curr[sell] = Math.max(ahead2[buy]+prices[i], ahead1[sell]);   
            
            ahead2[0] = ahead1[0];
            ahead2[1] = ahead1[1];
            
            ahead1[0] = curr[0];
            ahead1[1] = curr[1];            
        }        
        
        return curr[buy];
        
    }
    
    
}