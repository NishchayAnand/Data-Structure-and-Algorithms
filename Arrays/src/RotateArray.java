
public class RotateArray {
	
	private void display(int[] nums) {
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
	
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    private void reversalAlgorithm(int[] nums, int n, int k) {
        reverse(nums, 0, n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);  
    }


    private void bruteForceAlgorithm(int[] nums, int n, int k) {
        int[] temp = new int[n];
        // 1. copy last k elements to [0...k-1] indices of the temporary array.  
        for(int i=0, j=(n-k); i<k; i++, j++){
            temp[i] = nums[j];
        }

        // 2. copy the first (n-k) elements to [k...n-1] indices of the temporary array.
        for(int i=k, j=0; i<n; i++, j++){
            temp[i] = nums[j];
        }

        // 3. copy back the rotated elements from the temporary array to the original array.
        for(int i=0; i<n; i++){
            nums[i] = temp[i];
        }

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        k = k%n;

        bruteForceAlgorithm(nums, n, k);
        reversalAlgorithm(nums, n, k);
    }
}