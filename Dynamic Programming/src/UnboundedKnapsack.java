import java.util.*;

public class UnboundedKnapsack {

    public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] vals = new int[n];
		for(int i=0; i<n; i++){
			vals[i] = scn.nextInt();
		}

		int[] wts = new int[n];
		for(int i=0; i<n; i++){
			wts[i] = scn.nextInt();
		}

		int w = scn.nextInt();

		int[][] dp = new int[n+1][w+1];

		int[] dpl = new int[w+1];

		boolean tabulation1 = false;
		boolean tabulation2 = false;
		boolean tabulation3 = true;

		if(tabulation1){
			for(int i=0; i<=n; i++){
				for(int j=0; j<=w; j++){
					if(i==0 || j==0){
						dp[i][j] = 0;
					} else {
						dp[i][j] = dp[i-1][j];
						if(wts[i-1]<=j){
							dp[i][j] = Math.max(dp[i][j], vals[i-1] + dp[i][j-wts[i-1]]);
						}		
					}
				}
			}
			System.out.println(dp[n][w]);
		} else if (tabulation2){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=w; j++){
					if(wts[i-1]<=j){
						dpl[j] = Math.max(dpl[j], (vals[i-1]+dpl[j-wts[i-1]]) );
					}
				}
			}
			System.out.println(dpl[w]);
		} else if (tabulation3) {
			for(int tar=1; tar<=w; tar++){
				for(int i=1; i<=n; i++){
					if(wts[i-1]<=tar){
						dpl[tar] = Math.max(dpl[tar], vals[i-1]+dpl[tar-wts[i-1]]);
					}
				}
			}
			System.out.println(dpl[w]);			
		} else {
			int max = maxVal(wts, vals, n, w, dp);
			System.out.println(max);
		}
		
		scn.close();
		
    }

	public static int maxVal(int[] wts, int[] vals, int n, int w, int[][] dp){

		if(n==0 || w==0){
			return 0;
		}

		if(dp[n][w]>0){
			return dp[n][w];
		}
		
		// excluded
		dp[n][w] = maxVal(wts, vals, n-1, w, dp);

		// included
		if(wts[n-1]<=w){
			dp[n][w] = Math.max(dp[n][w], vals[n-1] + maxVal(wts, vals, n, w-wts[n-1], dp));
		}

		return dp[n][w];

	}
}