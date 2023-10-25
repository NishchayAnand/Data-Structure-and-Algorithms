
/* Problem Statement: Design your implementation of a singly linked list. 
 * 
 * NOTE: A node in a singly linked list should have two attributes: val and next, where:
 * 				- val is the value of the current node, and
 * 				- next is a pointer/reference to the next node.
 * 
 * General Observations:
 * 
 * 	- SinglyLinkedList(): 
 * 		
 * 		- Constructor to initialize the SinglyLinkedList object. 
 * 		- Since no additional operation needs to be performed in the constructor, we don't need to 
 * 		  manually define it (will be created implicitly). 
 * 
 *  - getIndex(index):
 *  
 *  	- Algorithm:
 *  
 *  		- If index < 0 || index >=size (will handle size = 0), return -1; 
 *  		- Create a counter and iterate over linked list till we reach the "node" where counter == 
 *  		  index;
 *  		- return node.val;
 *  
 *   	- Time Complexity (worst-case scenario, i.e., getting last node): O(n).
 *   
 *  
 *  - addAtHead(val):
 *  
 *  	- Algorithm:
 *  	
 *  		- Create a new_node.
 *  		- if size==0:
 *  			- point the Head and Tail references to the new_node.
 *  		- else: 	
 *  			- point new_node's next reference to the head.
 *  			- point the head to the new_node.
 *  
 *   	- Time Complexity: O(1)
 *   
 *  
 *  - addAtTail(val):
 *  
 *  	- Algorithm:
 *  	
 *  		- Create a new_node;
 *  		- if size == 0:
 *  			- point the Head and Tail references to the new_node.
 *  		- else:
 *  			- point the next reference of tail to new_node.
 *  			- point the tail to the new_node.
 *  
 *  	- Time Complexity Analysis: O(1)
 *  
 *  
 *  - addAtIndex(index, val): // Add a node of value val before the indexth node in the linked list.
 *  
 *  	- Algorithm:
 *  
 *  		- if index < 0 || index > size, return; 
 *  
 *  		- if size == 0:
 *  			- addAtHead(val);
 *  
 *  		- else if index == size:
 *  			- addAtTail(val);
 *  
 *  		- else:
 *  			- Create a new_node;
 *  			- curr = head;
 *  			- prev = null;
 *  			- counter = 0;
 *  			- while counter != index:
 *  				- prev = curr;
 *  				- curr = curr.next;
 *  				- counter++;
 *  			- node.next = curr;
 *  			- prev.next = node;
 *  			- size++;
 *  
 *  	- Time Complexity (worst-case scenario, i.e., adding element between the last 2 nodes): O(n).
 *  
 * 
 *  
 *  - deleteAtIndex(index):
 *  
 *  	- Algorithm:
 *  
 *  		- if index < 0 || index >=size, return;
 *  
 *  		- curr = head;
 *  
 *  		- if index == 0 & size == 1:
 *  			- head=tail=null;
 *  
 *  		- else if index == 0:
 *  			- head = head.next;
 *  			- curr.next = null; // breaking the link with the linked list.
 *  
 *  		- else:
 *  			- prev = null;
 *  			- counter = 0;
 *  			- while counter != index:
 *  				- prev = curr;
 *  				- curr = curr.next;
 *  				- counter++;
 *  			- prev.next = curr.next;
 *  			- curr.next = null; // breaking the link with the linked list.
 *  
 *  		- size--;
 *  
 *  	- Time Complexity (worst case scenario, i.e., deleting the last node): O(n).
 *  
 * 
 * */

class Node {
	
	int val;
	Node next;
	
	Node(int val){
		this.val = val;
	}
	
}

public class SinglyLinkedList {
	
	// Properties:

    Node head; // start of the Linked List
    Node tail; // end of the Linked List
    int size;  // additional variable for quick retrieval of the size of linked list.
    
    // Methods: 
    
    public int get(int index) {
    	
        // validating the index.
        if(index < 0 || index >= size ){ 
            return -1;
        }  
        
        int pos = 0;
        Node curr = head;
        
        while(pos != index){
            curr = curr.next;
            pos++;
        } 
        
        return curr.val;
        
    }
    
    public void addAtHead(int val) {
    	
        Node node = new Node(val);
        
        if(size == 0){
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        
        size++;
        
    }
    
    public void addAtTail(int val) {
        
        Node node = new Node(val);
        
        if(size==0){
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
    	
        //validate the index.
        while(index < 0 || index > size){
        	System.out.println("Index out of bound.");
            return;
        }

        if(index == 0) { 
            addAtHead(val);
            
        } else if(index == size) { 
            addAtTail(val);
            
        } else { 
            Node node = new Node(val);
            Node curr = head;
            Node prev = null;
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
        	System.out.println("Index out of bound.");
            return;
        }
        
        Node curr = head;

        if(index == 0 && size == 1) {  // in case we are deleting the only element present in the linked list. 
            head = tail = null;
            
        } else if (index == 0) { 	   // in case we are deleting the first element.  
            head = head.next;
            
        } else { 					   // in case we are deleting any element other than the head node.
            Node prev = null;
            int pos = 0;
            while(pos != index){
               prev = curr;
               curr = curr.next;
               pos++; 
            }
            prev.next = curr.next;
            
        }
        
        curr = null;
        size--;  
        
    }
    
    @Override
    public String toString() {
    	StringBuilder list = new StringBuilder("[");
    	Node curr = head;
    	while(curr!=null) {
    		list.append(curr.val+" ");
    		curr = curr.next;
    	}
    	list.append("]");
    	return list.toString();
    }
    
    public static void main(String[] args) {
    	
    	SinglyLinkedList linkedList = new SinglyLinkedList();
    	
    	linkedList.deleteAtIndex(0);
    	
    	linkedList.addAtHead(6); // [6]
    	
    	linkedList.deleteAtIndex(0); // []
    	
    	linkedList.addAtHead(3); // [3]
    	
    	linkedList.addAtHead(1); // [1, 3]
    	
    	linkedList.addAtTail(4); // [1, 3, 4]
    	
    	linkedList.addAtIndex(1, 2); // [1, 2, 3, 4]
    	
    	linkedList.addAtTail(5); // [1, 2, 3, 4, 5]
    	
    	linkedList.deleteAtIndex(4);
    	
    	System.out.println(linkedList);
    }
    
}