public class NumberOfEnclavesApproach2 {
    
    public static void DFS(int[][] graph, int i, int j){
        
        graph[i][j] = 0;
        
        // left
        if(j-1>=0 && graph[i][j-1]==1){
            DFS(graph, i, j-1);
        }
        
        // up
        if(i-1>=0 && graph[i-1][j]==1){
            DFS(graph, i-1, j);
        }
        
        // right
        if(j+1<graph[0].length && graph[i][j+1]==1){
            DFS(graph, i, j+1);
        }
        
        // down
        if(i+1<graph.length && graph[i+1][j]==1){
            DFS(graph, i+1, j);
        }
        
    }
    
    public int numEnclaves(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j] == 1){
                        DFS(grid, i, j);
                    }
                }                
            }
        }
        
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }               
            }
        }
        
        return count;
        
    }
}