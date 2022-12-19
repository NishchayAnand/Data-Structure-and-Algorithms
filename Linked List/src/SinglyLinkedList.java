
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class SinglyLinkedList {

    // class inside another class.
    class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    Node head; // start of the Linked List
    Node tail; // end of the Linked List
    int size;

    public SinglyLinkedList() { 
        head = null; // default value was also null.
        tail = null; // default value was also null.
        this.size = 0; // default value was also 0.
    }
    
    public int get(int index) {
        // validating the index.
        if(index < 0 || index >= size ){ // index >= size will handle size = 0 condition
            return -1;
        }  

        Node curr = head;
        int pos = 0;
        while(pos != index){
            curr = curr.next;
            pos++;
        } 
        return curr.val;     
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(size == 0){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        //System.out.println(val);
        //System.out.println(size);
        Node node = new Node(val);
        if(size==0){
            head=node;
            tail=node;
        } else {
            Node curr = head;
            //int pos = 0;
            while(curr.next != null){ // check why curr != tail is not working 
                //System.out.println(pos + ". curr-> " + curr);
                //System.out.println(pos + ". tail-> " + tail);
                curr = curr.next;
                //pos++;
            }
            //System.out.println(pos + ". curr-> " + curr + ", tail-> " + tail);
            curr.next = node;
            tail = node;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        //validate the index.
        while(index < 0 || index > size){
            return;
        }

        if(index == 0){ // handles the case for size==0.
            addAtHead(val);
        } else if(index == size){ 
            addAtTail(val);
        } else { // for adding val somewhere in between.
            Node node = new Node(val);
            Node prev = null;
            Node curr = head;
            int pos = 0;
            while(pos != index){
                prev = curr;
                curr = curr.next;
                pos++;
            }
            prev.next = node;
            node.next = curr;
            size++;
        }  
    }
    
    public void deleteAtIndex(int index) {
        // validate the index.
        if(index < 0 || index >= size){
            return;
        }

        if(index == 0 && size == 1){ // handles case for single element.
            head = tail = null;
        } else if (index == 0){ // handles case for deletion of head when there are multiple elements
            head = head.next;
        } else { // handles case for deletion of any other element (in between or the tail).
            Node prev = null;
            Node curr = head;
            int pos = 0;
            while(pos != index){
               prev = curr;
               curr = curr.next;
               pos++; 
            }
            prev.next = curr.next;
        }
        size--;       
    }
}