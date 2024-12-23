
/*

    Problem Statement: Given the 'root' of a binary tree, invert the tree, and return its root.

                       For example:

                       1                             1
                       ------------                  ------------
                       |          |                  |          |
                       2          3        ---->     3          2
                       -------                                  -------
                       |     |                                  |     |
                       4     5                                  5     4

    General Observations:

        - Trees are inherently recursive data structures, where each node's children can be seen as smaller subtrees,
          making recursion a straightforward and intuitive approach.

        - Recursive Approach:

            - Swap the children of the current node under consideration (in preorder) and trust the recursive function
              to do the same for the remaining nodes in its left and right subtree.

            - Hypotheses: F(node) will invert the binary tree rooted at 'node'.

            - Recursive Steps:

                // Swap children of current node
                - TreeNode temp = node.left;
                - node.left = node.right;
                - node.right = temp;

                - F(node.left); // Process the left subtree
                - F(node.right); // Process the right subtree

            - Base Conditions:
                - if node == null: return;

            - Time Complexity: O(n).

            - Space Complexity: O(logn) for balanced binary tree, O(n) for skewed binary tree.

*/

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void invertTreeHelper(TreeNode root) {

        // Base Conditions:
        if(root == null) return;

        // Recursive Steps:
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);

    }

    private static TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
}
