package twoPointer;

/* Given: An integer array 'nums' and an integer 'val'. 
 * 
 * Output: Remove all occurrences of 'val' in 'nums' in-place and return the number of elements in 'nums' 
 * 		   which are not equal to val.
 * 
 * 		   NOTE: Change the array 'nums' such that the first k elements of nums contain the elements which
 * 				 are not equal to val. The remaining elements of nums are not important as well as the 
 * 				 size of nums.
 * 
 * General Observations:
 * 
 * 	- Brute Force Approach:
 * 
 * 		- Iterate over 'nums'. Every time you encounter nums[i] == val, shift all integers to the right
 *        of nums[i] towards left by 1.
 *        
 *      - Time Complexity: O(n^2).
 *      
 *      - Space Complexity: O(1).
 *      
 *  - The order of integers in the required output does not matter.
 * 
 * 	- Optimized Two Pointers Approach:
 * 
 * 		- Use two pointers, one to iterate over the input array 'nums' and another to mark the logical 
 *   	  valid end of the modified 'nums' array.
 *   
 *      - Every time we encounter a nums[i] == val condition, swap nums[i] and last valid integer in 'nums'.
 *      
 *      - Time Complexity: O(n).
 *      
 *      - Space Complexity: O(1).
 * 	
 * 
 * */

public class RemoveElement {
	
	private static int removeElementBruteForce(int[] nums, int val) {
		
		int start = 0;
		int k = nums.length;
		
		while(start<k) {
			if(nums[start] == val) {
				for(int j=start+1; j<k; j++) {
					nums[j-1] = nums[j];
				}
				k--;
			} else {
				start++;
			}
		}
		
		return k;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static int removeElement(int[] nums, int val) {
		
		int start = 0;
		int k = nums.length;
		
		while(start<k) {
			if(nums[start] == val) {
				swap(nums, start, k-1);
				k--;
			} else {
				start++;
			}
		}
		
		return k;
	}

	public static void main(String[] args) {
		
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		
		System.out.println(removeElement(nums, val)); // output = 5
		
		for(int num: nums) {
			System.out.print(num+" ");
		}

	}

}
