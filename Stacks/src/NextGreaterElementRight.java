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
 * 		- Use a nested loop.
 * 
 * 		- Algorithm:
 * 
 * 			- Loop over each 'ith' element of the array:
 *  
 * 				- Loop over each 'jth' elements to the right of the current element: 
 *  		  		- If 'jth' element > 'ith' element, 'jth' element is the next greater element to 'ith'
 *  				  element. 
 * 
 * 				- If there is no greater 'jth' element, the next greater element for that 'ith' element 
 * 				  is considered -1.
 * 
 * 		- Time Complexity Analysis:
 * 
 * 			- In worst-case scenario, i.e, if the input array is sorted in descending order, the algorithm
 * 			  will perform n^2 operations. Hence, time complexity = O(n^2).
 * 
 * 		- Space Complexity Analysis:
 * 
 * 			- We will store the output in an array of size 'n'. Hence, space complexity = O(n).  
 * 
 * 		- The brute force approach is inefficient because we might revisit the same elements multiple 
 * 		  times for different "i" values.
 *    
 * 
 * 	- Optimized Approach:
 * 
 * 		- Process the input array from 'right' to 'left' and use a 'Stack' to store potential next 
 * 		  greater elements encountered during the iteration.
 * 
 * 		- Algorithm: 
 * 
 * 			- Loop over each 'ith' element of the input array from 'right' to 'left':
 * 
 * 				- Pop elements from the Stack until the 'ith' element is greater than the element at 
 * 				  the top of the stack;
 * 
 * 				- If there's still an element left in the stack, it is the next greater element of the 
 * 				  'ith' element.
 * 
 * 				- Push the 'ith' element onto the stack because as we move left in the array, 'ith' 
 * 				  element might become the next greater element for elements encountered later. 	
 *
 *		- Time Complexity Analysis:
 * 
 * 			- We will loop over the input array and perform few pop operations. Average time complexity
 *   		  = O(n).
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
    	
    	long[] A = {1,3,2,4};
    	
    	long[] output = nextLargerElement(A, A.length);
    	
    	System.out.print("Output: ");
    	for(long el: output) {
    		System.out.print(el+" ");
    	}
    	
    }
    
}
