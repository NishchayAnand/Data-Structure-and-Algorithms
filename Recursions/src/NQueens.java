
/*

	Problem Statement: Given a chess board, i.e, a matrix of dimensions n*n, we are required to print
 * 					 all possible configurations where n queens can be placed on the chess board
 * 
 * General Observations:
 * 
 * - For every row, we have a choice to place a queen in each column provided that it is safe to 
 * 	 place a queen there.
 * - A queen can move in all 4 diagonals, i.e., in 8 directions from any coordinate (north-west, north,
 *   north-east, east, south-east, south, south-west, west)
 * - However, when placing a queen in any row, we only need to check if there's any queen in its
 *   north-west, north or north-east. 
 * 
 * */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
	public static boolean isSafe(int[][] chess, int row, int col) {
		
		// north
		for(int i=row-1; i>=0; i--) {
			if(chess[i][col]==1) return false;
		}
		
		// north-west
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(chess[i][j]==1) return false;
		}
		
		// north-east
		for(int i=row-1, j=col+1; i>=0 && j<chess[0].length; i--, j++) {
			if(chess[i][j]==1) return false;
		}
		
		return true;
		
	}
	
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> output = new ArrayList<>();
		return output;
	}

	public static void main(String[] args) {
	}

}
