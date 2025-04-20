
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

        -

        - Time Complexity:

        - Space Complexity:

*/

public class Search2DMatrix {


}
