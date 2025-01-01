
/*

    Problem Statement: A message containing letters from A-Z is encoded using the following mapping:

                        - 'A' -> "1"
                        - 'B' -> "2"
                        - .
                        - .
                        - .
                        - 'Z' -> "26"

                       Given a string 's' containing only digits, return the total number of ways to decode it.

                       NOTE: 1 <= s.length() <= 100

    General Observations:

        - For each character in the input string, there are up to two choices for how to decode it:
            - As a single digit, if it forms a valid number between 1 and 9 (e.g., 1 -> A, 2 -> B, ..., 9 -> I).
            - As a two-digit number, if it forms a valid number between 10 and 26 (e.g., 10 -> J, 11 -> K, ..., 26 -> Z).

        - We need to explore all possible ways to split the input string into combinations of substrings, where each
          substring is either a valid single-digit number (1-9) or a valid two-digit number (10-26).

        - The problem is naturally recursive in nature.

        - Recursive Approach:

            - Hypotheses:
                - F(s, n) will return the number of ways to decode the first 'n' characters of 's'.

            - Recursive Steps:

                // Option 1: Take the current character as single digit
                - waysCurrentCharacterAsSingleDigit = 0;
                - if s[n-1] != '0': // 0 is an invalid substring
                    - waysCurrentCharacterAsSingleDigit = F(s, n-1);

                // Option 2: Take the current character and its previous character as a pair
                - waysCurrentCharacterPairedWithPreviousCharacter = 0;
                - if n-1 != 0 and s.substring(n-2, n) >= 10 and s.substring(n-2, n) <= 26:
                    - waysCurrentCharacterPairedWithPreviousCharacter = F(s, n-2);

                - return waysCurrentCharacterAsSingleDigit + waysCurrentCharacterPairedWithPreviousCharacter;

            - Base Conditions:
                - if n == 0: return 1; // there's only 1 way to decode an empty string (""), i.e., do nothing.

            - Time Complexity: O(2^n) -> refer climbingStairs time complexity analysis

            - Space Complexity: O(n).

        -  Many sub-problems are solved multiple times in the above recursive approach.

        - Memoization Approach:

            - We can store the results of previously computed sub-problems in a cache (e.g., a map or an array). This
              would allow us to reuse the result of previously computed sub-problems instead of recalculating it.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - In the memoized solution, the cache is getting filled while backtracking from n = [1, n].

        - Iterative Approach:

            - Use iteration to fill the cache (or memoization array) from the smallest sub-problems F(1) to F(n).

            - Algorithm:

                // Base Conditions:
                - memo[0] = 1; // there's 1 way to decode an empty string (""), i.e., do nothing.

                // Backtracking:
                - for i = [1, n]:

                     current = 0;

                    // Option 1: Take the current character as single digit
                    - if s[i-1] != '0': // 0 is an invalid substring
                        - current += mem[i-1];

                    // Option 2: Take the current character and its previous character as a pair
                    - if i-1 != 0 and s.substring(i-2, i) >= 10 and s.substring(i-2, i) <= 26:
                        - current += memo[i-2];

                    - memo[i] = current;

                - return memo[n];

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - For n>=2, F(n) is only dependent on the last two computed values: F(n−1) & F(n−2).

        - Optimized Iterative Approach:

            - In the iterative approach, rather than maintaining an entire array, just maintain two variables to store
              the last two results.

            - NOTE: There is only 1 way to decode a single non-zero character (1-9).

            - Algorithm:

                // Base Conditions:
                - if s[0] == '0': return 0;
                - second_last = 1; // memo[0] = dp[n-2]
                - last = 1;        // memo[1] = dp[n-1]

                // Backtracking:
                for i = [2, n]:

                    - current = 0;

                    // Option 1: Take the current character as single digit
                    - if s[i-1] != '0': // 0 is an invalid substring
                        - current += mem[i-1];

                    // Option 2: Take the current character and its previous character as a pair
                    - if i-1 != 0 and s.substring(i-2, i) >= 10 and s.substring(i-2, i) <= 26:
                        - current += memo[i-2];

                    - second_last = last;
                    - last = current;

                return last; // memo[n]

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class DecodeWays {

    private static int helper(String s, int n, int[] memo) {

        // Base Conditions:
        if (n == 0) return 1; // there's only 1 way to decode an empty string (""), i.e., do nothing.

        // RecursiveSteps:

        if (memo[n] != -1) return memo[n];

        // Option 1: Take the nth character as single digit
        int waysAsSingleDigit = 0;
        int singleDigit = s.charAt(n-1) - '0';
        if (singleDigit != 0) waysAsSingleDigit = helper(s, n-1, memo);

        // Option 2: Take the nth character and (n-1)th character (if exists) as a pair
        int waysAsDoubleDigitNumber = 0;
        if (n-1 != 0) {
            int doubleDigitNumber = Integer.parseInt(s.substring(n-2,n));
            if(doubleDigitNumber >= 10 && doubleDigitNumber <= 26) waysAsDoubleDigitNumber = helper(s, n-2, memo);
        }

        return waysAsSingleDigit + waysAsDoubleDigitNumber;

    }

    public static int numDecodingsMemoized(String s) {
        int n = s.length();
        int[] memo = new int[n+1];
        for(int i=0; i<=n; i++) memo[i] = -1;
        return helper(s, n, memo);
    }

    public static int numDecodingsIterative(String s) {

        // Base Conditions:
        if (s.charAt(0) == '0') return 0;
        int second_last = 1;
        int last = 1;

        // Backtracking
        int n = s.length();
        for(int i=2; i<=n; i++) {

            int current = 0;

            // Option 1: Take the current character as single digit
            int singleDigit = s.charAt(i-1) - '0';
            if(singleDigit != 0) current += last;

            // Option 2: Take the ith character and (i-1)th character (if exists) as a pair
            int doubleDigitNumber = Integer.parseInt(s.substring(i-2,i));
            if(doubleDigitNumber >= 10 && doubleDigitNumber <= 26) current += second_last;

            second_last = last;
            last = current;

        }

        return last;

    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(numDecodingsIterative(s));
    }
}
