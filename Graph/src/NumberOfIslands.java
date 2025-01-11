
/*

	Problem Statement: Given a 2D grid of '1's (land) and '0's (water), count the number of islands.

					   NOTE:
					   		- An island is a group of adjacent lands connected either horizontally or vertically (not diagonally).
					   		- The grid's boundaries are surrounded by water.

 	General Observations:

 		- Consider the given 2D grid to be a graph where each cell containing '1' represent a graph vertex.

 		- An edge (undirected) exists between two vertices if they are adjacent cells containing '1'.

 		- Each connected component of '1's in the graph corresponds to an island.

		- Primary Problem: Find all connected components in the given connected undirected graph (represented as an
		                   adjacency matrix).

		- Intuition:
			- Loop through the grid. For each cell containing '1' that hasn’t been visited, treat it as the starting
			  point for a graph traversal (DFS or BFS).

		- GCC Algorithm:
			- count = 0;
			- for each row_index in grid:
				- for each column_index in grid:
					- if graph[row_index][column_index] == '1' and visited[row_index][column_index] == false:
						- count = count + 1;
						// Mark all cells (vertices) connected to current cell (vertex) as visited
						- DFS(graph, row_index, column_index, visited);

		- DFS Algorithm:

			- Hypotheses:
				- F(graph, row_index, column_index, visited) will traverse all the direct / indirect neighbours
						  of vertex = [row_index, column_index] and mark them as visited.

			- Recursive Steps:

				// Step 1: Process the current vertex
				visited[row_index][column_index] = true;

				// Step 2: Visit all the unvisited neighbours of the current vertex
				- F(graph, row_index, column_index-1, visited); // Left
				- F(graph, row_index-1, column_index, visited); // Top
				- F(graph, row_index, column_index+1, visited); // Right
				- F(graph, row_index+1, column_index, visited); // Down

			- Base Conditions:

				- isInvalidCell = (column_index < 0) or (column_index >= n) or (row_index < 0) or (row_index >= m);
				- isInvalidVertex = graph[row_index][column_index] == '0';

				- if isInvalidCell or isInvalidVertex or visited[row_index][column_index]:
				     - return; // do nothing if the vertex does not exist or is already visited

		- Time Complexity Analysis:

			- In worst-case scenario, all cells will be visited twice (grid containing all '1's). Hence, time
			  complexity = O(m*n).

		- Space Complexity Analysis:

			- Maintaining a 2D array of size m x n to keep account of the visited vertices. Hence, space complexity = O(m*n).

*/

public class NumberOfIslands {
    
    private static void DFS(char[][] graph, int r, int c, boolean[][] visited){

		//Base Conditions: do nothing if the vertex does not exist or is already visited
		if ((c<0) || (r<0) || (c>=graph[0].length) || (r>=graph.length) || (graph[r][c]=='0') || visited[r][c]) return;

		// Step 1: Process the current vertex
		visited[r][c] = true;

		// Step 2: Visit all the unvisited neighbours of the current vertex
		DFS(graph, r, c-1, visited); // Left
		DFS(graph, r-1, c, visited); // Top
		DFS(graph, r, c+1, visited); // Right
		DFS(graph, r+1, c, visited); // Down
        
    }
    
    private static int getConnectedComponents(char[][] graph) {
    	
    	int count = 0;
		int m = graph.length;
		int n = graph[0].length;
    	boolean[][] visited = new boolean[m][n];
    	
    	for(int r=0; r<m; r++) {
    		for(int c=0; c<n; c++) {
    			if(graph[r][c] == '1' && !visited[r][c]) {
    				count++;
					// Mark all cells (vertices) connected to current cell (vertex) as visited
    				DFS(graph, r, c, visited);
    			}
    		}
    	}
    	return count;

    }

	private static int numIslands(char[][] grid) {
		return getConnectedComponents(grid);
	}

	public static void main(String[] args) {

		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};

	   	System.out.println("Number of islands: " + numIslands(grid));

	}

}