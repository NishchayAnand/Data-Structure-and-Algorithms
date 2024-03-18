
/* Problem Statement: Given an array of integers "heights" representing the height of histogram bars 
 * 					  (width of each bar is 1), return the area of the largest rectangle in the 
 * 					  histogram.
 * 
 * General Observations:
 * 
 * 	- For a bar with height 'Hi', the maximum possible width of a rectangle with height = 'Hi' would be
 * 	  (index of Nearest Smaller Height to the Right) - (index of Nearest Smaller Height to the Left) - 1.
 * 
 * */

public class LargestRectangleHistogram {
	
	private static int getLargestRectangle(int[] heights) {
		
		int n = heights.length;
		int maxArea = -1;
		
		int[] NSR = getNearestSmallerToRight(heights, n);
		int[] NSL = getNearestSmallerToLeft(heights, n);
		
		for(int i=0; i<heights.length; i++) {
			
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		
		int[] heights = {2,1,5,6,2,3};
		
		int result = getLargestRectangle(heights);
		
	}

}
