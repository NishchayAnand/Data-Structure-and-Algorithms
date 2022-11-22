import java.io.*;
import java.util.*;

public class BuySellStocks2 {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] A = new int[n];
        for(int idx=0; idx<n; idx++){
            A[idx] = scn.nextInt();
        }
        
        int[] firstTransProfits = new int[n];
        int i=1, j=0, maxProfitSoFar = 0; // i= selling index, j= min buying index
        while(i<n){
            if(A[i]<A[j]){ // first update the min buying index, otherwise we will be considering loss
                j=i;
            } 
            maxProfitSoFar = Math.max(maxProfitSoFar, (A[i]-A[j]));
            firstTransProfits[i] = maxProfitSoFar;
            i++;
        }
        
        int[] secondTransProfits = new int[n];
        i=n-2;
        j=n-1;
        int maxProfitFromNow = 0;
        while(i>=0){ // i=buying index, j= max selling index
            if(A[i]>A[j]){
                j=i;
            }
            maxProfitFromNow = Math.max(maxProfitFromNow, (A[j]-A[i]));
            secondTransProfits[i] = maxProfitFromNow;
            i--;
        }
        
        int maxProfit = 0;
        for(int idx=0; idx<n; idx++){
            maxProfit = Math.max(maxProfit, firstTransProfits[idx] + secondTransProfits[idx]);
        }
        
        System.out.println(maxProfit);
        
        scn.close();
        
    }

}