import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/* Problem Statement: Given a string 's' containing just the characters '(', ')', '{', '}', '[' and ']', 
 * 					  determine if the input string is valid.
 * 
 * 					  An input string is valid if:
 * 							- Open brackets must be closed by the same type of brackets.
 * 							- Open brackets must be closed in the correct order.
 * 							- Every close bracket has a corresponding open bracket of the same type.
 * 
 * General Observations:
 * 
 * 	- For the input string to be valid, every "closing bracket" must have its corresponding "opening 
 * 	  bracket" immediately preceding it.
 *    
 *  - Approach:
 *  
 *  	- Use a "Stack" data structure to keep of all opening brackets. 
 *  	- When encountered with a closing bracket, check if the last seen opening bracket, i.e., the
 *        "top" of the Stack, matches the closing bracket's corresponding opening bracket.
 *        
 *      - Algorithm:
 *      
 *      	- Loop for each character: 'ch' of the input string 's':
 *      		- if 'ch' is a opening bracket:
 *      			- Stack.append(ch);
 *      		- else if 'ch' is a closing bracket:
 *      			- last_seen_bracket = Stack.pop();
 *      			- if last_seen_bracket matches ch[corresponding_opening_bracket]:
 *      				- continue;
 *      			- else:
 *      				- input string is invalid;
 *      
 *      	- if stack is empty:
 *      		- input string is valid;
 *      	- else if stack contains any left over opening brackets:	
 *      		- input string is invalid;
 *      
 *      - Use a HashMap to maintain a mapping between closing brackets and their corresponding opening
 *        brackets.
 *        
 *      - Time Complexity Analysis:
 *      
 *      	- We are iterating over a string of size 'n'.
 *      	- In each iteration, we are performing operations of contant time.
 *      	- Hence, time complexity = O(n).
 *      
 *      - Space Complexity Analysis:
 *      
 *      	- In worst-case scenario, i.e., when the input string only contains opening brackets, the 
 *      	  stack will store 'n' characters.
 *      	- Hence, space complexity = O(n).
 * 
 * */

public class ValidParenthesis {

    public static boolean isValid(String s) {

    	ArrayDeque<Character> stack = new ArrayDeque<>();
    	
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){ 	// encountered 'ch' is an opening bracket.     	
                stack.push(ch);  
            } 
            else if(stack.isEmpty()){	 				// encountered 'ch' is a closing bracket and no opening bracket has been encountered so far. 
            	return false; // invalid string
            } 
            else {										// encountered 'ch' is a closing bracket.
                char last_seen_bracket = stack.pop();
                // if last seen opening bracket is not the corresponding opening bracket of the encounter 'ch'.
                if(last_seen_bracket != map.get(ch)) {
                	return false; // invalid string
                }
            } 

        }

        // if stack is empty, then string is valid, else not. 
        return stack.isEmpty();
        
    }
    
    public static void main(String[] args) {
    	
    	String s = "[{()}]";
    	
    	if(isValid(s)) {
    		System.out.println(s + " is a valid string.");
    	} else {
    		System.out.println(s + " is not a valid string.");
    	}
    	
    }

}