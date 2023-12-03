
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
 *  	- Create a 2-D array: DP of dimensions: [N+1, W+1] and initialize each cell with an invalid output, for example, -1.
 *   
 *  	- Start with the recursion and store the result of each unique recursive function call to make sure we don't compute any 
 *  	  overlapping subproblem. 
 *  
 *  	- Time Complexity Analysis: ??
 *  
 *  	- Space Complexity Analysis: ??
 *  
 *  - Tabulation:
 *  
 * 		- Create a 2-D array: DP of dimensions: [N+1, W+1].
 *  
 *  	- Fill in the minimum output values for the base values of the N and W:
 * 				
 * 				- Loop from c=[0:W]:
 * 					- DP[0][c] = 0;
 * 
 * 				- Loop from r=[0:N]:
 * 					- DP[r][0] = 0;
 * 
 * 		- Iterate over the output array and fill in the entries using the "recursive steps" defined above.
 * 	
 * 			- Loop from r = [1:N]:
 * 				- Loop from c = [1:W]:
 * 					- inc_val = if wts[r-1] <= c ? then DP[r-1][c-wts[r-1]] : else -1;
 * 					- exc_val = DP[r-1][c];
 * 					- DP[r][c] = max(inc_val, exc_val);
 * 		
 * 		- DP[N][W] will hold the optimal solution to the problem.
 * 
 * 		NOTE: 
 * 
 * */

public class ZeroOneKnapsack {
	
	public static int memoization(int[] wts, int[] vals, int N, int W, int[][] mem){

        if(N == 0 || W == 0){
            mem[N][W] = 0;
            return mem[N][W];
        }

        if(mem[N][W]!=-1){
            return mem[N][W];
        }

        int exc = memoization(wts, vals, N-1, W, mem);
        int inc = wts[N-1] <= W ? vals[N-1] + memoization(wts, vals, N-1, W-wts[N-1], mem) : mem[N][W];

        mem[N][W] = Math.max(inc, exc);
        return mem[N][W];

	}
	
	public static int tabulation(int[] wts, int[] vals, int N, int W, int[][] mem) {
		
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
    	
    	int[] vals = {1,2,3};
    	int[] wts = {3,2,1};
    	
    	int N = vals.length;
    	
    	int W = 4;
    	
    	// Initializing each cell with an invalid output = -1.
    	int[][] mem = new int[N+1][W+1];
    	for(int r=0; r<mem.length; r++) {
    		for(int c=0; c<mem[0].length; c++) {
    			mem[r][c] = -1; 
    		}
    	}
    	
    	// Memoization Approach:
    	
    	int mem_output = memoization(wts, vals, N, W, mem);
    	System.out.println("Maximum value using memoization: " + mem_output);
    	
    	System.out.println("Output array after memoization solution:");
    	for(int r=0; r<mem.length; r++) {
    		for(int c=0; c<mem[0].length; c++) {
    			System.out.print(mem[r][c] + "\t"); 
    		}
    		System.out.println();
    	}
    	
    	System.out.println("-----------------------------------------------------------------------");
    	
    	// Tabulation Approach:
    	
    	int[][] tab = new int[N+1][W+1];
    	
    	int tab_output = tabulation(wts, vals, N, W, tab);
    	System.out.println("Maximum value using tabulation: " + tab_output);
    	
    	System.out.println("Output array after Tabulation solution:");
    	for(int r=0; r<tab.length; r++) {
    		for(int c=0; c<tab[0].length; c++) {
    			System.out.print(tab[r][c] + "\t"); 
    		}
    		System.out.println();
    	}

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