
/*

    Problem Statement: Given the root of a binary tree, return its maximum depth.

                       NOTE: Maximum depth is the number of nodes along the longest path from the
                             root node down to the farthest leaf node.

    General Observations:

        - The problem is naturally recursive in nature, i.e., maxDepth(node) = max(maxDepth(node.left),
          maxDepth(node.right)) + 1;

        - Recursive Algorithm:

            - Hypotheses: F(node) will return the maximum depth of binary tree whose root = node.

            - Recursive Steps:
                - leftSubtreeDepth = F(node.left);
                - rightSubtreeDepth = F(node.right);
                - return max(leftSubtreeDepth, rightSubtreeDepth) + 1;

            - Base Condition:
                - if node == null: return 0; // maximum depth of empty tree = 0

            - Time Complexity: O(n) because every node is processed once.

            - Space Complexity: O(h = logn) ~ O(n) for skewed tree.

        -

*/

public class MaximumDepthBinaryTree {
}
