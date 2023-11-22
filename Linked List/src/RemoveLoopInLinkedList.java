
/* Problem Statement: Given a linked list such that it may contain a loop. Remove the loop from the linked
 *  				  list, if it is present, i.e. unlink the last node which is forming the loop.
 * 
 * */

public class RemoveLoopInLinkedList {
	
	public static void removeLoop(Node head) {
		
		Node loopStart = FindLoopStartInLinkedList.getLoopStartNode(head);
		
		if(loopStart == null) {
			return;
		}
		
		Node temp = loopStart;
		while(temp.next != loopStart) {
			temp = temp.next;
		}
		
		temp.next = null;
		
	}

	public static void main(String[] args) {
		
		
	}

}
