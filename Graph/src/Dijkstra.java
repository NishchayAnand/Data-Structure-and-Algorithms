
/*

    Problem Statement:

        - Given an undirected graph with V vertices (numbered from 0 to V-1) and E edges, where each edge (X, Y) has a
          weight representing the distance between nodes X and Y.

        - Determine the shortest path distance from the source node (0) to all other vertices in the graph.

    General Observations:

        - BFS explores nodes level by level, counting the number of edges from the source to a node (assuming each edge
          has the same weight) and treating it as the "shortest" path.

        - In a weighted graph, the shortest path is based on the minimum sum of edge weights, not the fewest edges.

        - For example, in the below graph, the shortest path to reach C = 2 (A-B) + 1 (B-C) = 3, not 5 (A-C).

                         ________2_________B________1________
                        |                                    |
                        A__________________5_________________C
                        |                                    |
                        |_______________3_________D_____1____|

        - Greedy Intuition:
            - Out of all the unprocessed nodes (with known distance from source node), the node which is closest to the
              source node is guaranteed to have all possible paths leading to it fully explored.

        - Dijkstra's Algorithm:

            // Step 1: create an array to represent the shortest known distance from the source node to every other node.
            - let dist = [∞] * V;
            - Set dist[source] = 0;

            // Step 2: initialize a priority queue (min-heap) with the (source node) and its (distance from the source node).
            - pq.push([source, 0]);

            // Step 3: process all (V) nodes to find their shortest distance from source node.
            - While pq is not empty:
                - [X, dX] = pq.poll();
                - For each edge [Y,W] of X:
                    - If dist[X] + W < dist[Y]:
                        - dist[Y] = dist[X] + W;
                        - pq.add([Y, dist[Y]]);

            - return dist;

        - Time Complexity:

            - In the worst-case scenario (a densely connected graph where each node is connected to every other node),
              each node has V-1 edges and total number of edges (E) = V^2.

            - Number of operations performed by the above algorithm = V * ( log(avg_heap_size) + (V-1) * log(avg_heap_size) )
                                                                    = V * log(avg_heap_size) * (V)
                                                                    = V^2 * log(avg_heap_size)
                                                                    = E * log(avg_heap_size)
                                                                    = E * log(V^2)
                                                                    = E * 2 * log(V)

           - Since, number of operations is of the order E*log(V), time complexity = O( E*log(V) )

        - Space Complexity:

            - In the worst-case scenario (a densely connected graph where each node is connected to every other node),
              the priority queue will hold V^2 entries (number of edges - E).

            - Hence, space complexity = O(V^2)

        - NOTE: The Dijkstra's algorithm works for a weighted graph with non-negative edges.
*/

import java.util.*;

public class Dijkstra {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {

        // Step 1: Create the graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=0; i<vertices; i++) graph.put(i, new ArrayList<>());
        for(ArrayList<Integer> edge: vec) {
            graph.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
            graph.get(edge.get(1)).add(new int[]{edge.get(0), edge.get(2)});
        }

        // Step 2: Create an ArrayList to represent the shortest known distance from the source node to every other node
        ArrayList<Integer> dist = new ArrayList<>();
        for(int i=0; i<vertices; i++) dist.add(Integer.MAX_VALUE);
        dist.set(source, 0);

        // Step 3: Initialize a priority queue (min-heap) with the (source node) and its (distance from the source node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0}); // {node, distance}

        // Step 4: Process all nodes to find their shortest distance from source node
        while(!pq.isEmpty()) {

            // Get the unprocessed node closest to the source node
            int[] current = pq.poll();
            int node = current[0], nodeDist = current[1];
            if(nodeDist>dist.get(node)) continue; // skip any extra entry for already finalized node (visited check)

            // Update the shortest distance from source node to node's neighbours
            for(int[] edge : graph.get(node)) {
                int neighbour = edge[0], weight = edge[1];
                if(dist.get(node) + weight < dist.get(neighbour)) {
                    dist.set(neighbour, dist.get(node) + weight);
                    pq.add(new int[]{neighbour, dist.get(neighbour)});
                }
            }

        }

        return dist;

    }

    public static ArrayList<ArrayList<Integer>> convertMatrix(int[][] matrix) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int[] row : matrix) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int num : row) tempList.add(num); // add elements to inner ArrayList
            list.add(tempList); // add the inner list to outer ArrayList
        }
        return list;
    }

    public static void main(String[] args) {
        // test case 1
        int V = 4;
        int E = 5;
        int[][] edges = {
                {0,1,5},
                {0,2,8},
                {1,2,9},
                {1,3,2},
                {2,3,6}
        };
        ArrayList<ArrayList<Integer>> vec = convertMatrix(edges);
        System.out.println(dijkstra(vec, V, E, 0));
    }
}
