import java.util.Scanner;

public class BuySellStockInfinite {
	
	public static void main(String args[]) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int[] prices = new int[n];
		for(int i=0; i<n; i++) {
			prices[i] = scn.nextInt();
		}
		
		int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        
        System.out.println(profit);
        
        scn.close();
	}

}
