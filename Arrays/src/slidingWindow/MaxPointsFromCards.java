package slidingWindow;

/*

    Problem Statement:

        - Given an integer array 'cardPoints' where cardPoints[i] represents the points associated with ith card, return
          the maximum score you can achieve by selecting exactly k cards, either from the beginning or end of the array.

        - Sample Input: cardPoints = [1,2,3,4,5,6,1], k = 3; Output: 12 ([1,6,5])

    General Observations:

        - If k = 0, return 0.
        - If k = n, return sum(cardPoints, 0, n-1).
        - k cannot be greater than n.

    Brute Force Approach:

        - Start with leftSum (sum of the first k cards) and gradually shift selection by removing left cards and adding
          right cards, tracking the maximum sum.

        - Algorithm:

            - leftSum = sum(cardPoints, 0, k-1);

            - maxSum = leftSum;
            - if k == n: return maxSum;

            - rightSum = 0;
            - loop from i = [1, k]:
                - leftSum = leftSum - cardPoints[k-i];
                - rightSum = rightSum + cardPoints[n-i];
                - maxSum = max(maxSum, leftSum + rightSum);

            - return maxSum;

        - Time Complexity: O(k).

        - Space Complexity: O(1).

    - Sliding Window Approach:

        - Intuition:
            - If we pick k cards from the edges, we are forced to leave (n-k) consecutive cards in the middle.
            - Minimizing the sum of the (n-k) left-out cards maximizes the sum of the chosen k cards.

        - Instead of computing all possible k selections, explore all subarrays of length (n-k) to find the subarray
          with the minimum sum.

        - Algorithm:

            - totalSum = sum(cardPoints, 0, n-1);
            - windowSum = sum(cardPoints, 0, n-k-1);
            - minWindowSum = windowSum;

            - left = 0, right = n-k;
            - while right < n:
                - windowSum = windowSum + cardPoints[right] - cardPoints[left];
                - minWindowSum = min(minWindowSum, windowSum);
                - left++;

            - return totalSum - minWindowSum;

        - Time Complexity: O(n).

        - Space Complexity: O(1).

*/

public class MaxPointsFromCards {

    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int totalSum = 0;
        for( int points: cardPoints ) totalSum += points;
        if(k == n) return totalSum;

        int windowSum = 0;
        for( int i=0; i<n-k; i++ ) windowSum += cardPoints[i];
        int minWindowSum = windowSum;

        int left = 0;
        for( int right = n-k; right < n; right++ ) {
            windowSum += (cardPoints[right] - cardPoints[left++]);
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return totalSum - minWindowSum;

    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k)); // output = 12
    }
}
