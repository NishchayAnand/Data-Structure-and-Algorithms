
/*

    Problem Statement: Given a connected undirected graph represented by an adjacency list 'adj' were each adj[i]
                       represents the list of vertices connected to vertex i, perform a Depth First Traversal (DFS)
                       starting from vertex 0, visiting vertices from left to right as per the adjacency list, and
                       return a list containing the DFS traversal of the graph.

                       For example: adj = [[2,3,1],[0],[0,4],[0],[2]]

                                            0
                                             -------------
                                            |      |      |
                                            2      3      1
                                            |
                                            4

    General Observations:

        - Graphs may can contain cycles. To avoid processing a vertex more than once, we must maintain a cache (e.g. a
          set or a boolean array) to keep track of the visited vertices.

        - Intuition:
            - Visit a vertex, mark it as visited and tell the procedure to do the same for all its unvisited neighbours.

        - The problem is naturally recursive in nature.

        - Recursive Approach:

            - Hypotheses:
                - F(adj, vertex, visited) will traverse all the direct / indirect neighbours of 'vertex'.

            - Recursive Steps:
                -

*/

public class DFS {
}
