
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
 * 
 * 	- HashMap uses 4 private functions for its internal working. 
 * 
 * 		- initBucket(n): initiate an array of linkedLists of size 'n'.
 * 		- hashFunction(key): returns the bucket index of the linkedList containing the key-value pair.
 * 		- getIndexWithinBucket(key, bucket_index): iterates over the linkedList present at bucket_index
 * 												   and return the index where the key was present. If key 
 * 												   was not found, return -1.
 * 		- rehash(): re-calculates the hashcode of already stored entries (key-value pairs) to move them to
 * 				    another bigger size hashmap. 
 * 
 *  - Common HashMap functions:
 *  	
 *  	- get(key):
 *  	- put(key, value):
 *  	- containsKey(key):
 *  	- remove(key):
 *  	- size():
 *  	- keySet():
 *  
 *  - The hashCode() method is defined in the java.lang.Object class. It's a fundamental method that all 
 *    objects in Java inherit. The purpose of this method is to return an integer value that serves as a 
 *    hash code for the object.  	
 * 
 * */


public class MyHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
