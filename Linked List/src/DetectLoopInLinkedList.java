
/* Problem Statement: Given the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * General Observations:
 * 
 * 	- Each node object in a linked list is unique, even if the values they hold are the same.
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- Iterate over the Linked List and store each visited Node in a HashSet. While iterating, if we
 * 		  jump upon a node which is already present in the HashSet, then we have a Cycle in Linked List.
 * 
 * 		- NOTE: Store the Node objects in the HashSet to make sure the algorithm works fine for duplicate 
 * 				node values.
 * 
 *  	- Time Complexity Analysis: O(n).
 *  
 *  	- Space Complexity Analysis: O(n).
 *  
 *  - Floyd Cycle Detection Approach: 
 *  	
 *  	- Assume you have two pointers on an infinite strip separated by a distance of 'k' units. 
 *  
 *  	- If you starting moving the first pointer (behind) by 2 units and the second pointer (ahead) by 1
 *  	  unit, the distance between the two pointers will start decreasing by 1 unit in each iteration 
 *  	  and will eventually reduce to 0, i.e., the two pointers will collide.
 *  	
 *  	- A cycle in a Linked List can be thought of as an infinite strip. 
 *  
 *  	- Time Complexity: ?
 *  
 *  	- Space Complexity: O(1).
 *  
 * */


public class DetectLoopInLinkedList {
	
	public static Boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){ // could be figured out through dry run.
            fast = fast.next.next; // jump of 2 units.
            slow = slow.next;	   // jump of 1 unit.
            if(slow == fast){
                return true;
            }
        }

        return false;
        
    }

	public static void main(String[] args) {

	}

}
