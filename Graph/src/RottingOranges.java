import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Problem Statement: 
 * 
 * 	- You are given a 'm x n' grid where each cell can have one of three values:
 * 
 * 		- 0 representing an empty cell,
 * 		- 1 representing a fresh orange,
 * 		- 2 representing a rotten orange.
 * 
 * 	- Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * 	- Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is 
 * 	  impossible, return -1.
 * 
 * General Observations:
 * 
 * 	- From each cell with value = 2 (rotten orange), we can visit all ajdacent cells ("left", "up", 
 *    "right", "down") with value = 1 (fresh orange).  
 * 
 * 	- All cells:
 * 		- with value = 2 (rotten oranges) can be treated as "Level 1" of a graph.
 * 		- with value = 1 (fresh oranges) adjacent to cells in "Level 1" can be treated as "Level 2" of the
 * 		  graph.
 * 		- and so on.
 * 
 *  - We can traverse a "Rotten Level" and mark all cells in the next "Fresh Level" as rotten.
 *  
 *  - (Minutes required to spoil all "Fresh Levels") = (Minutes required to traverse all "Levels") - 1.
 * 
 *  - Approach:
 *  
 *  	- Perform BFS algorithm on the graph treating all cells with value = 2 (rotten oranges) as 
 *  	  "Level 1". 
 *  
 *  	- Algorithm:
 *  
 *  		// preparing Level 1 of the graph.
 *  		- Add all cells with value = 2 in a Queue;
 *  		
 *  		- While Queue is not empty:
 *  
 *  			// traversing a Level.
 *  			- Run a loop to empty the Queue, i.e., for Queue.size();
 *  				- rotten_cell = Queue.remove();
 *  				- Loop over neighbors of rotten_cell, i.e., cells adjacent to rotten_cell with value = 1:
 *  					- If a neighbor is not marked as rotten, i.e., a fresh orange:
 *  
 *  						// preparing the next Level.
 *  						- Add neighbor to the Queue;
 *  						- Mark neighbor as rotten;
 *  
 *  			// finished traversing a Level.
 *  			- minutes++;
 *  
 *  		- return minutes-1; 
 *  
 *  	- Time Complexity Analysis:
 *  
 *  		- In worst case scenario, we would be traversing over the entire input array of size 'm x n'.
 *  		- Hence, time complexity = O(m*n).
 *  
 *  
 *  	- Space Complexity Analysis:
 *  
 *  		- We are using a boolean visited array of size 'm x n'. 
 *  		- Queue would at max store m*n coordinates, only in case all cells have value = 2.
 *  		- Hence, overall space complexity = O(m*n).
 *  
 * */

public class RottingOranges {
	
	private static int[][] directions = { {0,-1}, {-1,0}, {0,1}, {1,0} };
	
	private static List<Integer> getCoordinate(int r, int c) {
		List<Integer> coordinate = new ArrayList<>();
		coordinate.add(r);
		coordinate.add(c);
		return coordinate;
	}
	
	private static int BFS(int[][] grid, int m, int n, boolean[][] rotten) {
		
		Queue<List<Integer>> queue = new LinkedList<>();
		boolean hasRottenOranges = false;
		int minutes = 0;
		
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(grid[r][c] == 2) {
					hasRottenOranges = true;
					queue.add(getCoordinate(r, c));
				}
			}
		}
		
		if(!hasRottenOranges) {
			return minutes;
		}
		
		while(!queue.isEmpty()) {
			
			int cellsInLayer = queue.size();
			
			for(int i=0; i<cellsInLayer; i++) {
				
				List<Integer> coordinate = queue.remove();
				int r = coordinate.get(0);
				int c = coordinate.get(1);
				
				for(int[] direction: directions) {
					
					// neighbor's coordinate.
					int nr = r + direction[0];
					int nc = c + direction[1];
					
					boolean isBound = (nr>=0) && (nr<m) && (nc>=0) && (nc<n);
					
					if(isBound && grid[nr][nc]==1 && !rotten[nr][nc]) {
						queue.add(getCoordinate(nr, nc));
						rotten[nr][nc] = true;
					}
					
				}
				
			}
			
			minutes++;
			
		}
		
		return minutes-1;
		
	}

	public static void main(String[] args) {
		
		int[][] grid = {{0}}; //{{2,1,1,2}, {1,1,0,1}, {0,1,1,1}};
		
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] rotten = new boolean[m][n];
		
		int minutes = BFS(grid, m, n, rotten);
		
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(grid[r][c]==1 && !rotten[r][c]) {
					System.out.println("All oranges cannot be rotten.");
					return;
				}
			}
		}
		
		System.out.println("Minutes required to spoil all oranges: " + minutes);

	}

}
