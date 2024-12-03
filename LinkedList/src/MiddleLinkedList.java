
/*

    Problem Statement: Given the head of a singly linked list, return the middle node of the linked
                       list.

                       NOTE: If there are two middle nodes (in case of linked list having even
                             number of nodes), return the second middle node (closer to the tail).

    General Observations:

        - Brute Force Approach:

            - Convert the linked list to array list and return the middle node in the arrayList.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - Two Pointers Approach: Fast and Slow Pointers

            - If a 'fast' pointer traverse the linked list twice as fast as the 'slow' pointer, when
              the 'fast' pointer reaches the end of the linked list, the 'slow' pointer would have
              traveled half the distance, landing exactly at the middle.

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class MiddleLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // stop at fast == null when we have odd numbered linked list.
        // stop at fast.next == null when we have even number linked list.
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        node4.next = node5;

        System.out.println(middleNode(node1).val);

    }
}
