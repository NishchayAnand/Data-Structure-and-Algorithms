
/* Problem Statement: There are 'n' gas stations along a circular route, where the amount of gas at the 'ith' station is
                      gas[i]. You have a car with an unlimited gas tank, and it costs (requires) cost[i] of gas to travel
                      from the 'ith' station to its next '(i + 1)th' station. You begin the journey with an empty tank at
                      one of the gas stations.

                      Given two integer arrays 'gas' and 'cost', return the starting gas station's index if you can
                      travel around the circuit once in the clockwise direction, otherwise return -1.

                      NOTE: If there exists a solution, it is guaranteed to be unique.

   General Observations:

    - At any 'ith' gas station, if (gas[i] >= cost[i]), then 'i' could be a potential starting gas station index.

    - The value (gasInTank + gas[i] - cost[i]) can tell us if we have the required gas to travel from the 'ith' gas
      station to its next '(i+1)th' gas station.

    - Brute Force Approach:

        - Use nested loop to iterate over each potential starting gas station index and check if we can complete a full
          circle in the clockwise direction.

        - Time Complexity: O(n).

        - Space Complexity: O(1).

    - If sum(gas) >= sum(cost), we definitely have a unique solution, else the no solution exists.

    - Greedy Approach

        - In the example given below, assume we started the journey from Station0.

                Station0------------Station1------------Station2-------------Station3-------------Station4

        - After reaching Station2, we observed that we won't have the required gas to travel from Station2 to Station3.
          This simply means:
                - we won't be able to travel from Station2 to Station3 if we start from any station between Station0 and
                  Station2, i.e., Station1.
                - The starting station could either be Station3 or Station4.

        - Whether we start from Station3 or Station4, the journey from Station0 to Station3 is guaranteed. Therefore, if
          we can travel from Station3 to Station4, Station3 is the required starting station, else Station4.

                [Station0------------Station1------------Station2-------------Station3] ------------- Station4

        - Algorithm:

            - Loop from i = [0, n):
                - gasInTankSoFar = 0
                - if gasInTankSoFar < 0:
                    - gasInTankSoFar = 0;
                    - startingIndex = i+1

        - Time Complexity: O(n)

        - Space Complexity: O(1).

*/

public class GasStation {

    private static boolean canCompleteHelper(int[] gas, int[] cost, int startingStationIndex) {

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

    public static int canCompleteCircuitBruteForce(int[] gas, int[] cost) {

        int n = gas.length;
        boolean isPossible = false;

        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                isPossible = canCompleteHelper(gas, cost, i);
                if (isPossible) return i;
            }
        }

        return -1;

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        // sum(gas) >= sum(cost) check.
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) {
            return -1;
        }

        // loop to get starting station index.
        int startStationIndex = 0;
        int gasInTank = 0;
        for(int i=0; i<gas.length; i++) {
            gasInTank += gas[i] - cost[i];
            if(gasInTank < 0) {
                gasInTank = 0;
                startStationIndex = i+1;
            }
        }

        return startStationIndex;

    }

    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));

    }
}
