public class ReverseLinkedList {
	
	class ListNode {
		int val;
		ListNode next;
		
		ListNode() {}
		
		ListNode(int val) { this.val = val; }
		
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode reverseListIterative(ListNode head) {

//        if(head == null){
//            return null;
//        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead;
//        ListNode ahead = head.next;

        while(curr!=null){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
//            ahead = ahead.next; -> will throw error when curr = tail element.
        }

        return head = prev;
        
    }
    
    public ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode rest_head = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest_head;
    }

    public ListNode reverseListRecursive(ListNode head) {

        if(head == null){
            return null;
        }

        return reverse(head);
        
    }
    
}