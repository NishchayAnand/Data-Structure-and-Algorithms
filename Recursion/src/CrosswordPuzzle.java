import java.util.*;

public class CrosswordPuzzle {
    
    public static boolean canPlaceHorizontally(char[][] arr, int i, int j, String word){
        
        if(j-1 >= 0 && arr[i][j-1] != '+'){
            return false;
        }
        
        if(j+word.length()-1 >= arr[0].length){
            return false;
        }
        
        if(j+word.length() < arr[0].length && arr[i][j+word.length()] != '+'){
            return false;
        }
        
        for(int k=0; k<word.length(); k++){
            if(arr[i][j+k]!='-' && arr[i][j+k]!=word.charAt(k)){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static boolean canPlaceVertically(char[][] arr, int i, int j, String word){
        
        if(i-1 >= 0 && arr[i-1][j] != '+'){
            return false;
        }
        
        if(i+word.length()-1 >= arr.length){
            return false;
        }
        
        if(i+word.length() < arr[0].length && arr[i+word.length()][j] != '+'){
            return false;
        }
        
        for(int k=0; k<word.length(); k++){
            if(arr[i+k][j]!='-' && arr[i+k][j]!=word.charAt(k)){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static boolean[] placeHorizontally(char[][] arr, int i, int j, String word){
        
        boolean[] wePlaced = new boolean[word.length()];
        for(int k=0; k<word.length(); k++){
            if(arr[i][j+k] == '-'){
                wePlaced[k] = true;
                arr[i][j+k] = word.charAt(k);
            }
        }
        
        return wePlaced;
    }
    
    public static boolean[] placeVertically(char[][] arr, int i, int j, String word){
        
        boolean[] wePlaced = new boolean[word.length()];
        for(int k=0; k<word.length(); k++){
            if(arr[i+k][j] == '-'){
                wePlaced[k] = true;
                arr[i+k][j] = word.charAt(k);
            }
        }
        
        return wePlaced;
        
    }
    
    public static void unplaceHorizontally(char[][] arr, int i, int j, boolean[] wePlaced){
    
        for(int k=0; k<wePlaced.length; k++){
            if(wePlaced[k]){
                arr[i][j+k] = '-';
            }
        }
        
    }
    
    public static void unplaceVertically(char[][] arr, int i, int j, boolean[] wePlaced){
    
        for(int k=0; k<wePlaced.length; k++){
            if(wePlaced[k]){
                arr[i+k][j] = '-';
            }
        }
        
    }
    
  public static void solution(char[][] arr, String[] words, int vidx) {
    
    if(vidx == words.length){
        print(arr);
        return;
    }
    
    String word = words[vidx];
    for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr[0].length; j++){
            if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
                
                if(canPlaceHorizontally(arr, i, j, word)){
                    boolean[] wePlaced = placeHorizontally(arr, i, j, word);
                    solution(arr, words, vidx+1);
                    unplaceHorizontally(arr, i, j, wePlaced);   
                }
                
                if(canPlaceVertically(arr, i, j, word)){
                    boolean[] wePlaced = placeVertically(arr, i, j, word);
                    solution(arr, words, vidx+1);
                    unplaceVertically(arr, i, j, wePlaced);   
                }
                
            }
            
        }
        
    }

  }

  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  
  public static void main(String[] args) {
	  
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    
    int n = scn.nextInt();
    String[] words = new String[n];
    
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    
    solution(arr, words, 0);
    scn.close();
    
  }
  
}