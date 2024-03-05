import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Problem Statement: Given a "connected" directed graph, perform Breadth-First-Traversal on the graph
 * 					  and print the order of traversal.
 * 
 * General Observations:
 * 
 * 	- Based on the ideology of exploring a graph "level by level", i.e., explore all vertices at the 
 *    current depth level before moving on to the verices at the next depth level.
 *    
 *  - Approach: Can be implemented using a "Queue" data structure. 
 *  
 *  - Algorithm:
 *  
 *  	- Queue.add(root_vertex);
 *  	- visited[root_vertex] = true;
 *  
 *  	- While Queue is not empty:
 *  		- current_vertex = Queue.pop();
 *  
 *  		- for each neighbor: curr_vertex:
 *  			- if neighbor is unvisited:
 *  				- Queue.add(neighbor);
 *  				- visited[neighbor] = true;
 *  
 *  - Time Complexity Analyis:
 *  
 *  	- "current_vertex = Queue.pop();" will be executed n (no. of vertices, V) times.
 *  	- "if neighbor is unvisited:" will be executed m (no. of edges, E) times.
 *  	- Hence, time complexity = O(n+m).
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- We are using a boolean array of size 'n' to keep a note of each visited vertex.
 *  	- Hence, space complexity = O(n).
 * 
 * */

public class BreadthFirstSearch {
	
	private static ArrayList<Integer> traversalOrder = new ArrayList<>(); 
	
	private static ArrayList<ArrayList<Integer>> getSampleGraph(){
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		// Adding neighbors of vertex 0.
		ArrayList<Integer> zero = new ArrayList<>();
		zero.add(1);
		zero.add(2);
		zero.add(3);
		graph.add(zero);
		
		// Adding neighbors of vertex 1.
		ArrayList<Integer> one = new ArrayList<>();
		graph.add(one);
		
		// Adding neighbors of vertex 2.
		ArrayList<Integer> two = new ArrayList<>();
		two.add(4);
		graph.add(two);
		
		// Adding neighbors of vertex 3.
		ArrayList<Integer> three = new ArrayList<>();
		graph.add(three);
		
		// Adding neighbors of vertex 3.
		ArrayList<Integer> four = new ArrayList<>();
		graph.add(four);
		
		return graph;
		
	}
	
	private static void BFS(ArrayList<ArrayList<Integer>> graph, int root, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(root);
		visited[root] = true;
		
		while(!queue.isEmpty()) {
			
			int vertex = queue.remove();
			traversalOrder.add(vertex);
			
			for(int neighbor: graph.get(vertex)) {
				if(!visited[neighbor]) {	
					queue.add(neighbor);
					visited[neighbor] = true;
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> graph = getSampleGraph(); // {{1,2,3},{},{4},{},{}}
		
		int vertexCount = graph.size();
		boolean[] visited = new boolean[vertexCount];
		
		int root = 0;
		BFS(graph, root, visited);
		
		System.out.println(traversalOrder);

	}

}
