package Matrix;

/*

    Problem Statement: Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
                       to the following rules:

                        - Each row must contain the digits 1-9 without repetition.
                        - Each column must contain the digits 1-9 without repetition.
                        - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    General Observations:

        - We have 9 rows, 9 columns and 9 3x3 sub-boxes.

        - Each cell in the board is part of one of these 9 3x3 sub-boxes.

        - For any cell = board[row_index][col_index], it will lie in the [(row_index/3)*3 + col_index/3]th sub-box.

        - Create a HashMap where each key represents a row index and its corresponding value is a HashSet containing all
          digits present in that row.

        - Create a HashMap where each key represents a column index and its corresponding value is a HashSet containing
          all digits present in that column.

        - Create a HashMap where each key represents a 3 x 3 sub-box index (from 0 to 8) and its corresponding value is
          a HashSet containing all digits present in that sub-box.

        - Time Complexity: O(9^2).

        - Space Complexity: O(9^2).

*/

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    private static boolean isValidSudoku(char[][] board) {

        HashMap<Integer, HashSet<Character>> rhm = new HashMap<>();
        HashMap<Integer, HashSet<Character>> chm = new HashMap<>();
        HashMap<Integer, HashSet<Character>> bhm = new HashMap<>();

        for(int i=0; i<9; i++) {
            rhm.put(i, new HashSet<>());
            chm.put(i, new HashSet<>());
            bhm.put(i, new HashSet<>());
        }

        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                int box_index = (r/3)*3 + c/3;
                if(board[r][c] == '.') {
                    continue;
                } else if(rhm.get(r).contains(board[r][c]) ||
                        chm.get(c).contains(board[r][c]) ||
                        bhm.get(box_index).contains(board[r][c])) {
                    return false;
                } else {
                    rhm.get(r).add(board[r][c]);
                    chm.get(c).add(board[r][c]);
                    bhm.get(box_index).add(board[r][c]);
                }
            }
        }

        return true;

    }

    public static void main(String args[]) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));

    }


}
