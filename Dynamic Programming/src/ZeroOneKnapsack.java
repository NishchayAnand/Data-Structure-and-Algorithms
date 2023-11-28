
/* Problem Statement: Given a Knapsack (bag) with "W" weight capacity and a list of N items each having some value: "vi" and weight: 
 * 					  "wi", return the maximum value that can be attained by placing certain items in the knapsack without exceeding 
 * 					  the weight capacity of the Knapsack.
 * 
 * 					  NOTE: We have only one quantity of each item.
 * 
 * General Observations:
 * 
 * 	- Find all subset of items whose combined weight is less than or equal to "W" and pick the subset with the maximum value (if 
 * 	  multiple, pick any).
 * 
 * 	- Every item has an option of being added to the knapsack or not. For example, for v = [1,2,3] & w = [3,2,1]:
 * 
 * 	  	sv=[], sw=[]
 * 		|
 * 		include(1,3)------------------------------------------------------------------------exclude(1,3)
 * 	 	sv=[1], sw=[3] 																		sv=[], sw=[]	  
 * 		|																					|	  
 * 	   	include(2,2)----------------------------------exclude(2,2)							include(2,2)--------------------------exclude(2,2)  
 * 	  	sv=[1,2], sw=[3,2] 							  sv=[1], sw=[3] 						sv=[2], sw=[2]						  sv=[], sw=[]
 * 		|											  |	 									|									  |
 * 		include(3,1)-------------exclude(3,1)  		  include(3,1)---------exclude(3,1)		include(3,1)---------exclude(3,1)	  include(3,1)-----exclude(3,1)
 * 	  	sv=[1,2,3], sw=[3,2,1]	 sv=[1,2], sw=[3,2]   sv=[1,3], sw=[3,1]   sv=[1], sw=[3]   sv=[2,3], sw=[2,1]	 sv=[2], sw=[2]	  sv=[3], sw=[1]   sv=[], sw=[]
 *
 * 	- The problem is naturally recursive in nature. 
 * 
 * 	- We don't need to make calls to subproblems where including the Nth item will make the weight of knapsack > W (weight capacity 
 * 	  of knapsack). For example, for W = 5, we can't perform include(3,1) when we already have items (1,3) and (2,2) in the knapsack.
 * 
 * 	- Hypothesis:
 * 
 * 		- F(vals, wts, N, W) returns the maximum value that can be achieved by picking a subset of items out of first N items such
 *  	  that their combined weight < "available" weight capacity of knapsack.
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
 *  	   a subset of items from the first N item. 
 *  
 *  				- return max(inc_curr_val, exc_curr_val); 
 *  
 *  - Base Condition:
 *  
 *   	1. Maximum value that can be achieved if W = 0, i.e., knapsack is full = 0. 
 *   	2. Maximum value that can be achieved if N = 0, i.e., no items are left = 0.
 *   
 *  - Time Complexity Analysis: ??
 *   
 *  - Space Complexity Analysis: ??
 *   
 *  - Overlapping Subproblems:
 *   
 *   	- If the weight of an item is equal to the sum of the weights of all the items to the right of that element, then it can lead 
 *   	  to overlapping subproblems. For example, consider v=[1,2,3], w=[3,2,1], W=6:
 *   
 *     		F(3,6)
 * 			|
 * 			include(3,1)-------------------------------------------------exclude(3,1)
 * 	 		F(2,5) 														 F(2,6)					  
 * 			|															 |							  
 * 	   		include(2,2)------------------exclude(2,2)				     include(2,2)------------------exclude(2,2)
 * 	  		F(1,3)						  F(1,5) 						 F(1,4)						   F(1,6)
 * 			|							  |								 |							   |
 * 			include(1,3)---exclude(1,3)   include(1,3)---exclude(1,3)	 include(1,3)---exclude(1,3)   include(1,3)---exclude(1,3)
 * 			F(0,0)		    ------		  F(0,2)		 F(0,5)			 F(0,1)	        F(0,4)		    -----         F(0,6)
 * 						   |F(0,3)|                                                                    |F(0,3)|
 * 							------																		-----
 * 							  ^																			  ^
 * 							  |_______________________ Overlapping Subproblems ___________________________|	
 * 							
 *  - Memoization:	
 *  
 *  	- We can use a 2-D array A of dimensions: [N+1, W+1] to store the results of each unique recursive function call. 
 *  
 *  	- The required answer will get updated at A[N][W] post the code execution.
 *  
 *  	- Time Complexity Analysis: ??
 *  
 *  	- Space Complexity Analysis: ??
 *  
 *  - Tabulation:
 *  
 * 		-
 * 
 * */

public class ZeroOneKnapsack {
	
	public static int memoization(int[] wts, int[] vals, int n, int wt, int[][] mem){

        if(n == 0 || wt == 0){
            return 0;
        }

        if(mem[n][wt]!=-1){
            return mem[n][wt];
        }

        int exc = memoization(wts, vals, n-1, wt, mem);
        int inc = wts[n-1] <= wt ? vals[n-1] + memoization(wts, vals, n-1, wt-wts[n-1], mem) : mem[n][wt];

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