
/* Problem Statement: Design a data structure that follows the constraints of a Least Recently Used (LRU) 
 * 					  cache.
 * 
 * General Observations:
 * 
 * 	- LRU Cache prioritizes recently used data and evicts least recently used data.
 * 
 * 	- The idea is that data accessed recently is more likely to be accessed again in the near future. When
 *    the cache is full and a new item needs to be added, the least recently used item is removed to make 
 *    space.
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
