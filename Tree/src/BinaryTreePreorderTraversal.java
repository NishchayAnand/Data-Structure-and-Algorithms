
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

        - Iterative Approach:

            - Use 2 stacks:
                - stack1: to explicitly simulate the function call stack of a recursive solution.
                - stack2: to store the order in which the nodes will be processed.

            - Since, stack processes the last visited (Last In) node first (First Out), push nodes
              onto stack1 in reverse order of how they need to be processed.

            - NOTE: This approach is particularly useful for trees with significant depth, where
                    recursion may cause stack overflow.

            - Algorithm:
                - stack1.push(root);
                - while stack1 is not empty:
                    - node = stack1.pop();
                    - stack2.add(node);
                    - if node.right != null: stack1.push(node.right);
                    - if node.left != null: stack1.push(node.left);

            - NOTE: Here, the output (represents the order of processing) can simply be stored in an
                    arraylist, considering that the result is required as a list.

            - Time Complexity: O(n).

            - Space Complexity: O(h) ~ O(n) in worst case scenario (skewed binary tree).

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

    private static void helper(TreeNode root, List<Integer> output) {
        if(root == null) return;
        output.add(root.val);
        helper(root.left, output);
        helper(root.right, output);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        //helper(root, output);

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

        node1.right = node2;
        node2.left = node3;

        System.out.println(preorderTraversal(node1));
    }

}
