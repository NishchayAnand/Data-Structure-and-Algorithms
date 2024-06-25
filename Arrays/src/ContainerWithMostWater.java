
/* Problem Statement: Given an array "Height" containing n integers, each representing wall heights. Find 
 * 					  two walls that together with the x-axis form a container, such that the container 
 * 					  contains the most water.
 * 
 * General Observations:
 * 
 * 	- The amount of water held in a container made up of two walls = (Distance between two walls) x
 * 	  (Distance between the x-axis and the height of the container, i.e., the minimum height of the two
 *    walls).
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Use a nested loop {i, j} to check every pair of walls and calculate the area of water they 
 * 		  could hold.
 * 
 * 		- Time Complexity: O(n^2).
 * 
 * 		- Space Complexity: O(1).
 * 
 * 	- For a pair of walls {L, R} such that Height[R] <= Height[L], the area of a container formed using 
 *    any wall M between L and R would always be less than the area of the container formed using L and R. 
 * 
 * 	- Two Pointers Approach:
 * 
 * 		- Algorithm:
 * 
 * 			- left = 0;
 * 			- right = length of height - 1;
 * 			- max_area = -1;
 * 			- while (left < right):
 * 				- current_area = min(Height[left], Height[right])*(right-left);
 * 				- max_area = max(max_area, current_area);
 * 				- if(height[left]<=Height[right]):
 * 					- left++;
 * 				- else:
 * 					- right--;
 * 
 * 		- Time Complexity: O(n).
 * 		
 * 		- Space Complexity: O(1).
 * 
 * */

public class ContainerWithMostWater {
	
	private static int maxArea(int[] height) {
		
		int left = 0;
		int right = height.length-1;
		int globalMax = -1;
		
		while(left<right) {
			int localMax = Math.min(height[left], height[right])*(right-left);
			globalMax = Math.max(globalMax, localMax);
			if(height[left]<=height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return globalMax;
	}

	public static void main(String[] args) {
		
		int[] height = {1,8,6,2,5,4,8,3,7};
		int maximumArea = maxArea(height);
		System.out.println("Maximum Area: " + maximumArea);

	}

}
