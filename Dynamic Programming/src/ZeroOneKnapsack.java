
/* Problem Statement: Given a Knapsack (bag) with "W" weight capacity and a list of N items each having some value: "vi" and weight: 
 * 					  "wi", return the maximum value that can be attained by placing certain items in the knapsack without exceeding 
 * 					  the weight capacity of the Knapsack.
 * 
 * 					  NOTE: We have only one quantity of each item.
 * 
 * General Observations:
 * 
 * 	- Find all subset of items whose combined weight is less than or equal to "W" and pick the subset with the maximum value.
 * 
 * 	- Every item has an option of being added to the knapsack or not. For example, for v = [1,2,3], w = [4,5,1] and W = 5,
 * 
 * 	  	sv=[], sw=[]
 * 		|
 * 		include (1,4)-----------------------------------------------------------------------------exclude (1,4)
 * 	 	sv=[1], sw=[4] 																			  sv=[], sw=[]
 * 		|																						  |
 * 	   	include (2,5)------------------------------------exclude (2,5)							  include (2,5)---------------------------exclude (2,5)
 * 	  	sv=[1,2], sw=[4,5](x) 							 sv=[1], sw=[4]							  sv=[2], sw=[5]						  sv=[], sw=[]
 * 		|												 |										  |										  |
 * 		include (3,1)-------------exclude (3,1)  		 include (3,1)---------exclude(3,1)		  include (3,1)---------exclude (3,1)	  include (3,1)-----exclude (3,1)
 * 	  	sv=[1,2,3], sw=[4,5,1](x) sv=[1,2], sw=[4,5](x)	 sv=[1,3], sw=[4,1]	   sv=[1], sw=[4]	  sv=[2,3], sw=[5,1](x) sv=[2], sw=[5]	  sv=[3], sw=[1]    sv=[], sw=[]	
 * 					    
 * 	- The problem is naturally recursive in nature. 
 * 
 * 	- Hypothesis:
 * 
 * 		- F(vals, wts, N, W) returns the maximum value that can be achieved by picking a subset of items out of first N items such
 *  	  that their combined weight < "available" weight capacity of knapsack.  
 *  
 *  - Don't need calls to subproblems where including the Nth item will make the weight of knapsack > W (available weight capacity of 
 *    knapsack).
 *    
 *  - Recursive Steps: 
 *  
 *  	1. Find the maximum value that can be achieved by including the Nth element in the subset, making sure that weight of the Nth
 *  	   item <= W (available weight capacity of knapsack):
 *  
 *  				- inc_curr_val = wts[N-1] <= W? val[N-1] + F(vals, wts, N-1, W-wts[N-1]) : -1;
 *  
 *  	2. Find the maximum value that can be achieved by excluding the Nth element from the subset:
 *  
 *  				- exc_curr_val = F(vals, wts, N-1, W);
 *  
 *  	3. Return the maximum value out of "inc_curr_val" and "exc_curr_val" to get the maximum value that can be achieved by picking 
 *  	   a subset of items from the first Nth item. 
 *  
 *  				- return max(inc_curr_val, exc_curr_val); 
 *  
 *  - Base Condition:
 *  
 *   	1. Maximum value that can be achieved if W = 0, i.e., knapsack is full = 0. 
 *   
 *   	2. Maximum value that can be achieved if N = 0, i.e., no items are left = 0.
 *
 *        
 *     
 * 
 * */

public class ZeroOneKnapsack {
	
	public static int memoization(int[] wts, int[] vals, int n, int wt, int[][] mem){

        if(n == 0 || wt == 0){
            return 0;
        }

        if(mem[n][wt]>0){
            return mem[n][wt];
        }

        int exc = memoization(wts, vals, n-1, wt, mem);

        int inc = Integer.MIN_VALUE;
        if(wts[n-1]<=wt){
            inc = vals[n-1] + memoization(wts, vals, n-1, wt-wts[n-1], mem);
        }

        mem[n][wt] = Math.max(inc, exc);

        return mem[n][wt];

	}
	
	public static int tabulation(int[] vals, int[] wts, int N, int W) {
		
		int[][] mem = new int[N+1][W+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=W; j++){
                mem[i][j] = mem[i-1][j];
                if(wts[i-1]<=j){
                    mem[i][j] = Math.max(mem[i][j], vals[i-1]+mem[i-1][j-wts[i-1]]);
                }
            }
        }
        
        return mem[N][W]; 
		
	}

    public static void main(String[] args) {

            

    }

    public static int basicIntitutiveRecursion(int[] wts, int[] vals, int idx, int subwts, int tarwt){

        if(subwts == tarwt || idx == wts.length){
            return 0;
        }

        int exc = basicIntitutiveRecursion(wts, vals, idx+1, subwts, tarwt);

        int inc = Integer.MIN_VALUE;
        if(subwts+wts[idx]<=tarwt){
            inc = vals[idx] + basicIntitutiveRecursion(wts, vals, idx+1, subwts+wts[idx], tarwt);
        }

        return Math.max(inc, exc);

    }

}