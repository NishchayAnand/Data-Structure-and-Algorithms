import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

	Problem Statement:

		- Given a reference of a node in a connected undirected graph. return a deep copy (clone) of the graph.

		- NOTE:
			- Each node's value is the same as the node's index (1-indexed).
			- The given node will always be the first node with val = 1.

	General Observations:

		- The problem requires us to traverse the entire graph and create copies of each node while maintaining their
		  connections.

		- Intuition:
			- Use Depth-First-Search to traverse over the given graph.

		- Algorithm:

			- Hypothesis:
				- F(node) will return a deep copy of node and all its neighbors.

			- Recursive Steps:
				- clonedNode = Node(node);
				- for each neighbor in node:
					- clonedNeighbor = F(neighbor);
					- clonedNode.add(clonedNeighbor);
				- return clonedNode;

			- Base Conditions:
				- if clonedNode of node exists: return clonedNode;

			NOTE: Use a HashMap to keep track of cloned nodes.

			- Time Complexity: O(V+E)

			- Space Complexity: O(V)

*/

public class CloneGraph {

	static class Node {

		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}

	}
	
	private static Node DFS(Node node, Map<Node, Node> clones) {

		// Base Conditions:
		if(clones.containsKey(node)) return clones.get(node);

		// Recursive Steps:
		Node clonedNode = new Node(node.val);
		clones.put(node, clonedNode);
		
		for(Node neighbor: node.neighbors) {
			Node clonedNeighbor = DFS(neighbor, clones);
			clonedNode.neighbors.add(clonedNeighbor);
		}
		
		return clonedNode;
		
	}
	
    private static Node cloneGraph(Node node) {
		if(node == null) return null;
    	Map<Node, Node> clones = new HashMap<>();
        return DFS(node, clones);
    }

	public static void main(String[] args) {

		int[][] adj = {{2,4},{1,3},{2,4},{1,3}};
		int V = adj.length;

		// Create vertices
		Node[] nodes = new Node[V];
		for(int i=0; i<V; i++) {
			nodes[i] = new Node(i+1);
		}

		// Create edges
		for(int i=0; i<V; i++) {
			Node node = nodes[i];
			int[] edges = adj[i];
			for(int edge: edges) {
				Node neighbor = nodes[edge-1];
				node.neighbors.add(neighbor);
			}
		}

		Node clonedRootNode = cloneGraph(nodes[0]);
		
	}

}
