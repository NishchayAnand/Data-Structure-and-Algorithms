
/* Problem Statement: Given two integer arrays nums1 (containing m1 integers) and nums2 (containing n1 
 * 					  integers), sorted in non-decreasing order, merge nums1 and nums2 into a single array
 *                    sorted in non-decreasing order.
 * 
 * NOTE: The final sorted array should not be returned by the function, but instead be stored inside the 
 * 		 array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote 
 * 		 the elements that should be merged, and the last n elements are set to 0.
 * 
 * General Observations:
 * 
 * 	- The problem is equivalent to inserting all elements of nums2 into nums1.
 * 
 * 	- Algorithm: Add all elements of nums2 at the end of nums1 and use insertion sort algorithm to merge 
 * 			     the 2 arrays.
 * 
 * 	- Time Complexity Analysis (worst-case scenario): 
 * 
 * 		- Considering 2 arrays A = {7,8,9} and B = {1,2,3}, we would run the outer loop for n=3 times and 
 * 		  in iteration, we would perform m swaps. Total number of operations would be a polynomial of 
 * 		  order (m*n), hence, time complexity: O(m*n).
 * 
 * */

public class MergeTwoSortedArraysInplace {
	
	// implement this method.
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		for(int i=m; i<(m+n); i++){
			
			// adding nums2[i-m] as the last element in nums1 array.
            nums1[i] = nums2[i-m];
            
            // inserting nums2[i-m] at the correct position in nums1 array.
            for(int j=i; j>0; j--){
                if(nums1[j]<nums1[j-1]){
                    int temp = nums1[j];
                    nums1[j] = nums1[j-1];
                    nums1[j-1] = temp;
                } else {
                    break;
                }
            }
            
        }
    }

	public static void main(String[] args) {
		
		int[] A = {4,6,18};
		int[] B = {3,7,10,17,20};
		
		int m = A.length;
		int n = B.length;
		
		int[] ans = new int[m+n];
		for(int i=0; i<m; i++) {
			ans[i] = A[i];
		}
		
		merge(ans, m, B, n);
		
		System.out.print("Sorted Array: ");
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}

	}

}
