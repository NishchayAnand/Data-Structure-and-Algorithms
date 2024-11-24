import java.util.*;
import java.util.stream.Collectors;

/*

    Problem Statement: Given an array 'nums' of integers, find the next greater element on the right
                       for each element in the array.

                       NOTE:

                        - Take -1 if there does not exist next greater element for any element in 'nums'.
                        - Next greater element of the last element is always -1.

    General Observations:

        - Brute Force Approach: Use a nested loop.

            - Time Complexity: O(n^2).

            - Space Complexity: O(1).

        - Only the monotonically increasing elements to the right are valid candidates for the
          Next Greater Element to the right.

  		- Monotonic Stack Approach:

  		    - Process the input array from 'right' to 'left' and use a 'Stack' to store potential
  		      next greater elements encountered during the iteration (eliminating smaller, irrelevant
  		      elements).

  		    - Loop from i = [n-1, 0]:
  		        - while stack is not empty and stack.top <= nums[i]:
  		            - stack.pop();
  		        - if stack is not empty:
  		            - NGE[i] = stack.top;
  		        - else:
  		            - NGL[i] = -1;

            - Time Complexity Analysis:

			    - We are looping over the input array and performing few pop operations. Hence,
                  Time Complexity = O(n).

            - Space Complexity: O(1).

*/

public class NextGreaterElement {

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] NLE = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                NLE[i] = -1;
            } else {
                NLE[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return Arrays.stream(NLE).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,3,2,4};
    	List<Integer> NLE = nextLargerElement(arr);
    	System.out.print(NLE);
    }
    
}
