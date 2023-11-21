
/* Problem Statement: Given the head of a linked list, return the node where the cycle begins. If there is
 * 					  no cycle, return null.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach: 
 * 
 * 		- use a hashMap(keys = Node, values = boolean) to mark the nodes as visited as we iterate over the
 * 		  linked list. The starting node of the loop in the linked list will be the node which gets 
 * 		  repeated the first time while iteration. 
 * 
 * 		NOTE: make sure to use key as Nodes to make sure the algorithm works fine for duplicate node 
 * 			  values.
 * 
 *  	- Time Complexity Analysis: O(N).
 *  
 *  	- Space Complexity Analysis: O(N).
 * 
 * 	- In Floyd cycle detection algorithm, the slow pointer and the fast pointer, moving at twice the speed,
 *    will always collide before the slow pointer makes a complete rotation of the loop/cycle. 
 *    
 *  - Let A be the number of nodes between the start of the linked list and the start of the loop, a.k.a
 *    "tail".
 *  - Let B be the number of nodes between the start of the loop and the node where the fast and slow 
 *    pointers will collide.
 *  - Let C be the remaining nodes in the loop from the node where the fast an slow pointers will collide.
 *  
 *  
 *  		-> A + n(B+C) + B = 2(A+B)
 *  		-> (n-1)(B+C) + C = A 
 * 
 * 	- When the tail is smaller than the length of the loop, the fast pointer will only make a single 
 * 	  "complete" rotation before colliding with the slow pointer. Therefore, A = C. Take a new pointer
 *    "temp" pointed to the first node of the linked list and start iterating both temp and slow 
 *    pointers by 1 until they both collide. Since, A = C, they will collide at the start of the loop.
 * 
 *  - When the tail is larger than the length of the loop, the fast pointer can make more than 1 rotation
 *    before colliding with the slow pointer. 
 *    
 *    		For n = 2, (B+C) + C = A. Moving the slow pointer by C nodes will point the slow pointer at
 *         							  the start of the loop. Then making 1 rotation, i.e., (B+C) will 
 *         							  again point the slow pointer at the start of the loop.
 *         
 *         For n = 3 , 2(B+C) + C = A, Moving the slow pointer by C nodes will point the slow pointer at
 *         							  the start of the loop. Then making 2 rotation, i.e., 2(B+C) will 
 *         							  again point the slow pointer at the start of the loop.
 *         
 *    Take a new pointer "temp" pointed to the first node of the linked list and start iterating both temp
 *    and slow pointers by 1 until they both collide will always end up placing the slow pointer at the
 *    start of the loop.
 *    
 *    NOTE: We don't know C but we know A.
 *    
 * */


public class FindLoopStartInLinkedList {
	
	public static Node detectCycle(Node head) {

        Node fast = head;
        Node slow = head;

        if(head == null){
            return null;
        }

        if(head.next == null){
            return null;
        }

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                break;
            }
            
        }

        if(fast != slow){
            return null;
        }

        Node temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        } 

        return slow;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
