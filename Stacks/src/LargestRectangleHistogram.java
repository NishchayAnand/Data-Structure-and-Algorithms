
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

		- Single Stack Approach:



*/

public class LargestRectangleHistogram {
	
	private static int[] nearestSmallerRightIndex(int[] heights) {

		int n = heights.length;
		int[] NSR = new int[n];
		
		Stack<Integer> stack = new Stack<>(); // monotonically decreasing
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
		
		Stack<Integer> stack = new Stack<>();
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
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		int result = getLargestRectangle(heights);
		System.out.println("Area of largest possible rectangle: "+result);
	}

}
