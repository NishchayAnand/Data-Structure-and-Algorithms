
/*

    Problem Statement:

        - Given 'numCourses' courses labeled from 0 to numCourses-1, and a list of prerequisites, where
          prerequisites[i] = [ai, bi] means you must take course 'bi' before taking course 'ai', return the ordering of
          courses you should take to finish all courses.

        - For example:

                       int numCourses = 4;

                       int[][] prerequisites = {
                            {1, 0}, // To take course 1, you must complete course 0
                            {2, 1}, // To take course 2, you must complete course 1
                            {3, 2}, // To take course 3, you must complete course 2
                            {3, 0}  // To take course 3, you must complete course 0
                       };

        - NOTE:
            - If there are many valid answers, return any of them.
            - If it is impossible to finish all courses, return an empty array.

    General Observations:

        - The problem can be modeled as a directed graph, where:
            1. Each course is a vertex.
            2. Each prerequisite pair [ai, bi] is a directed edge (bi → ai), indicating that course 'ai' depends on
               course 'bi'.

        - The problem involves detecting cycles in the directed graph. If no cycles exist, return a valid topological
          ordering of courses one can follow to finish all courses.

        - Each vertex in a cycle has at least one incoming edge coming from another vertex in the cycle, there are no
          vertices in the cycle with indegree = 0.

        - BFS Approach (Kahn's Algorithm):

            - Use Kahn's algorithm to generate a valid topological ordering of courses.

            - NOTE: If the graph contains a cycle, none of the vertices in the cycle can resolve their dependencies
                    first, i.e., their indegree remains greater than 0 indefinitely. This makes it impossible to process
                    any vertex in the cycle.

            - Once Kahn's algorithm finish processing, if the total number of processed vertices (added to the topological
              order) is less than the total number of vertices, a cycle exists.

            - Time Complexity: O(V+E).

            - Space Complexity: O(V).

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list to represent graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int vertex=0; vertex < numCourses; vertex++) graph.add(new ArrayList<>());
        for(int[] pre: prerequisites) graph.get(pre[1]).add(pre[0]); // pre = [ai, bi] such that bi → ai

        // Step 2: Calculate the indegree for each vertex
        int[] indegree = new int[numCourses];
        for(int vertex=0; vertex < numCourses; vertex++) {
            for(int neighbour: graph.get(vertex)) indegree[neighbour]++;
        }

        // Step 3: Generate topological sort by dynamically processing the vertices with indegree = 0
        Queue<Integer> queue = new LinkedList<>();
        for(int vertex=0; vertex < numCourses; vertex++) {
            if(indegree[vertex] == 0) queue.add(vertex);
        }

        int[] order = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            order[index++] = vertex; // Add course to the topological order
            // Reduce indegree of neighbours
            for(int neighbour: graph.get(vertex)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) queue.add(neighbour); // If indegree becomes 0, add to queue
            }
        }

        // Step 4: Check for cycles in graph
        if(index != numCourses) return new int[0]; // cycle detected, no valid topological order

        return order;

    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0}, // To take course 1, you must complete course 0
                {2, 1}, // To take course 2, you must complete course 1
                {3, 2}, // To take course 3, you must complete course 2
                {3, 0}  // To take course 3, you must complete course 0
        };

        int[] order = findOrder(numCourses, prerequisites);
        if(order.length == 0) System.out.println("It is impossible to finish all the courses");
        else {
            System.out.print("Order: ");
            for(int num: order) System.out.print(num + " ");
        }

    }
}
