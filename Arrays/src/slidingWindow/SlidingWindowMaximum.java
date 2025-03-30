package slidingWindow;

/*

    Problem Statement:

        - You are given an array of integers 'nums', there is a sliding window of size 'k' which is moving from the very
          left of the array to the very right.

        - You can only see the k numbers in the window.

        - Each time the sliding window moves right by one position.

        - Return the max sliding window.

        - Example: [1,3,-1,-3,5,3,6,7], k = 3; Output: [3 (1,3,-1), 3 (3,-1,-3), 5 (-1,-3,5), 5 (-3,5,3), 6 (5,3,6), 7 (3,6,7)]

    General Observations:

        Q. What do we mean by "return max sliding window"?
        A. Return the maximum element in every contiguous subarray of size 'k'.

        Q. What if 'nums' is empty?
        A. Return [].

        Q. What if k = 1?
        A. Return 'nums'.

        Q. What if k > nums.length?
        A. k cannot be greater than nums.length.

    Brute Force - Sliding Window Approach:

        - Iterate over each window of size = k and use a loop to find the maximum value within each window.

        - Algorithm:
            - output = [];
            - left = 0, right = k-1;
            - while right < n:
                - maxElement = max(nums, left, right);
                - output.add(maxElement);
                - right++;
                - left++;
            - return output;

        - Time Complexity:
            - We will explore (n-k+1) windows of size = k. In each iteration, we will run a loop of O(k).
            - Hence, time complexity = O(n*k).

        - Space Complexity: O(1) -> ignored output array.

    Monotonic Queue Optimization:

        - Intuition: For each window, we want to maintain the elements in monotonically decreasing order while
                     preserving their indices, ensuring that the largest element is always at the front for quick
                     access.

        - Use two pointers (left, right) to iterate over each window of size = k and maintain a deque to store the indices
          of elements in each window in a monotonically decreasing order, ensuring that the front always holds the
          largest element in the current window.

        - NOTE: At every iteration, the index of the current element would be appended to the queue.

        - Algorithm:

            - output = [];
            - deque = [];
            - left = 0, right = 0;

            // Pre-populate the deque with indices of monotonically decreasing elements in the first window
            - while right < k:

                // Remove the indices of all elements smaller than the current element: nums[right] from the back of deque
                - while nums[queue[back]] < nums[right]: deque.popBack();
                - deque.append(right);

                - right++ to expand the window;

            // Append the maximum element in the first window, i.e., the element at the front of the deque to output to the output array
            - output.append(nums[deque[front]]);
            - left++ to shrink the window to make it valid again;

            // Process the remaining windows, one step at a time
            - while right < n:

                // Process the deque so that the front of the deque holds the index of the maximum element in the current window
                - if deque[front] < left: deque.popFront() to remove the index of the out-of-bound element from the front;
                - while nums[queue[back]] < nums[right]: deque.popBack() to maintain monotonically decreasing order;
                - deque.append(right);

                // Append the maximum element in the current window, i.e., the element at the front of the deque to output to the output array
                - output.append(nums[deque[front]]);

                - right++ to expand the window;
                - left++ to shrink the window to make it valid again;

            - return output;

        - Time Complexity:
            - Each element is processed at most twice: once when it is added to the deque and once when it is removed from the deque.
            - Considering there are n elements, the total number of operations will be at most 2n. Hence, overall time
              complexity = O(n).

        - Space Complexity:
            - The deque will store at most k elements simultaneously. Hence, space complexity = O(k).

*/

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Base Conditions
        if(n == 0) return new int[0];
        if(k == 1) return nums;

        int[] output = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        int left = 0;
        for(int right=0; right<n; right++) {

            // Process the deque such that the front of the deque holds the index of the maximum element for the current window
            if(!dq.isEmpty() && dq.peekFirst() < left) dq.pollFirst(); // remove the index of the out-of-bound element from the front of deque
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) dq.pollLast(); // remove the indices of all elements smaller
                                                                                     // than the current element from the back of deque
                                                                                     // to maintain monotonically decreasing order

            dq.add(right);

            if(right-left+1 == k) {
                // Append the maximum element in the current window, i.e., the element at the front of the deque to output to the output array
                output[left] = nums[dq.peekFirst()];
                left++; // shrink the window;
            }

        }

        return output;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        for(int num: maxSlidingWindow(nums, k)) System.out.print(num + " ");
    }
}
