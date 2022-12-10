import java.util.Arrays;

public class LongestCommonSubsequence {

    public int LCS(String text1, String text2, int i, int j, int[][] dp){

        if(i == text1.length() || j == text2.length()){
            return dp[i][j] = 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + LCS(text1, text2, i+1, j+1, dp);
        } else {
            int op1 = LCS(text1, text2, i+1, j, dp);
            int op2 = LCS(text1, text2, i, j+1, dp);
            dp[i][j] = Math.max(op1, op2);
        }

        return dp[i][j];

    }
    
    public int longestCommonSubsequenceRecursive(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return LCS(text1, text2, 0, 0, dp);
    }
    
    public int longestCommonSubsequenceTabulation(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];

    }
    
    // copy elements of curr in ahead
    public void copy(int[] ahead, int[] curr){
        for(int i=0; i<curr.length; i++){
            ahead[i] = curr[i];
        }
    }
    
    public int longestCommonSubsequenceTabulationOptimized(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] ahead = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = 1 + ahead[j+1];
                } else {
                    curr[j] = Math.max(ahead[j], curr[j+1]);
                }
            }
            copy(ahead, curr);
        }

        return curr[0];

    }
}