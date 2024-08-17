package twoPointer;

/* Given: An integer array 'nums' sorted in non-decreasing order (increasing order with duplicates).
 * 
 * Output: Remove some duplicates in-place such that each unique element appears at most twice. 
 * 
 * 		   NOTE: The relative order of the elements should be kept the same.
 * 
 * General Observations:
 * 
 * 	- The first two elements are always allowed (if they exists). 
 * 
 *  - Use two pointers:
 *  	- idx, to interate over 'nums' to find the valid elements
 *  	- nextWritePos, to keep track of the next position where we need to write a valid element.
 *  
 *  - if nums[i] != nums[nextWritePos-2], then nums[i] is a valid element that should be at nextWritePos
 *    index.
 * 
 * */

public class RemoveDuplicatesSortedArray2 {
	
	private static int removeDuplicates(int[] nums) {
		
		if(nums.length<=2) {
			return nums.length;
		}
		
		int nextWritePos = 2;
		for(int i=2; i<nums.length; i++) {
			if(nums[i] != nums[nextWritePos-2]) {
				nums[nextWritePos] = nums[i];
				nextWritePos++;
			}
		}
		
		return nextWritePos;
	}

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3}; // Output: 7, nums = [0,0,1,1,2,3,3,_,_]
		System.out.println(removeDuplicates(nums));
	}

}
