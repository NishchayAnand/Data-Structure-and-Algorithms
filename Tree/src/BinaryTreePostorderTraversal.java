
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

                - map<TreeNode.val, visitedCount> = {};
                - stack = []
                - currentNode = root;
                - while currentNode exists or stack is not empty:

                    - if currentNode exists:
                        - map.put(currentNode.val, map.get(currentNode.val)+1);
                        - stack.push(currentNode);
                        - currentNode = currentNode.left;
                    else:
                        - currentNode = stack.top();
                        - map.put(currentNode.val, map.get(currentNode.val)+1);

                        - if map.get(currentNode.val) == 3:
                            - output.add(stack.pop());
                        - else:
                            - currentNode = currentNode.right;

                - return output;

            - Time Complexity: O(n).

            - Space Complexity: O(n) -> due to the visited node count map.

        - Tricky Iterative Approach:

            - Use 2 stacks:
                - stack1: to explicitly simulate the function call stack of a recursive solution.
                - stack2: to store the order in which the nodes will be processed.

        - NOTE: Iterative approaches is particularly useful for trees with significant depth, where
                recursion may cause stack overflow.

*/

public class BinaryTreePostorderTraversal {
}
