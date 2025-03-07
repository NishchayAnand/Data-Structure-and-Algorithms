
/*

    Problem Statement: Given the root of a binary tree, return the postorder traversal of its nodes'
                       values.

    General Observations:

        - Postorder traversal is one of the depth-first traversal methods where the nodes are
          visited in the following order:

                1. Left Subtree: Traverse the left subtree.
                2. Right Subtree: Traverse the right subtree.
                3. Root Node: Process the current node.

        - Recursive Approach:

            - Each node of a binary tree has a value and reference pointers to two child nodes,
              which are themselves binary trees (or NULL). This recursive definition allows us to
              naturally traverse the tree using recursion.

            - Hypotheses: F(root) will return the inorder traversal of the binary tree starting
                          at root.

            - Recursive Steps:
                - F(root.left);
                - F(root.right);
                - output.add(root.val);

            - Base Condition:
                - if (root == null): return;

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

        - In postorder traversal, a tree node is processed when it is visited the third  time.

        - Intuitive Iterative Approach:

            - Use a stack to explicitly simulate the function call stack of the recursive solution.

            - Algorithm:

                - map<TreeNode, visitedCount> = {};
                - stack = []
                - currentNode = root;
                - while currentNode exists or stack is not empty:

                    - if currentNode exists:
                        - map.put(currentNode, 1); // currentNode visited for the first time
                        - stack.push(currentNode);
                        - currentNode = currentNode.left;
                    else:
                        - currentNode = stack.top();
                        - map.put(currentNode, map.get(currentNode)+1);
                        - if map.get(currentNode) == 3:
                            - output.add(stack.pop());
                            - currentNode = null;
                        - else:
                            - currentNode = currentNode.right;

                - return output;

            - NOTE: A node's third visit occurs after returning from its right subtree. Instead of
                    maintaining a counter, we can use a pointer 'lastVisited' to remember the most
                    recently visited node. If the currentNode.right = lastVisited, we know the
                    right subtree has been processed.

            - Time Complexity: O(n).

            - Space Complexity: O(h) = O(n) in worst case scenario (skewed binary tree).

*/

import java.util.*;

public class BinaryTreePostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> postorderTraversalIntuitive(TreeNode root) {

        List<Integer> output = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        TreeNode lastVisited = null;

        while(currentNode!=null || !stack.isEmpty()) {

            if(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.peek();
                if(currentNode.right == null || currentNode.right == lastVisited) {
                    output.add(stack.pop().val);
                    lastVisited = currentNode;
                    currentNode = null;
                } else {
                    currentNode = currentNode.right; // Visit the right subtree
                }

            }

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

        System.out.println(postorderTraversalIntuitive(node1));
    }


}
