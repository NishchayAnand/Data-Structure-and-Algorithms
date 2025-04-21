
/*

    Problem Statement:

        - Given a 2D matrix: 'matrix' of dimensions: m x n, where each row is sorted, and the first element of each row
          is greater than the last element of the previous row; and an integer: 'target', return true if the target is
          in the matrix or false otherwise.

    General Observations:

        - Can the 'matrix' be empty?
        - No.

    Linear Search Approach - Brute Force:

        - Use nested loop {i,j} to iterate over all integers in the 'matrix' and check if any of them is equal to the
          'target' integer.

        - Time Complexity: O(m * n).

        - Space Complexity: O(1).

    Optimized Linear Search Approach:

        - Check each row's first and last element to see if the target lies within its bounds, and if so, perform a
          linear search on that row.

        - Time Complexity: O(m + n).

        - Space Complexity: O(1).

    Binary Search Approach:

        - Check each row's first and last element to see if the target lies within its bounds, and if so, perform a
          binary search on that row.

        - Time Complexity: O(m + logn).

        - Space Complexity: O(1).

    Optimized Binary Search Approach:

        - Intuition: Each coordinate in the 2D matrix can be converted to a 1D index using (row * n + col).

        - Treat the 2D matrix as a 1D sorted array and run binary search in the range [0, (m * n) - 1] by converting middle
          element index from 1D index and 2D coordinate using row = mid / n and col = mid % n.

        - Algorithm:
            - left = 0, right = m*n-1;
            - while left <= right:
                - mid = (left + right) / 2;
                - row = mid / n;
                - col = mid % n;
                - if matrix[row][col] == target: return true;
                - if matrix[row][col] > target: right = mid - 1;
                - if matrix[row][col] < target: left = mid + 1;
            - return false;

        - Time Complexity: O(log(m*n)).

        - Space Complexity: O(1).

*/

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) right = mid - 1;
            else left = mid + 1; // matrix[row][col] < target
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 4;
        System.out.println(searchMatrix(matrix, target));
    }

}
