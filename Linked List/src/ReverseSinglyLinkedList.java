
/* Problem Statement: Given the head of a singly linked list, reverse the linked list and return the new 
 * 					  head.
 * 
 * General Observations:
 * 
 * 	- In a singly linked list, every node is connected to at most one neighbor. 
 * 
 *  - We need to reverse every node-neighbor connection. 
 *  
 *  - For every curr node, we need to point curr.next to its prev element and we need to make sure we
 *    have a way to curr node to the next node to perform the same steps again. 
 * 
 * 	- Algorithm Time Complexity: O(n).
 * 		
 * 	- Algorithm Space Complexity: O(1).
 * 
 * */


public class ReverseSinglyLinkedList {
	
	private static Node reverse(Node head) {
		
		Node prev=null;
		Node curr=head;
		Node ahead=null;
		
		while(curr!=null) {
			ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		
		return prev;
		
	}

	public static void main(String[] args) {
		
		SinglyLinkedList  linkedList = new SinglyLinkedList();
		
		for(int i=1; i<=10; i++) {
			linkedList.addAtTail(i);
		}
		
		System.out.println("Original Linked List: " + linkedList);
		
		// reverse the linked list.
		Node newHead = reverse(linkedList.head);
		linkedList.tail = linkedList.head;
		linkedList.head = newHead;
		
		System.out.println("Reversed Linked List: "+linkedList);

	}

}
