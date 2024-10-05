package twoPointer;
/*
 * Given: An array 'Heights' containing 'n' non-negative integers, together representing an elevation map where
 *        the width of each building is 1,
 *
 * Output: Return the units of water the elevation map can trap after raining.
 *
 * General Observations:
 *
 *   - Total units of water the elevation map can trap = sum of units of water that can be trapped above each building.
 *
 *   - For any 'ith 'building, units of water that can be trapped above it = min(Height of tallest building on the left,
 *     i.e., HTL[i], Height of tallest building on the right, i.e., HTR[i]) - Heights[i].
 *
 *     NOTE:
 *          - Here, min(HTL[i], HTR[i]) represents the water level above the 'ith' building
 *          - If min(HTL[i], HTR[i]) - heights[i] <= 0, no water can be trapped above the 'ith' building.
 *
 *   - Brute Force Approach:
 *
 *      - Use 2 arrays: 'HTL' and 'HTR' to store the height of the tallest building on the left and right for each
 *        building.
 *
 *      - Time Complexity: O(n).
 *
 *      - Space Complexity: O(n).
 *
 *   - Two Pointers Approach:
 *
 *      - Considering MaxL = Heights[0],  MaxR = heights[n-1], L = 1 and R = n-2, if MaxL <= MaxR, then water level
 *        above the 'Lth' building would only depend upon MaxL. Similarly, if MaxL > MaxR, then water level above the
 *        'Rth' building would only depend upon MaxR.
 *
 *      - Time Complexity: O(n).
 *
 *      - Space Complexity: O(1).
 *
 * */

public class TrappingRainWater {

    private static int trapBruteForce(int[] height) {

        int n = height.length;

        int[] htl = new int[n];
        for(int i=1; i<n; i++){
            htl[i] = Math.max(htl[i-1], height[i-1]);
        }

        int[] htr = new int[n];
        for(int i=n-2; i>=0; i--) {
            htr[i] = Math.max(htr[i+1], height[i+1]);
        }

        int total = 0;
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(htl[i], htr[i]);
            int currUnit = waterLevel - height[i];
            if(currUnit > 0) total += currUnit;
        }

        return total;

    }

    private static int trap(int[] height) {

        int n = height.length;
        if(n<=2) return 0;

        int maxL = height[0];
        int left = 1;

        int maxR = height[n-1];
        int right = n-2;

        int total = 0;
        while(left<=right) {

            if(maxL <= maxR) {
                // maxL represents the water level above the 'left' building.
                if(maxL > height[left]) {
                    total += maxL - height[left];
                } else {
                    maxL = height[left];
                }
                left++;
            } else { // maxR < maxL
                // maxR represents the water level above the 'right' building.
                if (maxR > height[right]) {
                    total += maxR - height[right];
                } else {
                    maxR = height[right];
                }
                right--;
            }
        }

        return total;

    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
