
/*

    Problem Statement:

        - Given 'n' courses labeled from 0 to n-1, and a list of prerequisites, where prerequisites[i] = [ai, bi] means
          you must take course 'bi' before taking course 'ai', determine if you can finish all the courses.

        - For example:

                       int numCourses = 4;

                       int[][] prerequisites = {
                            {1, 0}, // To take course 1, you must complete course 0
                            {2, 1}, // To take course 2, you must complete course 1
                            {3, 2}, // To take course 3, you must complete course 2
                            {3, 0}  // To take course 3, you must complete course 0
                       };

    General Observations:

        - The problem can be modeled as a directed graph, where:
            1. Each course is a vertex.
            2. Each prerequisite pair [ai, bi] is a directed edge (bi → ai), indicating that course 'ai' depends on
               course 'bi'.

        - The problem involves detecting if the graph has a cycle. If a cycle exists, it's impossible to finish all courses.

        - DFS Approach:

            - Time Complexity: O(V+E).

            - Space Complexity: O(V).

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {

    // Enum to represent vertex states
    enum States {
        UNVISITED, VISITING, VISITED
    }

    private static boolean dfs(List<List<Integer>> graph, int vertex, States[] state) {

        // Base Conditions:
        if(state[vertex] == States.VISITING) return true; // If the current vertex is in the VISITING state, a cycle is detected
        if(state[vertex] == States.VISITED) return false; // If the current vertex is already VISITED, no need to process further
                                                          // (current vertex is completely explored, including all its outgoing
                                                          // edges, i.e., its neighbors).

        // Recursive Steps:
        state[vertex] = States.VISITING; // Mark the vertex as VISITING
        for(int neighbour: graph.get(vertex)){ // Traverse all neighbors
            boolean hasCycle = dfs(graph, neighbour, state);
            if(hasCycle) return true; // Cycle detected
        }

        state[vertex] = States.VISITED; // Mark the vertex as VISITED after processing all its neighbors
        return false; // No cycle detected

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Create the adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        for(int[] pre: prerequisites) graph.get(pre[1]).add(pre[0]); // pre = [ai, bi] such that bi → ai

        // Step 2: Initialize an array to track the state of each vertex
        States[] stateCourses = new States[numCourses];
        Arrays.fill(stateCourses, States.UNVISITED);

        // Step 3: Perform DFS to detect cycles
        for(int i=0; i<numCourses; i++) {
            if(stateCourses[i] == States.UNVISITED) {
                boolean hasCycle = dfs(graph, i, stateCourses); // check if graph component having vertex 'i' has a cycle
                if(hasCycle) return false; // Cannot finish all courses
            }
        }

        return true; // Can finish all courses since no cycles detected

    }

    public static void main(String[] args) {

//        int numCourses = 4;
//
//        int[][] prerequisites = {
//                {1, 0}, // To take course 1, you must complete course 0
//                {2, 1}, // To take course 2, you must complete course 1
//                {3, 2}, // To take course 3, you must complete course 2
//                {3, 0}  // To take course 3, you must complete course 0
//        };

        int numCourses = 2;

        int[][] prerequisites = {
                {1, 0}, // To take course 1, you must complete course 0
                {0, 1}, // To take course 0, you must complete course 1
        };

        System.out.println(canFinish(numCourses, prerequisites));

    }
}
