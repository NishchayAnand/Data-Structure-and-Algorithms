package slidingWindow;

/*

    Problem Statement:

        - Given a string 's' and an integer 'k', you can replace at most 'k' character in 's' with any uppercase letter.

        - Return the length of the longest substring containing the same letter above performing at most 'k' replacements.

    General Observations:

        - Intuition:
            - Explore all substrings where you can replace at most k characters to make all the characters the same and
              keep track of the longest one.

        - Brute Force Approach:

            - Use nested loop to iterate over each possible substring and keep track of the longest substring where you
              can replace at most k characters to make all the characters the same.

            - Algorithm:
                - maxLength = 0;
                - Loop from i = [0, n-1] to explore all possible starting indices:
                    - Loop from j = [i, n-1] to explore all possible ending indices for substrings starting at s[i]:
                        - if (length of substring s[i:j] - count of most frequently occurring character) <= k:
                            - maxLength = max(maxLength, length of substring s[i:j]);
                - return maxLength;

            - Time Complexity: O(n^2).

            - Space Complexity Analysis:
                - We may need to use a hashMap or an array of size 26 to store the frequency of all the substrings
                  starting with each character s[i].
                - Thus, total space complexity will be O(26) ~ O(1).


*/

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacementBruteForce(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        for(int i=0; i<n; i++) {
            int[] freqMap = new int[26];
            int maxFreq = 0;
            for(int j=i; j<n; j++) {
                maxFreq = Math.max(maxFreq, ++freqMap[s.charAt(j) - 'A']);
                if ( (j-i+1) - maxFreq <= k) maxLength = Math.max(maxLength, j-i+1);
                else break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacementBruteForce(s,k));
    }
}
