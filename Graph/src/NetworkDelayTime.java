
/*

    Problem Statement:

        - Given a network of 'n' nodes (labeled from 1 to n) and a list of travel times as directed edges times[i] =
          (ui, vi, wi), where:
                - ui is the source node,
                - vi is the target node, and
                - wi is the time it takes for a signal to travel from source to target.

        - Return the minimum time it takes for all the n nodes to receive the signal sent from a given node 'k'. If it is
          impossible for all the 'n' nodes to receive the signal, return -1.

    General Observations:

        - The input network can be represented as a directed, weighted graph.

        - The problem involves finding the minimum time, i.e., the shortest path from source vertex 'k' to all other
          vertices and keeping track of the farthest vertex (i.e., the vertex with the maximum shortest path distance
          from 'k').

        - NOTE: In a weighted graph, the shortest path is based on the minimum sum of edge weights, not the fewest edges.

        - BFS - Brute Force Approach:

            - Use BFS traversal to explore all possible paths.

            - Algorithm:

                - dist = [Infinity]*V;
                - dist[k] = 0; // minimum time required to reach source 'k' = 0

                - queue.add(k);
                - while queue is not empty:
                    - vertex = queue.poll();
                    - for each [neighbour, weight] in graph[vertex]:
                        - if dist[vertex] + weight < dist[neighbour]:
                            - dist[neighbour] = dist[vertex] + weight;
                            - queue.add(neighbour);

                - if dist[any] == Infinity ? return -1 : return max(dist);

            - Time Complexity: O(V*E), O(V^3) in worst-case scenario (each vertex connected to every other vertex)

            - Space Complexity: O(V).

        - The BFS approach works but is inefficient because it explores extra paths and does not prioritize the shortest
          ones first.

        - Dijkstra - Greedy Approach:

            - Use a priority queue (min-heap) to ensure that we always process the closest (shortest distance) node first.

            - Algorithm:

                - dist = [Infinity]*V;
                - dist[k] = 0; // minimum time required to reach source 'k' = 0

                - pq.add([k,0]);
                - while pq is not empty:
                    - vertex, source_distance = queue.poll();

                    // Skip if already visited with a shorter path
                    if source_distance > dist[vertex]: continue

                    - for each [neighbour, weight] in graph[vertex]:
                        - if dist[vertex] + weight < dist[neighbour]:
                            - dist[neighbour] = dist[vertex] + weight;
                            - queue.add(neighbour);

                - if dist[any] == Infinity ? return -1 : return max(dist);

            - Time Complexity:

                - In the worst-case scenario (a densely connected graph where each node is connected to every other node),
                  each node has V-1 edges and the total number of edges (E) = V^2.

                - Number of operations performed = V * ( log(avg_heap_size) + (V-1) * log(avg_heap_size) )
                                                 = V * log(avg_heap_size) * (V)
                                                 = V^2 * log(avg_heap_size)
                                                 = E * log(avg_heap_size)
                                                 = E * log(V^2)
                                                 = E * 2 * log(V)

                - Since, number of operations is of the order E*log(V), time complexity = O( E*log(V) )

            - Space Complexity: O(V).

     Real-World Use Case:

        - Network Time Delay in a Distributed System.

*/

import java.util.*;

public class NetworkDelayTime {

    private static int[] BFS(Map<Integer, List<int[]>> graph, int k) {

        // Step 1: Initialize distance array with Infinity
        int[] dist = new int[graph.size()+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // minimum time required to reach source 'k' = 0

        // Step 2: BFS setup with queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        // Step 3: Perform BFS traversal
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int[] neighbour_edge: graph.get(vertex)) {
                int neighbour = neighbour_edge[0], weight = neighbour_edge[1];

                // Step 4: If a shorter path to neighbor vertex found, update and add to the queue
                if(dist[vertex] + weight < dist[neighbour]) {
                    dist[neighbour] = dist[vertex] + weight;
                    queue.add(neighbour);
                }
            }
        }

        return dist;

    }

    private static int[] Dijkstra(Map<Integer, List<int[]>> graph, int k) {

        // Step 1: Initialize distance array with Infinity
        int[] dist = new int[graph.size()+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // minimum time required to reach source 'k' = 0

        // Step 2: BFS setup with queue
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        queue.add( new int[]{k,0} );

        // Step 3: Perform BFS traversal
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int vertex = current[0], sourceDistance = current[1];

            // Skip if already visited with a shorter path
            if(sourceDistance > dist[vertex]) continue;

            for(int[] neighbour_edge: graph.get(vertex)) {
                int neighbour = neighbour_edge[0], weight = neighbour_edge[1];

                // Step 4: If a shorter path to neighbor vertex found, update and add to the queue
                if(dist[vertex] + weight < dist[neighbour]) {
                    dist[neighbour] = dist[vertex] + weight;
                    queue.add( new int[]{neighbour, dist[neighbour]} );
                }
            }
        }

        return dist;

    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build the graph (Adjacency List)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) graph.put(i, new ArrayList<>());
        for(int[] edge: times) graph.get(edge[0]).add(new int[]{edge[1], edge[2]});

        // Step 2: Get the minimum time required for the signal to reach each node
        int[] dist = Dijkstra(graph, k);

        // Step 3: Find the minimum time it takes for all the n nodes to receive the signal
        int maxTime = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1; // If any node is unreachable
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;

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
