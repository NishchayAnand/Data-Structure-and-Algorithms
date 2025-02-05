
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

        - At each index 'i' < 'n-1' , we can jump to an index anywhere within the range: [i+1, min(i + nums[i], n-1)].

        - Intuition:

            - Each index 'i' represents a vertex of a graph such that there exists a directed edge from vertex 'i' to
              every vertex within the range: [i+1, min(i + nums[i], n-1)].

            - The problem involves finding the shortest path from vertex '0' to vertex 'n-1'.

            - Can use BFS traversal where each level in BFS corresponds to one jump.

        - Greedy Approach:

            - Simulate BFS traversal using two pointers: 'left' and 'right' representing the start and end of the
              current level under process.

            - Algorithm:

                - jumps = 0;

                // Step 1: Set level 0 boundaries
                - left = 0, right = 0;

                // Step 2: Stop when last index is reached
                - while right < n-1:

                    // Find next level boundary
                    - next_level_boundary = -1;
                    - for i = [left, right]:
                        - next_level_boundary = max( next_level_boundary, min(i+nums[i], n-1) );

                    // Set next level boundaries
                    - left = right + 1;
                    - right = next_level_boundary;

                    // jump to the next level
                    - jumps++;

                - return jumps;

            - Time Complexity: O(n).

            - Space Complexity: O(1).

*/

public class JumpGameII {

    public static int jump(int[] nums) {

        int n = nums.length;
        int jumps = 0;

        // Step 1: Set level 0 boundaries
        int left = 0, right = 0;

        // Step 2: Stop when last index is reached
        while(right < n-1) {

            // Find next level boundary
            int nextLevelBoundary = -1;
            for(int i = left; i<=right; i++) {
                nextLevelBoundary = Math.max( nextLevelBoundary, Math.min(i+nums[i], n-1) );
            }

            // Set next level boundaries
            left = right + 1;
            right = nextLevelBoundary;

            // jump to the next level
            jumps++;

        }

        return jumps;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
