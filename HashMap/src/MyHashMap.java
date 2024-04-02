
/* General Observations:
 * 
 * 	- 'Insertion' and 'Searching' are two basic operations in a hashMap. 
 * 
 * 	- Two essential factors to consider when designing a hashMap:
 * 
 * 		1. Hash Function:
 * 
 * 			- Used to map a key to a specific bucket.
 * 
 * 			- Depends on the:
 * 
 * 				- Range of Key Values: If the hash function doesn't consider the key range, it might map 
 * 								       all keys to a limited range within the available buckets, leading 
 * 									   to clustering and collisions, even with a sufficient number of 
 * 									   buckets.
 * 
 * 									   For example, consider a hashmap where the keys are unique 
 * 									   identifiers for products, ranging from 1 to 1000. If its hash 
 * 									   function always maps keys to hash codes within a small range, let's 
 * 									   say between 1 and 10, the hash function will map a large number of 
 * 									   keys (from 1 to 1000) into a very limited bucket range (from 1 to 
 * 									   10). This essentially compresses the entire key range into a small 
 * 									   portion of the available buckets.
 * 									   
 * 				- Number of Buckets: An ideal hash function should distribute keys effectively across the 
 * 									 available number of buckets. If there are too few buckets compared to
 * 									 the range of key values, collisions become very likely, regardless of
 * 									 the hash function's design.
 * 
 * 		2. Collision Resolution:
 * 
 * 			- Ideally, if our hash function is a perfect one-one mapping, we will not need to handle 
 * 			  collisions. Unfortunately, in most cases, collisions are almost inevitable.
 * 
 *  		- To organizing collided elements within a bucket, we use the concept of "Separate Chaining". 
 *  		  
 *  		- Separate Chaining: Involves chaining collided elements together in a linked list or similar 
 *  							 data structure. When a collision occurs, the new key-value pair is 
 *  							 "inserted" to the beginning of the linked list associated with that 
 *  							 bucket. 
 *  
 *  		- "Searching" for a value involves traversing the linked list within the bucket.
 *  
 *  		- As the number of elements per bucket increases, the time to find a specific value also 
 *  		  increases. To prevent this, hashmaps typically have a "Load Factor", a threshold value that 
 *  		  determines when the hashmap needs to resize its internal bucket array. 
 *  
 *  		- When the load factor is reached, the hashmap undergoes a process called "Rehashing".
 *  
 *  		- Rehashing: Involves resizing the bucket array (often doubled) and redistributing all the 
 *  					 existing key-value pairs across the new buckets using the hash function. This 
 *  					 effectively reduces the average elements per bucket and minimizes collisions, 
 *  					 maintaining efficient performance.
 *  
 *  - NOTE: 
 *  
 *  	- hashCode(): - A fundamental method that all objects in Java inherit. 	
 *  				  - Defined in the java.lang.Object class. 
 *  				  - Returns an integer that serves as a hash code for an object. 
 *  				  - Different objects can have the same hash code (collision). 
 * 
 * */


public class MyHashMap {
	
	private Node[] buckets;
	private static final double LOAD_FACTOR = 0.75;
	private int size;
	private int capacity;
	
	public MyHashMap() {
		this.capacity = 16;
		this.buckets = new Node[capacity];
		this.size = 0;
	}
	
	private static class Node {
		final int key;
		int value;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int hash(int key) {
		return Math.abs(Integer.valueOf(key).hashCode() % capacity);
	}
	
	private void rehash() {
		capacity *= 2;
		Node[] newBuckets = new Node[capacity];
		buckets = newBuckets;
		
		size = 0;
		
		// Re-insert all existing key-value pairs into the new buckets
		for(Node node: buckets) {
			
		}
	}
	
	// Insertion
	public void put(int key, int value) {
		int index = hash(key);
		Node newNode = new Node(key, value);
		
		if(buckets[index]==null) {
			buckets[index] = newNode;
		} else {
			Node head = buckets[index];
			// Chaining - add the new entry to the beginning of the linked list at the bucket
			newNode.next = head;
			buckets[index] = newNode;
		}
		size++;
		
		if(size > capacity*LOAD_FACTOR) {
			rehash();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
