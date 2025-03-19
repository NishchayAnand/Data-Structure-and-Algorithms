package slidingWindow;

/*

    Problem Statement:

        - Given two strings 's' and 't' of lengths m and n respectively, return the minimum window substring of 's' such
          that every character in t (including duplicates) is included in the window.

        - NOTE: If there is no such substring, return the empty string "".

        - Sample Input: s = "ADOBECODEBANC", t = "ABC"; Output: "BANC"

    General Observations:

        - The problem involves finding the smallest substring in 's' that contains all characters of 't' with their
          exact or greater count.

        - Brute Force Approach:

            - Use nested loop {i,j} to iterate over all substrings of 's' and keep track of the smallest substring that
              contains all characters of 't' with their exact counts.

            - Algorithm:
                - min_substring = "";
                - min_length = Infinity;
                - t_freq_map = {t};
                - loop from i = [0, n) to iterate over all starting indices:
                    - substring_freq_map = {};
                    - loop from j = [i, n) to iterate over all substrings starting at index i:
                        - substring_freq_map[s[j]]++;
                        - if substring_contains_t(substring_freq_map, t_freq_map) and min_length > (j-i+1):
                            - min_length = (j-i+1);
                            - min_substring = s[i,j]; (inefficient) -> takes O(n)
                            - break; (optimization) -> once we have found a substring s[i,j] which contains all
                                                       characters of 't', extending it further (i.e., considering
                                                       s[i, j+1], s[i, j+2], etc.) will only increase its length while
                                                       still satisfying the condition.
                - return min_substring;

            - Supplementary Algorithm:
                - substring_contains_t(substring_freq_map, t_freq_map):
                    - for each (ch,freq) in t_freq_map:
                        - if !substring_freq_map.contains(ch) or substring_freq_map.get(ch) < value: return false;
                    - return true;

            - Time Complexity:
                - In the worst case scenario, i.e., when 's' does not contain all characters of 't', the nested loop
                  will run n^2 iterations. For each iteration, substring_contains_t() will run a loop to iterate over
                  t_freq_map of size = m.
                - Hence, time complexity = O(n^2 * m).

            - Space Complexity:
                - The substring_freq_map will store at most store n characters simultaneously.
                - Hence, space complexity = O(n).

            - Redundant Operations:
                - Instead of computing "min_substring = s[i,j]" in every iteration, we can just track the starting index
                  and the length of the shortest valid substring.
                - The algorithm recomputes the entire frequency map from scratch to find valid substrings starting from
                  each starting index i.

        - Once we have identified a valid window s[i, j] starting at index = i, we don't need to recompute the frequency
          map for every possible starting index in (i, j]. We can adjust the frequency map dynamically by shrinking the
          window from the left (i++) to find the shortest valid substring within [i, j].

        - Sliding Window Approach:

            - Use two pointers (left, right) and a frequency map to expand the window (right++) until it contains all
              required characters, then shrink (left++) to find the shortest valid substring while maintaining the
              condition.

            - Algorithm:
                - min_start_index = 0;
                - min_length = Infinity;
                - t_freq_map = {t}; (precomputed frequency map of t)
                - window_freq_map = {};
                - left = 0, right = 0;
                - while right < n:
                    - window_freq_map[s[right]]++;
                    - while window_contains_t(window_freq_map, t_freq_map):
                        - if right - left + 1 < minLength:
                            - min_length = right - left + 1;
                            - min_start = left;
                        - window_freq_map[s[left]]--;
                        - left++;
                - return s.substring(min_start, min_start + min_length);

            - Time Complexity:
                - Each character of 's' would be processed at most twice (once when added to the window, once when removed from the window).
                - For each iteration, window_contains_t() will run a loop to iterate over t_freq_map of size = m.
                - Hence, time complexity = O(2 * n * m) ~= O(n * m).

            - Space Complexity:
                - In the worst-case scenario, i.e., when the entire string 's' does not contain all characters of 't', the
                  window_freq_map will store at most store 'n' characters simultaneously.
                - Hence, space complexity = O(n).

            - Redundant Operations:
                - The window_contains_t function iterates over m elements (characters in t) for each iteration.

            - Optimizations:
                - Instead of checking window_contains_t in each iteration, we maintain a matching count to track when we
                  have all required characters. This will reduce the time complexity to O(n).

*/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        // edge case: when s is shorter than t
        if(s.length() < t.length()) return "";

        // Create the frequency map for t and window substring
        Map<Character, Integer> tfreqMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // pre-populate the frequency map of t

        for(char ch: t.toCharArray()) tfreqMap.put(ch, tfreqMap.getOrDefault(ch, 0) + 1);

        // Initialize the sliding window
        int minLength = Integer.MAX_VALUE, minStartIndex = 0, left = 0;
        int required = tfreqMap.size(), matched = 0;
        for(int right=0; right<s.length(); right++) {

            // Increment the frequency of character at index = right to include it in the current window
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // check if rightChar completes a match
            if( tfreqMap.containsKey(rightChar) && windowMap.get(rightChar).equals(tfreqMap.get(rightChar)) ) matched++;

            // shrink the window while valid
            while( matched == required ) {

                // check for the minimum substring
                if( (right-left+1) < minLength ) {
                    minLength = (right-left+1);
                    minStartIndex = left;
                }

                // remove the leftmost character from the window
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar)-1);
                if( tfreqMap.containsKey(leftChar) && windowMap.get(leftChar) < tfreqMap.get(leftChar) ) matched--;

                // shrink the window
                left++;

            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStartIndex, minStartIndex + minLength);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));

    }
}
