
/* Problem Statment: 
 * 
 * 		- Given a 2-D array of size n x n filled with 0, 1, 2, 3 such that:
 * 
 * 			- a cell with value = '1' represent the 'source' cell.
 * 			- a cell with value = '2' represent the 'destination' cell.
 * 			- cells with value = '3' represent 'paths' which can be traversed.
 * 			- cells with value = '0' represent 'walls' through which we can't traverse.
 * 
 * 		- Check if there is a path possible from the 'source' cell to the 'destination' cell.
 *  
 *  	- NOTE: 
 *  		- There is only 1 'source' cell and 1 'destination' cell in the entire input array.
 *  		- You can traverse 'up', 'down', 'right' and 'left', conditon being that the traversal is 
 *  		  possible.
 * 
 * General Observations:
 * 
 * 	- If 2 vertices of a graph are connected to each other (directly or indirectly), depth-first-search 
 *    from one of the vertex will surely visit the other vertex.
 * 
 * 	- Approach:
 * 		
 * 		- Perform Depth-First-Search on the 'source' cell to check see if we can reach the 'destination' 
 * 		  cell.
 * 
 * 		- Time Complexity Analysis:
 * 
 * 			- In worst-case scenario, we would need to traverse the entire input array of size n x n to
 * 			  reach the destination. Hence, time complexity = O(n^2).
 * 
 * 		- Space Complexity Analysis:
 * 
 * 			- We need to maintain a 2-D boolean visited array of size n x n. Hence, space complexity = O(n^2). 
 * 
 * */

public class FindWhetherPathExists {
	
	private static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	
	private static boolean hasPath(int[][] grid, int r, int c, boolean[][] visited) {
		
		if(grid[r][c] == 2) {
			return true;
		}
		
		visited[r][c] = true;
		
		for(int[] dir: directions) {
	
			int nr = r+dir[0];
			int nc = c+dir[1];
			
			boolean isValidCell = (nr>=0) && (nr<grid.length) && (nc>=0) && (nc<grid[0].length);
			
			if( isValidCell && grid[nr][nc] != 0 && !visited[nr][nc] ) {
				
				boolean pathExists = hasPath(grid, nr, nc, visited);
				if(pathExists) return true;
				
			}
			
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		int[][] grid = { {3,0,3,0,0}, {3,0,0,0,3}, {3,3,3,3,3}, {0,2,3,3,0}, {3,0,0,1,3} };
		
		/* 
		 * grid = [ [3 0 3 0 0],
		 * 			[3 0 0 0 3],
		 * 			[3 3 3 3 3],
		 * 			[0 2 3 0 0],
		 * 			[3 0 0 1 3] ]
		 * 
		 * */
		
		int sr = -1;
		int sc = -1;
		
		for(int r=0; r<grid.length; r++) {
			for(int c=0; c<grid[0].length; c++) {
				if(grid[r][c] == 1) {
					sr = r;
					sc = c;
					break;
				}
			}
		}
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		System.out.println("Path Exist: " + hasPath(grid, sr, sc, visited));

	}

}
