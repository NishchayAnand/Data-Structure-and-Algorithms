
/*

    Problem Statement: Given the 'root' of a binary tree and an integer 'targetSum', return true if the tree has a
                       root-to-leaf path such that adding up all the values along the path equals 'targetSum'.

    General Observations:

        - Trees are inherently recursive data structures, where each node's children can be seen as smaller subtrees,
          making recursion a straightforward and intuitive approach.

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

                - if root == null: return false;

                - if root.left == null and root.right == null: return root.val == targetSum;



*/

public class PathSum {
}
