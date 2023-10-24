
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
 *   	- Time Complexity Analysis:
 *   
 *   		- 
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
 *   	- Time Complexity Analysis:
 *   	
 *   		-
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
 *  	- Time Complexity Analysis:
 *  	
 *  		- 
 *  
 *  
 *  - addAtIndex(index, val):
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
 *  			- Create a counter and iterate over linked list till we reach the "node" where counter ==
 *  		  	  index;
 *  			- new_node.next = node.next;
 *  			- node.next = new_node;
 *  
 *  	- Time Complexity:
 *  
 *  		- 
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
            tail = head;
        }
        
        size++;
        
    }
    
    
    public void addAtIndex(int index, int val) {
    	
        //validate the index.
        while(index < 0 || index > size){
            return;
        }

        if(index == 0) { 
            addAtHead(val);
            
        } else if(index == size) { 
            addAtTail(val);
            
        } else { 
            Node node = new Node(val);
            Node curr = head;
            int pos = 0;
            while(pos != index){
                curr = curr.next;
                pos++;
            }
            node.next = curr.next;
            curr.next = node;
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