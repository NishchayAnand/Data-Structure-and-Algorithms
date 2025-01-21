
/*

    Problem Statement: Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it
                       contains any cycle or not.

                       NOTE: The graph is represented as an adjacency list, where adj[i] contains a list of vertices that
                             are directly reachable from vertex 'i'. Specifically, adj[i][j] represents an edge from vertex
                             'i' to vertex 'j'.

    General Observations:

        - In a directed graph, a cycle exists if there is a "back edge", i.e., an edge that points back to an already
          visited node in the current path being explored.

        - The problem involves focusing only on one path at a time. DFS inherently uses recursion stack to keep track of
          the nodes in the current path.

        - DFS Approach:

            - Perform DFS and keep track of the "state" of each node during traversal:

                - Not Visited (0): The node hasn't been explored yet.

                - Being Visited (1): The node is currently in the recursion stack or is part of the current DFS path.

                - Visited (2): The node and all its descendants have been fully explored, and it no longer belongs to
                               the current path.

            - A cycle is detected if we revisit a node marked as "Being Visited" during DFS.

            - Time Complexity: O(V+E).

            - Space Complexity: O(V).

*/

import java.util.ArrayList;

public class DetectCycleDirectedGraph {

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, int vertex, int[] state) {

        // Base Conditions:
        if(state[vertex] == 1) return true; // vertex already "being visited" in the current path, i.e., back edge detected
        if(state[vertex] == 2) return false; // vertex already "visited" in some previous path

        // Recursive Steps:
        state[vertex] = 1; // "Being Visited"
        for(int neighbour: graph.get(vertex)) {
            boolean hasCycle = dfs(graph, neighbour, state);
            if(hasCycle) return true;
        }
        state[vertex] = 2; // "Visited"
        return false;

    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] state = new int[V]; // by default, all vertices are in "unvisited" state
        for(int i=0; i<V; i++) {
            if(state[i] != 2) {
                boolean hasCycle = dfs(adj, i, state); // Traverse graph component starting from vertex 'i' and return true if cycle exists.
                if(hasCycle) return true;
            }
        }
        return false; // No cycle detected
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // {{1}, {2}, {0}}

        // Vertex 0:
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        graph.add(list1);

        // Vertex 1:
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        graph.add(list2);

        // Vertex 2:
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(0);
        graph.add(list3);

        System.out.println(isCyclic(graph.size(), graph));

    }
}
