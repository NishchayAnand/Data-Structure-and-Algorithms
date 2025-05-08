
/*

    Problem Statement:

        - The Leetcode file system keeps a log each time some user performs a change folder operation.

        - The operations are described below:

            - "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in
              the same folder).
            - "./" : Remain in the same folder.
            - "x/" : Move to the child folder named x (This folder is guaranteed to always exist).

        - You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

        - The file system starts in the main folder, then the operations in logs are performed. Return the minimum number
          of operations needed to go back to the main folder after the change folder operations.

    Example:

        - Input: logs = ["d1/","d2/","../","d21/","./"]
        - Output: 2
        - Explanation: Use this change folder operation "../" 2 times and go back to the main folder.

    General Observations:

        -

    Brute Force Approach - Using Stack:

        - Intuition: We need a data structure that could help us perform 3 operations efficiently:
                        - For every "x/" operation, append the child folder to the directory path.
                        - For every "../" operation, remove the most recent child folder from the directory path.
                        - For every "./" operation, do not alter the directory path.

        - Use a stack to simulate the folder structure that can dynamically grow (with "x/") or shrink (with "../") as
          we navigate through the 'logs' array.

        - Algorithm:
            - stack = [];
            - loop over each operation in logs:
                - if operation matches "x/": stack.push(operation);
                - if operation matches "../": if stack is not empty: stack.pop();
                - if operation matches "./": continue;
            - return stack.size();

        - Time Complexity:
            - We are iterating over the 'logs' array of size 'n' and performing push / pop operations. Hence, overall
              time complexity = O(n).

        - Space Complexity:
            - In the worst-case scenario, i.e., when the entire 'logs' array contains "x/" operations, the stack will store
              n elements simultaneously. Hence, overall space complexity = O(n).

    Optimized Approach - Using Single Variable:

        - Instead of using a stack to simulate folder navigation, we can optimize the solution by maintaining a single
          integer variable: depth to track the current depth of the folder structure when iterating through the 'logs' array.

        - Algorithm:
            - depth = 0;
            - for each operation in logs:
                - if operation == "../": if depth != 0: depth--;
                - if operation == "x/": depth++;
                - if operation == "./": continue;

        - Time Complexity:
            - We are iterating over 'logs' array of size 'n' and performing simple push / pop operations. Hence, overall
              time complexity = O(n).

        - Space Complexity:
            - No extra space is used. Hence, overall space complexity = O(1).

*/


import java.util.Stack;

public class CrawlerLogFolder {

    public static int minOperationsBF(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String operation: logs) {
            if(operation.equals("../")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(!operation.equals("./")) stack.push(operation);
        }
        return stack.size();
    }

    public static int minOperations(String[] logs) {
        int depth = 0;
        for(String operation: logs) {
            if(operation.equals("../")) {
                if(depth != 0) depth--;
            } else if(!operation.equals("./")) depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(minOperations(logs));
    }
}
