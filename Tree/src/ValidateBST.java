
/*

    Problem Statement: Given the 'root' of a binary tree, determine if it is a valid binary search tree (BST).

                       NOTE: A valid BST is defined as follows:
                                i. The left subtree of a node contains only nodes with keys less than the node's key.
                               ii. The right subtree of a node contains only nodes with keys greater than the node's key.
                              iii. Both the left and right subtrees must also be binary search trees.

    General Observations:

        - Trees are inherently recursive data structures, where each node's children can be seen as smaller subtrees,
          making recursion a straightforward and intuitive approach.

        - Every node in a BST is bounded by a valid range of values, determined by its ancestors. For example:
                i. At the root node, there are no restrictions (-∞ < root.val < ∞).
               ii. For the left child of the root, the valid range becomes (-∞ < root.left.val < root.val).
              iii. For the right child of the root, the valid range becomes (root.val < root.right.val < ∞).

        - Algorithm:

            - Hypotheses: F(node, min, max) will return true if the binary tree rooted at 'node' is a valid BST, else
                          will return false.

            - Recursive Steps:
                - if node.val <= min or node.val >= max: return false; // Step 1: Process the current node
                - isLeftSubtreeBST = F(node.left, min, node.val); // Step 2: Process the left subtree
                - isRightSubtreeBST = F(node.right, node.val, max); // Step 3: Process the right subtree
                - return isLeftSubtreeBST and isRightSubtreeBST;

            - Base Conditions:
                - if node == null: return true; // An empty tree is valid BST

            - Time Complexity: O(n).

            - Space Complexity: O(h) ~ O(n) in case of skewed binary tree

*/

public class ValidateBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {

        // Base Conditions:
        if (root == null) return true;

        // Recursive Steps:
        if ( (min != null && root.val <= min) ||
                (max != null && root.val >= max) ) return false; // Step 1: Process the current root
        boolean isLeftSubtreeBST = isValidBSTHelper(root.left, min, root.val); // Step 2: Process the left subtree
        boolean isRightSubtreeBST = isValidBSTHelper(root.right, root.val, max); // Step 3: Process the right subtree
        return isLeftSubtreeBST && isRightSubtreeBST;

    }

    private static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        System.out.println(isValidBST(root));
    }

}
