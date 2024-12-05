
/*

    Problem Statement: Given a linked list such that each node contains an additional random pointer,
                       either pointing to any node in the list, or null.

                       Construct a deep copy of the list. Return the head of the copied linked list.

                       NOTE: None of the pointers in the new list should point to nodes in the
                             original list.

    General Observations:

        - Brute Force Approach:

            - Use a Hashmap to store mapping between the original list nodes and their corresponding
              copy in the copied linked list.

            - Algorithm:

                - Traverse each currentNode in the original linked list:
                    - Create a copy of the currentNode.
                    - Add {currentNode: copiedNode} mapping in the map.

                - Traverse each currentNode in the original linked list:
                    - set map.get(currentNode).next = map.get(currentNode.next);
                    - set map.get(currentNode).random = map.get(currentNode.random);

            - Time Complexity: O(n+n) ~ O(n).

            - Space Complexity: O(n).

*/

import java.util.HashMap;

public class CopyListRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            String randomVal = random == null ? "Null" : Integer.toString(random.val);
            return "[" + val + ", " + randomVal + "]";
        }
    }

    private static void display(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current+" ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        Node currentNode = head;
        while(currentNode != null) {
            Node copiedNode = new Node(currentNode.val);
            map.put(currentNode, copiedNode);
            currentNode = currentNode.next;
        }

        currentNode = head;
        while(currentNode != null) {
            Node copiedNode = map.get(currentNode);
            copiedNode.next = map.get(currentNode.next);
            copiedNode.random = map.get(currentNode.random);
            currentNode = currentNode.next;
        }

        return map.get(head);

    }

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.next = null;
        node5.random = node1;

        display(copyRandomList(node1));

    }

}
