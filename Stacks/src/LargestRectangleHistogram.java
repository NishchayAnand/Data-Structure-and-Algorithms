
import java.util.Stack;

/*

	Problem Statement: Given an array of integers 'heights' representing the histogram's bar height
	 				   where the width of each bar is 1, return the area of the largest rectangle in
	 				   the histogram.


	General Observations:

		- A valid rectangle can be represented as a pair of bars {i,j} where:
			  				(i) i<=j,
			  			   (ii) height[i] <= height of all bars in the range [i+1, j].

		- Brute Force Approach:

			- Use a nested loop {i,j} to iterate over all valid rectangles.

			- For every 'ith' bar, start the inner loop from 'j=i' and expand until in the right
			  until you reach a bar where height[j] < height[i].

			- Area of a valid rectangle {i,j} = (j-i+1)*height[i].

			- Time Complexity: O(n^2).

			- Space Complexity: O(1).

		- For every 'ith' bar, width of the largest rectangle with height = height[i] =
		  [NearestSmallerRightIndex - NearestSmallerLeftIndex - 1].

		- Pre-computed Monotonic Stacks Approach:

			- Algorithm:
				- NSL = nearestSmallerLeftIndex(heights);
				- NSR = nearestSmallerRightIndex(heights);
				- Loop from i = [0, n):
					- currArea = heights[i]*(NSR[i]-NSL[i]-1);
					- maxArea = max(maxArea, currArea);
				- return maxArea;

			- Time Complexity: O(n).

			- Space Complexity: O(n).

		- While computing the index of the nearest smaller element to the left, we maintain a
		  monotonically increasing stack from left (bottom) to right (top).

		- For any 'ith' bar, if heights[i] < heights[stack.top], it means:
		  	- 'ith' bar is the NSR of 'stack.top' bar,
		  	- 'stack.(top-1)' is the NSL of 'stack.top' bar,
		  	- width of the largest rectangle with height heights[stack.top] can be calculated as
		  	  (i-stack.(top-1)-1).

		- NOTE: After processing the entire histogram, some bars may remain in the stack. Treat the
		 	    histogram's end (n) as the NSR for these bars and calculate their areas.

		- Single Stack Approach:

			- Algorithm:

				- Loop from i = [0, n-1]:
					- while stack is not empty and heights[stack.top] > heights[i]:
						- height = heights[stack.pop()];
						- width = if stack is not empty: i - stack.top - 1 : i;
						- maxArea = max(maxArea, width*height);
						- stack.push(i);

				- while stack is not empty:
					- height = heights[stack.pop()];
					- width = if stack is not empty: n - stack.top - 1: n;
					- maxArea = max(maxArea, width*height);

				- return maxArea;

			- Time Complexity: O(n+n) in worst case ~ O(n).

			- Space Complexity: O(n).

*/

public class LargestRectangleHistogram {
	
	private static int[] nearestSmallerRightIndex(int[] heights) {

		int n = heights.length;
		int[] NSR = new int[n];
		
		Stack<Integer> stack = new Stack<>(); // monotonically decreasing from left (top) to right (bottom)
		for(int i=n-1; i>=0; i--) {
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
			if(stack.isEmpty()) NSR[i] = n;
			else NSR[i] = stack.peek();
			stack.push(i);
		}
		
		return NSR;
		
	}
	
	private static int[] nearestSmallerLeftIndex(int[] heights) {

		int n = heights.length;
		int[] NSL = new int[n];
		
		Stack<Integer> stack = new Stack<>(); // monotonically increasing from left (bottom) to right (top)
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
			if(stack.isEmpty()) NSL[i] = -1;
			else NSL[i] = stack.peek();
			stack.push(i);
		}
		
		return NSL;
		
	}
	
	public static int getLargestRectangle(int[] heights) {

		int[] NSR = nearestSmallerRightIndex(heights);
		int[] NSL = nearestSmallerLeftIndex(heights);

		int maxArea = 0;
		for(int i=0; i<heights.length; i++) {
			int currArea = heights[i]*(NSR[i] - NSL[i] - 1);
			maxArea = Math.max(maxArea, currArea);
		}

		return maxArea;
	}

	public static int getLargestRectangleSingleStack(int[] heights) {

		int n = heights.length;
		int maxArea = 0;

		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i-stack.peek()-1;
				maxArea = Math.max(maxArea, height*width);
			}
			stack.push(i);
		}

		while(!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? n : n - stack.peek() - 1;
			maxArea = Math.max(maxArea, height*width);
		}

		return maxArea;

	}
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		int result = getLargestRectangleSingleStack(heights);
		System.out.println("Area of largest possible rectangle: "+result);
	}

}
