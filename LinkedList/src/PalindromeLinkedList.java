
/*

    Problem Statement: Given the head of a singly linked list, return true if it is a palindrome or
                       false otherwise.

    General Observations:

        - Brute Force Approach:

            - Convert linked list to arraylist and use 2 pointers to check if the arraylist is
              palindrome or not.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        - Two Pointers + Reversing Approach:

            - Find the middle element and reverse the second half of the linked list. After
              reversing, the second half's nodes appear in the reverse order, making it easy to
              traverse and compare with the first half in a single pass.

            - Algorithm:

                - middleNode = findMid(head);
                - secondHalfNode = reverseList(middleNode);
                - while secondHalfCurrentNode != null: // length of the second half would be less than or equal to length of the first half.
                    - if firstHalfCurrentNode.val != secondHalfCurrentNode.val:
                        - return false;
                    - firstHalfCurrentNode = firstHalfCurrentNode.next;
                    - secondHalfCurrentNode = secondHalfCurrentNode.next;
                - return true;

           - Time Complexity: O(n).

           - Space Complexity: O(1).

*/

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        while(currentNode!=null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static boolean isPalindrome(ListNode head) {

        // find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the linked list
        ListNode secondHalfHead = reverseList(slow);

        ListNode firstHalfCurrentNode = head;
        ListNode secondHalfCurrentNode = secondHalfHead;
        while(secondHalfCurrentNode != null) {
            if(firstHalfCurrentNode.val != secondHalfCurrentNode.val) {
                return false;
            }
            firstHalfCurrentNode = firstHalfCurrentNode.next;
            secondHalfCurrentNode = secondHalfCurrentNode.next;
        }

        // restore the second half to its original state
        reverseList(secondHalfHead);

        return true;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(4);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        node3.next = node4;

        ListNode node5 = new ListNode(1);
        node4.next = node5;

        System.out.println(isPalindrome(node1));

    }

}
