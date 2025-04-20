
/*

    Problem Statement:

        - Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have
          gone and will come back in h hours.

        - Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats
          k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat
          any more bananas during this hour.

        - Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

        - Return the minimum integer k such that she can eat all the bananas within h hours.

    Deduced Requirement:

        - Given:
            - An integer array 'piles' where piles[i] represent the number of bananas in the ith pile,
            - An integer 'h' representing the number of hours koko has to eat the entire banana collection.

        - NOTE:
            - Each hour, Koko can choose any pile and eat up to 'k' from that pile. If the pile has less than 'k' bananas,
              she eats all of them and doesn't eat more in that hour.

        - Find the minimum number of bananas 'k' Koko should eat in each hour so that she can eat all the bananas
          within h hours.

    General Observations:

        - For any chosen value of 'k', the number of hours required to consume all bananas = ceil(piles[0] / k) + ... +
          ceil(piles[n-1] / k).

    Brute Force Approach:

        - Start iterating from k = 1 and find the first valid value of k where [ceil(piles[0] / k) + ... +
          ceil(piles[n-1] / k)] <= h.

        - NOTE: If Koko eats faster than the biggest pile: max(piles), she still only spends 1 hour per pile.

        - Algorithm:
            - for k in range: [1, max(piles)]:
                - let totalHours = 0;
                - loop for each pile in piles:
                    - totalHours += ceil(pile / k);
                - if totalHours <= h: return k;
            - return -1;

        - Time Complexity: O(max(piles) * n).

        - Space Complexity: O(1).

    Binary Search Approach:

        - Use Binary Search to find the minimum value of k in the range [1, max(piles)] where where [ceil(piles[0] / k)
          + ... + ceil(piles[n-1] / k)] <= h.

        - Algorithm:

            - left = 1, right = max(piles);
            - output = -1;

            - while left <= right:

                - k = (left + right) / 2;
                - totalHours = 0;
                - loop for each pile in piles:
                    - totalHours += ceil(pile / k);

                - if totalHours <= h, current k is a possible output:
                    - output = k;
                    - right = k - 1;

                - if totalHours > h, all values of k < current value of k will result in totalHours > h, therefore, we
                  need to increase k (number of bananas eaten per hour), i.e., explore the right search space:
                    - left = k + 1;

            - return output;

        - Time Complexity: O(max(piles)) * n.

        - Space Complexity: O(1).

*/

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int output = -1;

        int left = 1, right = 0;
        for(int pile: piles) right = Math.max(right, pile);

        while(left <= right) {

            int k = (left + right) / 2;
            long totalHours = 0;

            for(int pile: piles) totalHours += (int) Math.ceil((double) pile / k);

            if(totalHours <= h) {
                output = k;
                right = k - 1;
            }
            else left = k + 1; // all values of k < current value of k will result in totalHours > h, hence, explore the right search space:
        }

        return output;

    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

}
