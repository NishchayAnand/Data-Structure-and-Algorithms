import java.util.Arrays;

// considering k complete transaction as 2k single transaction.

class Solution {
    
    public int getMaximumProfit(int[] prices, int index, int t, int k, int[][] mem){
        
        if(index == prices.length || t == k){
            return mem[index][t] = 0;
        }
        
        if(mem[index][t] != -1){
            return mem[index][t];
        }
        
        int profit = 0;
        
        if(t%2 == 0){
            int buyProfit = getMaximumProfit(prices, index+1, t+1, k, mem) - prices[index];
            int noBuyProfit = getMaximumProfit(prices, index+1, t, k, mem);
            profit = Math.max(buyProfit, noBuyProfit);
        } else {
            int sellProfit = getMaximumProfit(prices, index+1, t+1, k, mem)+prices[index];
            int noSellProfit = getMaximumProfit(prices, index+1, t, k, mem);
            profit = Math.max(sellProfit, noSellProfit);
        }
        
        return mem[index][t] = profit;
        
    }
    
    public int maxProfitRecursion(int k, int[] prices) {
        
        int n = prices.length;
        int[][] mem = new int[n+1][2*k+1];
        
        for(int i=0; i<=n;i++){
            Arrays.fill(mem[i], -1);
        }
        
        return getMaximumProfit(prices, 0, 0, 2*k, mem);
        
    }
    
    public int maxProfitTabulation(int k, int[] prices) {
        
        int n = prices.length;
        int[][] mem = new int[n+1][2*k+1];
        
        
        for(int i=n-1; i>=0; i--){
            for(int t=2*k-1; t>=0; t--){
                if(t%2==0){ // have the option to buy
                    mem[i][t] = Math.max(mem[i+1][t+1] - prices[i], mem[i+1][t]);
                } else { // have the option to sell
                    mem[i][t] = Math.max(mem[i+1][t+1] + prices[i], mem[i+1][t]);
                }                
            }
        }
        
        return mem[0][0];
        
    }
}
