
/*

    Problem Statement: Implement a first in first out (FIFO) queue using only two stacks.

    General Observations:

        - Brute Force Approach:

            - Costly Push Operation: Use two stacks, 'stack1' and 'stack2', to implement insert at
                                     bottom of stack algorithm, i.e.,:

                        1. move all elements from stack1 to stack2.
                        2. Push the new element onto stack1.
                        3. Move all elements back from stack2 to stack1.

            - Time Complexity: O(n) for push, O(1) for pop, peek and isEmpty.

        - Think of two stacks as a U-tube, where 'stack1' could be used for push operations and
          'stack2' for pop operations.

        - Optimized Approach:

                - Costly Pop Operation: If 'stack2' is empty, move all elements from 'stack1' to
                                        'stack2'. This reverses the order of elements so the oldest
                                        element is at the top of 'stack2'. Then pop the top element
                                        from 'stack2'.

                - Time Complexity Analysis:

                    - The costly part of the pop operation is transferring elements from 'stack1' to
                      'stack2'. However, this only happens when 'stack2' is empty. Once the transfer
                      is complete, multiple dequeues can be performed in O(1) until 'stack2' is empty
                      again.

                    - Time Complexity: Amortized O(1) for pop and peek, O(1) for push and isEmpty.

*/

import java.util.Stack;

class MyQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Pushes element x to the back of the queue.
    public void push(int x) {
        stack1.push(x);

    }

    // Removes the element from the front of the queue and returns it.
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    // Returns the element at the front of the queue.
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    // Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueueUsingStackImpl {
    public static void main(String[] args) {

    }

}
