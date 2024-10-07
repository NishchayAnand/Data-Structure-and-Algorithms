
/* Problem Statement:

*/

public class GasStation {

    private static boolean canCompleteBruteForce(int[] gas, int[] cost, int startingStationIndex) {

        int n = gas.length;
        int tank = 0;
        for(int i=0; i<n; i++) {
            int actualIndex = (i+startingStationIndex)%n;
            tank = tank + gas[actualIndex] - cost[actualIndex];
            if(tank < 0) {
                return false;
            }
        }

        return true;

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        boolean isPossible = false;

        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                isPossible = canCompleteBruteForce(gas, cost, i);
                if (isPossible) return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));

    }
}
