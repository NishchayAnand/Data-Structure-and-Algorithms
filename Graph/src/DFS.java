
/*

    Problem Statement: Given a connected undirected graph represented by an adjacency list 'graph', return a list
                       containing the DFS traversal of the graph.

                       For example: graph = [[2,3,1],[0],[0,4],[0],[2]]

                                            0
                                             -------------
                                            |      |      |
                                            2      3      1
                                            |
                                            4

    General Observations:

        - Graphs may can contain cycles. To avoid processing a vertex more than once, we must maintain a cache (e.g. a
          set or a boolean array) to keep track of the visited vertices.

        - The problem involves fully exploring one branch before trying others (naturally recursive in nature).

        - Intuition:
            - Visit a vertex, mark it as visited and tell the procedure to do the same for all its unvisited neighbours.

        - Algorithm:

            - Hypotheses:
                - F(graph, vertex, visited) will traverse all the direct / indirect neighbours of 'vertex'.

            - Recursive Steps:

                - visited[vertex] = true; // mark the vertex as visited once it is added to the recursive stack

                // Step 1: Process the current 'vertex'
                - dfs.add(vertex);

                // Step 2: Visit all the unvisited neighbours of 'vertex'
                - for each neighbour in graph.get(vertex):
                    - if visited[neighbour] == false:   // implicitly handle the base condition
                        - F(graph, neighbour, visited);

            - Time Complexity Analysis:

                - Each vertex is visited exactly once during the traversal.

                - For each vertex, the algorithm iterates over its adjacency list to explore its neighbors. Across the
                  entire graph, each edge is explored exactly once.

                - Hence, Time Complexity = O(V+E).

            - Space Complexity:

                - The algorithm maintains a boolean array to track visited nodes.

                - The maximum depth of the recursion stack is proportional to the longest path in the graph, which can
                  be up to 'V' in the worst case (e.g., a linear graph).

*/

import java.util.ArrayList;

public class DFS {

    private static void helper(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, ArrayList<Integer> dfs) {

        visited[vertex] = true; // mark the vertex as visited once it is added to the recursive stack

        // Step 1: Process the current 'vertex'
        dfs.add(vertex);

        // Step 2: Visit all the unvisited neighbours of 'vertex'
        for(int neighbour : graph.get(vertex)) {
            if(!visited[neighbour]) { // implicitly handle the base condition
                helper(graph, neighbour, visited, dfs);
            }
        }

    }

    private static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        int startVertex = 0;
        boolean[] visited = new boolean[adj.size()];
        helper(adj, startVertex, visited, dfs);
        return dfs;
    }

    public static void main(String[] args) {

        // Undirected Graph Adjacency List = [0:[2,3,1], 1:[0], 2:[0,4], 3:[0], 4:[2]]

        // Number of nodes in the graph
        int n = 5;

        // Create an adjacency list for the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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

        // Print DFS of Graph
        System.out.println(dfsOfGraph(graph)); // output = [0, 2, 4, 3, 1]

    }

}
