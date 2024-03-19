import java.util.ArrayDeque;

/* Problem Statement: Given an array "heights" holding 'n integers', each representing the height of a
 * 					  histogram bar (width of each bar is 1), return the area of the largest possible 
 * 					  rectangle in the histogram.
 * 
 * General Observations:
 * 
 * 	- For a bar with height 'Hi', the maximum possible width of a rectangle with height = 'Hi' would be
 * 	  (index of Nearest Smaller Height to the Right) - (index of Nearest Smaller Height to the Left) - 1.
 * 
 * 	- Consider the nearest smaller element to the:
 * 			- left of the first bar as -1.
 * 			- right of the last bar as 'n', length of input array "heights".
 * 
 * 	- Time Complexity = O(n).
 * 
 * 	- Space Complexity = O(n).
 * 
 * */

public class LargestRectangleHistogram {
	
	private static int[] getNearestSmallerRightIndex(int[] heights, int n) {
		
		int[] output = new int[n];
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i=n-1; i>=0; i--) {
			
			while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				output[i] = n;
			} else {
				output[i] = stack.peek();
			}
			
			stack.push(i);
		}
		
		return output;	
		
	}
	
	private static int[] getNearestSmallerLeftIndex(int[] heights, int n) {
		
		int[] output = new int[n];
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			
			while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				output[i] = -1;
			} else {
				output[i] = stack.peek();
			}
			
			stack.push(i);
		}
		
		return output;	
		
	}
	
	private static int getLargestRectangle(int[] heights) {
		
		int n = heights.length;
		int maxArea = -1;
		
		int[] NSR = getNearestSmallerRightIndex(heights, n); // O(n)
		int[] NSL = getNearestSmallerLeftIndex(heights, n);	 // O(n)
		
		for(int i=0; i<n; i++) {							 // O(n)
			
			int width = (NSR[i] - NSL[i]) - 1;
			
			int area = width*heights[i];
			maxArea = Math.max(maxArea, area);
			
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		
		int[] heights = {2,1,5,6,2,3};
		
		int result = getLargestRectangle(heights);
		
		System.out.println("Area of largest possible rectangle: "+result);
		
	}

}
