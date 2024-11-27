
/*

    Problem Statement: You are given an array of strings 'tokens' that represents an arithmetic
                       expression in a Reverse Polish Notation (a.k.a postfix notation). Evaluate the
                       expression and return an integer that represents the value of the expression.

                       NOTE:

                            - The valid operators are '+', '-', '*', and '/'.
                            - The division between two integers always truncates toward zero. For
                              example (-3/2) should truncate to 0.
                            - There will not be any division by zero.
                            - The input represents a valid arithmetic expression in a reverse polish
                              notation.

    General Observations:

        - Postfix notation, also known as Reverse Polish Notation (RPN), is a mathematical
          expression format in which operators follow their operands. For example, [1,2,+]
          represents expression (1+2).

        - Operators must act on the most recently encountered operands, and these operands must be
          stored until the operator is processed.

        - A stack, by its nature, allows us to keep track of the most recently added operands,
          enabling immediate access for the operator.

        - Algorithm:

            - Loop over each 'token' in 'tokens':
                - if token is not an operator:  - O(1)
                    - stack.push(token);        - O(1)
                - else:
                    - operand2 = stack.pop();   - O(1)
                    - operand1 = stack.pop();   - O(1)
                    - answer = applyOperation(operand1, operand2, token);   - O(1)
                    - stack.push(answer);   - O(1)
            - return stack.pop();

        - Time Complexity: O(n).

        - Space Complexity: ~ O(n).

*/

import java.util.Stack;

public class EvaluateReversePolishNotation {

    private static boolean isOperator(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    private static int applyOperation(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid Operator: " + operator);
        };
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if(isOperator(token)) {
                // Pop two elements
                int b = stack.pop();
                int a = stack.pop();
                int c = applyOperation(a, b, token);
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Result: " + evalRPN(tokens));
    }
}
