import java.util.*;

public class SolveSudokuOptimized {
	
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static boolean isValidOptimized(int[][] board, int i, int j, int digit){
      
      int block_rst = i - i%3;
      int block_cst = j - j%3;
      
      for(int k=0; k<9; k++){
          
          // row check
          if(board[i][k] == digit){
              return false;
          }
          
          // column check
          if(board[k][j] == digit){
              return false;
          }
          
          // block check
          int r = block_rst + k/3;
          int c = block_cst + k%3;
          if(board[r][c] == digit){
              return false;
          }
          
      }
      
      return true;
      
  }

  public static boolean solveSudokuOptimized(int[][] board, int i, int j) {
    
	// base condition
    if(i == board.length){
        display(board);
        return true;
    }
    
    boolean found = false;
    
    if(board[i][j] == 0){
        
        for(int dig=1; dig<=9; dig++){
            
            if(isValidOptimized(board, i,j,dig)){
                
                board[i][j] = dig;
                
                if(j!=board[0].length-1){
                    found = solveSudokuOptimized(board, i, j+1);
                } else {
                    found = solveSudokuOptimized(board, i+1, 0);
                }
                
                // no need to check any further
                if(found){
                    return true;
                }
                
                board[i][j] = 0;
                
            }
        }
        
    } else {
        
        if(j!=board[0].length-1){
            found = solveSudokuOptimized(board, i, j+1);
        } else {
            found = solveSudokuOptimized(board, i+1, 0);
        }
        
    }
    
    return found;
    
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudokuOptimized(arr, 0, 0);
    
    scn.close();
    
  }
}
