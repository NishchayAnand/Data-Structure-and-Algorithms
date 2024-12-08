
/*

    Problem Statement: Given the root of a binary tree, return the preorder traversal of its nodes'
                       values.

    General Observations:

        - Preorder traversal is one of the depth-first traversal methods where the nodes are
          visited in the following order:

                1. Root Node: Process the current node first.
                2. Left Subtree: Traverse the left subtree.
                3. Right Subtree: Traverse the right subtree.

        - Recursive Approach:

            - Each node of a binary tree has a value and reference pointers to two child nodes,
              which are themselves binary trees (or NULL). This recursive definition allows us to
              naturally traverse the tree using recursion.

            - Hypotheses: F(root) will return the preorder traversal of the binary tree starting
                          at root.

            - Recursive Steps:
                - output.add(root.val);
                - F(root.left);
                - F(root.right);

            - Base Condition:
                - if (root == null): return;

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

*/


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void helper(TreeNode root, List<Integer> output) {

        if(root == null) return;

        output.add(root.val);
        helper(root.left, output);
        helper(root.right, output);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        helper(root, output);
        return output;
    }

}
