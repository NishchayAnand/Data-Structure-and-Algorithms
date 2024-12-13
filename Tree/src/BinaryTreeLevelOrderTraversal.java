
/*

    Problem Statement: Given the root of a binary tree, return the level order traversal of its
                       nodes' values. (i.e., from left to right, level by level).

                       NOTE: Return a list of lists where each list represents a level of the
                             binary tree.

    General Observations:

        - In level order traversal, you need to process all nodes at one level before moving to the
          next level. This matches the behavior of a First-In-First-Out (FIFO) structure, which is
          exactly what a Queue provides.

        - Algorithm:

            - queue.add(root);

            - while queue is not empty:
                - levelSize = queue.size();
                - currentLevel = [];
                - for i = [1:levelSize]:
                    - currentNode = queue.poll();
                    - currentLevel.add(currentNode.val);
                    - if currentNode.left exists: queue.add(currentNode.left);
                    - if currentNode.right exists: queue.add(currentNode.right);
                - result.add(currentLevel);

            - return result;

        - Time Complexity: O(n).

        - Space Complexity Analysis:

            - Depends on the maximum number of nodes that are stored in the queue at any point
              during the traversal.

            - In a complete binary tree, the last level can have up to n/2 nodes, where n is the
              total number of nodes in the tree.

            - Hence, the space complexity is O(n) for the queue in the worst case.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=1; i<=levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentLevel);
        }

        return result;

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

        System.out.println(levelOrder(node1));
    }

}
