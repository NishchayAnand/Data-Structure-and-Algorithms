import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* Problem Statement: 
 * 
 * 	- Given an m x n input array where:
 * 
 * 		 - "left" and "top" edges mark the Pacific Ocean
 * 		 - "right" and "bottom" edges mark the Atlantic Ocean. 
 * 
 * 	- Each cell in the input array represent is a piece of island. The value in each cell denotes the 
 * 	  height of that piece of land above sea level.
 * 
 * 	- From a given 'cell', rain water can flow to its neighboring cells (i.e., cells "up", "below", 
 *    "right" and "left" of the current 'cell') if:
 *    		- "neighboring cell's value" <= "current cell's value". 
 * 
 * 	- Return a 2-D list of coordinates from where rain water can flow, i.e., "connected" to both the 
 * 	  Pacific and Atlantic Oceans.
 * 
 * General Observations:
 * 
 * 	- All cells on the "left" and "top" edge are connected to the Pacific Ocean.
 * 
 * 	- All cells on the "right" and "bottom" edge are connected to the Atlantic Ocean. 
 *    
 *  - A cell is connected to both Pacific and Atlantic Oceans if it is connected (directly/indirectly)
 *    to (i) [a ("left" || "top") edge cell] && 
 *    	(ii) [a ("right" || "bottom") edge cell].
 *    
 *  - A cell can receive water from its neighboring cells (i.e., cells "left", "up", "right" and "below" 
 *    the current cell) if "neighboring cell's value" >= "current cell's value".  
 *  
 *  - Algorithm:
 *  
 *  	- Peform DFS on:
 *  		- all ("left" & "top") edge cells to get all the cells from where water can flow to the 
 *   		  Pacific Ocean.
 *  		- all ("right" & "bottom") edge cells to get all the cells from where water can flow to the 
 *  		  Atlantic Ocean.
 *         
 *  	- Time Complexity Analysis:
 *  		- DFS on ("left" & "top") edge cells can lead to a maximum of (m*n) operations. Similarly, 
 *  		  DFS on ("right" & "bottom") edge cells can lead to a maximum of (m*n) operations.
 *  		- Hence, time complexity = O(m*n).
 *  
 *  	- Space Complexity Analysis:
 *  		- We are maintaining 2 boolean 2-D arrays of size m*n. Hence, space complexity = O(m*n).
 *  
 * */




public class PacificAtlanticWaterFlow {
	
	private static int[][] directions = {
			{0, -1},	// left
			{-1, 0},	// up
			{0, 1},		// right
			{1, 0}		// down
	};
	
	private static void DFS(int[][] grid, int r, int c, boolean[][] visited) {
		
		visited[r][c] = true;
		
		// visit neighbors
		for(int[] direction: directions) {
			
			int nr = r + direction[0];
			int nc = c + direction[1];
			
			boolean isInBound = (nr>=0) && (nr<grid.length) && (nc>=0) && (nc<grid[0].length);
			
			if(isInBound && (grid[nr][nc] >= grid[r][c]) && !visited[nr][nc]) {
				DFS(grid, nr, nc, visited);
			}
		}
				
	}

	public static void main(String[] args) {
		
		int[][] grid = {
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
		};
		
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] touchPacific = new boolean[m][n];
		boolean[][] touchAtlantic = new boolean[m][n];
		
		List<List<Integer>> output = new ArrayList<>();
		
		for(int c=0; c<n; c++) {
			//Perform DFS on all "top" edge cells.
			DFS(grid, 0, c, touchPacific);
			//Perform DFS on all "bottom" edge cells.
			DFS(grid, m-1, c, touchAtlantic);
		}
		
		for(int r=0; r<m; r++) {
			//Perform DFS on all "top" edge cells.
			DFS(grid, r, 0, touchPacific);
			//Perform DFS on all "bottom" edge cells.
			DFS(grid, r, n-1, touchAtlantic);
		}
		
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(touchPacific[r][c] && touchAtlantic[r][c]) {
					ArrayList<Integer> coordinate = new ArrayList<>();
					coordinate.add(r);
					coordinate.add(c);
					output.add(coordinate);
				}
			}
		}
		
		System.out.println(output);

	}

}
