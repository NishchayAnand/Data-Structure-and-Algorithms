import java.util.Stack;

public class StockSpanProblem {
    
    public static int[] calculateSpan(int price[], int n) {
 
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            while(!stack.empty() && price[stack.peek()]<=price[i]){
                stack.pop();
            }
            if(!stack.empty()){
                ans[i] = i-stack.peek();
            } else {
                ans[i] = i+1;
            }
            stack.push(i);
        }
        
        return ans;
        
    }
    
}
