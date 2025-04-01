
/*

    Given: Given a positive integer 'num'.

    Required Output: Return true if num is a perfect square or false otherwise.

    NOTE: You must not use any built-in library function, such as sqrt.

    General Observations:

        - For any integer i, if i*i = num, then num is a perfect square.

        - Brute Force Approach:

            - Loop from i = [1, i*i<=num] and check if i*i == num.

            - Time Complexity: O(sqrt(n)).

            - Space Complexity: O(1).

       - The square root of any perfect square 'num' is <= num/2 (sqrt(4) == 4/2 = 2).

       - Binary Search Approach:

            - Use binary search algorithm to search for mid (s.t. mid*mid = num) in the search space
              [1,num/2].

            - Time Complexity: O(logn).

            - Space Complexity: O(1).

            - NOTE:

                 - When calculating mid = (start+end)/2, mid can exceed the maximum value that an int
                   can hold, which is 2^31 - 1 (approximately 2.1 billion). Therefore, use:

                                        mid = start + (end-start)/2;

                 - When calculating mid * mid, the result can exceed the maximum value and give a
                   negative result, which will incorrectly suggest that mid*mid is smaller than num.
                   To avoid this overflow, you should use a long data type for storing the result of
                   mid * mid.

*/

public class ValidPerfectSquare {

    private static boolean isPerfectSquareBruteForce(int num) {
        int i = 1;
        while(true) {
            if(i*i == num) return true;
            else if(i*i > num) break;
        }
        return false;
    }

    private static boolean isPerfectSquare(int num) {

        if(num==1) return true;

        int start = 1;
        int end = num/2;

        while(start<=end) {

            int mid = start + (end-start)/2;
            long square = (long) mid*mid;

            if(square == num) return true;
            else if(square < num) start = mid+1;
            else end = mid-1; // square > num

        }

        return false;

    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));
    }
}
