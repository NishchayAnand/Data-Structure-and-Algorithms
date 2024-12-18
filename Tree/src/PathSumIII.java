
/*

    Problem Statement: Given the 'root' of a binary tree and an integer 'targetSum', return the number of paths where
                       the sum of the values along the path equals 'targetSum'.

                       NOTE:
                            - The path does not need to start at the 'root' or end at a 'leaf'.
                            - The given binary tree may contain nodes with negative values.

    General Observations:

        - Intuition:

            - Use DFS to traverse over each node and count all possible paths starting from the current node whose
              aggregated sum of nodes' values = 'targetSum'.

        - Algorithm:

            - Hypothesis: F(node, targetSum) will return count of all possible paths from the current 'node' whose
                          nodes' values' sum = 'targetSum'.

            - Recursive Steps:
                - int count = 0;
                // Step 1: Process the current node
                - pathsFromNode = countPathsFromNode(node, targetSum);
                // Step 2: Process the left subtree
                - pathsFromLeft = F(root.left, targetSum);
                //Step 3: Process the right subtree
                - pathsFromRight = F(root.right, targetSum);

            - Base Conditions:
                - if root == null: return 0; // no paths possible in an empty tree

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

    private static int countPathsFromNode(TreeNode root, long targetSum) {

        // Base Conditions:
        if(root == null) return 0;

        // Recursive Steps:
        int count = 0;
        if(root.val == targetSum) count++; // process the current root
        count += countPathsFromNode(root.left, targetSum-root.val); // traverse the left subtree
        count += countPathsFromNode(root.right, targetSum-root.val); // traverse the right subtree
        return count;

    }

    public static int pathSum(TreeNode root, int targetSum) {

        // Base Conditions:
        if(root==null) return 0;

        // Recursive Steps:
        int pathsFromRoot = countPathsFromNode(root, targetSum); // process the current root
        int pathsFromLeft = pathSum(root.left, targetSum); // traverse to the left subtree
        int pathsFromRight = pathSum(root.right, targetSum); // traverse to the right subtree

        return pathsFromRoot + pathsFromLeft + pathsFromRight;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // Level 1
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        // Level 2
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        // Level 3
        root.left.left.left = new TreeNode(-1);

        System.out.println(pathSum(root, -1));

    }


}
