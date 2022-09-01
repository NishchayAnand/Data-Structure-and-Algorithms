
import java.util.*;

public class Smallest_Substring_With_All_Distinct_Elements_Of_InputString {

	public static int solution(String str){

		/*

		General Observations:
			- First task is to get the unique elements in the input string.
				- Brute force approach would be to select every character and check if any other character matches 
				  the current character under- consideration 
				  -> Nested Loop approach -> O(n^2)
				- Another approach is to use a HashSet.
				- Size of the hashSet will tell the number of unique characters in the string.
				  -> Time: O(n), Space: O(k)

			- The problem boils down to iterating over each sunstring and finding the smallest substring which contains 
			  all elements present in hashSet.
			- Lets assume that containsAllUniqueCharacter is a function that returns true if the given substring 
			  contains all the unique elements. 
			  -> Time: O(T)

		Algorithms:
			- Brute force approach would be to iterate over each possible substring and use containsAllUniqueCharacters'
			  function to check if the substring under-consideration contains all unique characters of input string.
			  -> Time: (n^2*T)

			- Dynamic Sliding Window Approach: 
				- Perform the checks in an intelligent manner.
				1. Lets start with the first batch of substrings, i.e., the substrings with starting index i=0.
					- Given: "aabcbcdbca", HS: [a,b,c,d] -> length = 4
							  0123456789

							  (0,0) -> sub: [a] (acquire & containsAllUniqueCharacters=false)
							  (0,1) -> sub: [a,a] (acquire & containsAllUniqueCharacters=false)
							  .
							  .
							  .
							  (0,6) -> sub: [a,a,b,c,b,c,d] (acquire & containsAllUniqueCharacters=true) = ans = 7
							
					- Observation 1: Once we have found the first substring in any ith batch, we don't need to check the 
									 remaining substrings, since substring [i,j] will be the smallest sunstring starting some
									 index = i.

				2. Lets start with the next batch of substrings starting from index = i+1.
					- Observation 2: Since all [i, j-1] substrings from the ith batch didn't contained all unique characters, 
								 	 we can ignore all substrings between [i+1, j-1]. Therefore, we only need to check the 
								 	 substrings between [i+1, j>=previous_batch_j]
						- Given: "aabcbcdbca", HS: [a,b,c,d] -> length = 4
								  0123456789

								(0,6) -> sub: [a,a,b,c,b,c,d] (acquire & containsAllUniqueCharacters=true) = 7

								(1,6) -> sub: [a,b,c,b,c,d] (release & containsAllUniqueCharacters=true) = 6
								(2,6) -> sub: [b,c,b,c,d] (release & containsAllUniqueCharacters=false)

								(2,7) -> sub: [b,c,b,c,d,b] (acquire & containsAllUniqueCharacters=false)
								(2,8) -> sub: [b,c,b,c,d,b,c] (acquire & containsAllUniqueCharacters=false)
								(2,9) -> sub: [b,c,b,c,d,b,c,a] (acquire & containsAllUniqueCharacters=true) = 6

								(3,9) -> sub: [c,b,c,d,b,c,a] (release & containsAllUniqueCharacters=true) = 6
								(4,9) -> sub: [b,c,d,b,c,a] (release & containsAllUniqueCharacters=true) = 6
								(5,9) -> sub: [c,d,b,c,a] (release & containsAllUniqueCharacters=true) = 5
								(6,9) -> sub: [d,b,c,a] (release & containsAllUniqueCharacters=true) = 4

								(7,9) -> sub: [b,c,a] (release & containsAllUniqueCharacters=false)
								(7,10) -> j>str.length(), hence terminate
				
				- Total Time Complexity: O(n*Acquire_time) + O(n*T) + O(m*Release_time)
				- Since, we observed that for each iteration, we are acquiring a character or/and removing a character, 
				  we can use HashMap for storing the unique elements present in any substring under-consideration.
					-> Acquire in HashMap -> O(1)
					-> Release in HashMap -> O(1)
				- Also, containsAllUniqueCharacters' check can be perfomed by comparing if HashMap.size() == HashSet.size().
				  A substring satifying this condition will contain all unique elements of the input string.

				- Total Time Complexity: O(n) + O(n) + O(m) ~ O(n).
						
		*/
		
		HashSet<Character> hs = new HashSet<>();
		for(int i=0; i<str.length(); i++){
			hs.add(str.charAt(i));
		}

		int minLen = Integer.MAX_VALUE;

		HashMap<Character, Integer> map = new HashMap<>();

		int i=0;

		for(int j=0; j<str.length(); j++){

			if(map.size()!=hs.size()){

				// acquire
				char end_ch = str.charAt(j);
				map.put(end_ch, map.getOrDefault(end_ch, 0)+1);

				// containsAllUniqueCharactersCheck
				while(map.size()==hs.size()){

					// updating the smallest substring's length
					minLen = Math.min(minLen, (j-i+1));

					// release
					char start_ch = str.charAt(i);
					int freq = map.get(start_ch);
					if(freq==1){
						map.remove(start_ch);
					} else {
						map.put(start_ch, freq-1);
					}
					i++;

				}

			}

		}

		return minLen;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
		scn.close();
	}

}

