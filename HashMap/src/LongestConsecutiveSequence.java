import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Problem Statement: Given an unsorted array of integers 'nums', return the length of the longest 
 * 					  consecutive elements sequence.
 * 
 * 					  For example, for nums = [100,4,200,1,3,2], the LCS = [1,2,3,4]. Hence, the length
 * 					  of the longest consecutive elements subsequence is 4.
 * 
 * General Observaions: 
 * 
 * 	- Each element can either be the "starting element of a subsequence" or "part of a subsequence".
 * 
 * 	- If we know the starting element of each consecutive subsequence, we can easily figure out 
 * 		  the longest consecutive subsequence. 
 *  
 *  	- Time Complexity Analysis:
 *  		
 *  		- We are iterating over the input 'nums' array two times:
 *  			- first, to fill the HashSet. --> O(n)
 *  			- second, to find the length of the longest consecutive subsequence. --> O(n)
 *  
 *  		- In worst case scenario, i.e., when the entire array is a consecutive sequence, the while
 *  		  loop in (#2) will explore:
 *  			- all the (n-1) elements for the first iteration of (#2).
 *  			- no elements for the remaining iterations of (#3).
 *  
 *  		- The time complexity for the while loop could be considered as O(1) within the context of 
 *  		  (#2). 
 *
 *   		- Hence, overall time complexity = O(n).
 *   
 *   	- Space Complexity Analysis:
 *   
 *   		- We are creating a HashSet of size 'n'. Hence, overall space complexity = O(n).
 * 
 * */

public class LongestConsecutiveSequence {
	
	public static int longestConsecutiveBF(int[] nums) {

        if(nums.length == 0) return 0;
		
		int maxLength = 1;
			
		Set<Integer> hs = new HashSet<>();
		for(int num: nums) {
			hs.add(num);
		}
			
		for(int startNum: hs) {
			int currLength = 1;
            int nextNum = startNum+1;
			while(hs.contains(nextNum)) {
				currLength++;
				nextNum++;
			}
			maxLength = Math.max(maxLength, currLength);
		}
			
		return maxLength;
        
    }

	private static int longestConsecutive(int[] nums) {
		
		if(nums.length == 0) return 0;
		
		int maxLength = 1;
			
		Set<Integer> hs = new HashSet<>();
		for(int num: nums) {
			hs.add(num);
		}
			
		for(int startNum: hs) {
            if(!hs.contains(startNum-1)) {
                int currLength = 1;
                int nextNum = startNum+1;
			    while(hs.contains(nextNum)) {
				    currLength++;
				    nextNum++;
			    }
			    maxLength = Math.max(maxLength, currLength);
            }	
		}
			
		return maxLength;
		
	}

	public static void main(String[] args) {
		
		int[] nums = {1,2,0,1};
		
		System.out.println("Length of the longest consecutive elements subsequence: " + longestConsecutive(nums));

	}

}
