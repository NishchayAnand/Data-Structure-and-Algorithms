import java.util.* ;

/* Problem Statement: Given an expression ‘expr’ with parenthesis, find if the expression contains 
 * 					  duplicate parenthesis. 
 * 
 * 					  NOTE: A set of parenthesis is duplicate if multiple parenthesis surrounds the same 
 * 							subexpression.
 * 
 * General Observations:
 * 
 * 	- The input expression is balanced (valid), i.e., for every closing parenthesis, we have a 
 *    corresponding opening parenthesis.
 *    
 *  - Every:
 *  	- opening parenthesis: "(" should mark the start of a subexpression. 
 *  	- closing parenthesis: ")" should mark the end of a subexpression. 
 *  
 *  - A set of "opening-closing" parenthesis is not redundant if it encloses a subexpression (combination 
 *    of operands and operators).
 *  
 *  - Approach:
 *  
 *  	- Use a "Stack" to store subexpressions (opening parenthesis, operands, operators). 
 *        
 *      - For any closing parenthesis encountered, if the "Stack":    
 *      	- holds a subexpression, solve it, i.e., remove it from the stack. 
 *     		- doesn't hold a subexpression, we have a redundant set of parenthesis.  
 *     
 *     - Time Complexity Analysis:
 *     
 *     		- We will iterate over the input string. Hence, time complexity = O(n).
 *     
 *     - Space Complexity Analysis:
 *     
 *     		- In worst-case scenerio, i.e., when we have no opening and closing parenthesis in the 
 *        	  input string, the stack will store 'n' characters. Hence, space complexity = O(n). 
 * 
 * */

public class DuplicateParenthesis {

	public static boolean hasDuplicate(String expr) {
		
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<expr.length(); i++){
            
            char ch = expr.charAt(i);
            	
            if(ch != ')'){
            	
            	stack.push(ch);
            	
            } else {
            	
            	// solve the subexpression.
            	int popCount = 0;
                while(stack.peek() != '('){
                    stack.pop();
                    popCount++;
                }
                
                // check if there existed a subexpression between the set of "opening-closing" parenthesis.
                if(popCount==0) {
                	return true;
                }
                
                // remove the opening parenthesis of the subexpression from the stack.
                stack.pop();
                
            }
            
        }
        
        return false;
        
	}
	
	public static void main(String[] args) {
		
		String expr = "(a+b)+((c+d))";
		System.out.println("Has Duplicate Parenthesis: " + hasDuplicate(expr));
			
	}

}
