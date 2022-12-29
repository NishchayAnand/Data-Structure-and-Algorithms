import java.util.* ;

public class DuplicateBrackets {

	public static boolean duplicateParanthesis(String expr) {
		
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<expr.length(); i++){
            
            char ch = expr.charAt(i);
            
            if(ch == ')' && stack.peek() == '('){
                return true;
            } else if(ch == ')'){
                while(stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
            
        }
        
        return false;
        
	}

}
