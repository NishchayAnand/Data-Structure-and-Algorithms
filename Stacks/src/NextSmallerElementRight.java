import java.util.*;

/* Problem Statement: 
 * 
 * 	- Given an input array of integers of length 'n', find the next smaller element for each of the array 
 * 	  elements.
 * 
 * 	- NOTE: - Next Smaller Element for an array element is the first element to the right of that element 
 * 	  	      which has a value strictly smaller than that element.
 * 			- If for any array element the next smaller element does not exist, then next smaller element 
 * 			  for that element is -1.
 * 
 * 	- Example: A = [2, 3, 1], Output = [1, 1, -1]. 
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
 *  		  		- If 'jth' element < 'ith' element, 'jth' element is the next smaller element to 'ith'
 *  				  element. 
 * 
 * 				- If there is no smaller 'jth' element, the next smaller element for that 'ith' element 
 * 				  is considered -1.
 * 
 * 		- Time Complexity Analysis:
 * 
 * 			- In worst-case scenario, i.e, if the input array is sorted in ascending order, the algorithm
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
 * 		  smaller elements encountered during the iteration.
 * 
 * 		- Algorithm: 
 * 
 * 			- Loop over each 'ith' element of the input array from 'right' to 'left':
 * 
 * 				- Pop elements from the Stack until the 'ith' element is smaller than the element at 
 * 				  the top of the stack;
 * 
 * 				- If there's still an element left in the stack, it is the next smaller element of the 
 * 				  'ith' element.
 * 
 * 				- Push the 'ith' element onto the stack because as we move left in the array, 'ith' 
 * 				  element might become the next smaller element for elements encountered later. 	
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

public class NextSmallerElementRight{
	
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        
        ArrayList<Integer> nse = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            while(!stack.empty() && stack.peek()>=arr.get(i)){
                stack.pop();
            }
            if(!stack.empty()){
                nse.add(0,stack.peek());
            } else {
                nse.add(0,-1);
            }
            stack.push(arr.get(i));
        }
        
        return nse;
        
    }
}