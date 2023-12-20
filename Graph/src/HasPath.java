import java.util.LinkedList;
import java.util.Queue;

/* Problem Statement: Given:
 * 						- a 2-D integer array: edges, where each edges[i] = [ui, vi] denotes a bi-directional 
 * 					      edge between vertex ui and vertex vi, 
 * 						- a source vertex, and 
 * 						- a destination vertex.
 * 
 * 					   Check if there exists a valid path from source vertex to destination vertex. 
 * 
 * 					  NOTE: Every vertex pair is connected by at most one edge, and no vertex has an edge to 
 * 						    itself. 
 * 
 * General Obervations:
 * 
 * 	- 
 * 	
 *	- DFS Approach:
 *
 *		- Hypothesis: check(edges, source, destination) will return true if path exists between source and 
 *					  destination, else false.
 *
 *		- Recursive Steps: 
 *
 *		- Base Condition:
 *
 *			- if source == destination, return true;
 * */


public class HasPath {
	
	private static boolean hasPathDFS(int[][] edges, int src, int dest, boolean[] visited) {
		
		if(src == dest){
            return true;
        }
		
		visited[src] = true;

        for(int[] edge: edges){
        	
        	if(edge[0] == src) {
				int nbr = edge[1];
				if(!visited[nbr] && hasPathDFS(edges, nbr, dest, visited)) return true;
				
			} else if(edge[1] == src) {
				int nbr = edge[0];
				if(!visited[nbr] && hasPathDFS(edges, nbr, dest, visited)) return true;
			}
        	
        }

        return false;
        
	}
	
	private static boolean hasPathBFS(int[][] edges, int source, int destination, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			
			int vertex = queue.remove();
			
			if(vertex == destination) {
				return true;
			}
			
			for(int[] edge: edges) { 
				
				if(edge[0] == vertex) {
					int nbr = edge[1];
					if(!visited[nbr]) {
						visited[nbr] = true;
						queue.add(nbr);
					}
					
				} else if(edge[1] == vertex) {
					int nbr = edge[0];
					if(!visited[nbr]) {
						visited[nbr] = true;
						queue.add(nbr);	
					}
				}
				
			}
		}
		
		return false;

	}

	public static void main(String[] args) {
		
		int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		int source = 0;
		int destination = 5;
		
		boolean[] visitedDFS = new boolean[6];
		boolean[] visitedBFS = new boolean[6];
		
		System.out.println("Does path exists:");		
		System.out.println("\t Check using DFS: " + hasPathDFS(edges, source, destination, visitedDFS));
		System.out.println("\t Check using BFS: " + hasPathBFS(edges, source, destination, visitedBFS));
		
	}

}
