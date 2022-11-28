public class BuySellStocksTransactionFee {
	
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int buy = 1;
        int sell = 0;
        
        int[] ahead1 = new int[2];
        int[] curr = new int[2];
        
        for(int i= n-1; i>=0; i--){
            
            // Maximum profit from ith day with buy option
            curr[buy] = Math.max(ahead1[sell]-prices[i], ahead1[buy]);
            // Maximum profit from ith day with sell option
            curr[sell] = Math.max(ahead1[buy]+prices[i]-fee, ahead1[sell]); 
            
            ahead1[0] = curr[0];
            ahead1[1] = curr[1];
            
        }
        
        return curr[1];
        
    }
    
}