
/*

    Problem Statement: Given the root of a binary tree, return the preorder traversal of its nodes'
                       values.

    General Observations:

        - Preorder traversal is one of the depth-first traversal methods where the nodes are
          visited in the following order:

                1. Root Node: Process the current node first.
                2. Left Subtree: Traverse the left subtree.
                3. Right Subtree: Traverse the right subtree.

        - Recursive Approach:

            - Each node of a binary tree has a value and reference pointers to two child nodes,
              which are themselves binary trees (or NULL). This recursive definition allows us to
              naturally traverse the tree using recursion.

            - Hypotheses: F(root) will return the preorder traversal of the binary tree starting
                          at root.

            - Recursive Steps:
                - output.add(root.val);
                - F(root.left);
                - F(root.right);

            - Base Condition:
                - if (root == null): return;

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

        - In preorder traversal, a tree node is processed when it is visited the first time.

        - Intuitive Iterative Approach:

            - Use a stack to explicitly simulate the function call stack of the recursive solution.

            - Algorithm:

                - stack = [];
                - currentNode = root;
                - while currentNode exists or stack is not empty:

                    - if currentNode exists:
                        - stack.push(currentNode);
                        - output.add(currentNode.val); // Process the currentNode
                        - currentNode = currentNode.left;
                    else:
                        - currentNode = stack.pop(); // Backtrack to the most recent node
                        - currentNode = currentNode.right; // Move to the right subtree

                - return output;

            - Time Complexity: O(n).

            - Space Complexity: O(h) ~ O(n) in worst-case scenario (skewed tree).

        - Tricky Iterative Approach:

            - Since, stack processes the last visited (Last In) node first (First Out), a stack can
              be used to store child nodes in reverse order of how they need to be processed, i.e,
              we push the right child first, then the left child. This ensures that the left child
              is processed before the right child.

            - Algorithm:

                - stack.push(root);

                - while stack is not empty:

                    - currentNode = stack.pop();

                    // Process current node
                    - output.add(currentNode.val);

                    - if currentNode.right exists: stack.push(currentNode.right);
                    - if currentNode.left exists: stack.push(currentNode.left);

            - Time Complexity: O(n).

            - Space Complexity: O(h) ~ O(n) in worst case scenario (skewed binary tree).

        - NOTE: Iterative approaches is particularly useful for trees with significant depth,
                where recursion may cause stack overflow.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversalIntuitive(TreeNode root) {

        List<Integer> output = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode!=null || !stack.isEmpty()) {

            if(currentNode != null) {
                stack.push(currentNode);
                output.add(currentNode.val); // Process the current node
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                currentNode = currentNode.right; // Visit the right subtree
            }

        }

        return output;

    }

    private static void recursiveHelper(TreeNode root, List<Integer> output) {
        if(root == null) return;
        output.add(root.val);
        recursiveHelper(root.left, output);
        recursiveHelper(root.right, output);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        //recursiveHelper(root, output);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return output;
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

        System.out.println(preorderTraversalIntuitive(node1));
    }

}
