import java.util.ArrayList;

public class DepthFirstSearch {
	
	private static void DFS(ArrayList<Integer>[] graph, int vertex, boolean[] visited) {
		
		visited[vertex] = true;
		System.out.print(vertex+" ");
		
		for(int neighbour : graph[vertex]) {
			
			if(visited[neighbour] == false) {
				DFS(graph, neighbour, visited);
			}
			
		}
		
	}

	public static void main(String[] args) {

		int V = 4;
		ArrayList<Integer>[] graph = new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		graph[0].add(1);
		graph[0].add(2);
		
		graph[1].add(0);
		graph[1].add(3);
		
		graph[2].add(0);
		graph[2].add(3);
		
		graph[3].add(1);
		graph[3].add(2);
		
		boolean[] visited = new boolean[V];

		System.out.print("Depth-First Traversal: ");
		DFS(graph, 0, visited);

	}

}
