import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* Problem Statement: 
 * 
 * 	- Given an input array of 'n' daily price quotes for a stock, we need to calculate the span of stocks 
 * 	  price for all 'n' days.
 *  
 *  - NOTE: The span 'Si' of the stocks price on a given day 'i' is defined as the maximum number of 
 *  		consecutive days just before the given day, for which the price of the stock on the given day
 *   		is less than or equal to its price on the current day.
 *  
 *  - Example: prices = {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are 
 *  					{1  , 1 , 1 , 2 , 1 , 4 , 6}.
 *  
 *  
 * General Observations:
 * 
 * 	- The span 'Si' of the stocks price on a given day 'i' is equal to:
 * 		 	- "Index of Nearest Greater Price to the Left" - Price[i]; 
 * 
 * */

public class StockSpanProblem {
	
	private static int[] getNearestGreaterToLeftIndex(int[] price, int n) {
		
		int[] output = new int[n];
		
		// will store collection of [price, index]
		ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			
			// stack.peek().get(0) can be replaced with price[stack.peek()] where stack only stores the index.
			while(!stack.isEmpty() && stack.peek().get(0) <= price[i]) { 
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				output[i] = -1;
			} else {
				output[i] = stack.peek().get(1);
			}
			
			List<Integer> element = new ArrayList<>();
			element.add(price[i]);
			element.add(i);
			
			stack.push(element);
			
		}
		
		return output;
	}
    
    public static int[] calculateSpan(int price[], int n) {
 
        int[] result = new int[n];
        
        int[] NGL = getNearestGreaterToLeftIndex(price, n);
        
        for(int i=0; i<n; i++) {
        	result[i] = i - NGL[i];
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
    	
    	int[] price = {100, 80, 60, 70, 60, 75, 85};
    	
    	int[] result = calculateSpan(price, price.length);
    	
    	System.out.print("Output: ");
    	for(int span: result) {
    		System.out.print(span + " ");
    	}
    	
    }
    
}
