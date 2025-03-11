package slidingWindow;

/*

    Problem Statement:

        - Given an array of integers where each index represents a tree and value at that index represents the type of fruit
          produced by that tree.

        - Return the maximum fruits you can pick from a contiguous set of trees when you are only allowed to pick 2 different
          varieties of fruits.

    General Observations:

        - The problem involves finding the longest subarray containing 2 unique sets of integers.

        - Brute Force Approach:

            - Use nested loop to iterate over all possible substrings containing 2 unique sets of integers.

            - Algorithm:
                - max_length = 0;
                - loop from i = [0, n):
                    - unique_num_set = HashSet;
                    - loop from j = [i, n):
                    - unique_num_set.add(nums[j]);
                    - if unique_num_set.size() <= 2:
                        - max_length = max(max_length, j-i+1);
                    - else:
                        - break;

            - Time Complexity: O(n^2)

            - Space Complexity: O(n).

            - Redundant Operations:

            - Sliding Window Approach:
                -

*/

public class FruitsInBasket {

}
