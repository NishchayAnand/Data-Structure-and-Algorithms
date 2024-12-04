
/*

    Problem Statement: Given the heads of two singly linked-lists 'headA' and 'headB', return the
            node at which the two lists intersect. If the two linked lists have no intersection at
            all, return null.

            NOTE: There are no cycles anywhere in the entire linked structure.

    General Observations:

        - Brute Force Approach:

            - Store each node of listA in a Hashset. Traverse through listB and check if any
              node already exist in the hashset.

            - Time Complexity: O(n+m).

            - Space Complexity: O(n).

       - Let listA = |-------------------|-------------|
                      <-------A'--------> <-----C----->

       - Let listB = |------------------------|-------------|
                      <----------B'----------> <-----C----->

       - Two Pointers Approach:

            - Use two pointers to traverse both lists simultaneously. If one pointer reaches the end
              of its list, redirect it to the head of the other list.

            - When the two pointers meet, they are at the intersection node (or both are null if
              there's no intersection).

            - listA = |-------------------|-------------|------------------------||
                       <-------A'--------> <-----C-----> <----------B'---------->

            - listB = |------------------------|-------------|-------------------||
                       <----------B'----------> <-----C-----> <-------A'-------->

            - NOTE: The two pointers will traverse the same number of nodes.

            - Time Complexity: O(n+m).

            - Space Complexity: O(1).

*/

public class IntersectionLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode getIntersectionNodeUnderstanding(ListNode headA, ListNode headB) {

        ListNode currentListANode = headA;
        ListNode currentListBNode = headB;

        while(currentListANode!=null && currentListBNode!=null) {

            if(currentListANode == currentListBNode) {
                return currentListANode;
            }
            else if(currentListANode.next == null) {
                currentListANode = headB;
                currentListBNode = currentListBNode.next;
            }
            else if(currentListBNode.next == null) {
                currentListANode = currentListANode.next;
                currentListBNode = headA;
            } else {
                currentListANode = currentListANode.next;
                currentListBNode = currentListBNode.next;
            }

        }

        return null;

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1; // Either the intersection node or null

    }

    public static void main(String[] args) {

        // listA = 4 -> 1 -> 8 -> 4 -> 5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(8, node4);
        ListNode listANode2 = new ListNode(1, node3);
        ListNode headA = new ListNode(4, listANode2);

        // listB = 5 -> 1 -> 8 -> 4 -> 5
        ListNode listBNode2 = new ListNode(1, node3);
        ListNode headB = new ListNode(4, listBNode2);

        ListNode intersectNode = getIntersectionNode(headA, headB);
        if (intersectNode!=null) System.out.println(intersectNode.val);

    }

}
