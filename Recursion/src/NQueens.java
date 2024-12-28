
import java.util.ArrayList;
import java.util.List;

/*

	Problem Statement: Given an integer 'n', return all distinct solutions to the n-queens puzzle.

	NOTE:

		- The n-queens puzzle is the problem of placing 'n' queens on an 'n x n' chessboard such
		  that no two queens attack each other.

		- You may return the answer in any order.

	General Observations:

		- We can place a queen on any cell [i,j] on the chessboard, if it is "safe" to move in all
		  8 directions, i.e., {north-west, north, north-east, east, south-east, south, south-west,
		  west}.

		- In simple terms, no two queens can be in the same row, column, or diagonal.

		- The task is to find all possible permutations of placing 'n' queens on an 'n x n'
		  chessboard such that no two queens attack each other.

		- The problem is naturally recursive in nature, i.e., we only need to place a queen at a
		  feasible cell in a row and trust the recursive function to place the remaining 'n-1' queens
		  in the remaining 'n-1' rows.

		- Hypothesis:

			- F(chessboard, row, configurations) will add all possible configurations of placing
			  'n' queens in 'configurations'.

		- Recursive Steps:

			- For each column in chessboard[row]:
				- if isSafe(chessboard, row, column):
					- chessboard[row][column] = "Q";
					- F(chessboard, row+1, solutions);
					- chessboard[row][column] = ".";

			- NOTE: For any cell [row, column], we only need to check the {north-west, north,
			        north-east} directions since we would have only placed queens in the rows above
			        the 'row' row.

		- Base Conditions:

			- if row == chessboard.size(), i.e., we have a valid configuration:
				- solutions.add(chessboard.clone());
				- return;

	 	- Time Complexity Analysis:

	 		- We are exploring different ways of filling 'n' spaces. Hence, Time Complexity = O(n!).

	 	- Space Complexity Analysis:

	 		- The depth of auxiliary recursive stack would reach at max 'n'. Hence, Space
	 		  Complexity = O(n).

 */

public class NQueens {

	private static List<String> generateBoard(int[][] chessboard) {

		int n = chessboard.length;

		List<String> configuration = new ArrayList<>(n);
		for(int i=0; i<n; i++) {
			StringBuilder row = new StringBuilder();
			for(int j=0; j<n; j++) {
				if(chessboard[i][j]==1) {
					row.append('Q');
				} else {
					row.append('.');
				}
			}
			configuration.add(row.toString());
		}

		return configuration;

	}

	private static boolean isSafe(int[][] chessboard, int row, int col) {
		
		// north
		for(int i=row-1; i>=0; i--) {
			if(chessboard[i][col]==1) return false;
		}
		
		// north-west
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(chessboard[i][j]==1) return false;
		}
		
		// north-east
		for(int i=row-1, j=col+1; i>=0 && j<chessboard.length; i--, j++) {
			if(chessboard[i][j]==1) return false;
		}
		
		return true;
		
	}

	private static void getAllConfigurations(int[][] chessboard, int row, List<List<String>> configurations) {

		// Base Condition
		if(row==chessboard.length) {
			List<String> configuration = generateBoard(chessboard);
			configurations.add(configuration);
			return;
		}

		// Recursive Steps
		int n = chessboard.length;
		for(int col=0; col<n; col++) {
			if(isSafe(chessboard, row, col)) {
				chessboard[row][col] = 1;
				getAllConfigurations(chessboard, row+1, configurations);
				chessboard[row][col] = 0;
			}
		}

	}
	
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> configurations = new ArrayList<>();
		int[][] chessboard = new int[n][n];
		getAllConfigurations(chessboard, 0, configurations);
		return configurations;
	}

	public static void main(String[] args) {
		int n = 4;
		List<List<String>> configurations = solveNQueens(n);
		System.out.println(configurations);
	}

}
