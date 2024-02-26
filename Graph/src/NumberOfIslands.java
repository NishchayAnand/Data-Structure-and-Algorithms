
/* Problem Statement: Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), 
 *  				  return the number of islands.
 * 
 * 					  NOTE: - An island is surrounded by water and is formed by connecting adjacent lands 
 * 							  horizontally or vertically. 
 * 							- You may assume all four edges of the grid are all surrounded by water.
 * 
 * General Observations:
 * 
 * 	- The input matrix can be thought as a graph where:
 * 		- each cell containing '1' represent a vertex.
 * 		- each vertex (cell containing '1') is connected to its adjacent vertices (cell containing '1') by
 *  	  edges.
 *    
 *  - Core Problem: Find the number of connected subgraphs in the provided graph. 
 *  
 *  - Approach 1 (using "Depth-First-Search"):
 *  
 *  	1. Loop over the input graph to search for an unvisited vertex (part of an unvisited subgraph):
 *  
 *  		2. If found:
 *  			3. Increase count of subgraphs by 1.
 *  			4. Start Depth-First-Search from the unvisited vertex and mark all its neighbouring 
 *                (direct/indirect) as visited. 
 *              5. Continue looping over the input graph (Step 1).
 *              
 *         	6. If not found:
 *         		7. End the algorithm.
 *         
 *     - Time Complexity Analysis:
 *     
 *     		- In worst-case scenario, all cells of the input array contains '1'. The algorithm will 
 *      	  visit all m*n cells and mark them as visited. Hence, time complexity = O(m*n).
 *     
 *     - Space Complexity Analysis:
 *     
 *     		- In worst-case scenario, i.e., all cells of the input array containing '1', the call stack 
 *     		  will hold 'm*n' stack frames simultaneously. 
 *     
 *     		- Also, we would be maintaining a 2-D array of size 'm*n' to keep account of the visited 
 *     		  vertices. 
 *     
 *     		- Hence, Space Complexity = O(m*n).
 *         		
 * */

public class NumberOfIslands {
    
    public static void DFS(char[][] graph, boolean[][] visited, int i, int j){
        
        visited[i][j] = true;
        
        // (if there is a cell to the "left") & (its a valid vertex, i.e., contains 1) & (it hasn't been
        //  visited before): 
        if(j-1 >= 0 && graph[i][j-1] == '1' && !visited[i][j-1]){
            DFS(graph, visited, i, j-1);
        }
        
        // (if there is a cell "above") & (its a valid vertex, i.e., contains 1) & (it hasn't been
        //  visited before):
        if(i-1 >= 0 && graph[i-1][j] == '1' && !visited[i-1][j]){
            DFS(graph, visited, i-1, j);
        }
        
        // (if there is a cell to the "right") & (its a valid vertex, i.e., contains 1) & (it hasn't been
        //  visited before):
        if(j+1<graph[0].length && graph[i][j+1] == '1' && !visited[i][j+1]){
            DFS(graph, visited, i, j+1);
        }
        
        // (if there is a cell "below") & (its a valid vertex, i.e., contains 1) & (it hasn't been
        //  visited before):
        if(i+1<graph.length && graph[i+1][j] == '1' && !visited[i+1][j]){
            DFS(graph, visited, i+1, j);
        }
        
    }
    
    private static int getConnectedComponents(char[][] graph, int m, int n) {
    	
    	int count = 0;
    	
    	boolean[][] visited = new boolean[m][n];
    	
    	for(int r=0; r<m; r++) {
    		for(int c=0; c<n; c++) {
    			if(graph[r][c] == '1' && !visited[r][c]) {
    				count++;
    				DFS(graph, visited, r, c);
    			}
    		}
    	}
    	
    	return count;
    }
    
   public static void main(String[] args) {
	   
	   int m = 4; // rows
	   int n = 5; // columns
	   
	   char[][] graph = new char[m][n];
	   
	   for(int r=0; r<m; r++) {
		   for(int c=0; c<n; c++) {
			   graph[r][c] = '0';
		   }
	   }
	   
	   graph[0][0] = graph[0][1] = graph[0][2] = graph[0][3] = '1';
	   graph[1][0] = graph[1][1] = graph[0][3] = '1';
	   graph[1][0] = graph[1][1] = '1';
	   
	   /*
	    * graph = [ [1 1 1 1 0],
	    * 			[1 1 0 1 0],
	    * 			[1 1 0 0 0],
	    * 			[0 0 0 0 0] ]
	    * 
	    * */
	   
	   	int count = getConnectedComponents(graph, m, n);
	   	System.out.println("Number of islands: " + count);
      
   }

}