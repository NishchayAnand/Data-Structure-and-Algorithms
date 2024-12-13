
/*

    Problem Statement: Given the root of a binary tree, return its maximum depth.

                       NOTE: Maximum depth is the number of nodes along the longest path from the
                             root node down to the farthest leaf node.

    General Observations:

        - The problem is naturally recursive in nature, i.e., maxDepthRecursive(node) = max(maxDepthRecursive(node.left),
          maxDepthRecursive(node.right)) + 1;

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

        - Can perform Level-order traversal to calculate the number of levels processed a.k.a
          the maximum depth of the binary tree.

        - Iterative Algorithm:

            - maxDepth = 0;
            - queue.add(root);

            - while queue is not empty:
                - depth++; // processing a new level
                - int levelSize = queue.size();
                - for i = [1:levelSize]:
                    - currentNode = queue.poll();
                    - if currentNode.left exists: queue.add(currentNode.left);
                    - if currentNode.right exists: queue.add(currentNode.right);

            - return maxDepth;

            - Time Complexity: O(n).

            - Space Complexity: O(n) in worst case scenario (complete binary tree).

*/

public class MaximumDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepthRecursive(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
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

        System.out.println(maxDepthRecursive(node1));
    }

}
