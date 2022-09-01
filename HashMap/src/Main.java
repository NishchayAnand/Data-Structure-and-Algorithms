import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	
	// inner class for HashMap implementation
	public static class HashMap<K, V> {
		
		// Each (key, value) is stored as HMNode object
		private class HMNode<K, V> {
			K key;
			V value;
			
			HMNode(K key, V value){
				this.key = key;
				this.value = value;
			}
		}
		
		// size represents the number of key-value pairs added in the linkedList.
		private int size;
		private LinkedList<HMNode>[] buckets;
		
		// initialize/create an array of LinkedList
		private void initBuckets(int size) {
			buckets = new LinkedList[size];
			for(int i=0; i<size; i++) {
				buckets[i] = new LinkedList<HMNode>();
			}
		}
		
		HashMap(){
			initBuckets(4);
			size = 0;
		}
		
		private int hashFunction(K key) {
			int hc = key.hashCode();
			return Math.abs(hc) % buckets.length;
		}
		
		private int getIndexWithinBucket(K key, int bi) {
			
			int di = 0;
			
			for(HMNode node: buckets[bi]) {
				if(node.key.equals(key)) {
					return di;
				} else {
					di++;
				}
			}
			
			return -1;
			
		}
		
		private void rehash() {
			
			LinkedList<HMNode>[] copy = buckets;
			
			initBuckets(2*buckets.length);
			size=0;
			
			for(int i=0; i<copy.length; i++) {
				for(HMNode node: copy[i]) {
					put((K) node.key, (V)node.value);
				}
			}
			
		}
		
		public void put(K key, V value) {
			
			int bi = hashFunction(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di==-1) {
				buckets[bi].addLast(new HMNode(key, value));
				size++;
			} else {
				HMNode node = buckets[bi].get(di);
				node.value = value;
			}
			
			double lambda = size*1.0 / buckets.length;
			if(lambda > 2.0) {
				rehash();
			}
			
		}
		
		public boolean containsKey(K key) {
			
			int bi = hashFunction(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di==-1) {
				return false;
			} else {
				return true;
			}
			
		}
		
		public V get(K key) {
			
			int bi = hashFunction(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di==-1) {
				return null;
			} else {
				HMNode node = buckets[bi].get(di);
				return (V) node.value;
			}
			
		}
		
		public V remove(K key) {
			
			int bi = hashFunction(key);
			int di = getIndexWithinBucket(key, bi);
			
			if(di==-1) {
				return null;
			} else {
				HMNode node = buckets[bi].remove(di);
				size--;
				return (V) node.value;
			}
			
		}
		
		public int size() {
			return size;
		}	
		
		public ArrayList<K> keySet(){
			
			ArrayList<K> set = new ArrayList<K>();
			
			for(int bi=0; bi<buckets.length; bi++) {
				for(HMNode node: buckets[bi]) {
					set.add((K) node.key);
				}
			}
			
			return set;
			
		}
		
	}

}
