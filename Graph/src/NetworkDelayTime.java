
/*

    Problem Statement:

        - Given a network of n nodes (labeled from 1 to n) and a list of travel times as directed edges
          times[i] = (ui, vi, wi), where:
                - ui is the source node,
                - vi is the target node, and
                - wi is the time it takes for a signal to travel from source to target.

        - Return the minimum time it takes for all the n nodes to receive the signal sent from a given node k. If it is
          impossible for all the n nodes to receive the signal, return -1.

    General Observations:

        - The input network can be represented as a weighted directed graph.

        - Use BFS to process (traverse) network (graph) layer-by-layer. Processing each layer takes 1 unit of time.

        - BFS Approach:

            - Algorithm:
                - queue.add(k);
                - minTime = 0;
                - while queue is not empty:
                    - layerSize = queue.size();
                    - for i = [1, layerSize]:
                        - vertex = queue.pop();
                        - maxTime = 0;
                        - for each edge of vertex:
                            - maxTime = max(maxTime, edge.weight);
                            - queue.add(edge.neighbour);
                        - minTime += maxTime;
                - return minTime;

            - Time Complexity:

            - Space Complexity:


    Use Case: Network Time Delay in a Distributed System



*/

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {
        return -1;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };

        int k = 2;

        System.out.println(networkDelayTime(times, n, k));

    }
}
