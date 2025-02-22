
/*

    Problem Statement:

        - Given an undirected graph (represented using an adjacency list) having unit weight of the edges and a source
          vertex 'src', find the shortest path from 'src' to all the vertex.

        - NOTE: If it is impossible to reach any vertex from the 'src' vertex, return -1 for that vertex.

    General Observations:

        - Intuition:
            - Use BFS traversal to explore each vertex level by level. Since BFS processes all nodes at distance 'd'
              before moving to distance 'd+1', the first time a vertex is visited, it is through the shortest path.

        - Algorithm:

            // Initialize an array to track the shortest distance from the source 'src' to each vertex
            - dist = [-1]*V;
            - dist[src] = 0;

            // Process each vertex level-by-level
            - queue.add(src);
            - while queue is not empty:
                - levelSize = queue.size();
                - for i = [1, levelSize]:
                    - vertex = queue.poll();
                    - for each neighbour in graph[vertex]:
                        - if dist[neighbour] == -1:
                            - dist[neighbour] = dist[vertex] + 1;
                            - queue.add(neighbour);

            - return dist;

        - Time Complexity: O(V + E).

        - Space Complexity: O(V).

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BFSShortestPath {

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {

        // Initialize an array to track the shortest distance from the source 'src' to each vertex
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, -1);
        dist[src] = 0;

        // Process each vertex level-by-level
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int neighbour: adj.get(vertex)) {
                if(dist[neighbour] == -1) {
                    dist[neighbour] = dist[vertex] + 1;
                    queue.add(neighbour);
                }
            }
        }

        return dist;

    }

    public static void main(String[] args) {

        int src = 0;

        int[][] graph = {
                {1,3},
                {0,2},
                {1,6},
                {0,4},
                {3,5},
                {4,6},
                {2,5,7,8},
                {6,8},
                {6,7}
        };

        ArrayList<ArrayList<Integer>> adj = Arrays.stream(graph)
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

        int[] dist = shortestPath(adj, src);
        Arrays.stream(dist).forEach(System.out::println);

    }
}
