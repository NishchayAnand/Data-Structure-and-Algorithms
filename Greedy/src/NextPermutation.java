import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Problem Statement: Given an array of 'n' integers representing a permutation, rearrange the integers to
 * 					  get the next lexicographically greater permutation. For example, the next 
 * 					  permutation of A=[1,2,3] is [1,3,2]. 
 * 
 * 					  NOTE: If such arrangement is not possible, the array must be re-arranged in the 
 * 							lowest possible order i.e., sorted in ascending order. 
 * 
 * General Observations:
 * 
 * 	- Replacing a larger digit on the right with a smaller digit on the left will always get a number
 *    greater than the orginal number. For example, we can obtain numbers greater than 123 by:
 *    		- replacing 3 on the right with 1 on the left, i.e., 321.
 *    		- replacing 2 on the right with 1 on the left, i.e., 213.
 *    		- replacing 3 on the right with 2 on the left, i.e., 132.
 *    
 *  - To get permutations greater than the original permutation, we need to find a digit (pivot) on the 
 *    left which is less than the immediate digit on its right. A pivot marks the point where the original
 *    permutation can be modified to create a greater one. 
 *    
 *  - Swapping the rightmost pivot digit with the digit "just" greater than the pivot on its right 
 *    (successor), and re-arranging all the digits to the right of the pivot index in ascending order
 *    will give us the permutation just greater than the original permutation. 
 *    
 *  - NOTE: Every after swapping the pivot element with the successor element, all elements to the right
 *  		of the pivot index would still be arranged in descending order. 
 *    
 *  - Algorithm:
 *  
 *  	1. Find the rightmost pivot element.
 *  		- pivot_index = -1;
 *  		- Loop from i=[n-2, 0]:
 *  			- if A[i] < A[i+1]:
 *  				- pivot_index = i;
 *  				- break;
 *  
 *  	2. If not pivot index found
 *  		- If pivot_index == -1:
 *  			- reverse(A, 0, n-1) -> no pivot index means A is in descending order. Reversing the array
 *  								    will make it in ascending order.
 *    
 *    	3. Find the successor element. 
 *    		- successor_index = pivot_index + 1;
 *    		- Loop from i=[successor_index+1, n):
 *    			- If A[i] > A[pivot_index] && A[i] < A[successor_index]:
 *    				- successor_index = i;
 *    
 *    	4. Swap the pivot element and the successor element.
 *    		- swap(A, pivot_index, successor_index);
 *    
 *    	5. Reverse the element in the range [pivot_index+1, n)
 *    		- reverse(A, pivot_index, n-1);
 *  
 *  	- Time Complexity:
 *  
 *  		- In worst case scenario, i.e., when nums[0] is the pivot element and nums[n-1] is the 
 *  		  successor element, we would iterate over the input array 3 times:
 *  			- first, to find the pivot element -> O(n).
 *  			- second, to find the successor element -> O(n).
 *  			- third, to reverse the elements in range: [pivot_index+1, n) -> O(n/2).
 * 
 * 			- Hence, time complexity = O(n).
 *  
 *  	- Space Complexity: O(1).
 * 
 * */

public class NextPermutation {
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void reverse(int[] nums, int i, int j) {
		while(i<j) {
			swap(nums, i, j);
			i++; 
			j--;
		}
	}
	
	public static void nextPermutation(int[] nums) {
		
		int n = nums.length;
		
		// find pivot index
		int pivot_index = -1;
		for(int i=n-2; i>=0; i--) {
			if(nums[i]<nums[i+1]) {
				pivot_index = i;
				break;
			}
		}
		
		// if no pivot_index found
		if(pivot_index==-1) {
			reverse(nums, 0, n-1);
		}
		
		// find the successor index
		int successor_index = pivot_index+1;
		for(int i=successor_index+1; i<n; i++) {
			if(nums[i]>nums[pivot_index] && nums[i]<nums[successor_index]) {
				successor_index = i;
			}
		}
		
		// swap the pivot element and the successor element
		swap(nums, pivot_index, successor_index);
		
		// reverse the elements in the range [pivot_index+1, n)
		reverse(nums, pivot_index+1, n-1);
		
	}

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		List<Integer> before = Arrays.stream(nums).boxed().collect(Collectors.toList());
		
		nextPermutation(nums);
		List<Integer> after = Arrays.stream(nums).boxed().collect(Collectors.toList());
		
		System.out.println("Next Permutation of " + before + ": " + after);
		
	}

}
