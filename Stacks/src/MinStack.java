import java.util.ArrayDeque;

/*

	Problem Statement: Design a stack that supports push, pop, top, and retrieving the minimum
					   element in constant time.

					   NOTE: Implement a solution with O(1) time complexity for each function.

	General Observations:

		- Brute Force Approach:

			-
 *  	
 *  	- Use 2 stacks:
 *  		- first to hold the actual elements, and
 *  		- second to maintain the minimum element encountered so far for each element in the stack. 
 *  
 *  	- Algorithm:
 *  		
 *  		1. Push Operation:
 *  
 *  			- mainStack.push(element);
 *  			- if minStack is empty:
 *  				- minStack.push(element);
 *  			- else if element <= 'top' of minStack:
 *  				- minStack.push(element);
 *  			- else: 
 *  				- minStack.push(top);
 *  
 *   		2. Pop Operation:
 *   
 *   			- if mainStack is empty:
 *   				- return -1;
 *   			- mainStack.pop();
 *   			- minStack.pop();
 *  
 *  	- Space Complexity Analysis:
 *  		- We will be maintaining an auxiliary Stack of size 'n'. Hence, space complexity = O(n).
 *  
 *  - In the above approach, most of the minimum values stored in minStack would be redundant.
 *  
 *  - Optimized Approach:
 *  
 *  	- Use 2 stacks:
 *  		- first to hold the actual elements, and
 *  		- second to keep track of the minimum elements (unique) encountered so far.
 *  
 *  	- Algorithm:
 *  		
 *  		1. Push Operation:
 *  
 *  			- mainStack.push(element);
 *  			- if minStack is empty:
 *  				- minStack.push(element);
 *  			- else if element <= 'top' of minStack:
 *  				- minStack.push(element);
 *  
 *   		2. Pop Operation:
 *   
 *   			- if mainStack is empty:
 *   				- return -1;
 *   			- element = mainStack.pop();
 *   			- if element == 'top' of minStack:
 *   				- minStack.pop();
 *   
 *   	- There will always be at least one element in the minStack as long as the mainStack is not 
 *   	  empty.
 *   
 *   	- Space Complexity Analysis:
 *   		- In worst-case scenario, the size of the auxiliary Stack will reach 'n'. Hence, worst-case
 *            space complexity = O(n).
 *  	
 * */ 

public class MinStack {
	
	ArrayDeque<Integer> stack;
	ArrayDeque<Integer> minStack;
	
	public MinStack() {
		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}
	
	public void push(int val) {
		stack.push(val);
		if(minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}
	}
	
	public void pop() {
		if(stack.isEmpty()) return;
		int val = stack.pop();
		if(val == minStack.peek()) {
			minStack.pop();
		}
	}
	
	public int top() {
		if(stack.isEmpty()) return -1;
		return stack.peek();
	}
	
	public int getMin() {
		if(minStack.isEmpty()) return -1;
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		
		MinStack obj = new MinStack();
		obj.push(10);
		obj.push(5);
		obj.push(20);
		System.out.println("Top element: " + obj.top());
		System.out.println("Minimum element: " + obj.getMin());

	}

}
