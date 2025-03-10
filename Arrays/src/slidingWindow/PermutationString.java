package slidingWindow;

/*

    Problem Statement:

        - Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

        - For Example: s1 = "ab", s2 = "eidbaooo", then output: true ("ba" in s2 is a permutation of s1).

    General Observations:

        - Frequency maps of two permutations are the same.

        - Brute Force Approach:

            - Iterate over each possible substrings of s2 having length = size(s1) and return true if the frequency map
              of any substring matches the frequency map of s1, or false otherwise.

            - Algorithm:
                - let m = s1.length() and n = s2.length();
                - loop from i = [0, n-m] to iterate over starting characters of all valid substrings in 's2':
                    - let substring = s[i, i+m);
                    - if the frequency map of substring = the frequency map of s1: return true;
                - return false;

            - Time Complexity:
                - For each ith iteration, we are generating a frequency map of substring of length = m.
                - Hence, time complexity = O(n*m).

            - Space Complexity: O(m).

            - Redundant Operations:
                - For each substring, we are recalculating the frequency map from scratch, i.e., performing O(m) operation
                  repeated for each window in s2.

        - The problem involves exploring all windows (substrings) of length = size(s1).

        - Sliding Window Approach:

            - Use two pointers (left and right) to track a moving window representing the substrings of size = s1.length()
              inside s2. Instead of recalculating the frequency map for each substring from scratch, dynamically update
              the frequency map as the window slides forward.

            - NOTE: Since we are dealing with strings containing lowercase English letters, we can efficiently represent
                    character frequency maps using an array of size 26 instead of a HashMap.

            - Algorithm:
                - m = s1.length(), n = s2.length(), left = 0, right = 0;
                - freqMap = [26], pre-populated to represent the frequency map of s1;
                - windowFreqMap = [26], to maintain frequency map of each window while sliding across s2;
                - loop from right = [0, n) to slide across s2:
                    - if right - left + 1 > m:
                        - windowFreqMap[s[left]]--;
                        - left++;
                    - windowFreqMap[s[right]]++;
                    - if freqMap == windowFreqMap: return true;
                - return false;

            - Time Complexity: O(n).

            - Space Complexity: O(26) ~ O(1).

*/

import java.util.Arrays;

public class PermutationString {

    public static boolean checkInclusion(String s1, String s2) {

        int m = s1.length(), n = s2.length();

        int[] freqMap = new int[26];
        // pre-populate freqMap to represent the frequency map of s1
        for(char ch: s1.toCharArray()) freqMap[ch-'a']++;

        int[] windowFreqMap = new int[26]; // maintain the frequency map of each window while sliding across s2

        int left = 0;
        for(int right = 0; right < n; right++) {
            if(right - left + 1 > m) windowFreqMap[s2.charAt(left++) - 'a']--;
            windowFreqMap[s2.charAt(right) - 'a']++;
            if(Arrays.equals(freqMap, windowFreqMap)) return true;
        }

        return false;

    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2)); // output: true
    }
}
