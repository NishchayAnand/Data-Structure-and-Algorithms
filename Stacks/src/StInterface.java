public interface StInterface<AnyType> {

   public boolean isEmpty();

   // Removes and returns the item at the top of this stack.
   public AnyType pop() throws StException;

   // Returns the top item without its removal
   public AnyType peek() throws StException;

   // Inserts an item onto the top of the stack.
   public void push(AnyType e) throws StException;

   // Removes all items from the stack.
   public void clear();
   
}
