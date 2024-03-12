import java.util.ArrayDeque;

/* Problem Statement: Given an array containing 'n' elements, find the next greater element for each 
 * 					  element of the array in order of their appearance in the array.
 * 
 * 					  NOTE: - Next greater element of an element in the array is the nearest element on 
 * 							  the right which is greater than the current element.
 * 							- If there does not exist next greater of current element, then next greater 
 * 							  element for current element is -1. For example, next greater of the last 
 * 							  element is always -1.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Algorithm:
 * 		
 * 			- Loop over every 'ith' element in arr:
 * 				- Loop over every 'jth' element to the right of the 'ith' element in arr:
 * 					- if arr[j] > arr[i]:
 * 				 		- then arr[j] is the next greater element of arr[i];
 * 						- break 'jth', i.e., inner loop;
 * 
 * 		- Time Complexity Analysis:
 * 
 * 			- In worst-case scenario, i.e, if input array is sorted in descending order, the algorithm
 * 			  will perform n^2 operations. Hence, time complexity = O(n^2).
 * 
 * 		- Space Complexity Analysis:
 * 
 * 			- We will store the output in an array of size 'n'. Hence, space complexity = O(n).  
 * 
 * 	- The brute force approach uses nested loops, where the inner loop iterates through elements to the 
 *    right of the current element (i) searching for the next greater element. This can be inefficient 
 *    because we might revisit the same elements multiple times for different i values.
 * 
 * 	- Optimized Approach:
 * 
 * 		- We can use "Stack" to optimize the brute force solution.
 * 
 * 		- Algorithm: 
 * 
 * 			- Iterate over each element: "current" of the input array from right to left.  
 * 				- Keep popping elements from the Stack as long as they are smaller than current.
 * 				- If Stack is not empty:
 * 					- stack.top is the next greater element of current.
 * 				- else:
 * 					- we do not have a element greater than the current element to its right.
 *				- Push current to the top of the stack to ensure that the top element is always the 
 *				  smallest among elements pushed so far. 
 *
 *		- Time Complexity Analysis:
 * 
 * 			- In worst-case scenario, ??
 * 
 * 		- Space Complexity Analysis:
 * 
 * 			- We will store the output in an array of size 'n'. Hence, space complexity = O(n). 		
 * 
 * */

public class NextGreaterElementRight {
   
    public static long[] nextLargerElement(long[] arr, int n) { 
        
        long[] output = new long[n];
        ArrayDeque<Long> stack = new ArrayDeque<>(); 
        
        for(int i=n-1; i>=0; i--){
        	
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                output[i] = stack.peek();
            } else {
                output[i] = -1;
            }
            
            stack.push(arr[i]);
            
        }
        
        return output;
        
    } 
    
    public static void main(String[] args) {
    	
    }
    
}
