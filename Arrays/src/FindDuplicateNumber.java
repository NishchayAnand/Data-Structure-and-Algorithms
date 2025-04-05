
/*

    Problem Statement:

        - Given an integer array 'nums' of length = (n+1), containing numbers ranging from [1, n] inclusive. Considering,
          there is only one repeating number in 'nums', return that repeated number.

    General observations:

        Q. What would be the output of the following input: nums = [1,2,2,4,5]?
        A. Output = 2.

        Q. Is it guaranteed that there will always exist a duplicate number?
        A. No.

        Q. Will the integers in the 'nums' array be arranged in any sorted order?
        A. No.

        Q. Can the repeated integer appear more than once?
        A. Yes.

    Brute Force Approach:

        - Intuition: Considering we have at least one repeated element, there will be at least one pair where both the
                     elements are equal.

        - Use nested loop {i,j} to iterate over all pairs of elements, i.e., compare each element of the array with every
          other element.

        - Algorithm:
            - for i in range: [0, n-1):
                - for j in range: [i+1, n):
                    - if nums[i] == nums[j]: return nums[i];

        - Time Complexity: In the worst-case scenario, i.e., when the duplicate pair is at the end of the nums[] array
                           (e.g., [1,3,4,2,2]), the number of operations executed will be of the order n^2. Hence, time
                           complexity = O(n^2).

        - Space Complexity: O(1).

    Sorting Approach:

        - Iterate over the sorted the 'nums' array and check if any two consecutive elements are equal.

        - Algorithm:
            - nums = sort(nums);
            - for i in range [1, nums.length]:
                - if nums[i] == nums[i-1]: return nums[i];

        - Time Complexity: O(nlogn).

        - Space Complexity: O(1).

    HashSet Approach:

        - Iterate over every integer in the 'nums' array and maintain a HashSet to store all the unique numbers observed.
          At any point, if we found an integer which already exists in the HashSet, that would represent the duplicate
          number in the 'nums' array.

        - Algorithm:
            - HashSet = {};
            - for num in nums:
                - if num already present in HashSet: return num;
                - HashSet.add(num);

        - Time Complexity: O(n).

        - Space Complexity: O(n).

    Floyd's Tortoise and Hare Algorithm: Detect Cycle in a Linked list

        - Intuition: Treat the nums[] array as a linked list where every nums[i] node is connected to nums[nums[i]] node.

        NOTE: A cycle exist in a linked list when at least two nodes point to the same node (entry point to the cycle).

        - Algorithm:

            - slow = nums[0];
            - fast = nums[0];

            - do:
                - slow = nums[slow]; // equivalent to slow.next for jumping to the next node
                - fast = nums[nums[fast]]; // equivalent to fast.next.next for jumping to the next of the next node
            - while slow != fast;

            - slow = nums[0];
            - while slow != fast:
                - slow = nums[slow];
                - fast = nums[fast];

            - return slow;

        - Time Complexity: O(n).

        - Space Complexity: O(1).

*/



public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        while(true) {
            slow = nums[slow]; // equivalent to slow.next for jumping to the next node
            fast = nums[nums[fast]]; // equivalent to fast.next.next for jumping to the next of the next node
            if(slow == fast) break;
        }

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,4};
        System.out.println(findDuplicate(nums));
    }
}
