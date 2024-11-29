import java.util.*;

/*

	Problem Statement: Given an array of strings 'strs', group the anagrams together. For example,

	  				   	strs = ["eat","tea","tan","ate","nat","bat"],
	  				   	output = [["bat"],["nat","tan"],["ate","eat","tea"]]

					   NOTE:
					   		- strs[i] consists of lowercase English letters.
					   		- You can return the answer in any order.

	General Observations:

		- When you sort the characters of a string, all anagrams will result in the exact same
		  sorted string.

		- Brute Force Approach:

			- Use a HashMap to group all strings that are anagrams, with the sorted strings serving
			  as keys.

			- Time Complexity: O(n.k.logk), where k = average length of each string in 'strs'.

			- Space Complexity: O(n.k).

		- Anagrams share the same frequency map, where a frequency map is a representation of the
		  count of each character in the string.

		- Since maps are not directly hashable, we can represent the frequency map as a "string
	      representation of the map" to serve as the key in a HashMap.

		- Frequency Map Approach:

			- The frequency map of a string only containing lowercase English letters can be
			  efficiently represented as an array of size 26, where each index corresponds to a
			  letter in the alphabet and the value at that index represents the frequency of
			  that letter in the string.

			- The array representation of the frequency map can be used to generate a unique
			  hash code for each string.

			- NOTE: For strings like 'bdddddddddd' and 'bbbbbbbbbbc', simply concatenating the
			        array representations would lead to same hashcode.

						- 'bdddddddddd': [0,1,0,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
						- 'bbbbbbbbbbc': [0,10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

				   Use a delimiter, for example '#', between the counts of different characters
				   to make sure each frequency is uniquely interpreted.

			- Time Complexity: O(n.k), where k is the average length of each string in 'strs'.

			- Space Complexity: O(n.k).

*/

public class GroupAnagrams {

	public static List<List<String>> groupAnagramsBruteForce(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		for(String str: strs) {
			char[] strArray = str.toCharArray();
			Arrays.sort(strArray);
			String sortedStr = new String(strArray);
			map.putIfAbsent(sortedStr, new ArrayList<>());
			map.get(sortedStr).add(str);
		}

		return new ArrayList<>(map.values());

	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {

			// Count frequency of each character in the word
			int[] charCount = new int[26];
			for (char ch : str.toCharArray()) {
				charCount[ch - 'a']++;
			}

			// Create a hashcode representing the frequency map of str.
			StringBuilder keyBuilder = new StringBuilder();
			for (int count : charCount) {
				keyBuilder.append(count);
			}
			String key = keyBuilder.toString();

			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(str);

		}

		return new ArrayList<>(map.values());

	}

	public static void main(String[] args) {
		// String[] strs = {"eat","tea","tan","ate","nat","bat"};
		String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
		System.out.println(groupAnagrams(strs));
	}

}
