
/*

    Problem Statement: Given an integer 'n', generate all combinations of pairs of well-formed
                       parentheses.

    General Observations:

        - Task is to find different ways of filling '2n' spaces with '(' and ')' such that all
          combinations have the correct parentheses sequence.

        - For each space, we have 2 choices:
            (i) place an opening parentheses if opening_parentheses_count > 0.
           (ii) place a closing parentheses if closing_parentheses_count > opening_parentheses_count.

        - The problem is naturally recursive in nature, i.e., we only need to fill the space
          under-consideration with a valid parentheses and trust the recursive function to do the
          same for the remaining spaces.

        - Hypotheses:

            - F(openParenthesesCount, closeParenthesesCount, combination, combinations) will add
              all possible combinations to 'combinations'.

        - Recursive Steps:

            // place an opening parentheses
            - if openParenthesesCount > 0:
                - combination.append("(");
                - F(openParenthesesCount-1, closeParenthesesCount, combination, combinations)
                - combination.removeLast();

            // place a closing parentheses
            - if closeParenthesesCount > openParenthesesCount:
                - combination.append(")");
                - F(openParenthesesCount, closeParenthesesCount-1, combination, combinations)
                - combination.removeLast();

            NOTE:

                - We don't need to perform combination.removeLast(): During each recursive call, we
                  directly overwrite the position 'index' in the 'combination' with either '(' or ')'.
                  Since 'combination' is reused for every path in the recursion tree, no "stale"
                  values persist as they are replaced in subsequent calls.

        - Base Conditions:

            - if openParenthesesCount = closeParenthesesCount = 0, i.e., all '2n' spaces have been filled:
                - combinations.add(combination.clone());

        - Time Complexity Analysis:

            - ??

        - Space Complexity Analysis:

            - Maximum auxiliary space consumed by the recursive stack would be '2n', hence,
              Space Complexity = O(n).

*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static void getAllCombinations(int openCount, int closeCount, int index,
                                           char[] combination, List<String> combinations) {

        if(openCount == 0 && closeCount == 0){
            combinations.add(new String(combination));
            return;
        }

        if(openCount>0) {
            combination[index] = '(';
            getAllCombinations(openCount-1, closeCount, index+1, combination, combinations);
        }

        if(closeCount > openCount) {
            combination[index] = ')';
            getAllCombinations(openCount, closeCount-1, index+1, combination, combinations);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        char[] combination = new char[2*n];
        getAllCombinations(n, n, 0, combination, combinations);
        return combinations;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
