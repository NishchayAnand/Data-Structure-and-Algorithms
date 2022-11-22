import java.util.*;

public class BuySellStocks1 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = scn.nextInt();
        }
        
        int i=1, j=0, maxProfit = 0;
        while(i<n){
            if(A[i]<A[j]){
                j=i;
            } else if(A[i]>A[j]){
                maxProfit = Math.max(maxProfit, (A[i]-A[j]));
            }
            i++;
        }
        
        System.out.println(maxProfit);
        
        scn.close();
        
    }

}