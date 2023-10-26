
/* Problem Statement: Given the head of a singly linked list, return the middle node of the linked list.
 *
 *					  NOTE: If there are two middle nodes, return the second middle node.
 *
 * General Observations:
 * 
 * 	- 
 * 
 * */

public class MiddleOfSinglyLinkedList {
	
	private static Node getMiddleNode(Node head) {
		
		Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast.next == null){
            return slow;
        } else {
            return slow.next;
        }
        
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
