import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static void DFS(int[][] graph, int i, int j, StringBuilder comp){
        
        graph[i][j] = 0;
        
        if(j-1>=0 && graph[i][j-1]==1){
            DFS(graph, i, j-1, comp.append("L"));
            comp.append(".");
        }
        
        if(i-1>=0 && graph[i-1][j]==1){
            DFS(graph, i-1, j, comp.append("U"));
            comp.append(".");
        }
        
        if(j+1<graph[0].length && graph[i][j+1]==1){
            DFS(graph, i, j+1, comp.append("R"));
            comp.append(".");
        }
        
        if(i+1<graph.length && graph[i+1][j]==1){
            DFS(graph, i+1, j, comp.append("D"));
            comp.append(".");
        }
        
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> hs = new HashSet<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){ // could be a potential component
                    StringBuilder comp = new StringBuilder();
                    DFS(grid, i, j, comp);
                    hs.add(comp.toString());
                }
            }
        }
        
        return hs.size();
        
    }
}
