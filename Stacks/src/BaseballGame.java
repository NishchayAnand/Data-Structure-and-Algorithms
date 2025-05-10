
/*

    Problem Statement:

        - You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start
          with an empty record.

        - You are given a list of strings operations, where operations[i] is the ith operation you must apply to the
          record and is one of the following:

                - 'x': Record a new score of x.
                - '+': Record a new score that is the sum of the previous two scores.
                - 'D': Record a new score that is the double of the previous score.
                - 'C': Invalidate the previous score, removing it from the record.

        - Return the sum of all the scores on the record after applying all the operations.

    Example:

        - Input: ops = ["5","2","C","D","+"]

        - Output: 30

        - Explanation:
            - "5" -> Add 5 to the record, record is now [5].
            - "2" -> Add 2 to the record, record is now [5, 2].
            - "C" -> Invalidate and remove the previous score, record is now [5].
            - "D" -> Add 2 * 5 = 10 to the record, record is now [5, 10].
            - "+" -> Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
                  -> The total sum is 5 + 10 + 15 = 30.

    General Observations:

        - Do we need to handle invalid inputs, e.g., if the 'ops' start with "C", "D" or "+"?
        - No, we can assume that the input is always well-formed.

    Basic Intuition:

        - Each operation either adds a new score, modifies the previous score, or removes them. We need a data structure
          to track of the valid scores as we iterate over the 'ops' array and process each operation.

    Brute Force Approach - Using Stacks:

        - We can use a Stack to keep track of the valid scores as we iterate over the 'operations' array and process each
          operation.

        - Algorithm:
            - stack = [];
            - for each operation in operations:
                - if operation == "C": if stack is not empty: stack.pop();
                - if operation == "D": stack.push( stack.peek() * 2 );
                - if operation == "+":
                    - top = stack.pop();
                    - element = top + stack.peek();
                    - stack.push(top);
                    - stack.push(element);
                - else: stack.push( operation.toInt() );
            - return stack.sum();

        - Time Complexity:
            - We are primarily iterating over the 'operations' array and performing push / pop operations on the stack.
              Hence, overall time complexity = O(n).

        - Space Complexity:
            - In the worst-case scenario, i.e., when all elements in 'operations' array are integer, the stack will
              store 'n' elements simultaneously. Hence, overall space complexity = O(n).

*/

import java.util.Stack;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(String operation : operations) {
            switch (operation) {
                case "C" -> {
                    if (!stack.isEmpty()) stack.pop();
                }
                case "D" -> {
                    int top = stack.peek();
                    stack.push(top * 2);
                }
                case "+" -> {
                    int top = stack.pop();
                    int element = stack.peek() + top;
                    stack.push(top);
                    stack.push(element);
                }
                default -> stack.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) sum+= stack.pop();

        return sum;

    }

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

}
