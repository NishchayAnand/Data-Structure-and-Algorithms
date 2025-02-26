package Feb_23_2025;

/*

    Problem Statement:

        - You are given a string s consisting of digits. Perform the following operation repeatedly until the string has
          exactly two digits:

        - For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of
          the two digits modulo 10. Replace s with the sequence of newly calculated digits, maintaining the order in
          which they are computed.

        - Return true if the final two digits in s are the same; otherwise, return false.

    General Observations:

        - The below solution is not optimized. Think about an optimized solution.

*/

public class CheckIfDigitsEqualOperationI {

    private static String modify(String str) {
        int n = str.length();
        StringBuilder modified = new StringBuilder();
        for(int i=0; i<n-1; i++) {
            int ch = (str.charAt(i) - '0' + str.charAt(i+1) - '0') % 10;
            modified.append(ch);
        }
        return modified.toString();
    }

    public static boolean hasSameDigits(String s) {
        int n = s.length();
        String str = s; // will str be copy of s?
        for(int i=1; i<=n-2; i++) {
            str = modify(str); // will this modify s or not?
        }
        return str.charAt(0) == str.charAt(1);
    }

    public static void main(String[] args) {
        String s = "3902";
        System.out.println(hasSameDigits(s));
    }

}
