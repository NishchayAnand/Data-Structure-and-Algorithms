import java.util.ArrayList;
import java.util.Stack;

/* NOTE: We will traverse from left to right and use Stack data structure to maintain the decreasing
 *       order subsequence as viewed from right to left.  
 * */

public class NextSmallerElementLeft {
	
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        ArrayList<Integer> nse = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<A.size(); i++){
            while(!stack.empty() && stack.peek()>=A.get(i)){
                stack.pop();
            }
            if(!stack.empty()){
                nse.add(stack.peek());
            } else {
                nse.add(-1);
            }
            stack.push(A.get(i));
        }
        
        return nse;
        
    }
}
