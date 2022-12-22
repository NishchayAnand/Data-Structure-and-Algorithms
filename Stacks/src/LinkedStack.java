/*****************************************************************************
 * A linked list-based implementation of a stack.
 *
 *****************************************************************************/

public class LinkedStack<AnyType> implements StInterface<AnyType> {

	private static class Node<AnyType> {
		
		public AnyType data;
		public Node<AnyType> next;
		
		public Node(AnyType data) {
			this.data = data; 
			next = null;
		}
		
	}
	
	private Node<AnyType> top; // analogous to head

	// Creates a Stack
	public LinkedStack() {
		top = null;
	}

	// Tests if the stack is empty.
	public boolean isEmpty( ) {
		return top == null;
	}

	// Make the stack logically empty.
	public void clear( ) {
		top = null;
	}

	// Inserts a new item into the stack.
	public void push(AnyType data) {
		Node<AnyType> node = new Node<AnyType>(data);
		node.next = top;
		top = node;
	}

	// Removes and returns the item at the top of this stack.
	public AnyType pop() {
		
		if(isEmpty( )) {
			throw new StException("Stack is empty");
		}
		
		AnyType data = top.data;
		top = top.next;
		return data;
		
	}

	// Returns the top item without its removal
	public AnyType peek() {
		
		if(isEmpty( )) {
			throw new StException("Stack is empty");
		} 
		return top.data;
		
	}

	// Returns a string representation of the Stack.
	public String toString() {
		
		if(isEmpty()) return "[ ]";

		StringBuffer out = new StringBuffer("[");
		Node<AnyType> tmp = top;
		while(tmp != null)
		{
			out.append(tmp.data + "  ");
			tmp = tmp.next;
		}

		out.append("]");
		return out.toString();
		
	}

	public static void main(String[] args) {
		
		LinkedStack<Integer> s = new LinkedStack<Integer>();

		try {

			for(int i = 0; i < 6; i++) s.push(i);
			//s.clear();
			System.out.println(s);

			for(int i = 0; i < 5; i++) s.pop();
			System.out.println(s);

		} catch (StException e) {
			System.err.println(e);
		}
		
	}
	
}

