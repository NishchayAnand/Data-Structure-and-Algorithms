
/*

    Problem Statement: Given a stack consisting of 'N' integers, sort it in descending order.

                       NOTE: You are not allowed to use any other data structure.

    General Observations:

        - Sorting a stack is naturally recursive in nature, i.e., you trust the recursive function
          to sort the (n-1) elements in the stack, and you only worry about adding the 'nth' (top)
          element at the correct position in the sorted stack.

        - Hypotheses: F(stack, n) will sort the 'n' integers in stack.

        - Recursive Steps:

            - top = stack.pop();
            - F(stack, n);
            - insertAtPosition(stack, top);

        - Base Conditions:

            - if n == 1, i.e., stack with 1 element is always sorted:
                - return;

        - Time Complexity: O(n^2).

        - Space Complexity: O(n).

*/

import java.util.Stack;

public class SortStack {

    private static void insertAtPosition(Stack<Integer> stack, int num) {
        if(!stack.isEmpty() && num < stack.peek()) {
            int top = stack.pop();
            insertAtPosition(stack, num);
            stack.push(top);
        } else {
            stack.push(num);
        }
    }

    public static void sortStack(Stack<Integer> stack) {
        if(stack.size() == 1) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertAtPosition(stack, top);
    }

    public static void main(String[] args) {
        int[] input = {3,-7,9,-2,5};
        Stack<Integer> stack = new Stack<>();
        for(int num: input) stack.push(num);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }
}
