import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

	Problem Statement: Given a mXn grid where:
	 						- '0' represents an empty cell,
	 				   		- '1' represents a fresh orange
	 				   		- '2' represents a rotten orange.

 					   Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 					   Return the minimum number of minutes that must elapse until no cell has a fresh orange.

 					   NOTE: If this is impossible, return -1.

	General Observations:

		- The rotten oranges act as starting points or "sources" of the rot. The problem involves spreading the rot to
		  adjacent fresh oranges in the shortest possible time.

		- The 2D grid can be interpreted as a graph, where cells are vertices, and adjacency determine edges.

		- We can use BFS algorithm to process nodes in a graph layer-by-layer.

		- Algorithm:

			// Step 1: Prepare the first rotten level of the graph
			- Loop over each cell in graph:
				- queue.add(cell);

			- minutes = 0; // time to rot the first (already rotten layer) = 0

			// Step 2: Process the cells containing fresh oranges layer by layer
			- while(queue is not empty)

				// Get count of rotten oranges in the current layer
				- layerSize = queue.size();
				- hasRottenAny = false;

				// Process each rotten orange in the current layer to prepare the next rotten layer
				- for count = [1, layerSize]:
					- rottenCell = queue.poll();
					- for each neighbour (adjacent) fresh cell of rottenCell:
						- hasRottenAny = true;
						- graph[cell.x][cell.y] = 2; // mark neighbour as rotten
						- queue.add(cell);

				- if hasRottenAny: minutes++; // if condition will help us while processing the last layer, i.e., when no oranges will get rotten.

			- return minutes;

		- Time Complexity: O(m*n).

		- Space Complexity: O(m*n) in worst-case scenario (when all cells have value = 2).

*/

public class RottingOranges {

	static class Cell {
		int x;
		int y;

		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int orangesRotting(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		Queue<Cell> queue = new LinkedList<>();
		int freshCount = 0;

		// Step 1: Prepare the first rotten level of the graph
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 2) queue.add(new Cell(i, j));
				else if(grid[i][j] == 1) freshCount++;
			}
		}

		if(queue.isEmpty() || freshCount == 0) return 0; // edge cases: no rotten orange or no fresh orange

		int minutes = 0; // time to rot the first (already rotten layer) = 0

		int[][] directions = {
				{-1, 0},	// left
				{0, -1},	// Up
				{1, 0},		// Right
				{0, 1} 	// Down
		};

		// Step 2: Process the cells containing fresh oranges layer by layer
		while(!queue.isEmpty() && freshCount!=0) { // freshCount != 0 will help us handle the last layer, i.e., when no oranges will get rotten.

			// Get count of rotten oranges in the current layer
			int layerSize = queue.size();

			// Process each rotten orange in the current layer to prepare the next rotten layer
			for(int i=0; i<layerSize; i++) {

				Cell rottenCell = queue.poll();

				// Explore each adjacent neighbour (cell) of the rottenCell
				for(int[] dir : directions) {
					int nr = rottenCell.x + dir[1];
					int nc = rottenCell.y + dir[0];
					boolean isBounded = (nr >=0) && (nr < m) && (nc >=0) && (nc < n);
					if(isBounded && (grid[nr][nc]==1)) { // if the adjacent cell is fresh
						grid[nr][nc] = 2; // mark the adjacent cell as rotten
						queue.add(new Cell(nr, nc));
						freshCount--;
					}
				}

			}

			minutes++;

		}

		return freshCount == 0 ? minutes : -1;

	}

	public static void main(String[] args) {
		
//		int[][] grid = {
//				{2,1,1}, // [rotten, fresh, fresh]
//				{1,1,0}, // [fresh,  fresh, empty]
//				{0,1,1}  // [empty,  fresh, fresh]
//		};

		int[][] grid = {
				{1},
				{2}
		};
		
		System.out.println("Minutes required to rot all fresh oranges: " + orangesRotting(grid));

	}

}
