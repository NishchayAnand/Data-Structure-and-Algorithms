
/*

    Problem Statement: Given the roots of two binary trees 'p' and 'q', write a function to check if they are the same
                       or not.

                       NOTE: Two binary trees are considered the same if they are structurally identical, and the nodes
                             have the same value.

    General Observations:

        - Iterative Approach:

            - Use level-order (BFS) traversal to explore both trees simultaneously.

            - Algorithm:

                // Step 1: Initialize the queues
                - queue1.add(p);
                - queue2.add(q);

                // Step 2: Process the queues
                - while (queue1 is not empty) and (queue2 is not empty):

                    - currentNode1 = queue1.poll();
                    - currentNode2 = queue2.poll();

                    - if (currentNode1 == null) and (currentNode2 == null): continue; // both are null, continue

                    // Check if current nodes are different
                    - if (currentNode1 == null) or (currentNode2 == null): return false; // one is null, trees are not identical
                    - if currentNode1.val != currentNode2.val: return false; // values don't match, trees are not identical

                    // Add children of currentNode1 to queue1
                    - queue1.add(currentNode1.left);
                    - queue1.add(currentNode1.right);

                    // Add children of currentNode3 to queue2
                    - queue2.add(currentNode2.left);
                    - queue2.add(currentNode2.right);

                - return true; // Trees are identical

                - NOTE: We can use a single queue to traverse both the binary trees together.

                - Time Complexity: O(n).

                - Space Complexity: O(2^logn) = O(n), O(1) in case of skewed binary tree.

        - Recursive Approach:

            - Hypotheses: F(p, q) will return tree if binary trees rooted at 'p' and 'q' are identical.

            - Recursive Steps:

                // Step 1: Process the current nodes, i.e., check if they are different
                - if p.val != q.val: return false; // values don't match, trees are not identical

                // Step 2: Process the left subtrees, i.e., check if the left subtrees of both 'p' and 'q' are identical
                - isLeftSubtreeSame = F(p.left, q.left);

                // Step 3: Process the right subtrees, i.e., check if the right subtrees of both 'p' and 'q' are identical
                - isRightSubtreeSame = F(p.right, q.right);

                - return isLeftSubtreeSame and isRightSubtreeSame;

            - Base Conditions:
                - if (p == null) and (q == null): return true; // empty trees are identical
                - if (p == null) or (q == null): return false; // one is null, trees are not identical

            - Time Complexity: O(n).

            - Space Complexity: O(logn), O(n) in case of skewed binary tree.

*/

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isSameTreeIterative(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();

        // Step 1: Initialize the queue
        queue.add(p);
        queue.add(q);

        // Step 2: Process the elements in the queue.
        while(!queue.isEmpty()) {

            TreeNode currentNode1 = queue.poll();
            TreeNode currentNode2 = queue.poll();

            if (currentNode1 == null && currentNode2 == null) continue;

            // check if the current nodes are different
            if (currentNode1 == null || currentNode2 == null) return false;
            if (currentNode1.val != currentNode2.val) return false;

            // add left children of the current nodes to the queue
            queue.add(currentNode1.left);
            queue.add(currentNode1.right);

            // add right children of the current nodes to the queue
            queue.add(currentNode2.left);
            queue.add(currentNode2.right);

        }

        return true; // both binary trees are identical

    }

    private static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {

        // Base Conditions:
        if (p==null && q==null) return true; // empty trees are identical
        if (p==null || q==null) return false; // one is null, trees are not identical

        // Recursive Steps:
        if (p.val != q.val) return false; // process the current nodes
        boolean isLeftSubtreeSame = isSameTreeRecursive(p.left, q.left); // process the left subtrees
        boolean isRightSubtreeSame = isSameTreeRecursive(p.right, q.right); // process the right subtrees

        return isLeftSubtreeSame && isRightSubtreeSame;

    }

}
