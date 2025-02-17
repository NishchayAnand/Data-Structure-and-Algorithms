
/*

    Problem Statement:

        - Given an undirected graph with V vertices (numbered from 0 to V-1) and E edges, where each edge (X, Y) has a
          weight representing the distance between nodes X and Y.

        - Determine the shortest path distance from the source node (0) to all other vertices in the graph.

    General Observations:

        - BFS explores nodes level by level, counting the number of edges from the source to a node (assuming each edge
          has the same weight) and treating it as the "shortest" path.

        - In a weighted graph, the shortest path is based on minimum sum of edge weights, not the fewest edges.

        - For example, in the below graph, the shortest path to reach C = 2 (A-B) + 1 (B-C) = 3, not 5 (A-C).

                         ________2_________B________1________
                        |                                    |
                        A__________________5_________________C
                        |                                    |
                        |_______________3_________D_____1____|

        - Intuition:
            - Out of all the unvisited nodes with known distance from source node, always process the node which is closest
              to the source node. since all paths to it would have been fully explored.Always process the node closest

        - Out of all the unvisited nodes with known distance from source node, we can process the node which is closest
          to the source node since all paths to it would have been fully explored.

          Since all edge weights are non-negative, expanding the closest node

        - Node closest to the source would be processed first??


*/

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraShortestPath {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> graph, int vertices, int edges, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
    }

    public static ArrayList<ArrayList<Integer>> convertMatrix(int[][] matrix) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int[] row : matrix) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int num : row) {
                tempList.add(num); // Add elements to inner ArrayList
            }
            list.add(tempList); // Add inner list to outer ArrayList
        }

        return list;
    }

    public static void main(String[] args) {

        int V = 4;
        int E = 5;

        int[][] edges = {
                {0,1,5},
                {0,2,8},
                {1,2,9},
                {1,3,2},
                {2,3,6}
        };

        ArrayList<ArrayList<Integer>> graph = convertMatrix(edges);

        System.out.println(dijkstra(graph, V, E, 0));

    }
}
