import java.util.Scanner;

/*Problem Statement: Given a chess board, i.e, a matrix of dimensions n*n, we are required to print 
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

public class printNQueens {
	
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
	
	public static void printNQueensFunc(int[][] chess, int row, String psf) {
		
		if(row==chess.length) {
			System.out.println(psf+".");
			return;
		}
		
		for(int j=0; j<chess[0].length; j++) {
			if(isSafe(chess, row, j)) {
				chess[row][j] = 1;
				printNQueensFunc(chess, row+1, psf+row+"-"+j+", ");
				chess[row][j] = 0;
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of chess board: ");
		int size = scn.nextInt();
		
		int[][] chess = new int[size][size];
		
		System.out.println("All possible configurations to place "+size+" queens in a chess board of size "+size+":");
		printNQueensFunc(chess, 0, "");
		
		scn.close();

	}

}
