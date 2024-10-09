
/*

    Problem Statement: Given an integer array 'nums' and an integer 'k', return the number of subarrays of 'nums' where
                       the greatest common divisor (GCD) of the subarray's elements is 'k'.

                       NOTE: A subarray is a contiguous non-empty sequence of elements within an array.

    General Observations:

        - GCD(a,a) = a.

        - GCD(a,b,c) = GCD(GCD(a, b), c).

        - Brute Force Approach:

            - Use a nested loop to iterate over each possible subarray and use the following formula: GCD(a,b,c) =
              GCD(GCD(a, b), c) to compute GCDs.

            - Time Complexity ~ O(n^2).

            - Space Complexity = O(1).

            - Optimization: If GCD(a,b) < k, then GCD(a,b.c) will also be < k.

*/

public class SubarraysWithGCDEqualK {

    private static int GCD(int a, int b) {
        if(b==0) return a;
        return GCD(b, a%b);
    }

    public static int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int gcd = nums[i];
            for(int j=i; j<nums.length; j++) {
                gcd = GCD(gcd, nums[j]);
                if(gcd == k) {
                    count++;
                } else if(gcd < k) { // subarrays with ending index > j would all have GCD < k.
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {9,3,1,2,6,3};
        int k = 3;
        System.out.println(subarrayGCD(nums, k));
    }
}
