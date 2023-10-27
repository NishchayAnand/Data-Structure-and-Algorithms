
/* Problem Statement: Given the head of a linked list, remove the nth node from the end of the list and 
 * 					  return its head.
 * 
 * 					  NOTE: nth node will always be a valid node.
 * 
 *  General Observations:
 *  
 *  	- Considering the size of linked list = length, nth node from last = (length-n+1)th node from 
 *  	  start.
 *  
 *  	- Brute Force Approach:
 *  
 *  		- Algorithm:
 *  		
 *  			- Iterate over linked list and calculate its size = "length";
 *  			- Iterate over linked list till you reach the "curr" = (length-n)th element:
 *  				- point curr.next pointer to (curr.next i.e., element to be deleted).next pointer;
 *  
 *  		- Time Complexity: O(n), but we are still making 2 pass (iterations) over the linked list.
 *  
 *  	- Two Pointers Approach:
 *  
 *  
 *  	- Ideology:
 *  
 * 
 * */


public class RemoveNthNodeFromEnd {
	
	public static Node removeNthFromEnd(Node head, int n) {

        Node start = new Node();
        start.next = head;

        Node fast = start;
        int counter = 1; 
        while(counter<=n){
            fast = fast.next;
            counter++;
        }

        Node slow = start;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        if(slow == start) {
        	start.next = start.next.next;
        } else {
        	slow.next = slow.next.next;        	
        }

        return head;
        
    }
	
	private static Node createLinkedList(int size) {
		
		Node head = null;
		Node prev = null;
		
		if(size >= 1) {
			Node node = new Node(1);
			head = prev = node;
		}
		
		for(int i=2; i<=size; i++) {
			Node node = new Node(i);
			prev.next = node;
			prev = node;
		}
		
		return head;
		
	}
	
	private static void printLinkedList(Node head) {
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Node head = createLinkedList(5);
		
		System.out.print("Original Linked List: ");
		printLinkedList(head);
		
		head = removeNthFromEnd(head, 1);
		
		System.out.print("Modified Linked List: ");
		printLinkedList(head);

	}

}
