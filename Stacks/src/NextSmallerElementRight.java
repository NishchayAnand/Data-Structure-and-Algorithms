import java.util.*;

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