
/*

    Problem Statement: Given the head of a singly linked list, return true if it is a palindrome or
                       false otherwise.

    General Observations:

        - Brute Force Approach:

            - Convert linked list to arraylist and use 2 pointers to check if the arraylist is
              palindrome or not.

            - Time Complexity: O(n).

            - Space Complexity: O(n).

        -

*/

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        return true;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
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
