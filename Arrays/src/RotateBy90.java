
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
 *  	- Loop through each layer:
 *  		- Shift top row elements to the right;
 *  		- Shift right column elements down;
 *  		- Shift bottom column elements to the left;
 *  		- Shift left column elements up;
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
		approach1(matrix, matrix.length);
		display(matrix);	
	     
	}

}
