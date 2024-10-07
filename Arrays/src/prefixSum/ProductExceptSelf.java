package prefixSum;

/* Problem Statement: Given an integer array 'nums', return an array answer such that answer[i] is equal to the product
                      of all the elements of nums except nums[i].

                      NOTE: You must write an algorithm that runs in O(n) time and without using the division operation.

   General Observations:

    - For every nums[i], answer[i] = (Product of all elements in the range [0,i-1]) * (Product of all elements in the
                                      range [i+1, n-1]).

    - Brute Force Approach:

        - For every nums[i], run 2 loops to calculate the product of elements to the left of it and product of elements
          to the right of it.

        - Time Complexity: O(n^2).

        - Space Complexity: O(1).

    - Prefix Sum Approach:

        - Define left_products[i] such that for every nums[i], it will store the product of all elements to the left of
          nums[i].

        - Similarly, define right_products[i] such that for every nums[i], it will store the product of all elements to
          the right of nums[i].

        - Every answer[i] would be equal to left_product[i]*right_product[i].

        - Time Complexity: O(n).

        - Space Complexity: O(n).

        - We can optimize this approach to avoid using extra space by using a single result array and updating it in
          two passes, one for the left products and one for the right products.

        - NOTE: The output array does not count as extra space for space complexity analysis.

* */

public class ProductExceptSelf {

    private static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] left_product = new int[n];
        left_product[0] = 1;
        for(int i=1; i<n; i++) {
            left_product[i] = left_product[i-1]*nums[i-1];
        }

        int[] right_product = new int[n];
        right_product[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            right_product[i] = right_product[i+1]*nums[i+1];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = left_product[i]* right_product[i];
        }

        return ans;

    }

    private static int[] productExceptSelfOptimized(int[] nums) {

        int n = nums.length;

        int[] output = new int[n];
        output[0] = 1;
        for(int i=1; i<n; i++) {
            output[i] = output[i-1]*nums[i-1];
        }

        int right_product = 1;
        for(int i=n-1; i>=0; i--) {
            output[i] = output[i]*right_product;
            right_product = right_product*nums[i];
        }

        return output;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4}; // output = {24,12,8,6}
        System.out.print("Output: ");
        int[] ans = productExceptSelfOptimized(nums);
        for(int num: ans) {
            System.out.print(num + " ");
        }
    }

}
