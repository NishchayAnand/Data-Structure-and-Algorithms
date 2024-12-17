
/*

    Problem Statement: Given the 'root' of a binary tree and an integer 'targetSum', return the number of paths where
                       the sum of the values along the path equals 'targetSum'.

                       NOTE:

                            - The path does not need to start at the 'root' or end at a 'leaf'.

                            - The given binary tree may contain nodes with negative values.

    General Observations:

        - Intuition:

            - Use DFS to traverse over each node and count paths starting from the current node whose aggregated sum of
              values = 'targetSum'.

        - Algorithm:

            - Hypothesis: F(node, targetSum)

            - Recursive Steps:

            - Base Conditions:

            - Time Complexity: O(n^2).

            - Space Complexity: O(n).

*/

public class PathSumIII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int countPathsFromNode(TreeNode root, int targetSum) {

        // Base Conditions:
        if(root == null) return 0;
        if(root.val == targetSum) return 1;

        // Recursive Steps:
        int leftCount = countPathsFromNode(root.left, targetSum-root.val);
        int rightCount = countPathsFromNode(root.right, targetSum-root.val);
        return leftCount + rightCount;

    }

    public int pathSum(TreeNode root, int targetSum) {

        // Base Conditions:
        if(root==null) return 0;

        // Recursive Steps:
        int pathsFromRoot = countPathsFromNode(root, targetSum); // process the current root
        int pathsFromLeft = pathSum(root.left, targetSum); // traverse to the left subtree
        int pathsFromRight = pathSum(root.right, targetSum); // traverse to the right subtree

        return pathsFromRoot + pathsFromLeft + pathsFromRight;

    }


}
