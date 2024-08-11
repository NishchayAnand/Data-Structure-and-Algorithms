
/* Problem Statement: Given the head of a singly linked list, return true if it is a palindrome or false 
 * 					  otherwise.
 * 
 * General Observations:
 * 
 * 	- Algorithm:
 * 
 * 		1. Node mid = Find the middle element of the linked list.
 * 		2. Node tail = reverse the second half from mid till the end such that tail becomes the head of 
 * 					   the reversed linked list (the next of mid will now point to null). 
 * 		3. let left = head;
 * 		4. let right = tail;
 * 		5. Start iterating over the first half using left pointer and second half using the right pointer
 * 		   and compare value of the left pointer node and right pointer node. 
 * 		6. If any of the left point value does not match the right pointer value, then given linked list 
 *         is not a palindrome, else it is. 
 * 
 * */

public class PalindromeLinkedList {
	
	private static Node getMid(Node head) {
		
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static Node reverse(Node head) {
		Node prev = null;
		Node ahead = null;
		Node curr = head;
		while(curr!=null) {
			ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		return prev;
	}
	
	private static boolean isPalindrome(Node head) {
		
		Node mid = getMid(head);
		Node tail = reverse(mid);
		
		Node left = head;
		Node right = tail;
		while(right != null) {
			if(left.val != right.val) return false;
			left = left.next;
			right = right.next;
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(2);
		Node fifth = new Node(1);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		System.out.println(isPalindrome(first));

	}

}
