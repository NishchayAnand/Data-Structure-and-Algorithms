import java.util.Arrays;

public class MatrixChainMutiplication{
    
    static int getMinimumOperations(int[] arr, int i, int j, int[][] dp){
        
        if(i==j){
            return dp[i][j] = 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int minOps = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int ops = getMinimumOperations(arr, i, k, dp) + getMinimumOperations(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j];
            minOps = Math.min(minOps, ops);
        }
        
        return dp[i][j] = minOps;
    }
    
    static int matrixMultiplicationRecursion(int N, int arr[])
    {
        
        int[][] dp = new int[N][N];
        
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return getMinimumOperations(arr, 1, N-1, dp);
        
    }
    
    static int matrixMultiplicationTabulation(int N, int arr[])
    {
        
        int[][] dp = new int[N][N];
        
        for(int i=1; i<N; i++){
            dp[i][i] = 0;
        }
        
        for(int i=N-1; i>=1; i--){
            for(int j=i+1; j<N; j++){
                int minOps = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int ops = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    minOps = Math.min(minOps, ops);
                }
                dp[i][j] = minOps;
            }
        }
        
        
        return dp[1][N-1];
    }
}