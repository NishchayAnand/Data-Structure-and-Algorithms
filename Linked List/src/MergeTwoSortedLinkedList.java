
/* Problem Statement: Given the heads of two sorted linked lists 'list1' and 'list2', merge the two lists 
 * 					  into one sorted list.
 * 
 * General Observations:
 * 
 * 	- Create a dummy node and use a tail pointer to populate the merged linked list. 
 * 
 * 	- Algorithm Time Complexity: O(m+n), m = size of 'list1', n = size of 'list2'
 * 
 * */

public class MergeTwoSortedLinkedList {
	
	public static Node mergeTwoLists(Node list1, Node list2) {

        Node dummy = new Node();
        Node tail = dummy;

        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        while(list1!=null){
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }

        while(list2!=null) {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }

        return dummy.next;
        
    }

	public static void main(String[] args) {
		
		Node node1 = new Node(1);
		Node list1 = node1;
		Node node2 = new Node(2);
		node1.next = node2;
		Node node3 = new Node(4);
		node2.next = node3;
		
		
		Node curr = list1;
		System.out.print("List1 = [");
		while(curr!=null) {
			System.out.print(curr.val+", ");
			curr = curr.next;
		}
		System.out.println("]");
		
		node1 = new Node(1);
		Node list2 = node1;
		node2 = new Node(3);
		node1.next = node2;
		node3 = new Node(4);
		node2.next = node3;
		
		curr = list2;
		System.out.print("List2 = [");
		while(curr!=null) {
			System.out.print(curr.val+", ");
			curr = curr.next;
		}
		System.out.println("]");
		
		Node mergedHead = mergeTwoLists(list1, list2);
		
		curr = mergedHead;
		System.out.print("Merged List = [");
		while(curr!=null) {
			System.out.print(curr.val+", ");
			curr = curr.next;
		}
		System.out.println("]");

		
	}

}
