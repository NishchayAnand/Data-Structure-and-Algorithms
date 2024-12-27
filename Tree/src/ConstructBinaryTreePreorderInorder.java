
/*

    Problem Statement: Given two integer arrays 'preorder' and 'inorder' where 'preorder' is the preorder traversal of
                       a binary tree and 'inorder' is the inorder traversal of the same tree, construct and return the
                       binary tree.

    General Observations:

        - The first element in the 'preorder' list represents the 'root' of the tree.

        - The position of the 'root' in the 'inorder' list divides the tree into the left and right subtrees, i.e.,:
            - all elements to the left of the 'root' in the 'inorder' list belongs to the left subtree of the root.
            - all elements to the right of the 'root' in the 'inorder' list belongs to the right subtree of the root.

        - If k = the number of elements before the 'root' in the 'inorder' list (represents the elements of the left
          subtree of the root), the first 'k' elements after the 'root' in the 'preorder' list corresponds to the
          left subtree (remaining belong to the right subtree).

        - Brute Force Recursive Approach:

            - Hypotheses: F(preorder, inorder) will build a binary tree using the 'preorder' and 'inorder' lists
                          and return the root of the constructed tree.

            - Recursive Steps:

                // Create root node
                - root_val = preorder[0];
                - root = TreeNode(root_val);

                // Find index of root in inorder list
                - rootIndex = findRootIndexInorder(root_val);

                // Construct inorder and preorder of left subtree
                - leftSubtreeInorder = inorder[0,root_index);
                - leftSubtreePreorder = preorder[1, leftSubtreeInorder.length + 1];

                // Construct inorder and preorder of the right subtree
                - rightSubtreeInorder = inorder[root_index+1, inorder.length);
                - rightSubtreePreorder = preorder[leftSubtreeInorder.length + 1, preorder.length];

                // Build the left and right subtrees
                - root.left = F(leftSubtreePreorder, leftSubtreeInorder);
                - root.right = F(rightSubtreePreorder, rightSubtreeInorder);

            - Base Conditions:

                - if preorder.length == 0 and inorder.length == 0; return null;

            - Time Complexity Analysis:

                - In case of skewed binary tree, finding root index = O(n) for each recursive call.

                - Hence, overall Time Complexity = O(n^2).

            - Space Complexity Analysis:

                - Recursion stack: O(h), where 'h' is the height of the tree.

                - In case of skewed binary tree, storing sliced arrays = O(n) for each recursive call.

                - Hence, overall Space Complexity = O(n^2).

        - Optimizations:

            - We can use a HashMap to store the indices of the elements in the 'inorder' list. This will allow us to
              perform lookup for the root node value in constant time, reducing the time complexity to O(n).

            - We don't need to actually slice the arrays in each recursive call to construct the binary tree. Instead,
              we can simply pass the starting and ending indices of the relevant segments of 'preorder' and 'inorder',
              reducing the space complexity to O(h).

*/

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> fMap) {

        // Base Condition: no elements to construct the tree
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root of the current subtree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Get the index of the root in inorder list
        int rootInorderIndex = fMap.get(rootVal);

        // Number of elements in the left subtree
        int leftSubtreeLength = rootInorderIndex - inStart;

        // Recursively construct the left subtree
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeLength,
                                    inorder, inStart, rootInorderIndex - 1, fMap);

        // Recursively construct the right subtree
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeLength + 1, preEnd,
                                    inorder, rootInorderIndex + 1, inEnd, fMap);

        return root;

    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            fMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, n-1, inorder, 0, n-1, fMap);

    }
}
