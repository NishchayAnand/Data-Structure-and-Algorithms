
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

            - Explicitly manage the traversal using a Stack to simulate the function call stack
              of a recursive solution.

            - NOTE: This approach is particularly useful for trees with significant depth, where
                    recursion may cause stack overflow.

            - Algorithm:
                -

*/

public class BinaryTreeInorderTraversal {
}
