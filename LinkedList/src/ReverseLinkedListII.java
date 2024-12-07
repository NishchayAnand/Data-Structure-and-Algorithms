
/*

    Problem Statement: Given the 'head' of a singly linked list and two integers 'left' and 'right'
                       where left <= right, reverse the nodes of the list from position 'left' to
                       position 'right', and return the reversed list.

    General Observations:

        - Number of nodes that need to be reversed = right - left + 1.

        - Algorithm:
            1. Traverse the list to find the 'leftNode' (node at 'left' position).
            2. Reverse the sublist between 'leftNode' and 'rightNode' (node at 'right' position).
            3. Reconnect the 'previousOfLeftNode' to the 'reversedSublistHead' and 'nextOfRightNode' to
               the 'reversedSublistTail'.

            - NOTE: Post reversing the sublist:
                - 'previousOfLeftNode.next' would be pointing to 'reversedSublistTail'.
                - 'currentNode' would be pointing to 'nextOfRightNode'.

        - Time Complexity: O(n).

        - Space Complexity: O(1).

        - Edge Cases:

            - If left == right, no need to reverse as sublist contains only one node.

            - When 'left' = 1, the reversal affects the head of the linked list. Simply starting
              with 'previousLeftNode = null' in such cases can cause 'NullPointerException' when
              reconnecting the reversed sublist to the main list. Use a dummy node as a placeholder
              node that always points to the head of the list. Even if the head changes, the dummy
              remains the fixed entry point.

*/

public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static void display(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        // Step 1: Traverse to the node before 'left' position: will stop when pos = left
        ListNode previousLeftNode = dummy;
        ListNode currentNode = dummy.next;
        for(int pos = 1; pos < left; pos++) {
            previousLeftNode = currentNode;
            currentNode = currentNode.next;
        }

        // Step 2: Reverse the sublist: will stop when reverseNodeCount becomes equal to (right-left+1)
        ListNode reversedSublistHead = null;
        for(int reverseNodeCount=0; reverseNodeCount<(right-left+1); reverseNodeCount++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = reversedSublistHead;
            reversedSublistHead = currentNode;
            currentNode = nextNode;
        }

        // Step 3: Reconnect the reversed sublist.
        previousLeftNode.next.next = currentNode;
        previousLeftNode.next = reversedSublistHead;

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        display(node1);

        display(reverseBetween(node1, 2,4));

    }
}
