package Leetcode150;

import java.util.HashMap;
import java.util.Map;

/*

You are given a string s consisting of lowercase English letters. Your task is to find the maximum difference between the
frequency of two characters in the string such that:

One of the characters has an even frequency in the string.
The other character has an odd frequency in the string.
Return the maximum difference, calculated as the frequency of the character with an odd frequency minus the frequency of
the character with an even frequency.

*/

public class MaxDiffEvenOddFrequency {

    public static int maxDifference(String s) {

        int minEvenFrequency = Integer.MAX_VALUE;
        int maxOddFrequency = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch: map.keySet()) {
            int freq = map.get(ch);
            if(freq%2==0) minEvenFrequency = Math.min(minEvenFrequency, freq);
            else maxOddFrequency = Math.max(maxOddFrequency, freq);
        }

        return maxOddFrequency - minEvenFrequency;

    }

    public static void main(String[] args) {
        String str = "aaaaabbc";
        System.out.println(maxDifference(str));
    }


}
