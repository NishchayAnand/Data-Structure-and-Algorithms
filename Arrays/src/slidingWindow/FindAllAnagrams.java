package slidingWindow;

/*

    Problem Statement:

        - Given two strings s and p, return an array of all the start indices of p's anagrams in s.

        - NOTE:

            - An anagram is a word or phrase formed by rearranging the letters of another word or phrase, using all
              the original letters exactly once. For example, "ohlle" is an anagram of "hello".

            - You may return the answer in any order.

        - Sample Input: s = "c b a e b a b a c d", p = "a b c", output = [0,6] (0: "c b a"; 6: "b a c")
                             0 1 2 3 4 5 6 7 8 9        0 1 2                      0 1 2       6 7 8

    General Observations:

        - An anagram must have the same length and contain the same characters with the same frequency (i.e., the
          frequency maps of the original string and the anagram must be identical).

        - Brute Force Approach:

            - Iterate over all possible substrings of s having length = p.length() and check if the frequency map of
              the substring under-consideration matches the frequency map of p.

            - Algorithm:
                - m = p.length(), n = s.length();
                - p_freq_map = frequency map of p;
                - loop from i = [0, n-m] to iterate over all possible starting indexes of substrings of s having length = m:
                    - substring = s[i, i+m);
                    - if substring_freq_map = p_freq_map: result.add(i);
                - return result;

            - Time Complexity:
                - We are iterating + generating a frequency map of all possible substrings of s having length = m.
                - Hence, time complexity = O(n*m).

            - Space Complexity: O(m).

            - Redundant Operations:
                - We are generating the frequency map of each substring of s having length = m from scratch, i.e.,
                  performing O(m) operation repeatedly for every possible substring in s.

        - The problem involves sliding across every possible substring of s having length = m.

        - Sliding Window Approach:

            - Use two pointers (left and right) to iterate over all possible substrings of s of length = m and dynamically
              update the frequency map of each substring (window) while sliding across s.

            - NOTE: Since we are dealing with strings containing lower case letters only, we can represent the frequency
                    maps using an array of size 26 instead of a HashMap.

            - Algorithm:
                - m = p.length, n = s.length, left = 0, right = 0;
                - p_freq_map = [26], pre-populated to represent the frequency map of p;
                - window_freq_map = [26], to maintain frequency of each window while sliding across s;
                - while right < n:
                    - add s[right] to the current window by incrementing its frequency in window_freq_map;
                    - if length of the current window, i.e., (right - left + 1) > m:
                        - remove s[left] from the current window by decrementing its frequency in window_freq_map;
                        - do left++ to reduce the length of the current window to m;
                    - if p_freq_map == window_freq_map: result.add(left);
                    - do right++;
                - return result;

            - Time Complexity: O(n).

            - Space Complexity: O(m).

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int m = p.length(), n = s.length();
        if(m > n) return result;

        int[] freqMap = new int[26];
        int[] windowFreqMap = new int[26];

        // pre-populate freqMap (frequency map of p)and windowFreqMap (frequency map of the first substring of s having length = m)
        for(int i=0; i<m; i++) {
            freqMap[p.charAt(i)-'a']++;
            windowFreqMap[s.charAt(i)-'a']++;
        }

        // Check if the first substring of s having length = m is an anagram of p
        if(Arrays.equals(freqMap, windowFreqMap)) result.add(0);

        int left = 0;
        for(int right = m; right < n; right++) {
            windowFreqMap[s.charAt(left++)-'a']--;
            windowFreqMap[s.charAt(right)-'a']++;
            if(Arrays.equals(freqMap, windowFreqMap)) result.add(left);
        }

        return result;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
