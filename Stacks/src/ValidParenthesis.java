import java.util.HashMap;
import java.util.Stack;


/* NOTE: Every close parentheses, bracket and braces should have a corresponding open parentheses,
 *       bracket or braces for the input string to be a valid one.
 * */
public class ValidParenthesis {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if(stack.size()==0){
                    return false; // invalid
                } else if(stack.peek() != map.get(ch)){
                    return false; // invalid
                } 
                stack.pop();
            }

        }

        if(stack.size() != 0){
            return false;
        } 

        return true;
        
    }

}