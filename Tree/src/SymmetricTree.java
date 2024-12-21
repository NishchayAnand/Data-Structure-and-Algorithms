
/*

    Problem Statement: Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around
                       its center).

                       For example, below binary tree is symmetric.

                                              1
                                              ------------
                                              |          |
                                              2          2
                                              -------    -------
                                              |     |    |     |
                                              3     4    4     3

    General Observations:

        - In a symmetric binary tree, all levels are palindrome.

        - Palindrome Check Approach:

            - Perform a level-order traversal (BFS) and check if each level forms a palindrome.

            - Time Complexity: O( n -> level processing + n -> palindrome check) = O(n).

            - Space Complexity: O(n) for balanced binary tree, O(1) for skewed tree.

        - Symmetry implies a mirrored structure where the root node serves as the dividing line. Hence, we only need to
          check if root node's left subtree is a mirror of the root node's right subtree.

        - Mirror Check Iterative Approach:

            - Performing a normal BFS on the left subtree and a reversed BFS on the right subtree ensures we compare
              corresponding nodes in a mirrored order.

            - Algorithm:

                // Step 1: Initialize the queues
                - queue1.add(root.left);
                - queue2.add(root.right);

                // Step 2: Process the queues
                - while (queue1 is not empty) and (queue2 is not empty):

                    - currentNode1 = queue1.poll();
                    - currentNode2 = queue2.poll();

                    // Check if current nodes are different
                    - if currentNode1 == null and currentNode2 == null: continue; // both are null, continue;
                    - if currentNode1 == null or currentNode2 == null: return false; // one in null, subtrees are not mirror image
                    - if currentNode1.val != currentNode2.val: return false; // values don't match, subtrees are not mirror image

                    // Add children of currentNode1 to queue1: left first, then right
                    - queue1.add(currentNode1.left);
                    - queue1.add(currentNode1.right);

                    // Add children of currentNode2 to queue2 in reversed order: right first, then left
                    - queue2.add(currentNode2.right);
                    - queue2.add(currentNode2.left);

                - return true;

                - NOTE: We can use a single queue to traverse both the subtrees of root node together.

            - Time Complexity: O(n).

            - Space Complexity: O(2n) ~ O(n) for balanced binary tree, O(1) for skewed binary tree.

        - Mirror Check Recursive Approach:

            - Hypotheses: F(t1, t2) will return true if trees rooted at 't1' and 't2' are mirror images, else will
                          return false.

            - Base Conditions:
                - if t1 == null and t2 == null: return true; // empty trees are mirror images
                - if t1 == null or t2 == null: return false; // one is null, trees are not mirror images

            - Recursive Steps:
                - if t1.val != t2.val: return false; // values don't match, trees are not mirror images
                - return F(t1.left, t2.right) and F(t1.right, t2.left);

            - Time Complexity: O(n).

            - Space Complexity: O(logn) for balanced binary tree, O(n) for skewed binary tree.

*/

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isSymmetricIterative(TreeNode root) {

        if(root == null) return true; // empty tree is symmetric

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {

            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            // Check if current nodes are different
            if(leftNode == null && rightNode ==  null) continue; // empty trees are mirror image
            if(leftNode == null || rightNode == null) return false; // one is null, trees are not mirror image
            if(leftNode.val != rightNode.val) return false; // values don't match, trees are not mirror image

            // Add children in mirrored order
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);

        }

        return true;

    }
}
