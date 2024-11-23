
/*

    Problem Statement: Reverse a given stack of 'N' integers using recursion.

    General Observations:

        - Reverse a stack is naturally recursive in nature, i.e., you trust the recursive function
          to reverse the (n-1) elements and only worry about adding the nth (top) element to the
          bottom of the reversed stack.

        - Hypothesis: F(stack, n) will reverse the 'n' integers in stack.

        - Recursive Steps:

            - top = stack.pop();
            - F(stack, n-1);
            - insertAtBottom(stack, top);

        - Base Conditions:

            - if n==0, i.e., stack is empty:
                - return;

        - Time Complexity Analysis:

            - let o(n) be the total number of operations performed by the above algorithm. Then,

                - o(n) = C (for popping nth element from top of stack in reverse) +
                         o(n-1) +
                         (n-1)*C (for popping (n-1) elements in insertAtBottom) +
                         C (for pushing nth element at the bottom of stack in base condition of insertAtBottom) +
                         (n-1)*C (for pushing (n-1) elements back in the stack in insertAtBottom)

                       = o(n-1) + 2*n*C

                - o(n-1) = o(n-2) + 2*(n-1)*C
                - o(n-2) = o(n-3) + 2*(n-2)*C
                - .
                - .
                - .
                - O(1) = O(0) + 2*1*C

                -> o(n) = 2*n*C + 2*(n-1)*C + 2*(n-2)*C + ... + 2*1*C.
                        = 2*C[n + (n-1) + (n-2) + ... + 1].
                        = C*n*(n+1)

            - Since, operations performed is of order n^2, Time Complexity = O(n^2).

        - Space Complexity Analysis:

            - Maximum auxiliary space used by both recursive stacks combined would be 'n'. Hence,
              Space Complexity = O(n).

*/

import java.util.Stack;

public class ReverseStack {

    private static void insertAtBottom(Stack<Integer> stack, int num) {
        if(stack.isEmpty()) {
            stack.push(num);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, num);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        int[] input = {5,4,3,2,1};
        Stack<Integer> stack = new Stack<>();
        for(int num: input) stack.push(num);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);

    }
}
