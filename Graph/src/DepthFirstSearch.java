import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
	
	// Recursive Approach
	private static void RecursiveDFS(ArrayList<Integer>[] graph, int vertex, boolean[] visited) {
		
		visited[vertex] = true;
		System.out.print(vertex+" ");
		
		for(int neighbour : graph[vertex]) {
			
			if(visited[neighbour] == false) {
				RecursiveDFS(graph, neighbour, visited);
			}
			
		}
		
	}
	
	// Iterative Approach
	private static void IterativeDFS(ArrayList<Integer>[] graph, int root, boolean[] visited) {
		
		Stack<Integer> stack = new Stack<>();
		stack.add(root);
		visited[root] = true;
		
		while(!stack.isEmpty()) {
			
			int vertex = stack.pop();
			System.out.print(vertex+" ");
			
			for(int neighbour : graph[vertex]) {		
				if(visited[neighbour] == false) {
					stack.push(neighbour);
					visited[neighbour] = true; // needs to be done over here overwise we can get duplicate values in stack.
				}
			}
				
		}
		
	}

	public static void main(String[] args) {

		int V = 4;
		ArrayList<Integer>[] graph = new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(1);
		graph[0].add(2);
		
		graph[1].add(0);
		graph[1].add(3);
		
		graph[2].add(0);
		graph[2].add(3);
		
		graph[3].add(1);
		graph[3].add(2);
		
		boolean[] recursionVisited = new boolean[V];
		System.out.print("Recursive Depth-First Traversal: ");
		RecursiveDFS(graph, 0, recursionVisited);
		System.out.println();
		
		boolean[] iterationVisited = new boolean[V];
		System.out.print("Iterative Depth-First Traversal: ");
		IterativeDFS(graph, 0, iterationVisited);

	}

}
