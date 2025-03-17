package slidingWindow;

/*

    Problem Statement:

        - Given a string 's' and an integer 'k', you can replace at most 'k' character in 's' with any uppercase letter.

        - Return the length of the longest substring containing the same letter above performing at most 'k' replacements.

    General Observations:

        - Basic Intuition: Explore all substrings where you can replace at most k characters to make all the characters
                           the same and keep track of the longest one.

        - Brute Force Approach:

            - Use nested loop to iterate over each possible substring and keep track of the longest substring where you
              can replace at most k characters to make all the characters the same.

            - Algorithm:
                - maxLength = 0;
                - Loop from i = [0, n-1] to explore all starting indices:
                    - Loop from j = [i, n-1] to explore all possible ending indices for substrings starting at s[i]:
                        - if (length of substring s[i:j] - count of most frequently occurring character) <= k:
                            - maxLength = max(maxLength, length of substring s[i:j]);
                - return maxLength;

            - Time Complexity: O(n^2).

            - Space Complexity Analysis: We can use a HashMap or an array of size 26 to efficiently track character
                                         frequencies for each substring window. Thus, total space complexity will be
                                         O(26) ~ O(1).

        - Redundant Operations: If substring s[i,j] represents the longest possible substring starting from s[i], then
                                any substring starting from a later index s[i+k, j] where i < k ≤ j will be shorter and
                                is therefore redundant to explore separately.

        - Sliding Window Approach:

            - Use two pointers (left and right) to define a substring window that expands right while valid (replacements ≤ k)
              and shrinks left only when replacements exceed k.

            - NOTE: Removing just one character from the left is enough to make the window valid again.

            - Algorithm:
                - Initialize the current substring window (left = 0, right = 0);
                - While the current substring window remains in bound (right < n):
                    - Increase the frequency of character at index = 'right' by 1;
                    - Update the most frequent character in the current window;
                    - Check if s[left:right] is a valid substring (replacements ≤ k):
                        - Update the length of the longest substring where you can replace at most k characters to make
                          all the characters the same;
                        - Expand the current window towards right by 1;
                    - Else:
                        - Decrease the frequency of character at index = 'left by 1;
                        - Shrink the current window from left by 1;
                        - Expand the current window towards right by 1; // IMPORTANT - otherwise character at index = 'right'
                                                                                       would be processed twice.
                - Return the length of the longest substring;

            - Time Complexity Analysis: In the worst-case scenario (string containing unique characters and k = 1), each
                                        character would be visited twice (first time by the right pointer and later by the
                                        left pointer). Thus, total time complexity will be O(2n) ~ O(n).

            - Space Complexity: O(26) ~ O(1).

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

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength = 0, maxFreq = 0, left = 0;
        int[] freqMap = new int[26];

        for(int right=0; right<n; right++) {
            maxFreq = Math.max(maxFreq, ++freqMap[s.charAt(right) - 'A']);
            int currWindowLength = right - left + 1;
            if ( currWindowLength - maxFreq > k ) {
                freqMap[s.charAt(left) - 'A']--;
                left++;
            } else {
                maxLength = Math.max(maxLength, currWindowLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s,k));
    }
}
