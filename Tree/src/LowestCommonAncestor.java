
/*

    Problem Statement: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

                       NOTE:

                            - The lowest (nearest) common ancestor is defined between two nodes 'p' and 'q' as the
                              lowest node in 'T' that has both 'p' and 'q' as descendants (where we allow a node to
                              be a descendant of itself).

                            - Duplicate values are not allowed.

                            - Nodes 'p' and 'q' will always exist in the given binary tree.

                            - Nodes 'p' and 'q' will always be unique.

    General Observations:

        - A node 'X' is an ancestor of 'Y' if 'Y' is in the subtree rooted at 'X'.

        - Trees are inherently recursive data structures, where each node's children can be seen as smaller subtrees,
          making recursion a straightforward and intuitive approach.

        - Considering both 'p' and 'q' are guaranteed to exist in the binary tree, the root node of the binary tree
          will represent the highest common ancestor of 'p' and 'q'. This ensures that the Lowest Common Ancestor (LCA)
          will always exist.

        - Intuition:

            - Traverse the tree starting from the root. At each node:

                - If current node is null, neither of the target nodes can exist in this subtree.

                - If current node one of the two nodes we are looking for, it means that we have found one of the target
                  nodes in current subtree being explored. This node might be the LCA, considering the other target node
                  can exist somewhere in its subtree.

                - If the two nodes exist in different subtrees of current node, then the current node is the LCA.

        - Algorithm:

            - Hypotheses: F(root, p, q) will return the lowest common ancestor of nodes 'p' and 'q' if it exists, else
                          return null.

            - Base Conditions:
                - if root is null: return null; // LCA cannot exist in an empty tree.
                - if root == p or root == q: return root; // root might be the LCA.

            - Recursive Steps:
                - NodeInLeftSubtree = F(root.left, p, q);
                - NodeInRightSubtree = F(root.right, p, q);
                - if NodeInLeftSubtree and NodeInRightSubtree:
                    - return root;
                - return NodeInLeftSubtree == null ? NodeInRightSubtree : NodeInLeftSubtree;

            - Time Complexity: O(n)

            - Space Complexity: O(logn), O(n) in case of skewed binary tree.

*/

public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base Condition
        if(root == null || root == p || root == q) return root;

        // Recursive Steps
        TreeNode nodeInLeftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode nodeInRightSubtree = lowestCommonAncestor(root.right, p, q);

        if(nodeInLeftSubtree != null && nodeInRightSubtree != null) return root;
        return nodeInLeftSubtree != null ? nodeInLeftSubtree : nodeInRightSubtree;

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

        System.out.println(lowestCommonAncestor(node1, node4, node5).val);

    }

}
