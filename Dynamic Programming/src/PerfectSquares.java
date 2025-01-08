
/*

    Problem Statement: Given an integer 'n', return the least number of perfect square numbers that sum to 'n'.

    General Observations:

        - Similar to the coin change problem, where the denominations are the perfect squares (squares of integers) <= 'n'.

        - Recursive Approach:

            - Hypotheses:
                - F(n) will return the minimum number of perfect squares <= 'n' that sum up to 'n'.

            - Recursive Steps:
                - minCount = Infinity; // assume it is impossible to achieve sum = 'n' with perfect squares less than 'n'
                - for each perfectSquare <= n:
                    - count = F(n-perfectSquare);
                    - if count != Infinity: minCount = min(minCount, count+1);
                - return minCount;

            - Base Conditions:
                - if n == 0: return 0; no perfect squares needed to achieve sum = 0.

            - Space Complexity Analysis:

                - Each recursive call reduces 'n' by at least 1 (smallest perfect square is 1). At max 'n' recursive
                  calls will exist in the recursive call stack simultaneously.

                - Hence, Space Complexity: O(n).

            - Time Complexity Analysis:

                - The time complexity is dependent on the total number of operations, which is dependent on the total
				  number of sub-problems.

				- Time Complexity = ??

	        - Time-Based Optimizations:

	            - Store the results of already-solved sub-problems in a cache (e.g., a map or an array) and reuse them
			      when the same sub-problem is encountered again.

			    - There is one unique sub-problem for each 'n' (from 0 to 'n').

			    - For each 'kth' sub-problem (0 <= k <= n), we will consider sqrt(k) perfect squares. Hence, total
			      operations performed = sqrt(0) + sqrt(1) + sqrt(2) + sqrt(3) + ... + sqrt(n) ~= n.sqrt(n) (for large n)

			    - Reduced Time Complexity: O(n._/n).

        - Iterative Approach:

            - Use iteration to fill the cache from bottom-to-top, i.e., from 'n' = [1, n].

            - Algorithm:

                // Base Conditions:
                - memo[0] = 0; // no perfect squares needed to achieve sum = 0.

                // Filling cache from bottom-to-top
                - for i = [1, n]:
                    - minCount = Infinity; // assume it is impossible to achieve sum = 'i' with perfect squares <= 'i'
                    - for each perfectSquare <= i:
                        - count = memo[i-perfectSquare];
                        - if count != Infinity: minCount = min(minCount, count+1);

            - Time Complexity: O(n._/n).

            - Space Complexity: O(n).

*/

import java.net.Inet4Address;

public class PerfectSquares {

    public static int numSquares(int n) {

        int[] memo = new int[n+1]; // by default, base condition: memo[0] = 0 is already fulfilled.

        for(int i=1; i<=n; i++) {
            memo[i] = Integer.MAX_VALUE; // assume it is impossible to achieve sum = 'i' with perfect squares <= 'i'
            for(int j=1; j*j<=i; j++) {
                int count = memo[i-j*j];
                if(count != Integer.MAX_VALUE) memo[i] = Math.min(memo[i], count + 1);
            }
        }

        return memo[n];

    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

}
