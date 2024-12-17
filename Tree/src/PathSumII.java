
/*

    Problem Statement: Given the 'root' of a binary tree and an integer 'targetSum', return all root-to-leaf paths where
                       the sum of the node values in the path equals 'targetSum'.

                       NOTE: Each path should be returned as a list of the node values, not node references.

*/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private void pathSumHelper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> paths) {

        // Base Conditions:
        if(root == null) return; // cannot achieve targetSum in an empty binary tree

        path.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) { // leaf node encountered
            paths.add(new ArrayList<>(path));
        } else {
            // Recursive Steps:
            int remainingSum = targetSum - root.val; // process the current root
            pathSumHelper(root.left, remainingSum, path, paths); // explore all paths in the left subtree
            pathSumHelper(root.right, remainingSum, path, paths); // explore all paths in the right subtree
        }
        path.removeLast();

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root, targetSum, new ArrayList<>(), result);
        return result;
    }

}
