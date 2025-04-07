
/*

    Problem Statement:

        - Given a non-negative integer 'x', return the square root of x rounded down to the nearest integer.

    General Observations:

        Q. What do you understand by the problem statement?
        A. We need to find the floor of the square root of x.

        Q. What should be the output of the following input: x = 0?
        A. Output = 0.

        Q. What's the range of x?
        A. x can be any non-negative integer value ranging between [0, 2^31 - 1].

    Brute Force Approach:

        - Explore all integers 'i' in the range: [1, x) and return the largest integer which satisfies the following
          condition: (i * i <= x).

        - Algorithm:
            - if x == 0: return 0; // base condition
            - run loop for i in range: [1, x):
                - if i * i > x: return (i-1);

        - Time Complexity: We will find the required answer in the first [1:sqrt(x)] integers. Hence, time complexity = O(sqrt(x)).

        - Space Complexity: O(1).

    Binary Search Approach:

        - Considering the required result lies in the range: [1, x), we can use binary search on the search space: [1, x)
          to find the largest integer: mid where (mid * mid <= x).

        - Algorithm:
            - if x == 0: return 0; base condition
            - result = 1;
            - low = 1, high = num;
            - while low <= high:
                - mid = (low + high) / 2;
                - if mid * mid > x: high = mid - 1 to shrink the search space from right to ignore integers > mid;
                - else if mid * mid <= x:
                    - result = mid;
                    - left = mid + 1 to shrink the search space from left to ignore integers < mid;
            - return result;

        - Time Complexity: The search space is getting reduced to half in each iteration. Hence, time complexity = O(logn).

        - Space Complexity: O(1).

        - NOTE: For large values of x, mid * mid can overflow and give you the wrong results in languages like Java. Convert
                the data type of mid from int to long to allow multiplication to happen safely.

*/

public class SqrtX {

    public static int mySqrt(int x) {

        if(x == 0) return 0; // base condition

        int result = 1;
        long low = 1, high = x;
        while(low <= high) {
            long mid = (low + high) / 2;
            if(mid*mid > x) high = mid - 1;
            else { // mid * mid <= x
                result = (int) mid;
                low = mid + 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(8));
    }

}
