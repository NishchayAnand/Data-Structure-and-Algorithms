
/* Problem Statement: Given the head of a linked list, return the node where the cycle begins. If there is
 * 					  no cycle, return null.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- use a hashMap(keys = Node, values = boolean) to mark the nodes as visited as we iterate over the
 * 		  linked list. The starting node of the loop in the linked list will be the node which gets 
 * 		  repeated the first time while iteration. 
 * 
 * 		NOTE: make sure to use key as Nodes to make sure the algorithm works fine for duplicate node 
 * 			  values.
 * 
 *  	- Time Complexity Analysis: O(N).
 *  
 *  	- Space Complexity Analysis: O(N).
 * 
 * 	- In Floyd cycle detection algorithm, the fast and slow pointer will always collide before the 
 * 	  slow pointer makes a complete rotation of the loop/cycle. The fast pointer will only make a single
 * 	  rotation in that time. 
 * 
 * */


public class FindLoopStartInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
