
/*

    Problem Statement: A message containing letters from A-Z is encoded using the following mapping:

                        - 'A' -> "1"
                        - 'B' -> "2"
                        - .
                        - .
                        - .
                        - 'Z' -> "26"

                       Given a string 's' containing only digits, return the total number of ways to decode it.

    General Observations:

        - For each character in the input string, there are up to two choices for how to decode it:
            - As a single digit (e.g., 1 -> A, 2 -> B, ..., 9 -> I).
            - As a two-digit number, if it forms a valid number between 10 and 26 (e.g., 10 -> J, 11 -> K, ..., 26 -> Z).

        - We need to explore all possible ways to split the input string into combinations of substrings, where each
          substring is either a valid single-digit number (1-9) or a valid two-digit number (10-26).

        - The problem is naturally recursive in nature.

        - A string starting with 0 is an invalid string, i.e., there are 0 ways to decode it.

        - There is 1 way to decode an empty string (""), i.e., do nothing.

        - Recursive Approach:

            - Hypotheses:
                - F(s, n) will return the number of ways to decode the first 'n' characters of 's'.

            - Recursive Steps:

                // Option 1: Take the current character as single digit
                - waysWithCurrentCharacterAsSingleDigit = F(s, n-1);

                // Option 2: Take the current character and its previous character as a pair
                - waysWithCurrentCharacterPairedWithPreviousCharacter = 0;
                - if n-1 != 0 (previous character exists) and s.substring()
                - F(s, n-2);

            - Base Conditions:
                - if s[n-1] == '0': return 0;



*/

public class DecodeWays {
}
