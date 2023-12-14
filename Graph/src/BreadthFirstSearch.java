import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Given a connected undirected graph, perform a Breadth First Traversal of the graph.

public class BreadthFirstSearch {
	
	private static void BFS(ArrayList<Integer>[] graph, int root, boolean[] inQueue) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		inQueue[root] = true;
		
		while(!queue.isEmpty()) {
			
			int vertex = queue.remove(); // will be executed for n (V) times.
			System.out.print(vertex+" ");
			
			for(int nbr: graph[vertex]) {
				if(!inQueue[nbr]) {		// will be executed for m (E) times.
					queue.add(nbr);
					inQueue[nbr] = true;
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
		
		boolean[] visited = new boolean[V];
		System.out.print("Breadth-First Traversal: ");
		BFS(graph, 0, visited);
		System.out.println();

	}

}
