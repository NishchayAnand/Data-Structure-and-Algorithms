package twoPointer;

/* Given: An integer array 'nums' sorted in non-decreasing order
 * 
 * Output: Remove the duplicates in-place and return the number of unique elements in nums.
 * 
 * 		   NOTE: The relative order of the elements should be kept the same.
 * 
 * General Observations:
 * 
 * 	- All unique integers in 'nums' need to be places next to each other. 
 * 
 * 	- Use 2 pointers, one to iterate over 'nums' and other to keep track of the index where the next 
 *    unique element should be placed.  
 * 
 * */

public class RemoveDuplicatesSortedArray {
	
	private static int removeDuplicates(int[] nums) {	
		int nextUniquePos = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] != nums[i-1]) {// nums[i] is unique integer if it does not match the previous integer.
				nums[nextUniquePos] = nums[i];
				nextUniquePos++;
			}
		}
		return nextUniquePos;
	}

	public static void main(String[] args) {
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
	}

}
