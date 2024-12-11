
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

        - In inorder traversal, a tree node is processed when it is visited the second time.

        - Iterative Approach:

            - Use a stack to explicitly simulate the function call stack of the recursive solution.

            - Algorithm:

                - stack = [];
                - currentNode = root;
                - while currentNode exists or stack is not empty:

                    - if currentNode exists:
                        - stack.push(currentNode);
                        - currentNode = currentNode.left;
                    else:
                        - currentNode = stack.pop(); // Backtrack to the most recent node
                        - stack.push(currentNode.val); // Process the currentNode
                        - currentNode = currentNode.right; // Move to the right subtree

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

        - NOTE: This approach is particularly useful for trees with significant depth, where
                recursion may cause stack overflow.

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while(currentNode!=null || !stack.isEmpty()) {

            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop(); // Backtrack to the most recent node
                output.add(currentNode.val); // Process the node
                currentNode = currentNode.right; // Visit the right subtree
            }

        }

        return output;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(inorderTraversal(node1));
    }
}
