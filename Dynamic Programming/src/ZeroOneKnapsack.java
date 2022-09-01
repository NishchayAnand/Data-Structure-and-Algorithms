import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) throws Exception {

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

        int W = scn.nextInt();

        int[][] mem = new int[n+1][W+1];

        //tabulation
        boolean tabulation = true;

        if(tabulation){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=W; j++){
                    mem[i][j] = mem[i-1][j];
                    if(wts[i-1]<=j){
                        mem[i][j] = Math.max(mem[i][j], vals[i-1]+mem[i-1][j-wts[i-1]]);
                    }
                }
            }
            System.out.println(mem[n][W]);
        } else {
            // recursive solution.
            //int max = maxVal1(wts, vals, 0, 0, W);
            int max = maxVal2(wts, vals, n, W, mem);
            System.out.println(max); 
        }
        
        scn.close();     

    }

    public static int maxVal2(int[] wts, int[] vals, int n, int wt, int[][] mem){

        if(n == 0 || wt == 0){
            return 0;
        }

        if(mem[n][wt]>0){
            return mem[n][wt];
        }

        int exc = maxVal2(wts, vals, n-1, wt, mem);

        int inc = Integer.MIN_VALUE;
        if(wts[n-1]<=wt){
            inc = vals[n-1] + maxVal2(wts, vals, n-1, wt-wts[n-1], mem);
        }

        mem[n][wt] = Math.max(inc, exc);

        return mem[n][wt];

    }

    public static int maxVal1(int[] wts, int[] vals, int idx, int subwts, int tarwt){

        if(subwts == tarwt || idx == wts.length){
            return 0;
        }

        int exc = maxVal1(wts, vals, idx+1, subwts, tarwt);

        int inc = Integer.MIN_VALUE;
        if(subwts+wts[idx]<=tarwt){
            inc = vals[idx] + maxVal1(wts, vals, idx+1, subwts+wts[idx], tarwt);
        }

        return Math.max(inc, exc);

    }

}