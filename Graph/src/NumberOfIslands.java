import java.io.*;

public class NumberOfIslands {
    
    public static void DFS(int[][] graph, int i, int j){
        
        graph[i][j] = 1;
        
        if(j-1 >= 0 && graph[i][j-1] == 0){
            DFS(graph, i, j-1);
        }
        
        if(i-1 >= 0 && graph[i-1][j] == 0){
            DFS(graph, i-1, j);
        }
        
        if(j+1<graph[0].length && graph[i][j+1] == 0){
            DFS(graph, i, j+1);
        }
        
        if(i+1<graph.length && graph[i+1][j] == 0){
            DFS(graph, i+1, j);
        }
        
    }
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      int count = 0;
      
      for(int i=0; i<arr.length; i++){
          for(int j=0; j<arr[0].length; j++){
              if(arr[i][j]==0){
                  count++;
                  DFS(arr, i, j);
              }
          }
      }
      
      System.out.println(count);
      
   }

}