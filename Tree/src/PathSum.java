
/*

    Problem Statement: Given the 'root' of a binary tree and an integer 'targetSum', return true if the tree has a
                       root-to-leaf path such that adding up all the values along the path equals 'targetSum'.

    General Observations:

        - Trees are inherently recursive data structures, where each node's children can be seen as smaller subtrees,
          making recursion a straightforward and intuitive approach.

        - Intuition:

            - Use recursion to traverse the tree and reduce the 'targetSum' by the value of the current node (process
              the current node) as we go deeper.

            - Once we reach a leaf node, check if the remaining targetSum equals the leaf node's value. If yes, the
              path exists.

        - Algorithm:

            - Hypotheses: F(node, targetSum) will explore all root-to-leaf paths in the binary tree rooted at 'node'
                          and return true there's a path whose aggregated sum of values = 'targetSum'.

            - Recursive Steps:

                // Step 1: Process the current node
                - remainingSum = targetSum - node.val;

                // Step 2: Check if remaining sum can be achieved using nodes in left subtree
                - isSumAchievableInLeft = F(root.left, remainingSum);

                // Step 3: Check if remaining sum can be achieved using nodes in right subtree
                - isSumAchievableInRight = F(root.right, remainingSum);

                - return isSumAchievableInLeft or isSumAchievableInRight;

            - Base Conditions:

                - if root == null: return false; // cannot achieve targetSum in an empty binary tree

                - if root.left == null and root.right == null: return root.val == targetSum; // leaf node encountered

            - Time Complexity: O(n).

            - Space Complexity: O(logn) ~ O(n) in case of skewed binary tree.

*/

public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Base Conditions:
        if(root == null) return false; // cannot achieve targetSum in an empty binary tree
        if(root.left == null && root.right == null) return root.val == targetSum; // leaf node encountered

        // Recursive Steps:
        return hasPathSum(root.left, targetSum-root.val) ||
                hasPathSum(root.right, targetSum-root.val);

    }


}
