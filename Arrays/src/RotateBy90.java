
/* Problem Statement: Given an 'n x n' 2D matrix representing an image, rotate the image by 90 degrees 
 * 					  (clockwise).
 * 
 * General Observations:
 * 
 * 	- Number of rows = Number of columns = 'n'. 
 * 
 * 	- Approach 1: 
 * 
 * 		- Every 'ith' row becomes the '(n-1-i)th' column in the rotated matrix, where 0<=i<n. 
 * 
 * 		- Every [i, j] cell will become [j, n-1-i] in the rotated matrix. 
 * 
 * 		- Brute Force Approach: 
 * 
 * 			- Use a 'n x n' 2D auxiliary matrix to store the rotated matrix.
 * 
 * 			- Algorithm:
 * 	
 * 				- Loop from i = [0, n-1]:
 * 					- Loop from j = [0, n-1]:
 * 						- rotated[j][n-i-1] = matrix[i][j];
 * 
 * 			- Time Complexity: O(n^2).
 * 			
 * 			- Space Complexity: O(n^2). 
 * 
 * 		- Optimized Approach:
 * 
 * 			- The rotated matrix can be achieved by 'transposing' the matrix and 'reversing' each row. 
 * 
 *   		- Time Complexity: O(n^2).
 *   
 *   		- Space Complexity Analysis: 
 *   			
 *   			- We are performing inplace rotation. Hence, space complexity = O(1). 
 * 
 * 	- Approach 2:
 * 
 * 		- Consider the matrix as divided into concentric layers, similar to the rings of an onion. The 
 * 		  outermost layer consists of the border elements, and each subsequent layer moves one step 
 * 		  inwards.
 * 
 * 		- Use 4 pointers: 'Top', 'Bottom', 'Left' and 'Right' to represent the layers of the matrix.
 * 
 * 		- Algorithm:
 *  		
 *  		- Loop through each layer:
 *  			- Shift top row (Right-Left) elements to the right colum;
 *  			- Shift right column (Bottom-Top) elements to the bottom row;
 *  			- Shift bottom row (Right-Left) elements to the left column;
 *  			- Shift left column (Bottom-Top) elements to the top row;
 *  
 *  	- Time Complexity = O(n).
 *  
 *  	- Space Complexity = O(1).
 *  
 *  - NOTE: The first approach, i.e., the 'transpose' and 'reverse' approach might be easier to 
 *  	    understand due to its clear separation of steps.
 *  
 * */

public class RotateBy90 {
	
	private static void display(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private static void approach1(int[][] matrix, int n) {
		
		// Transposing the matrix.
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(r<c) {
					int temp = matrix[r][c];
					matrix[r][c] = matrix[c][r];
					matrix[c][r] = temp;
				}
			}
		}
		
		// reversing each row.
		for(int[] row: matrix) {
			int start = 0;
			int end = n-1;
			while(start<end) {
				int temp = row[start];
				row[start] = row[end];
				row[end] = temp;
				start++;
				end--;
			}
		}
		
	}
	
	private static void approach2(int[][] matrix, int n) {
		
		int top = 0, left = 0;
		int bottom = n-1, right = n-1;
		
		while(top<bottom) {
			
			int elementsToSwap = bottom-top; // (bottom-top) = (right-left) 
			
			for(int step=0; step<elementsToSwap; step++) {
				
				// Storing matrix[top][left+step] element for future reference. 
				int temp = matrix[top][left+step];
				
				// Move left column (bottom-step) element to top row (left+step) index.
				matrix[top][left+step] = matrix[bottom-step][left];
				
				// Move bottom row (right-step) element to the left column (bottom-step) index.
				matrix[bottom-step][left] = matrix[bottom][right-step];
				
				// Move right column (top+step) element to the bottom row (right-step) index.
				matrix[bottom][right-step] = matrix[top+step][right]; 
				
				// Move top row (left+step) element to right column (top+step) index.
				matrix[top+step][right] = temp;
				
			}
			
			// Moving to the inward layer. 
			top++;
			left++;
			bottom--;
			right--;
				
		}
			
	}

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		
		System.out.println("Original Matrix:");
		display(matrix);
		
		System.out.println("Rotated Matrix:");
		//approach1(matrix, matrix.length);
		approach2(matrix, matrix.length);
		display(matrix);	
	     
	}

}
