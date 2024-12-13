
/*

    Problem Statement: Given a binary tree, determine if it is height-balanced.

                       NOTE: A height-balanced binary tree is a binary tree in which the difference
                             in height (or depth) between the left and right subtrees of any node is
                             at most 1.

    General Observations:

        - For a binary tree to be balanced, it must satisfy 3 conditions:
            - its left subtree should be balanced,
            - its right subtree should be balanced,
            - |height of right subtree - height of left subtree| <= 1.

        - The problem is naturally recursive in nature.

        - Algorithm:

            - Hypothesis: F(node) will return true if binary tree rooted at 'node' is balanced, else
                          false.

            - Recursive Steps:
                - isLeftSubtreeBalanced = F(node.left);
                - isRightSubtreeBalanced = F(node.right);
                - isNodeBalanced = abs(getHeight(node.right)- getHeight(node.left)) <= 1;
                - return isLeftSubtreeBalanced & isRightSubtreeBalanced & isNodeBalanced;

            - Base Conditions:
                - if node == null: return true; // empty tree is balanced

*/

public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        boolean isRootBalanced = Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1;
        return isLeftBalanced && isRightBalanced && isRootBalanced;
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

        System.out.println(isBalanced(node1));
    }
}
