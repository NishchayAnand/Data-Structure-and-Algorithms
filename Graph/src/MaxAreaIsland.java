
/*

    Problem Statement:

        - Given a 2D binary grid where '0's represent water and '1's represent land.

        - An island represents a group of '1's connected 4-directionally (horizontal or vertical).

        - Return the maximum area of an island in grid. If no island exists, return 0.

        NOTE: The area of an island is the number of cells with value = '1' in the island.

    General Observations:

        - Consider the cells with value = '1' as vertices of a graph.

        - For any vertex [i, j], all non-diagonal adjacent vertices are connected to vertex [i, j].

        - Algorithm:
            - maxArea = 0;
            - Loop over each cell [i, j]:
                - if (cell [i, j] is a vertex, i.e., grid[i][j] = 1) and (is unvisited):
                    - area = getArea(grid, i, j, visited); // DFS traversal
                    - maxArea = max(maxArea, area);
            - return maxArea;

        - Time Complexity: O(m*n)

        - Space Complexity: O(m*n)

*/

public class MaxAreaIsland {

    private static int getArea(int[][] grid, int m, int n, int i, int j, boolean[][] visited) {

        // Base Conditions:
        if ((i<0) || (i==m) || (j<0) || (j==n) || visited[i][j] || grid[i][j] == 0) return 0;

        // Recursive Steps:

        // Process the current vertex
        int area = 1;
        visited[i][j] = true;

        // Explore all neighbours
        int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}}; // Left, Up, Right, Down
        for(int[] dir: directions) {
            area += getArea(grid, m, n, i+dir[1], j+dir[0], visited);
        }

        return area;

    }

    public static int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];

            int maxArea = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j] == 1 && !visited[i][j]) {
                        int area = getArea(grid, m, n, i, j, visited);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }

            return maxArea;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));

    }
}
