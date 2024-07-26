
/* Problem Statement: Design a data structure that follows the constraints of a Least Recently Used (LRU) 
 * 					  cache.
 * 
 * General Observations:
 * 
 * 	- A Cache is a temporarily storage used to store frequently accessed data.
 * 
 * 	- Cache usually store data as key-value pairs.
 * 
 * 	- LRU (Least Recently Used) Cache is is a type of Cache that is optimized to work when with limited 
 * 	  cache space.
 * 
 * 	- Ideology:
 * 
 * 		- Prioritizes Recently Used Data: The idea is that data accessed recently is more likely to be 
 * 										  accessed again in the near future.
 * 
 * 		- Evicts Least Recently Used Data: When the cache is full and a new item needs to be added, the 
 * 										   least recently used item is removed to make space.
 * 
 * 	- Requirements:
 * 
 * 		- A Data Structure with a fixed Capacity that allows O(1) storage and retrieval: We can use 
 * 		  HashMap. 
 * 
 * 		- A Data Structure to keep track of the Order of Access: We can use a Linked List where:
 * 			- 'Head' should always point to the 'Most_Recently_Accessed_Object'
 * 			- 'Tail' should always point to the 'Least_Recently_Accessed_Object'
 * 
 *   - Implementation: 
 * 
 * */

public class LRUCache {
	
	public LRUCache(int capacity) {
		// Initialize the LRU cache with positive size capacity.
	}
	
	public int get(int key) {
		// Return the value of the key if the key exists, otherwise return -1.
		return -1;
    }
    
    public void put(int key, int value) {
    	// Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
    	// If the number of keys exceeds the capacity from this operation, evict the least recently used 
    	// key. The functions get and put must each run in O(1) average time complexity.
    }

	public static void main(String[] args) {

	}

}
