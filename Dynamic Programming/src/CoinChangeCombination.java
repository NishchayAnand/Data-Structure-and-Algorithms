import java.util.*;

public class CoinChangeCombination {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int A = scn.nextInt();

        int[][] dp = new int[n+1][A+1];

        int[] dpl = new int[A+1];
        dpl[0] = 1;

        boolean tabulation1 = false;
        boolean tabulation2 = false;
        boolean tabulation3 = true;
        if(tabulation1){
            for(int i=0; i<=n; i++){
                for(int j=0; j<=A; j++){
                    if(j==0){
                        dp[i][j] = 1;
                    } else if(i==0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i-1][j];
                        if(arr[i-1]<=j){
                            dp[i][j]+=dp[i][j-arr[i-1]];
                        }
                    }
                }
            }
            System.out.print(dp[n][A]);
        } else if(tabulation2) {
            for(int i=1; i<=n; i++){
                for(int j=0; j<=A; j++){
                    if(j==0){
                        dp[i][j] = 1;
                    } else {
                        for(int k=i; k>=1; k--){
                            if(arr[k-1]<=j){
                                dp[i][j]+=dp[k][j-arr[k-1]];
                            }
                        }
                    }
                }
            }
            System.out.println(dp[n][A]);
        } else if(tabulation3) {
            for(int coin: arr){
                for(int tarsum=1; tarsum<=A; tarsum++){
                    if(coin<=tarsum){
                        dpl[tarsum] += dpl[tarsum-coin];
                    }
                }
            }
            System.out.println(dpl[A]);
        } else {
            int ans = possibleComb(arr, n, A, dp);
            System.out.print(ans);
        }
        
        scn.close();

    }

    public static int possibleComb(int[] arr, int n, int A, int[][] dp){

        if(A==0){
            return 1;
        }

        if(dp[n][A]>0){
            return dp[n][A];
        }
        
        // dp[n][A] = 0 -> by default
        for(int i=n; i>=1; i--){
            if(arr[i-1]<=A){
                dp[n][A] += possibleComb(arr, i, A-arr[i-1], dp);
            }
        }

        return dp[n][A];
        
    }
}