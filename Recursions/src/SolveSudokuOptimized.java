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
  
  public static boolean isValid(int[][] board, int i, int j, int digit){
      
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

  public static boolean solveSudokuOptimized1(int[][] board, int i, int j) {
    
	// base condition
    if(i == board.length){
        display(board);
        return true;
    }
    
    boolean found = false;
    
    if(board[i][j] == 0){
        
        for(int dig=1; dig<=9; dig++){
            
            if(isValid(board, i,j,dig)){
                
                board[i][j] = dig;
                
                if(j!=board[0].length-1){
                    found = solveSudokuOptimized1(board, i, j+1);
                } else {
                    found = solveSudokuOptimized1(board, i+1, 0);
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
            found = solveSudokuOptimized1(board, i, j+1);
        } else {
            found = solveSudokuOptimized1(board, i+1, 0);
        }
        
    }
    
    return found;
    
  }
  
  public static boolean solveSudokuOptimized2(int[][] board) {
	  
	  for(int i=0; i<board.length; i++) {
		  
		  for(int j=0; j<board[0].length; j++) {
			  
			  if(board[i][i]==0) {
				  
				  for(int dig=1; dig<=9; dig++) {
					  
					  if(isValid(board, i, j, dig)) {
						  board[i][j] = dig;
						  boolean found = solveSudokuOptimized2(board);
						  if(found) {
							  return true;
						  }
						  board[i][j] = 0;
					  }
					  
				  }
				  
				  // if for loop is over, we happened found the solution yet and we need to backtrack.
				  return false;
			  }
			  
		  }
	  }
	  
	  return true;
	  
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    //solveSudokuOptimized1(arr, 0, 0);
    solveSudokuOptimized2(arr);
    
    scn.close();
    
  }
}
