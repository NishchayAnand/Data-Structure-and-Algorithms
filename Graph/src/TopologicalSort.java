
/*

    Problem Statement: Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all
                       vertices 'v' such that there exists a directed edge (u -> v). Return topological sort for the
                       given graph.

                       NOTE: As there are multiple Topological orders possible, you may return any of them.

    General Observations:

        - Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every
          directed edge (u -> v), vertex 'u' comes before 'v' in the ordering.

        - NOTE: Topological sorting only works for Directed Acyclic Graphs (DAGs).

        - Intuition:

            - Think of each vertex as a task and edges as dependencies (a vertex 'u' connected to neighbor 'v' represents
              that 'u' is a dependency for 'v').

            - A task 'v' cannot be processed until all tasks 'u' that point to 'v' (u → v) are completed.

        - DFS Approach:

            - Perform DFS traversal. While backtracking, add the current vertex 'u' to a stack.

            - NOTE: The stack will hold the vertices in the reverse topological order, i.e., all dependencies 'u' of any
                    vertex 'v' will lie above vertex 'v' in the stack.

            - Time Complexity: O(V+E).

            - Space Complexity: O(V).

*/

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> reverseOrder) {
        visited[vertex] = true;
        for(int neighbour: graph.get(vertex)) {
            if(!visited[neighbour]) dfs(graph, neighbour, visited, reverseOrder);
        }
        reverseOrder.add(vertex);
    }

    private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {

        int n = adj.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for(int vertex = 0; vertex <n; vertex++){
            if(!visited[vertex]) dfs(adj, vertex, visited, stack);
        }

        ArrayList<Integer> order = new ArrayList<>();
        while(!stack.isEmpty()) order.add(stack.pop());

        return order;

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // [[], [3], [3], [], [0,1], [0,2]]

        // Vertex 0
        adj.add(new ArrayList<>());

        // Vertex 1
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        adj.add(list1);

        // Vertex 2
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        adj.add(list2);

        // Vertex 3
        adj.add(new ArrayList<>());

        // Vertex 4
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list4.add(1);
        adj.add(list4);

        // Vertex 5
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(0);
        list5.add(2);
        adj.add(list5);

        System.out.println("Topological Sort: " + topologicalSort(adj));

    }
}
