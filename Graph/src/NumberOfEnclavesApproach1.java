public class NumberOfEnclavesApproach1 {
    
    public static boolean DFS(int[][] graph, int i, int j, int[] count){
        
        graph[i][j] = 0;
        count[0] = count[0] + 1;
        
        boolean isBoundaryElement = false;
        if(i==0 || i==graph.length-1 || j==0 || j==graph[0].length-1){
            isBoundaryElement = true;
        }
        
        boolean isNeighbourBoundaryElement = false;
        
        // left
        if(j-1>=0 && graph[i][j-1]==1){
            isNeighbourBoundaryElement = DFS(graph, i, j-1, count) || isNeighbourBoundaryElement;
        }
        
        // up
        if(i-1>=0 && graph[i-1][j]==1){
            isNeighbourBoundaryElement = DFS(graph, i-1, j, count) || isNeighbourBoundaryElement;
        }
        
        
        // right
        if(j+1<graph[0].length && graph[i][j+1]==1){
            isNeighbourBoundaryElement = DFS(graph, i, j+1, count) || isNeighbourBoundaryElement;
        }
        
        // down
        if(i+1<graph.length && graph[i+1][j]==1){
            isNeighbourBoundaryElement =  DFS(graph, i+1, j, count) || isNeighbourBoundaryElement;
        }
        
        return isBoundaryElement || isNeighbourBoundaryElement;
        
    }
    
    public int numEnclaves(int[][] grid) {
        
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int[] tempCount = new int[1];
                    boolean canReachBoundary = DFS(grid, i, j, tempCount);
                    if(!canReachBoundary){
                        count += tempCount[0];
                    }
                }
            }
        }
        
        return count;
        
    }
}