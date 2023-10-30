

class Node {
		
	int val;
	Node next;
			
	Node(){}
			
	Node(int val){
		this.val = val;
	}
	
}

public class LinkedListUtils {
	
	LinkedListUtils(){}
	
	public static void print(Node head) {
		
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val+" ");
			curr = curr.next;
		}
		System.out.println();
		
	}
	
	public static Node createLinkedList(int[] arr) {
		
		Node list = new Node();
		Node curr = list;
		
		for(int element: arr) {
			Node node = new Node(element);
			curr.next = node;
			curr = curr.next;
		}
		
		return list.next;
		
	}

}
