
/* Problem Statement: Given the head of a linked list, reverse the linked list and return the new head.
 * 
 * General Observations:
 * 
 * 	- Ideology:
 * 
 * 		- Iterate over linked list:
 * 			- point each node's next property to its previous node. 
 * 
 * 	- Algorithm:
 * 		
 * 		- curr = head;
 * 		- prev = null;
 * 		- while curr != null:
 * 			- ahead = curr.next; 	// a temp pointer used to point curr to the next node. 
 * 			- curr.next = prev;
 * 			- prev = curr;
 * 			- curr = ahead;
 * 		- head = prev; 				// point the head to the start of the reversed linked list.	
 * 
 * 		- Time Complexity: O(n).
 * 		
 * 		- Space Complexity: O(1).
 * 
 * */


public class ReverseSinglyLinkedList {
	
	private static Node reverse(Node head) {
		
		Node curr=head, prev=null, ahead=null;
		
		while(curr!=null) {
			ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		
		return head = prev;
		
	}

	public static void main(String[] args) {
		
		SinglyLinkedList  linkedList = new SinglyLinkedList();
		
		for(int i=1; i<=10; i++) {
			linkedList.addAtTail(i);
		}
		
		System.out.println("Original Linked List: "+linkedList);
		
		// reverse the linked list.
		reverse(linkedList.head);
		
		System.out.println("Reversed Linked List: "+linkedList);

	}

}
