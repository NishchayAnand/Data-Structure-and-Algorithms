
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
 *   - For any building 'i', units of water that can be trapped above it = min(Height of tallest building on the left, i.e.,
 *     HTL[i], Height of tallest building on the right, i.e., HTR[i]) - Height[i], where: Height[i] < HTL[i], HTR[i].
 *
 *   - Brute Force Approach:
 *
 *      -
 *
 * */

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] Heights = {0,1,0,2,1,0,1,3,2,1,2,1};
    }
}
