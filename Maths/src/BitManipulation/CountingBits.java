package BitManipulation;

/*

    Problem Statement: Given an integer n, return an array ans of length 'n + 1' such that for each i (0 <= i <= n),
                       ans[i] is the number of 1's in the binary representation of i.

    General Observations:

        - Brute Force Approach:

              - Iterate over all integers in the range [1, n] and calculate the number of set bits in their binary
                representation.

              - Time Complexity: O(nlogn).

              - Space Complexity: O(1).

       -


*/

public class CountingBits {

    public static int getSetBits(int n) {
        int count = 0;
        while(n>0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int[] countBitsBruteForce(int n) {
        int[] output = new int[n+1];
        for(int i=0; i<=n; i++) {
            output[i] = getSetBits(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = countBitsBruteForce(n);
        for(int count: ans){
            System.out.print(count + " ");
        }
    }

}
