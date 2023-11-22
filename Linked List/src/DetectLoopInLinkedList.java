
/* Problem Statement: Given the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- use a hashMap(keys = Node, values = boolean) to mark the nodes as visited as we iterate over the
 * 		  linked list.
 * 
 * 		NOTE: make sure to use key as Nodes to make sure the algorithm works fine for duplicate node 
 * 			  values.
 * 
 *  	- Time Complexity Analysis: O(N).
 *  
 *  	- Space Complexity Analysis: O(N).
 *  
 *  - Floyd cycle detection:
 *  
 *  	- If you have two pointers on an infinite strip separated by a distance of k units, and you move 
 *  	  the first pointer by 2 units and the second pointer by 1 unit in each iteration, the distance 
 *  	  between the two pointers will decrease by 1 in each iteration.
 *  	
 *  	- Given that the distance between the pointers decreases by 1 unit with every iteration, 
 *  	  eventually, the pointers will collide when the distance between them becomes 0.
 *  
 *  	- A cycle is like a infinite strip. 
 * 	
 * 
 * */


public class DetectLoopInLinkedList {
	
	// return node represent the node where the fast and slow pointers collided.
	public static Node detectCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return slow;
            }
        }

        return null;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
