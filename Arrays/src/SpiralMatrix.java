
/* Problem Statement: Given an 'm x n' matrix, return all elements of the matrix in spiral order.
 * 
 * General Observations:
 * 
 * 	- Consider the matrix as divided into concentric layers, similar to the rings of an onion. The 
 * 	  outermost layer consists of the border elements, and each subsequent layer moves one step inwards.
 * 
 * 	- Use 4 pointers: 'Top', 'Bottom', 'Left' and 'Right' to represent the layers of the matrix.
 * 
 * 	- To iterate over:
 * 		- top row, traverse in the right direction (direction = 0),
 * 		- right column, traverse in the down direction (direction = 1),
 * 		- bottom row, traverse in the left direction (direction = 2),
 * 		- left column, traverse in the up direction (direction = 3).  
 * 
 * 	- We would need to check if all layers have been traversed after traversing each row/column. 
 * 
 * 	- Algorithm:
 *  		
 *  		- direction = 0; 
 *  
 *  		- While top<=bottom or left<=right:
 *  
 *  			- If direction = 0: // represents that we need to traverse in the right direction. 
 *  				- Iterate over top row from 'Left' to 'Right' and increment 'Top' by 1;
 *  
 *  			- If direction = 1: // represents that we need to traverse in the down direction. 
 *  				- Iterate over right column from 'Top' to 'Bottom' and decrement 'Right' by 1;
 *  
 *  			- If direction = 2: // represents that we need to traverse in the left direction.
 *  				- Iterate over bottom row from 'Right' to 'Left' and decrement 'Bottom' by 1;
 *  
 *  			- If direction = 3: // represents that we need to traverse in the up direction.
 *  				- Iterate over left column from 'Bottom' to 'Top' and increment 'Left' by 1;
 *  
 *  			- direction = (direction + 1)%4; // to make sure direction remains in the range [0-3].
 *  
 *  - Time Complexity = O(n^2).
 *  
 *  - Space Complexity = O(1).
 * 
 * */

public class SpiralMatrix {
	
	private static void traverse(int[][] matrix, int m, int n) {
		
		int top=0;
		int left=0;
		int bottom=m-1;
		int right=n-1;
		
		int direction = 0;
		
		System.out.print("Spiral Order Traversal: ");
		
		while(top<=bottom && left<=right) {
			
			if(direction==0) {
				// Iterate over top row from 'left' to 'right' and increment 'top' by 1.
				for(int i=left; i<=right; i++) {
					System.out.print(matrix[top][i]+ " ");
				}
				top++;
			}
			
			if(direction==1) {
				// Iterate over right column from 'top' to 'bottom' and decrement 'right' by 1.
				for(int i=top; i<=bottom; i++) {
					System.out.print(matrix[i][right]+ " ");
				}
				right--;
			}
			
			
			if(direction==2) {
				// Iterate over bottom row from 'right' to 'left' and decrement 'bottom' by 1.
				for(int i=right; i>=left; i--) {
					System.out.print(matrix[bottom][i]+ " ");
				}
				bottom--;
			}
			
			if(direction==3) {
				// Iterate over left column from 'bottom' to 'top' and increment 'left' by 1.
				for(int i=bottom; i>=top; i--) {
					System.out.print(matrix[i][left]+ " ");
				}
				left++;
			}
			
			direction=(direction+1)%4;
			
		}
	}

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		traverse(matrix, matrix.length, matrix[0].length);

	}

}
