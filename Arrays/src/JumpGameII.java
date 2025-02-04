
/*

    Problem Statement:

            - Given an integers array 'nums' of length 'n' where each element nums[i] represents the maximum length of a
              forward jump from index 'i'.

            - In other words, if you are at nums[i], you can jump to any nums[i + j] where:
                1. 0 <= j <= nums[i] and
                2. i + j < n

            - Return the minimum number of jumps to reach nums[n - 1].

            NOTE: The test cases are generated such that you can reach nums[n - 1].

    General Observations:

        - At every index, we have a choice: We can jump anywhere within the range i + nums[i].

        - Greedy Intuition:
            - At each index, only make a jump if it can take you ahead of the farthest reachable index from the previous
              indices.

        - Greedy Approach:

            - Algorithm:
                - farthest_index = 0;
                - min_jumps = 0;
                - for curr_index = [0, n-1]:
                    - max_next_index = max(curr_index + nums[curr_index], n-1);
                    - if max_next_index > farthest_index: farthest_index =

*/

public class JumpGameII {

    public static int jump(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
