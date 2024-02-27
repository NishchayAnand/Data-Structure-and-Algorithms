import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
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

/* Problem Statement: Given a reference of a node in a connected undirected graph, return a deep copy 
 * 					  a.k.a "clone of the graph".
 * 
 * General Observations:
 * 			
 * - We can use Depth-First-Search to traverse over the given graph.
 * 
 * - Hypothesis:
 * 
 * 		- DFS(node, cloned) will create a clone of 'node' and all its neighbours (direct/indirect) and 
 * 		  return the cloned 'node'.
 * 
 * - Recursive Steps:
 * 
 * 		- clone = Node(node.val);
 * 		- cloned(node);
 * 		- for each neighbour of node:
 * 			- neighbourClone = DFS(neighbour, cloned);
 * 			- clone.neighbors.add(neighbourClone);
 * 		- return clone;
 * 
 * - Base Condition:
 * 		
 * 		- if cloned.contains(node):
 * 			- return node->clone;
 * 
 * - NOTE: We need to maintain a "mapping of each node and its clone". Hence, 'cloned' should be a 
 * 		   HashMap where:
 * 				- original node -> key,
 * 				- clone node -> value.
 * 
 * - Time Complexity Analysis:
 * 
 * 		- "clone = Node(node.val)" will be executed 'n' (no. of vertices) times.
 *  
 *  	- "cloned.neighbors.add(nbrClone)" will be executed 'm' (no of edges) times.
 *  
 *  	- Therefore, time complexity = O(n+m).
 * 
 * - Space Complexity Analysis:
 * 		
 * 		- We are using a 'isCloned' HashMap which will store mapping of each cloned vertex. Hence, 
 *        the space consumed by the HasMap would be of order "n". 
 *        
 *      - Therefore, space complexity = O(n).
 * 
 * */

public class CloneGraph {
	
	private static Node createSampleInput() {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		
		return node1;
	}
	
	private static Node clone(Node node, HashMap<Node, Node> isCloned) {
		
		if(isCloned.containsKey(node)) {
			return isCloned.get(node);
		}
		
		Node cloned = new Node(node.val);
		isCloned.put(node, cloned);
		
		for(Node nbr: node.neighbors) {
			Node nbrClone = clone(nbr, isCloned);
			cloned.neighbors.add(nbrClone);
			
		}
		
		return cloned;
		
	}
	
    private static Node cloneGraph(Node node) {
    	
    	HashMap<Node, Node> isCloned = new HashMap<>();
    	
        return clone(node, isCloned);
        
    }

	public static void main(String[] args) {
		
		Node node = createSampleInput();
	
		Node clonedNode = cloneGraph(node);
		
	}

}
