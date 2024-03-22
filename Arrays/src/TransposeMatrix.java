
/* Problem Statement: Given a 2D integer array matrix of dimensions 'nxm', return the transpose of matrix.
 * 
 * General Observations:
 * 
 * 	- The dimensions of the transposed matrix will be 'mxn'.
 * 
 * 	- The transpose of a matrix is the matrix flipped over its "main diagonal", switching the matrix's 
 * 	  "row" and "column" indices.
 * 
 * 	- Algorithm:
 * 
 * 		- Loop over each 'row' index:
 * 			- Loop over each 'column' index:
 * 				- if row == column:
 * 					- transpose[row][column] = matrix[row][column];
 * 				- else if row != column:
 * 					- transpose[column][row] = matrix[row][column];
 * 
 * 		- Time Complexity = O(n*m).
 * 
 * 		- Space Complexity = O(n*m). 
 * 
 * */


public class TransposeMatrix {
	
	private static void display(int[][] matrix) {
		
		for(int r=0; r<matrix.length; r++) {
			for(int c=0; c<matrix[0].length; c++) {
				System.out.print(matrix[r][c]+"\t");
			}
			System.out.println();
		}
		
	}
	
	private static int[][] transpose(int[][] matrix) {
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[][] transpose = new int[m][n];
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(r==c) {
					transpose[r][c] = matrix[r][c];
				} else {
					transpose[c][r] = matrix[r][c];
				}
			}
		}
		
		return transpose;
		
	}

	public static void main(String[] args) {
		
		int[][] matrix = {{2,4,-1},{-10,5,11},{18,-7,6}};
		
		System.out.println("Original Matrix:");
		display(matrix);
		
		System.out.println("\nTransposed Matrix:");
		display(transpose(matrix));	

	}

}
