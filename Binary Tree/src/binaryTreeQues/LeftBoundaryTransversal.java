package binaryTreeQues;

import binaryTreeQues.BinaryTree.Node;

public class LeftBoundaryTransversal {
	
	/* Problem Statement: Given a binary tree, prints all nodes in its left boundary.
	 * 
	 * NOTE: - Left Boundary: All nodes on the path from the root to the left-most node.
	 * 
	 * Generation Obervations:
	 * 
	 * - root.left == null -> root is the only node in the left boundary.
	 * - If root != null and root is not a leaf node, then for any node in the left boundary:
	 * 				- if left child exists, transverse to the left child.
	 * 				- else -> if right child exists, transverse to the right child.
	 * 
	 * */
	
	public static void printLeftBoundary(Node node) {
		
		System.out.println(node.value);
		
		if(node.left!=null) {
			printLeftBoundary(node.left);
		} else if (node.right!=null) {
			printLeftBoundary(node.right);
		}
		
	}

	public static void printLeftBoundaryNodes(Node root) {
		
		if(root==null) {
			return;
		}
		
		if(root.left == null) {
			System.out.println(root.value);
			return;
		}
		
		printLeftBoundary(root);
		
	}
	
	public static void main(String[] args) {
		
		// general example
		//Integer[] arr = {1, 2, 3, null, 6, 8, null, null, null, 4, null, 7, 9, null, null, 10, null, null, null};
		// root = leaf node
		//Integer[] arr2 = {1, null, null};
		// root.left = null
		Integer[] arr3 = {1, null, 2, 3, null, 6, 8, null, null, null, 4, null, 7, 9, null, null, 10, null, null};
		
		Node rootNode = BinaryTree.buildBinaryTree(arr3);
		
		printLeftBoundaryNodes(rootNode);

	}

}
