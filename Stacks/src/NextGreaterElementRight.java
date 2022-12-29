import java.util.Stack;

public class NextGreaterElementRight {
   
    public static long[] nextLargerElement(long[] arr, int n) { 
        
        long[] output = new long[n];
        Stack<Long> stack = new Stack<>(); 
        
        for(int i=n-1; i>=0; i--){
            while(!stack.empty() && stack.peek()<=arr[i]){
                stack.pop();
            }            
            if(!stack.empty()){
                output[i] = stack.peek();
            } else {
                output[i] = -1;
            }
            stack.push(arr[i]);
        }
        
        return output;
    } 
}
