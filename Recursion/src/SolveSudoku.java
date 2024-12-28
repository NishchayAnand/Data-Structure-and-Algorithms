import java.util.*;

public class SolveSudoku {
	
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
  
  public static boolean isValid(int[][] board, int i, int j, int digit){
      
      // row check
      for(int c=0; c<9; c++){
          if(board[i][c] == digit){
              return false;
          }
      }
      
      // column check
      for(int r=0; r<9; r++){
          if(board[r][j] == digit){
              return false;
          }
      }
      
      // block check
      int block_rst = i - i%3;
      int block_cst = j - j%3;
      
      for(int r=0; r<3; r++){
          for(int c=0; c<3; c++){
              if(board[block_rst+r][block_cst+c] == digit){
                  return false;
              }
          }
      }
      
      return true;
      
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    
    if(i == board.length){
        display(board);
        return;
    }
    
    if(board[i][j] == 0){
    	
        for(int dig=1; dig<=9; dig++){
        	
            if(isValidOptimized(board, i,j,dig)){
            	
                board[i][j] = dig;
                
                if(j!=board[0].length-1){
                    solveSudoku(board, i, j+1);
                } else {
                    solveSudoku(board, i+1, 0);
                }
                
                board[i][j] = 0;
                
            }
            
        } 
    } else {
    	
        if(j!=board[0].length-1){
            solveSudoku(board, i, j+1);
        } else {
            solveSudoku(board, i+1, 0);
        }
        
    }
    
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
    
    scn.close();
  }
}
