import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Problem Statement: Given an array of strings 'strs', group the anagrams together. You can return the 
 * 					  answer in any order.
 * 
 * General Observations:
 * 
 * 	- Frequency maps of all anagrams are same. 
 * 
 *  - Create a HashMap where eack key will represent a unique frequency map and it corresponding will be 
 *    a list of strings whose frequency map matches the key. 
 * 
 * */

public class GroupAnagrams {
	
	private static Map<Character, Integer> getFrequencyMap(String str) {
		
		Map<Character, Integer> fm = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			fm.put(ch, fm.getOrDefault(ch, 0)+1);
		}
		
		return fm;
		
	}
	
	private static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> groups = new ArrayList<>();
		Map<Map<Character, Integer>, List<String>> groupHM = new HashMap<>();
		
		for(String str: strs) {
			
			Map<Character, Integer> fm = getFrequencyMap(str);
			
			if(groupHM.containsKey(fm)) {
				groupHM.get(fm).add(str);
			} else {
				List<String> value = new ArrayList<>();
				value.add(str);
				groupHM.put(fm, value);
			}
		}
		
		for(Map.Entry<Map<Character, Integer>, List<String>> entry: groupHM.entrySet()) {
			groups.add(entry.getValue());
		}
		
		return groups;
		
	}

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}

}
