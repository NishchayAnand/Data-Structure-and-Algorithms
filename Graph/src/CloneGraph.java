import java.util.ArrayList;
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
 * 					  (clone) of the graph.
 * 
 * General Observations:
 * 
 * 
 * 	- For any visited node, 
 * 
 * 		- check if it has been cloned before:
 * 
 * 			- if yes:
 *				- return the cloned copy:
 *
 *			- else:
 *				- clone the node;
 *				- loop over its neighbours:
 *					- ask algorithm to get the cloned copy of the neighbour;
 *					- add the cloned nighbour to the cloned node's neighbours' list;
 *
 *			- return the cloned node;
 * 
 * 	- When a node is visited, create a clone of it.
 * 
 * 		- for each of its neighbour:
 * 
 * 			- if neighbour is already cloned:
 * 				- then add the cloned neighour to its neigbour list;
 * 			- else:
 * 				- peform DFS on the neighbour, i.e, visit the neighbour and do the same things as step 1;
 * 
 * 	- return the reference of the cloned node. 
 * 			
 * 
 * */

public class CloneGraph {

	public static void main(String[] args) {
		

	}

}
