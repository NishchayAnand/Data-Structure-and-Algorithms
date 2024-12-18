
/*

    Problem Statement: Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes
                       ('p' & 'q') in the BST.

                       NOTE:
                            - Nodes 'p' and 'q' will always exist in the given BST.

    General Observations:

        - Trees are inherently recursive data structures, where each node's children can be seen as smaller subtrees,
          making recursion a straightforward and intuitive approach.

        - Every node in a BST is bounded by a valid range of values, determined by its ancestors. For example:
                i. At the root node, there are no restrictions (-∞ < root.val < ∞).
               ii. For the left child of the root, the valid range becomes (-∞ < root.left.val < root.val).
              iii. For the right child of the root, the valid range becomes (root.val < root.right.val < ∞).

        - Considering both 'p' and 'q' are guaranteed to exist in the binary tree, the root node of the BST
          will represent the highest common ancestor of 'p' and 'q'. This ensures that the LCA will always exist.

        - Intuition:

            - In a BST:
                i. If either 'p' or 'q' matches the current node, the current node is the LCA.
               ii. If both 'p' and 'q' are less than the current node, their LCA must be in the left subtree.
              iii. If both 'p' and 'q' are greater than the current node, their LCA must be in the right subtree.
               iv. If one is on the left and the other is on the right, the current node is the LCA (no need to
                   explore the left and right subtree for making this judgement).

        - Algorithm:

            - Hypotheses: F(node, p, q) will return the LCA of the BST rooted at 'node'.

            - Recursive Steps:
                - if p.val < node.val and q.val < node.val: return F(node.left, p, q);
                - if p.val > node.val and q.val > node.val: return F(node.right, p, q);
                - else: return node;

            - Base Conditions:
                - if node == null: return null; // LCA does not exist in an empty BST

            - Time Complexity: O(n)

            - Space Complexity: O(logn) ~ O(n) in case of skewed binary tree

*/

public class LowestCommonAncestorBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base Conditions:
        if (root == null) return null;

        // Recursive Steps:
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;

    }
}
