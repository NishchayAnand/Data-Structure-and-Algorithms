
/*

    Problem Statement:

        - Given an m x n grid, return the number of possible unique paths from grid[0][0] to grid[m - 1][n - 1].

        NOTE: You can move either down or right at any point in time.

    General Observations:

        - The problems involves exploring all unique combinations of steps one can take to reach from cell = grid[0][0]
          to cell = grid[m - 1][n - 1].

        - At any grid[i][j], you have 2 choices:
            1. if the right cell, i.e., grid[i+1][j] exists, move to the right cell.
            2. if the down cell, i.e., grid[i][j+1] exists, move to the down cell.

        - Intuition:
            - Number of ways to reach grid[i][j] = Number of ways to reach grid[i-1][j] (cell above grid[i][j]) +
                                                   Number of ways to reach grid[i][j-1] (cell to the left of grid[i][j]).

        - Recursive Approach:

            - Hypothesis:
                - F(grid, i, j) will return the number of ways to reach grid[i][j].

            - Recursive Steps:
                - return F(grid, i-1, j) + F(grid, i, j-1);

            - Base Conditions:
                - if i < 0 || j < 0: return 0; // No path exists to reach a cell that does not exist
                - if i == 0 && j == 0: return 1; // One way to reach grid[0][0] from grid[0][0], i.e., do nothing

            - Space Complexity:
                - At most, the call stack will hold (m+n) function calls.
                - Hence, Space Complexity = O(m+n).

            - Time Complexity:
                - For every m*n cells, we will explore 2 choices.
                - Hence, Time Complexity = O(2^(m*n)).

            - Optimisations:

                - Overlapping Sub-problems:
                    - Can use a cache (2D array) to store the results of the previously computed sub-problems.
                    - Only solve m*n unique sub-problems.
                    - Time Complexity: O(m*n).
                    - Space Complexity: O(m*n).

                - Call Stack Utilisation:
                    - The cache is filled while backtracking from i = [0, m] and j = [0, n].
                    - Can use a nested loop to fill the cache using the recursive steps.
                    - No stack overflow concerns.

*/

import java.util.Arrays;

public class UniquePaths {

    private static int helper(int i, int j, int[][] cache) {

        // Base Conditions:
        if(i==0 && j==0) return 1; // One way to reach grid[0][0] from grid[0][0], i.e., do nothing

        // Optimisations:
        if(cache[i][j] != -1) return cache[i][j];

        // Recursive Steps:
        int paths = 0;
        if(i>0) paths += helper(i-1, j, cache); // number of paths to reach the cell on the left of grid[i][j]
        if(j>0) paths += helper(i, j-1, cache); // number of paths to reach the cell above grid[i][j]

        return cache[i][j] = paths;

    }

    public static int uniquePathsRecursive(int m, int n) {
        int[][] cache = new int[m][n];
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));
        return helper(m-1, n-1, cache);
    }

    public static int uniquePathsIterative(int m, int n) {

        int[][] cache = new int[m][n];

        // Base Conditions:
        cache[0][0] = 1;

        // Backtracking:
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // Recursive Steps:
                if(i>0) cache[i][j] += cache[i-1][j]; // number of paths to reach the cell on the left of grid[i][j]
                if(j>0) cache[i][j] += cache[i][j-1]; // number of paths to reach the cell above grid[i][j]
            }
        }

        return cache[m-1][n-1];

    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePathsIterative(m, n));
    }
}
