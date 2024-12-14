
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

        - Brute Force Algorithm:

            - Hypothesis: F(node) will return true if binary tree rooted at 'node' is balanced, else
                          false.

            - Recursive Steps:
                - isLeftSubtreeBalanced = F(node.left);
                - isRightSubtreeBalanced = F(node.right);
                - isNodeBalanced = abs(getHeight(node.right)- getHeight(node.left)) <= 1;
                - return isLeftSubtreeBalanced & isRightSubtreeBalanced & isNodeBalanced;

            - Base Conditions:
                - if node == null: return true; // empty tree is balanced

            - Time Complexity Analysis (Worst-Case Scenario - Skewed Binary Tree):

                - Let o(n) be the total number of operations performed by the above algorithm for
                  a left skewed tree. Then,

                    1. o(n) = o(n-1) + (n-1) + C
                    2. o(n-1) = o(n-2) + (n-2) + C
                    3. o(n-2) = o(n-3) + (n-3) + C
                     .
                     .
                     .
                    n. o(1) = o(0) + 0 + C

                    -> o(n) = (n-1) + (n-2) + (n-3) + ... + 1 + 0 + [C+C+C+C+.....n times]
                            = n(n+1)/2 + n.C

                - Since, the total number of operations performed in worst-case scenario is of the
                  order n^2, Time Complexity = O(n^2).

            - Space Complexity (Worst-Case Scenario): O(n) for a skewed binary tree.

        - Optimized Approach:

            - Instead of calculating the height repeatedly, return both the height and balance
              status in a single recursive function.

            - Hypotheses: F(node) will return an object representing (i) height of binary tree
                          rooted at 'node' and (ii) whether the binary tree rooted at 'node' is
                          balanced or not.

            - Recursive Steps:
                - leftSubtreeInfo = F(node.left);
                - rightSubtreeInfo = F(node.right);

                // compute height of binary tree rooted at 'node'
                - currentNodeInfo.height = max(rightSubtreeInfo.height, leftSubtreeInfo.height) + 1;

                // compute if binary tree rooted at 'node' is balanced or not
                - isNodeBalanced = abs(rightSubtreeInfo.height- leftSubtreeInfo.height) <= 1;
                - currentNodeInfo.isBalanced = rightSubtreeInfo.isBalanced &
                                               leftSubtreeInfo.isBalanced &
                                               isNodeBalanced;

                - return currentNodeInfo;

            - Base Conditions:
                - if node == null: return new currentNodeInfo(0, true);

            - Time Complexity: O(n).

            - Space Complexity: O(n) in worst-case scenario (skewed binary tree).

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

    static class TreeNodeInfo {
        int height;
        boolean isBalanced;

        TreeNodeInfo() {}

        TreeNodeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private static int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalancedBruteForce(TreeNode root) {
        if (root == null) return true;
        boolean isLeftBalanced = isBalancedBruteForce(root.left);
        boolean isRightBalanced = isBalancedBruteForce(root.right);
        boolean isRootBalanced = Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1;
        return isLeftBalanced && isRightBalanced && isRootBalanced;
    }

    public static TreeNodeInfo isBalanced(TreeNode root) {
        if (root == null) return new TreeNodeInfo(0, true);

        TreeNodeInfo leftSubtreeInfo = isBalanced(root.left);
        TreeNodeInfo rightSubtreeInfo = isBalanced(root.right);

        TreeNodeInfo currentNodeInfo = new TreeNodeInfo();

        // compute height of current binary tree
        currentNodeInfo.height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;

        // check if binary tree is balanced or not
        boolean isRootBalanced = Math.abs(rightSubtreeInfo.height - leftSubtreeInfo.height) <= 1;
        currentNodeInfo.isBalanced = leftSubtreeInfo.isBalanced && rightSubtreeInfo.isBalanced &&
                                        isRootBalanced;

        return currentNodeInfo;
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

        System.out.println(isBalanced(node1).isBalanced);
    }
}
