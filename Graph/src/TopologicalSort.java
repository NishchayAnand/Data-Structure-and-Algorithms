
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

        -

*/

import java.util.ArrayList;

public class TopologicalSort {

    private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
