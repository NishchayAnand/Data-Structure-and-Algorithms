
/* Problem Statement: Given the head of a singly linked list, return the middle node of the linked list.
 *
 *					  NOTE: If there are two middle nodes, return the second middle node.
 *
 * General Observations:
 * 
 * 	- Ideology: Based on the concept of using two pointers, one moving faster than the other, to divide 
 * 				the list into two halves. 
 * 
 * 	- Algorithm:
 * 
 * 		- Initialize two pointers: "slow" and "fast", both pointing to the head of the linked list;
 * 		- Iterate over the linked list till fast is not null:
 * 			- advance the "fast" pointer by two nodes and the "slow" pointer by one node;
 * 		- return slow;
 * 
 * 		- NOTE: By the time the "fast" pointer reaches the end of the list, the "slow" pointer will be at 
 * 				the midpoint of the list. 
 * 
 * */

public class MiddleOfSinglyLinkedList {
	
	private static Node getMiddleNode(Node head) {
		
		Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
        
	}

	public static void main(String[] args) {
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
		// Test Case 1: Linked List containing odd number of nodes.
		for(int i=1; i<=5; i++) {
			linkedList.addAtTail(i);
		}
		
		System.out.println("Test Case 1:");
		System.out.println("\tLinked List: " + linkedList);
		System.out.println("\tMiddle Element = " + getMiddleNode(linkedList.head).val);
		
		
		// Test Case 2: Linked List containing even number of nodes.
		linkedList.addAtTail(6);
		
		System.out.println("Test Case 2:");
		System.out.println("\tLinked List: " + linkedList);
		System.out.println("\tMiddle Element = " + getMiddleNode(linkedList.head).val);
		
	}

}
