
/*

    Problem Statement: Given the heads of two sorted linked lists 'list1' and 'list2'. Merge the
                       two lists into one sorted list. Return the head of the merged linked list.

    General Observations:

        - Iterative Approach:

            - Algorithm:

                - while list1 & list2 both not equal to NULL:
                    - if(list1.val <= list2.val):
                        - tail.next = list1;
                        - tail = tail.next;
                        - list1 = list1.next;
                    - else:
                        - tail.next = list2;
                        - tail = tail.next;
                        - list2 = list2.next;

                - if list1 not equal to NULL:
                    - tail.next = list1;

                - if list2 not equal to NULL:
                    - tail.next = list2;

            - NOTE: When merging two lists, the first node of the result list is determined
                    dynamically based on comparisons. Therefor, either:

                        1. Use two pointers: one (head) to initialize the result list and another
                                             (tail) to track the last node, or

                        2. Use dummy node: acts as a placeholder for the head of the merged list.

           - Time Complexity = O(n+m), where 'n' and 'm' represent the size of two input linked lists.

           - Space Complexity = O(1).

*/


public class MergeTwoSortedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null) tail.next = list1;
        if(list2 != null) tail.next = list2;

        return dummy.next;

    }

}
