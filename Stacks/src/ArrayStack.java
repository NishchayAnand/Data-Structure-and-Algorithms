//Static-size fixed array implementation...

@SuppressWarnings("unchecked")
public class ArrayStack<AnyType> implements StIterface<AnyType> {

	private static final int DEFAULT_CAPACITY = 15;
	private int top;  // reference to the top element  
	private AnyType[] stack;

	// Creates a Stack of the size initialCapacity.   
	public ArrayStack(int initialCapacity) {

		if (initialCapacity <= 0) {
			stack = (AnyType[]) new Object[DEFAULT_CAPACITY];    	  
		} else {
			stack = (AnyType[]) new Object[initialCapacity];
		}

		// initialize stack as empty.
		top = -1;

	}
	
	// Creates a Stack with the default capacity
	public ArrayStack() {		
		this(DEFAULT_CAPACITY); //this() is used to call one constructor from the other of the same class.
	}

	// Tests if the stack is empty.
	public boolean isEmpty() {
		return top==-1;
	}

	// Returns the top item without its removal.
	public AnyType peek() {	
		
		if (isEmpty()) {
			throw new StException("Stack is empty");
		}	
		
		return stack[top];	
		
	}

	// Removes and returns the item at the top of this stack.
	public AnyType pop() {
		
		AnyType x = peek();
		
		stack[top] = null;    //make sure the object is destroyed
		top--;
		
		return x;
		
	}

	// Inserts an item onto the top of the stack.
	public void push(AnyType e) {	
		
		if (top == stack.length) {
			throw new StException("Stack has overflowed");
		}
		
		top++;
		stack[top] = e;	
		
	}

	// Removes all items from the Stack.
	public void clear() {	
		
		for(int i = 0; i <= top; i++)
			stack[i] = null;
		
		top = -1;	  
		
	}

	//Returns a string representation of the Stack.
	public String toString() {
		
		if(isEmpty()) return "[ ]";

		StringBuffer out = new StringBuffer("[");
		for(int i = 0; i < top; i++) {
			out.append(stack[i] + ", ");
		}
			
		out.append(stack[top] + "]");
		return out.toString();
		
	}

	public static void main(String[] args){
		
		ArrayStack<Integer> s = new ArrayStack<Integer>(6);

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