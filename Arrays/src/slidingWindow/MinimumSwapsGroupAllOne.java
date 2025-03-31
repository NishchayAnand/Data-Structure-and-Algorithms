package slidingWindow;

/*

    Problem Statement:

        - Given a circular binary array 'nums', return the minimum number of swaps needed to group all 1's together.

        - Example: nums = [0,1,0,1,1,0,0]; Output: 1 ([0,0,1,1,1,0,0] using 1 swap)
                                                         - -

    General Observations:

        Q. What do you understand from the problem statement?
        A. The problem involves finding the subarray of length = (number of 1's in nums[] array) containing the least
           number of 0's.

        Q. What should be the output if the nums[] array contains all 1s?
        A. The method should return 0.

        Q. What is a circular array?
        A. After the last element, it wraps around to the first element. For example, in nums = [1,1,1,0,1], possible
           subarrays of length 4 are: [1,1,1,0], [1,1,0,1], [1,0,1,1] (wrapping around), [0,1,1,1] (wrapping around), [1,1,1,1] (wrapping around)

        NOTE: Rather than using complex index calculations to handle wrap-around cases, we can duplicate nums[] by
              appending it to itself. This allows us to treat the problem as a standard linear array.


    Brute Force Approach:

        Q. What is the simplest way to solve this problem?
        A. Iterate over all subarrays of length = (number of 1's in nums[] array), starting at indices in the range [0, n-1]
           and keep track of the least number of 0s observed in all explored subarrays.

        - Algorithm: What is the simplest way to solve this problem?

            - minSwaps = 0;
            - countOnes = getCountOnes(nums);

            - Base Condition: if countOnes == n | 0: return minSwaps (0);

            - extendedNums = [nums] + [nums] to handle wrap-around cases;

            - loop for i in range [0, n-1]:
                - countZeroes = getCountZeroes(extendedNums, i, (i + countOnes) -> excluded);
                - minSwaps = min(minSwaps, countZeroes);

            - return minSwaps;

        - Time Complexity: What is the time complexity of this approach?
            - In the worst-case scenario, i.e., when the number of 1s in the nums[] array = (n -> handled | n-1), the
              number of operations performed would be of the order n^2.
            - Hence, time complexity = O(n^2).

        - Space Complexity: What is the space complexity of this approach?
            - No extra space needed.
            - Hence, space complexity = O(1).


    Sliding Window Approach: Can we improve this by utilizing some pattern in the problem?

        - Intuition: Instead of repeatedly computing the number of zeroes for each subarray from scratch, we can maintain
                     a running count of zeroes and efficiently update it as the window moves.

        - Use two pointers (left, right) to iterate over all subarrays of length = (number of 1's in nums[] array),
          keeping track of the count of zeroes in each observed window and efficiently update it as the window moves.

        - Algorithm:

            - minSwaps = 0;
            - countOnes = getCountOnes(nums);

            - Base Condition: if countOnes == n | 0: return minSwaps (0);

            - extendedNums = [nums] + [nums] to handle wrap-around cases;

            - countZeroes = getCountZeroes(nums, 0, countOnes -> excluded);

            - left = 1, right = countOnes;
            - while left < n:
                - if nums[right] == 0: countZeroes++;
                - if nums[left] == 0: countZeroes--;
                - minSwaps = min(minSwaps, countZeroes);
                - left++;
                - right++;

            - return minSwaps;

        - Time Complexity:
            - Each element is processed twice.
            - Hence, time complexity: O(2*n) ~ O(n).

        - Space Complexity: O(1).

*/

import java.util.Arrays;

public class MinimumSwapsGroupAllOne {

    public static int minSwaps(int[] nums) {

        int n = nums.length;
        int countOnes = Arrays.stream(nums).sum();

        // Base Condition:
        if(countOnes == 0 || countOnes == n) return 0;

        // Handle wrap-around cases
        int[] extendedNums = new int[2*n];
        for(int i=0; i<2*n; i++) {
            extendedNums[i] = nums[i%n];
        }

        // Pre-populate the running count of zeroes
        int countZeroes = 0;
        for(int i=0; i<countOnes; i++) {
            if(nums[i] == 0) countZeroes++;
        }
        int minSwapsRequired = countZeroes;

        // Iterate over the remaining subarrays of size = countOnes
        for(int i=1; i<n; i++) {
            if(extendedNums[i-1] == 0) countZeroes--; // remove the leftmost element
            if(extendedNums[i+countOnes-1] == 0) countZeroes++; // add the new rightmost element
            minSwapsRequired = Math.min(minSwapsRequired, countZeroes);
        }

        return minSwapsRequired;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,0};
        System.out.println(minSwaps(nums));
    }
}
