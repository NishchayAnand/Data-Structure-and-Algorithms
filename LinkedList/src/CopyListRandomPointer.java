
/*
    Given: A linked list where each node contains an additional random pointer which is pointing to a random node in the
           linked list or is null.

    Output: Construct a deep copy of the linked list.

            NOTE: None of the pointers in the new list should point to nodes in the original list.

*/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        if (random == null) return "[" + val + ", " + null + "]";
        return "[" + val + ", " + random.val + "]";
    }
}

public class CopyListRandomPointer {

    private static Node copyRandomList(Node head) {
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(7);
        Node first = new Node(13);
        Node second = new Node(11);
        Node third = new Node(10);
        Node fourth = new Node(1);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        head.random = null;
        first.random = head;
        second.random = fourth;
        third.random = second;
        fourth.random = head;

        Node newHead = copyRandomList(head);

        // Display cloned Linked List.
        Node curr = newHead;
        while(curr.next!=null) {
            System.out.print(curr+" ");
            curr = curr.next;
        }

    }

}
