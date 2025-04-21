
/*

    Problem Statement:

        - Given a 2D matrix of dimension: (mxn) having the following properties:
            - Integers in each row are sorted in ascending from left to right.
            - Integers in each column are sorted in ascending from top to bottom.

        - Return true if 'target' exists in the matrix, or false otherwise.

    General Observations:

        - Can we have duplicate elements?
        - No.

    Linear Search Approach - Brute Force:

        - Use nested loop {i,j} to iterate over all integers in the 'matrix' and check if any of them is equal to the
          'target' integer.

        - Time Complexity: O(m * n).

        - Space Complexity: O(1).

    Binary Search Approach:

        - Check each row's first and last element to see if the target can lie within its bounds, and if so, perform a
          binary search on that row.

        - Time Complexity: O(m * logn).

        - Space Complexity: O(1).

    Binary Search Like Elimination Approach:

        - Intuition: The top-right corner is the intersection point of the first row (sorted left to right) and the last
                     column (sorted top to bottom), i.e., it's the largest in the first row and the smallest in the last
                     column. That makes it a strategic decision point.

        - Start at the top-right corner [0, n-1] and iteratively eliminate a row if the current element is less than the
          'target' or a column if it's greater, continuing until the 'target' is found or the bounds are exhausted.

        - Algorithm:
            - row = 0, col = n-1;
            - while row < m and col >= 0:
                - if matrix[row][col] == target: return true;
                - if matrix[row][col] > target: col--;
                - if matrix[row][col] < target: row++;
            - return false;

        - Time Complexity: In the worst-case scenario, i.e., when the 'target' lies at matrix [n-1][0], time complexity = O(m+n).

        - Space Complexity: O(1)

*/

public class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++; // matrix[row][col] < target
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }
}
