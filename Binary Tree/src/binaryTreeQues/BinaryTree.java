package binaryTreeQues;

import java.util.Stack;

/*
 * Problem Statement: Given a pre-ordered array representation of a Binary Tree, construct an actual 
 * 					  Binary Tree. 
 * 
 * General Observations:
 * 	- In pre-ordered representation:
 * 			- first the parent node is processed, 
 * 			- then the left child node is processed 
 * 			- at last the right child node is processed.
 * 	- Hence, A[0] will be the root node.
 * 	- In a recursive solution, the node under-consideration will only be removed from the scope, once 
 *    all its sub-nodes are processed.  
 *  - Hence, we can use a stack -> that will store the nodes in the processing state and their no of 
 *    children processed.
 *    	- no. of children processed == 1, meaning, left node is processed
 *    	- no. of children processed == 2, meaning, right node is processed
 * 
 * Dry Run:
 * 		A = [50, 25, 12, N, N, 37, 30, N, N, N, 75, N, N]
 * 			  0   1   2  3  4   5   6  7  8  9  10 11 12
 * 
 * 			i=1, st = [(50,0)] -> [(50,1)] -> [(50,1),(25,0)], 50->lc->25
 * 			i=2, st = [(50,1),(25,0)] -> [(50,1),(25,1)] -> [(50,1),(25,1), (12,0)], 25->lc->12
 * 			i=3, st = [(50,1),(25,1), (12,0)] -> [(50,1),(25,1), (12,1)],
 * 			i=4, st = [(50,1),(25,1), (12,1)] -> [(50,1),(25,1), (12,2)], [(50,1),(25,1)]
 * 			i=5, st = [(50,1),(25,1)] -> [(50,1),(25,2)] -> [(50,1),(37,1)], 25->rc->37
 * 			...
 * */

public class BinaryTree {
	
	// node of the binary tree
	static class Node {
		
		private int value;
		private Node left;
		private Node right;
		
		Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		public int getValue() {
			return value;
		}
		
		public Node getLeftNode() {
			return left;
		}
		
		public Node getRightNode() {
			return right;
		}
		
	}
	
	private static class NodeInfo {
		
		private Node node;
		private int processedChildren;
		
		NodeInfo(Node node){
			this.node = node;
			this.processedChildren = 0;
		}
		
		private void setProcessedChildren(int processedChildren) {
			this.processedChildren = processedChildren;
		}
		
		private int getProcessedChildren() {
			return processedChildren;
		}
		
		private Node getNode() {
			return node;
		}
		
	}
	
	public static Node buildBinaryTree(Integer[] arr) {
		
		Stack<NodeInfo> st = new Stack<>();
		
		Node rootNode =  new Node(arr[0]);
		st.add(new NodeInfo(rootNode));
		
		for(int i=1; i<arr.length; i++) {
			
			NodeInfo topNodeInfo = st.peek();
			
			Node topNode = topNodeInfo.getNode();
			int processedChildren = topNodeInfo.getProcessedChildren();
			
			topNodeInfo.setProcessedChildren(processedChildren++);
			
			if(processedChildren == 2) {
				st.pop();
			}
			
			if(arr[i]!=null) {
				
				Node node = new Node(arr[i]);
				
				if(processedChildren == 1) {
					topNode.left = node;
				} else if(processedChildren == 2) {
					topNode.right = node;
				}
				
				st.add(new NodeInfo(node));
				
			}
			
		}
		
		return rootNode;
		
	}
	
	public static void main(String args[]) {
		
		Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, null, null};
		
		Node rootNode = buildBinaryTree(arr);
		
		System.out.println("Binary tree created successfully");
		
	}
}