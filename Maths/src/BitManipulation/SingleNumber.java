package BitManipulation;

/*

    Problem Statement: Given a non-empty array of integers nums, every element appears twice except for one. Find that
                       single one.

    General Observations:

        - Brute Force Approach:

            - Use a HashMap to create a frequency map and the integer whose frequency is 1.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

       - XOR properties: XOR(0, 0) = 0 and XOR(0,1) = 1.

       - XORing two identical numbers results in 0, i.e., a ^ a = 0.

       - XORing any number with 0 results in the number itself, i.e., a ^ 0 = a.

       - XOR is commutative and associative, meaning the order of XOR operations doesn't matter.

       - Optimized Approach:

            - Loop over the 'nums' array and store the XOR of every num in a variable. The value in the variable
              at the end of the iteration would be the number which only appeared once.

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class SingleNumber {

    private static int singleNumber(int[] nums) {
        int output = 0; // XOR(n,0) = 0
        for(int num: nums) {
            output = output^num;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1}; // output = 1
        System.out.println(singleNumber(nums));
    }
}
