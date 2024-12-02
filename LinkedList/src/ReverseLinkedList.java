
/*

    Problem Statement: Given the head of a singly linked list, reverse the list, and return the head
                       of the reversed list.

    General Observations:

        - Each node points to the next node using a 'next' pointer. Reversing the list means making
          each node's 'next' pointer point to its previous node instead of the next node.

        - The problem is naturally recursive in nature, i.e., to reverse a list starting at node
          'head', you trust the recursive function to reverse the sublist starting at 'head.next'
          then reconnect head to the tail of the reversed sublist using 'head.next.next = head'.

        - Recursive Approach:

            - Hypotheses: F(node) will reverse the linked starting at 'node'.

            - Recursive Steps:
                - newHead = F(head.next);
                - head.next.next = head; // Reconnect head to the tail of the reversed sublist
                - head.next = null; // Important: Break the forward link
                - return newHead;

            - Base Conditions:

                - if head.next == null, i.e., if linked list has just one node:
                    - return head;

            - Time Complexity: O(n+n) ~ O(n).

            - Space Complexity: O(n).

        - To reverse a linked list, we need to keep track of the previous node (prevNode), the
          current node (currentNode), and the next node (next_node) as we traverse the list.

        - Iterative Approach:

            - Algorithm:
                - For each node 'currentNode' in linked list:
                    - currentNode.next = previousNode;
                    - previousNode = currentNode;
                - return previousNode;

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) { this.val = val; }
    }

    private static void display(ListNode head) {
        ListNode curr = head;
        while(curr!=null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Iterative Approach
    public static ListNode reverseListInteractive(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        while(currentNode != null ) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static ListNode reverseListRecursion(ListNode head) {

        if (head.next==null) return head;

        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;

        display(node1);

        ListNode newHead = reverseListInteractive(node1);

        display(newHead);

    }


}
