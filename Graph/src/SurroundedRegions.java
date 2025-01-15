
/*

    Problem Statement: Given a mxn board consisting of 'X' and 'O', modify the grid such that any region of 'O' that is
                       completely surrounded by 'X' is captured by flipping all 'O's in that region to 'X'.

                       NOTE: 'O's that are on the boundary or connected to the boundary cannot be captured and remain
                            unchanged.

                       EXAMPLE:

                        - Input = [
                                    ["X","X","X","X"],
                                    ["X","O","O","X"],
                                    ["X","X","O","X"],
                                    ["X","O","X","X"]
                                  ]

                        - Output = [
                                    ["X","X","X","X"],
                                    ["X","X","X","X"],
                                    ["X","X","X","X"],
                                    ["X","O","X","X"]
                                   ]

    General Observations:

        - The 2D board can be interpreted as a graph, where all cells containing '0' are vertices (adjacency determine edges).

        - The problem involves finding all regions (i.e., connected components of 'O') connected to the boundary.

        - We can perform DFS/BFS from every vertex on the boundary to mark all regions connected to the boundary as 'F' (fixed).

        - After performing DFS/BFS on all boundary vertices, the remaining regions in the grid will be those that are
          completely surrounded by 'X'.

        - All regions untouched by the boundary traversal can be confidently flipped to 'X'.

        - Algorithm:

            // Step 1: Mark all regions connected to the boundary as 'F' (fixed).
            - for each row in graph:
                - for each column in graph:
                    - onBoundary = (row == 1) or (row == m) or (column==1) or (column==n);
                    - if onBoundary and graph[row][column] == '0':
                        - DFS(graph, row, column); // mark all vertices connected to [row][column] as 'F'.

            // Step 2: Flip all untouched regions to 'X'.
            - for each row in graph:
                - for each column in graph:
                    - if graph[row][column] == '0':
                        - graph[row][column] = 'X';

            // Step 3: Revert all vertices marked as 'F' to '0' to keep the regions connected to the boundary unchanged.
            - for each row in graph:
                - for each column in graph:
                    - if graph[row][column] == 'F':
                        - graph[row][column] = '0';

        - Time Complexity Analysis:

            - Traversing all boundary cells will lead to time complexity = O(m+n).

            - In worst-case scenario, i.e., when all cells in the board contains '0', each cell would be visited once,
              leading to a time complexity = O(m*n).

            - Hence, Time Complexity = O(m*n).

        - Space Complexity:

            - In the worst-case scenario, i.e., when all cells in the board contains '0', the recursive call stack will
              hold m*n recursive calls simultaneously, leading to space complexity = O(m*n).

            - Hence, Space Complexity = O(m*n).

*/

public class SurroundedRegions {

    private static void dfs(char[][] board, int m, int n, int row, int col) {

        // Base Conditions:
        boolean isOutOfBounds = (row < 0) || (row >= m) || (col < 0) || (col >= n);
        if(isOutOfBounds || board[row][col] == 'F' || board[row][col] == 'X') return;

        // Recursive Steps:

        // Mark current vertex as 'F'
        board[row][col] = 'F';

        // Explore all neighbour vertices
        dfs(board, m, n, row, col-1);    // Left
        dfs(board, m, n, row-1, col);   // Top
        dfs(board, m, n, row, col+1);    // Right
        dfs(board, m, n, row+1, col);   // Down

    }

    public static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark all regions connected to the boundary as 'F' (fixed).
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                boolean onBoundary = (r == 0) || (r == m-1) || (c == 0) || (c == n-1);
                if(onBoundary && board[r][c] == 'O') {
                    dfs(board, m, n, r, c); // mark all vertices connected to [row][column] as 'F'.
                }
            }
        }

        // Step 2: Flip all untouched regions to 'X' and revert all vertices marked as 'F' to '0'.
        for(int r=0; r<m; r++) {
            for (int c = 0; c<n; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                else if(board[r][c] == 'F') board[r][c] = 'O';
            }
        }

    }

    private static void display(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int r = 0; r <m; r++) {
            for(int c = 0; c <n; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };

        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };

        System.out.println("Original Board:");
        display(board);

        solve(board);

        System.out.println("Modified Board:");
        display(board);

    }
}
