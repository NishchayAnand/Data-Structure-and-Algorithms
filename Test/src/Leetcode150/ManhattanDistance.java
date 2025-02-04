package Leetcode150;

/*

    Maximum Manhattan Distance After k Changes

    You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:

'N' : Move north by 1 unit.
'S' : Move south by 1 unit.
'E' : Move east by 1 unit.
'W' : Move west by 1 unit.
Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.

Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManhattanDistance {

    private static int calculateDistance(String s) {
        int x = 0, y = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'N') y++;
            else if (ch == 'S') y--;
            else if (ch == 'E') x++;
            else if (ch == 'W') x--;
        }
        return Math.abs(x) + Math.abs(y);
    }

    private static int helper(String s, int index, int k) {
        if (index == s.length() || k == 0) {
            return calculateDistance(s);
        }

        int maxDistance = helper(s, index + 1, k); // No change
        StringBuilder str = new StringBuilder(s);
        for (char ch : new char[]{'N', 'S', 'E', 'W'}) {
            if (s.charAt(index) != ch) { // Try changing it
                str.setCharAt(index, ch);
                maxDistance = Math.max(maxDistance, helper(str.toString(), index + 1, k - 1));
            }
        }
        return maxDistance;
    }

    public static int maxManhattanDistance(String s, int k) {
        return helper(s, 0, k);
    }

    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        System.out.println(maxManhattanDistance(s, k)); // Output: 3
    }

}
