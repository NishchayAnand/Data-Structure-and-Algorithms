
/* Problem Statement: Given an integer array nums of length 'n', rotate the array to the right by k steps,
 * 					  where k is non-negative.
 * 
 * General Observations:
 * 
 * 	- If k = N, the rotations will have no impact. This is because rotating the array by 'n' positions is 
 * 	  equivalent to no rotation at all.
 * 
 * 	- If k > N, then k can be represented as (n*quo + rem). In this case, rotating the array by 'k' 
 * 	  positions would be equivalent to rotating the array by 'rem' positions ('rem' will always be less 
 *    than 'n').   
 * 
 *  - Brute Force Approach:
 *  
 *  	- NewIndex = (OldIndex + k) % n.
 *  
 *  	- Create an auxiliary array and fill it using the relation between the NewIndex and the OldIndex
 *  	  of each element in input array (defined above).
 *  
 *  	- Time Complexity = O(n).
 *  
 *  	- Space Complexity = O(n).
 *  
 *  - Space Optimized Approach:
 *  
 *  	- Considering k < n, the rotation needs to bring the last 'k' elements to the start of the array 
 *  	  and push the first 'n-k' element to the end of the array. 
 *  	
 *  	- Reversing the array would help us get the last 'k' elements to the start of the array and the
 *        first 'n-k' elements to the end of the array. However, the order of elements within each group 
 *        (the last k and the first n-k) is reversed.
 *        
 *      - Reversing the first 'k' elements would help us correct the order within the first 'k' elements. 
 *      
 *      - Similarly, reversing the remaining 'n-k' would help us correct the order within the last 'n-k'
 *        elements.
 *        
 *      - Time Complexity = O(n).
 *      
 *      - Space Complexity Analysis:
 *      	- Since we are performing inplace rotation. Space complexity = O(1). 
 * 
 * */


public class RotateArray {
	
	private static void display(int[] nums) {
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
	
    private static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    private static void reversalAlgorithm(int[] nums, int n, int k) {
    	
    	// reverse the entire array.
        reverse(nums, 0, n-1);
        
        // reverse the first 'k' elements.
        reverse(nums,0,k-1);
        
        // reverse the last 'n-k' elements.
        reverse(nums,k,n-1); 
        
    }


    private static void bruteForceAlgorithm(int[] nums, int n, int k) {
    	
        int[] temp = new int[n];
        
        for(int i=0; i<n; i++) {
        	int newIndex = (i+k)%n;
        	temp[newIndex] = nums[i];
        }
        
        for(int i=0; i<n; i++) {
        	nums[i] = temp[i];
        }

    }

    public static void rotate(int[] nums, int k) {
    	
        int n = nums.length; 
        k = k%n;

        //bruteForceAlgorithm(nums, n, k);
        reversalAlgorithm(nums, n, k);
    }
    
    public static void main(String[] args) {
    	
    	int[] A = {1,2,3,4,5,6,7};
    	int k = 3;
    	
    	System.out.print("Original Array: ");
    	display(A);
    	
    	rotate(A, k);
    	System.out.print("\nRotated Array: ");
    	display(A);
    	
    }
}