
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

        if(c1!=null){
            c3.next = c1;
        }

        if(c2!=null){
            c3.next = c2;
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

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,4};
		Node list1 = LinkedListUtils.createLinkedList(arr1);
		System.out.print("First Linked List: ");
		LinkedListUtils.print(list1);
		
		int[] arr2 = {1,3,4,5,6};
		Node list2 = LinkedListUtils.createLinkedList(arr2);
		System.out.print("Second Linked List: ");
		LinkedListUtils.print(list2);
		
		Node new_head = mergeTwoListsRecursive(list1, list2);
		
		System.out.print("Merged Linked List: ");
		LinkedListUtils.print(new_head);
		
	}

}
