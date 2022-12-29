import java.util.Stack;

/* NOTE: We will traverse from left to right and use Stack data structure to maintain the increasing
 *       order subsequence as viewed from right to left.  
 * */

public class NextGreaterElementLeft {
	
	public static int[] solve(int[] arr) {
		
	    int[] nge = new int[arr.length];
	    Stack<Integer> stack = new Stack<>();
	    
	    for(int i=0; i<arr.length; i++){
	        while(!stack.empty() && stack.peek()<=arr[i]){
	            stack.pop();
	        }
	        if(!stack.empty()){
	            nge[i] = stack.peek();
	        } else {
	            nge[i] = -1;
	        }
	        stack.push(arr[i]);
	    }
	    
	    return nge;
	    
	  }

}
