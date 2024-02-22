import java.util.ArrayList;
//import java.util.Stack;

/* Problem Statement: Given a "connected" undirected graph, perform a Depth First Traversal of the graph.
 * 
 * General Observations:
 * 
 * 	- Graphs can contain cycles. Hence, to avoid processing a vertex more than once, we must use a 
 *    boolean "visited" array (to maintain metadata for visited vertex).
 *    
 *  - The core idea is to visit a vertex, mark it as visited and tell the procedure to do the same for
 *    all its unvisited neighbours. 
 *    
 *  - The problem is naturally recursive in nature.
 *  
 *  - Hypothesis:
 *  	
 *  	- F(graph, visited, vertex) will visit all the unvisited vertices connected (directly/indirectly)
 *        to the input vertex.
 *  
 *  - Recursive Steps:
 *  
 *  	- visted[vertex] = true;
 *  	- for neighbour in graph[vertex]:
 *  		- if !visited[neighbour]:
 *  			- F(graph, visited, neighbour);
 *  
 *  - Base Condition:
 *  
 *  	- Ideally, the base condition could be "to not do anything if a vertex is already visited".
 *        However, since we are only calling F() for unvisited neighbours, we don't to explicitly 
 *        define any base condition in the code.
 *        
 *  - Time Complexity Analysis:
 *  
 * 		- "visited[vertex] = true;" --> will be executed 'n' (no. of vertices) times.
 *  
 *  	- "!visited[neighbour]" --> will be executed 'm' (no of edges) times.
 *  
 *  	- Therefore, time complexity = O(n+m). 
 *  
 *  - Space Complexity Analysis:
 *  
 *  	- We are using a visited boolean array of length 'n'. Therefore, space complexity = O(n).
 *  
 * 	- Extra:
 * 
 * 		- A stack data structure can be used to replicate the recursive nature of the code. 
 * 
 * 		- Stack would allow us to write an iterative code and help us avoid the overhead that comes with 
 *        recursion (litters the call stack with multiple stack frames that can lead to stack overflow 
 *        error).
 * 
 * */

public class DepthFirstSearch {
	
	@SuppressWarnings("unchecked")
	private static ArrayList<Integer>[] getSampleGraph(int vertexCount){

		ArrayList<Integer>[] graph = new ArrayList[vertexCount];
		
		for(int i=0; i<vertexCount; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int vertex=0; vertex < vertexCount; vertex++) {
			for(int neighbour = 0; neighbour < vertexCount; neighbour++) {
				if(vertex != neighbour) {
					graph[vertex].add(neighbour);
				}
			}
		}
		
		return graph;
		
	}
	
	private static void DFS(ArrayList<Integer>[] graph, boolean[] visited, int vertex) {
		
		visited[vertex] = true; 
		System.out.print(vertex + " ");
		
		for(int neighbour : graph[vertex]) {
			if(!visited[neighbour]) {
				DFS(graph, visited, neighbour);
			}
		}
		
	}
	
	/*
	private static void IterativeDFS(ArrayList<Integer>[] graph, int root, boolean[] visited) {
		
		Stack<Integer> stack = new Stack<>();
		stack.add(root);
		visited[root] = true;
		
		while(!stack.isEmpty()) {
			
			int vertex = stack.pop(); // will exexute n (V) times.
			System.out.print(vertex+" ");
			
			for(int neighbour : graph[vertex]) {		
				if(visited[neighbour] == false) { // will execute m (E) times.
					stack.push(neighbour);
					visited[neighbour] = true; // needs to be done here overwise we can get duplicate values in stack.
				}
			}
				
		}
		
	}
	*/

	public static void main(String[] args) {

		ArrayList<Integer>[] graph = getSampleGraph(4);
		boolean[] visited = new boolean[4];
		
		DFS(graph, visited, 0);

	}

}
