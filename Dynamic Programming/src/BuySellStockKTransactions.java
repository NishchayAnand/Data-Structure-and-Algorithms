import java.util.Arrays;

public class BuySellStockKTransactions {
    
    public int getMaximumProfit(int[] prices, int index, int isBuyPossible, int t, int[][][] mem){
        
        if(index == prices.length || t == 0){
            return mem[index][isBuyPossible][t] = 0;
        }
        
        if(mem[index][isBuyPossible][t] != -1){
            return mem[index][isBuyPossible][t];
        }
        
        int profit = 0;
        
        if(isBuyPossible == 1){
            int buyProfit = getMaximumProfit(prices, index+1, 0, t, mem) - prices[index];
            int noBuyProfit = getMaximumProfit(prices, index+1, 1, t, mem);
            profit = Math.max(buyProfit, noBuyProfit);
        } else {
            int sellProfit = getMaximumProfit(prices, index+1, 1, t-1, mem)+prices[index];
            int noSellProfit = getMaximumProfit(prices, index+1, 0, t, mem);
            profit = Math.max(sellProfit, noSellProfit);
        }
        
        return mem[index][isBuyPossible][t] = profit;
        
    }
    
    public int maxProfitRecursionMemoized(int k, int[] prices) {
        
        int n = prices.length;
        int[][][] mem = new int[n+1][2][k+1];
        
        for(int i=0; i<=n;i++){
            for(int j=0; j<=1; j++){
                Arrays.fill(mem[i][j], -1);
            }
        }
        
        return getMaximumProfit(prices, 0, 1, k, mem);
        
    }
    
    public int maxProfitTabulation(int k, int[] prices) {
        
        int n = prices.length;
        int[][][] mem = new int[n+1][2][k+1];
        int buy = 1;
        int sell = 0;
        
        for(int i=n-1; i>=0; i--){
            for(int t=1; t<=k; t++){ // t=0 doesn't need to be calculated, maxProfit will be 0. 
                // have the option to buy
                mem[i][buy][t] = Math.max(mem[i+1][sell][t] - prices[i], mem[i+1][buy][t]);
                // have the option to sell
                mem[i][sell][t] = Math.max(mem[i+1][buy][t-1] + prices[i], mem[i+1][sell][t]);
            }
        }
        
        return mem[0][1][k];
        
    }
    
    
}