
/*

    Problem Statement:

        - Given 'n' coins, we need to build a staircase like structure where every ith row can hold exactly 'i' coins. Return
          the number of complete rows of the staircase you will build.

    General Observations:

        Q. What would be the output of the following input: n = 8?
        A. Number of coins after building:
                - 1st row: 8 - 1 = 7
                - 2nd row: 7 - 2 = 5
                - 3rd row: 5 - 3 = 2
                - 4th row: Not enough coins to build the 4th row (required = 4, available = 2). Hence, output = 3.

        Q. What would be the output of the following input: n = 0?
        A. Invalid input, n always >= 1.

    - Brute Force Approach:

        - Keep building the rows while we have enough coins to build the current row.

        - Algorithm:
            - row = 1;
            - while n >= row: // will stop when we don't have enough coins to build the current row
                - n = n - row;
                - row++;
            - row-1; // represent the count of complete rows that we were able to build

        - Time Complexity:

            - Let 'k' be the largest value which satisfies the following condition: ( n - 1 - 2 - 3 ... - (k-1) ) >= k.

            - Rearranging the condition, we get: (1 + 2 + 3 + ... + k) <= n -> k(k+1)/2, where k represents the number of
              iterations the above algorithm will execute.

            - Considering, k will be an integer representing the number of complete rows that can be built using 'n' coins,
              we can solve: (k)(k+1)/2 = n to get the value of k.

            - Solving: - (k)(k+1)/2 = n
                       - k^2 + k - 2n = 0
                       - k = (-1 + sqrt(1+8n))/2

            - Considering, k is of the order sqrt(n), time complexity = O(sqrt(n)).

        - Space Complexity: O(1).

    - Mathematical Approach:

        - Use the following equation: k = (-1 + sqrt(1+8n))/2 to get the number of complete rows we can build using 'n' coins.

        - Time Complexity: O(1).

        - Space Complexity: O(1).

        - NOTE: (1+8n) can lead to wrong output for large values of n in Java (due to integer range out-of-bound issue).

*/

public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1+8*n)) / 2);
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
