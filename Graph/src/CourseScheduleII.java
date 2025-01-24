
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

        - Primary Problem: Return a valid topological order of courses (if it's possible to complete all courses).

*/

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];

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
