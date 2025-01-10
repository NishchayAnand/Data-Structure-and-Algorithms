
/*

    Problem Statement: Given a connected undirected graph represented by an adjacency list 'graph', return a list
                       containing the BFS traversal of the graph.

    General Observations:

        - Graphs may can contain cycles. To avoid processing a vertex more than once, we must maintain a cache (e.g. a
          set or a boolean array) to keep track of the visited vertices.

        - The problem involves exploring all the neighbors of a vertex before moving on to their neighbors, effectively
          working layer by layer.

        - Intuition:
            - Start at the source vertex and explore its direct neighbors first. Once all direct neighbors are visited,
              move to their neighbors, continuing until all vertex are visited.

        - Considering the vertices need to be visited in the order they are discovered (FIFO), we can use a queue to
          keep track of the next vertex to visit.

        - Algorithm:

            // Step 1: Initialization
            - queue.add(startVertex);
            - visited[startVertex] = true; // mark the vertex as visited once it is added to the queue

            - while(!queue.isEmpty()):

                // Step 2: Process the Oldest Visited Node
                - int vertex = queue.poll();
                - bfs.add(vertex);

                // Step 3: Visit all the unvisited neighbours of 'vertex'
                - for each neighbour in graph.get(vertex):
                    - if visited[neighbour] == false:
                        - queue.add(neighbour);
                        - visited[neighbour] = true;

        - Time Complexity Analysis:

            - Each vertex is processed exactly once. Similarly, each edge is explored exactly once.

            - Hence, Time Complexity = O(V+E).

        - Space Complexity Analysis:

            - The algorithm maintains a boolean array to track visited nodes.

            - In the worst case (graph with 1 level), all vertices will be in the queue simultaneously.

            - Hence, Space Complexity = O(V).

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {

        ArrayList<Integer> bfs = new ArrayList<>();

        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        int startVertex = 0;

        // Step 1: Initialization
        queue.add(startVertex);
        visited[startVertex] = true; // mark the vertex as visited once it is added to the queue

        while(!queue.isEmpty()) {

            // Step 2: Process the Oldest Visited Node
            int vertex = queue.poll();
            bfs.add(vertex);

            // Step 3: Visit all the unvisited neighbours of 'vertex'
            for(int neighbour : graph.get(vertex)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }

        }

        return bfs;

    }

    public static void main(String[] args) {

        // Undirected Graph Adjacency List = [0:[2,3,1], 1:[0], 2:[0,4], 3:[0], 4:[2]]

        // Number of vertices in the graph
        int V = 5;

        // Create an adjacency list for the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges

        // Vertex: 0
        for (int i : new int[]{2, 3, 1}) {
            graph.get(0).add(i);
        }

        // Vertex: 1
        graph.get(1).add(0);

        // Vertex: 2
        for(int i : new int[]{0, 4}) {
            graph.get(2).add(i);
        }

        // Vertex: 3
        graph.get(3).add(0);

        // Vertex: 4
        graph.get(4).add(2);

        // Print BFS of Graph
        System.out.println(bfsOfGraph(V, graph)); // output = [0, 2, 3, 1, 4]

    }
}
