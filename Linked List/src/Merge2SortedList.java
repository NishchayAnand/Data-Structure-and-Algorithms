
public class Merge2SortedList {
	
	private static Node mergeTwoListsIterative1(Node list1, Node list2) {

        Node list3 = null;

        Node c1 = list1;
        Node c2 = list2;
        Node c3 = list3;

        while(c1!=null && c2!=null){
            if(c1.val <= c2.val){
            	if(list3 == null) {
            		c3 = list3 = c1;
            	} else {
            		c3.next = c1;
            		c3 = c3.next;
            	}
                c1 = c1.next;
            } else {
            	if(list3 == null) {
            		c3 = list3 = c2;
            	} else {
            		c3.next = c2;
            		c3 = c3.next;
            	}
                c2 = c2.next;
            }
            
        }

        while(c1!=null){
            c3.next = c1;
            c1 = c1.next;
            c3 = c3.next;
        }

        while(c2!=null){
            c3.next = c2;
            c2 = c2.next;
            c3 = c3.next;
        }

        return list3;
        
    }
	
	// using dummy node.
	private static Node mergeTwoListsCleanIterative(Node list1, Node list2) {

        Node list3 = new Node();

        Node c1 = list1;
        Node c2 = list2;
        Node c3 = list3;

        while(c1!=null && c2!=null){
            if(c1.val <= c2.val){
            	c3.next = c1;
                c1 = c1.next;
            } else {
            	c3.next = c2;
                c2 = c2.next;
            }
            c3 = c3.next;   
        }

        while(c1!=null){
            c3.next = c1;
            c1 = c1.next;
            c3 = c3.next;
        }

        while(c2!=null){
            c3.next = c2;
            c2 = c2.next;
            c3 = c3.next;
        }

        return list3.next;
        
    }
	
	private static Node mergeTwoListsRecursive(Node list1, Node list2) {
		
		if(list1 == null) {
			return list2;
		}
		
		if(list2 == null) {
			return list1;
		}
		
		Node head = null;
		if(list1.val<=list2.val) {
			head = list1;
			head.next = mergeTwoListsRecursive(list1.next, list2);
		} else {
			head = list2;
			head.next = mergeTwoListsRecursive(list1, list2.next);
		}
		
		return head;
		
	}
	
	private static void print(Node head) {
		
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val+" ");
			curr = curr.next;
		}
		
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.addAtTail(1);
		list1.addAtTail(2);
		list1.addAtTail(4);
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.addAtTail(1);
		list2.addAtTail(3);
		list2.addAtTail(4);
		
		Node new_head = mergeTwoListsRecursive(list1.head, list2.head);
		
		System.out.print("Merged Linked List: ");
		print(new_head);
		
	}

}
