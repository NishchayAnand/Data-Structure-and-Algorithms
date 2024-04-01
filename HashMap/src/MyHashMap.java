
/* General Observations:
 * 
 * 	- Two essential factors to consider when designing a hash table:
 * 
 * 		- Hash Function:
 * 
 * 			- Used to map a key to a specific bucket.
 * 			- Depends on the (range of key values) and (the number of buckets). 
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
