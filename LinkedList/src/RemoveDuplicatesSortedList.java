
/*

    Problem Statement: Given the head of a linked list, delete all duplicates.

                       NOTE: Return the linked list in the same sorted order.

    General Observations:

        - Brute Force Approach:

            - Use a HashSet to store values of all the unique nodes.

            - Algorithm:
                - Traverse each currentNode in the linked list:
                    - if currentNode.val not in HashSet:
                        - HashSet.add(currentNode.val);
                    - else:
                        - prev.next = current.next;
                    - prev = current;
                    - current = current.next;

        - In a sorted linked list, all duplicate elements are adjacent to each other.

        - Algorithm:

            - Traverse each currentNode (except the last node) in linked list:
                - while currentNode.val == currentNode.next.val:
                    - currentNode.next = currentNode.next.next;
                - current = current.next;

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/


public class RemoveDuplicatesSortedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static void display(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                // Skip the duplicate node
                curr.next = curr.next.next;
            }
            else {
                // Move to the next node
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        display(deleteDuplicates(node1));

    }
}
