
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

            -

        - Space Complexity Analysis:

            -


*/

public class ReverseStack {

    public static void main(String[] args) {

    }
}
