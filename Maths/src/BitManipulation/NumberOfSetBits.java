package BitManipulation;

/*

    Problem Statement: Write a function that takes the binary representation of a positive integer and returns the number
                       of set bits it has (also known as the Hamming weight).

    General Observations:

        - Brute Force Approach:

            - Divide the input 'n' by 2 and capture the remainder till 'n' becomes 0.

            - Time Complexity: O(logn) -> O(32) in worst case scenario -> O(1).

            - Space Complexity: O(1).

       - The brute force approach will explore all remainders, whether they are 0 or 1.
       
       - Bitwise AND between n and (n-1) flips the least significant set bit (the rightmost 1 in the binary
         representation) to 0.

       - Optimized Approach:

            - Take bitwise AND between n and (n-1) to flip the least significant set bit of n to 0. Repeat until n
              becomes 0.

*/

public class NumberOfSetBits {

    private static int hammingWeightBruteForce(int n) {
        int count = 0;
        while(n>0) {
            count += n%2;
            n = n >> 1; // right shifting n by 2 is equivalent to dividing n by 2.
        }
        return count;
    }

    private static int hammingWeight(int n) {
        int count = 0;
        while(n>0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 11; // binary representation = 1011.
        System.out.println(hammingWeightBruteForce(num));

    }
}
