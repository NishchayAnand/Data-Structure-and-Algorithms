
/*

    Problem Statement: Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all
                       vertices 'v' such that there exists a directed edge (u -> v). Return topological sort for the
                       given graph.

                       NOTE: As there are multiple topological orders possible, you may return any of them.

    General Observations:

        - Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every
          directed edge (u -> v), vertex 'u' comes before 'v' in the ordering.

        - NOTE: Topological sorting only works for Directed Acyclic Graphs (DAGs).

        - Analogy:
            - Think of each vertex as a task and edges as dependencies (u → v implies 'u' is a dependency for 'v').
            - A task 'v' cannot be processed until all tasks 'u' pointing to 'v' are completed.

        - Intuition:
            - The number of incoming edges (indegree) to a vertex represents the number of dependencies (prerequisites) it has.
            - If a vertex has an indegree of 0, it means all its dependencies are already resolved, and it can be safely
              added to the topological order.

        - BFS Approach (Kahn's Algorithm):

            - A queue can be used to maintain all vertices that have no unresolved dependencies (indegree = 0). These
              vertices are "ready" to be processed since they can be added to the topological order without violating
              any dependency constraints.

            - Once a vertex is processed (dequeued from the queue a vertex), its outgoing edges can be removed reducing
              the indegree of its neighbors (dependent vertices).

            - If any neighbor's indegree becomes 0, it can be added to the queue, meaning it is now ready to be processed.

            - NOTE: BFS processes the vertices in layers, where each layer corresponds to vertices with indegree = 0.

            - Algorithm:

                // Step 1: Calculate indegree for each vertex
                - indegree = [vertices];
                - for each vertex in graph:
                    - for each neighbour in graph[vertex]:
                        - indegree[neighbour]++; // there is an incoming edge from 'vertex' to 'neighbour'

                // Step 2: Generate topological sort by dynamically processing the vertices with indegree = 0
                - for each vertex in graph:
                    - if indegree[vertex] == 0:
                        - queue.add(vertex);

                - while queue is not empty:
                    - vertex = queue.poll();
                    - order.add(vertex);
                    - for each neighbour in graph[vertex]:
                        - indegree[neighbour]--;
                        - if indegree[neighbour] == 0: queue.add(neighbour);

                - return order;

            - Time Complexity: O(V+E).

            - Space Complexity: O(V).

        - DFS Approach:

            - Perform DFS traversal. While backtracking, add the current vertex 'u' to a stack.

            - NOTE: The stack will hold the vertices in the reverse topological order, i.e., all vertices 'v' dependent on
                    vertex 'u' will lie below vertex 'u' in the stack.

            - Time Complexity: O(V+E).

            - Space Complexity: O(V).

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> reverseOrder) {
        visited[vertex] = true;
        for(int neighbour: graph.get(vertex)) {
            if(!visited[neighbour]) dfs(graph, neighbour, visited, reverseOrder);
        }
        reverseOrder.add(vertex);
    }

    private static ArrayList<Integer> topologicalSortDFS(ArrayList<ArrayList<Integer>> graph) {

        int n = graph.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for(int vertex = 0; vertex <n; vertex++){
            if(!visited[vertex]) dfs(graph, vertex, visited, stack);
        }

        ArrayList<Integer> order = new ArrayList<>();
        while(!stack.isEmpty()) order.add(stack.pop());

        return order;

    }

    private static ArrayList<Integer> topologicalSortBFS(ArrayList<ArrayList<Integer>> graph) {

        // Step 1: Calculate indegree for each vertex
        int V = graph.size();
        int[] indegree = new int[V];
        for(int vertex = 0; vertex < V; vertex++) {
            for(int neighbour: graph.get(vertex)) indegree[neighbour]++; // there is an incoming edge from 'vertex' to 'neighbour'
        }

        // Step 2: Generate topological sort by dynamically processing the vertices with indegree = 0
        Queue<Integer> queue = new LinkedList<>();
        for(int vertex = 0; vertex < V; vertex++) {
            if(indegree[vertex] == 0) queue.add(vertex);
        }

        ArrayList<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            order.add(vertex);
            for(int neighbour: graph.get(vertex)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) queue.add(neighbour);
            }
        }

        return order;

    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        return topologicalSortBFS(adj); // BFS Approach
        // return topologicalSortDFS(adj); // DFS Approach
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
