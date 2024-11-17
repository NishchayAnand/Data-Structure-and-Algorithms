
/*

    Problem Statement: You are given a stack of integers 'nums' and an integer 'num'. Insert ‘num’ at
                       the bottom of input stack ‘nums’ and return the updated stack 'nums'.

                       NOTE: Solve without using any other data structure.

    General Observations:

        - Brute Force Approach:

            - Use an auxiliary (temporary) stack to empty the input stack 'nums' and store elements
              in reverse order.

            - Once the input stack is empty, push 'num' at the bottom of the stack, and empty the
              auxiliary stack and push the elements back in the input (original) array.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - Recursive Approach:

            - Remove elements from stack 'nums' in pre-order, add new element 'num' at the bottom
              of 'nums' in base condition, i.e., when 'nums' become empty, and re-add the elements
              back in 'nums' in post order.

            - Time Complexity: O(n).

            - Space Complexity: O(n). // using recursive stack space

*/

import java.util.Stack;

public class InsertAtBottom {

    public static void helper(Stack<Integer> nums, int num) {
        if(nums.isEmpty()) {
            nums.push(num);
            return;
        }

        int el = nums.pop();
        helper(nums, num);
        nums.push(el);
    }

    public static Stack<Integer> pushAtBottom(Stack<Integer> nums, int num) {
        helper(nums, num);
        return nums;
    }

    public static void main(String[] args) {
        int[] input = {7,1,4,5};
        Stack<Integer> nums = new Stack<>();
        for(int num: input) {
            nums.push(num);
        }
        int num = 10;
        System.out.println(pushAtBottom(nums, num));
    }
}
