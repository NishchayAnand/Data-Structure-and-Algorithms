
/*

    Problem Statement: Given the root of a binary tree, return the inorder traversal of its nodes'
                       values.

    General Observations:

        - Inorder traversal is one of the depth-first traversal methods where the nodes are
          visited in the following order:

                1. Left Subtree: Traverse the left subtree.
                2. Root Node: Process the current node.
                3. Right Subtree: Traverse the right subtree.

        - Recursive Approach:

            - Each node of a binary tree has a value and reference pointers to two child nodes,
              which are themselves binary trees (or NULL). This recursive definition allows us to
              naturally traverse the tree using recursion.

            - Hypotheses: F(root) will return the inorder traversal of the binary tree starting
                          at root.

            - Recursive Steps:
                - F(root.left);
                - output.add(root.val);
                - F(root.right);

            - Base Condition:
                - if (root == null): return;

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

        - Iterative Approach:

            - Use 2 stacks:
                - stack1: to explicitly simulate the function call stack of a recursive solution.
                - stack2: to store the order in which the nodes will be processed.

            - NOTE: This approach is particularly useful for trees with significant depth, where
                    recursion may cause stack overflow.

            - Algorithm:
                - currentNode = root;
                - while currentNode exists and stack1 is not empty:
                    - traverse to the leftmost node of the currentNode and store all encountered
                      nodes in stack1;
                    - When currentNode becomes NULL, point currentNode = stack.pop();
                    - Process the currentNode, i.e., stack2.push(currentNode.val);
                    - To visit the right subtree, point currentNode = currentNode.right;

            - NOTE: The output (represents the order of processing) can simply be stored in an
                    arraylist, considering that the result is required as a list.

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode!=null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Current must be NULL at this point
            currentNode = stack.pop();
            // Process the node
            output.add(currentNode.val);

            // Visit the right subtree
            currentNode = currentNode.right;
        }

        return output;
    }
}
