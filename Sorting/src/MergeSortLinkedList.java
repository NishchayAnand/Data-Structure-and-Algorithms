

/* General Observations:
 * 
 * 	- Hypothesis: F(head) will sort the linked list starting from "head" using merge sort algorithm. 
 * 
 * 	- Recursive Steps: 1. Node mid = findMid(head); // in case of even elements, return the first middle node.
 * 
 * 					   2. right_sorted_linked_list_head = F(mid.next);
 * 
 * 					   3. mid.next = null; // IMPORTANT: To divide the linked list under-consideration 
 * 														 into 2 halves.
 * 
 * 					   4. left_sorted_linked_list_head = F(head);
 * 
 * 					   5. return merge(left_sorted_linked_list_head, right_sorted_linked_list_head);
 * 
 * 	- Base Condition: if head == null || head.next == null, return head; i.e., if the linked list is empty 
 * 					  or just have a single element, no action required. 
 * 
 *  - Time Complexity Analysis:
 *  	
 *  	- The max depth of the recursive tree will be logn and at each level, we will peform n operations,
 *  	  therefore, time complexity = O(nlogn).
 *  
 *  - Space Complexity Analysis:
 *  	
 *  	- Since, we are not using any auxiliary space, the space complexity will only depend on the 
 *  	  call stack space consumption, therefore, space complexity = O(logn).
 * 
 * */


public class MergeSortLinkedList {
	
	private static Node findMid(Node head) {
		
		Node fast = head;
		Node slow = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	private static Node merge(Node list1, Node list2) {
		
		Node list3 = new Node();
		
		Node p1 = list1;
		Node p2 = list2;
		Node p3 = list3;
		
		while(p1!=null && p2!=null) {
			if(p1.val <= p2.val) {
				p3.next = p1;
				p1 = p1.next;
			} else {
				p3.next = p2;
				p2 = p2.next;
			}
			p3 = p3.next;
		}
		
		if(p1!=null) {
			p3.next = p1;
		}
		
		if(p2!=null) {
			p3.next = p2;
		}
		
		return list3.next;
		
	}

	private static Node mergeSort(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node mid = findMid(head);
		
		Node right_sublist_head = mergeSort(mid.next);
		
		mid.next = null;
		Node left_sublist_head = mergeSort(head);
		
		return merge(left_sublist_head, right_sublist_head);
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,2,1,6,3};
		Node head = LinkedListUtils.createLinkedList(arr);
		System.out.print("Original Linked List: ");
		LinkedListUtils.print(head);
		
		Node new_head = mergeSort(head);
		System.out.print("Sorted Linked List: ");
		LinkedListUtils.print(new_head);
		
	}

}
