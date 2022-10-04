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
		
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
	}
	
	private static class Pair {
		
		Node node;
		int children;
		
		Pair(Node node){
			this.node = node;
			this.children = 0;
		}
		
	}
	
	public static Node buildBinaryTree(Integer[] arr) {
		
		Stack<Pair> st = new Stack<>();
		
		Node rootNode =  new Node(arr[0]);
		
		st.add(new Pair(rootNode));
		
		int index = 1;
		
		while(st.size()>0) {
			
			Pair top = st.peek();
			
			if(top.children == 0) {
				
				//System.out.println("Pre ->" + top.node.value);
				if(arr[index]!=null) {
					Node node = new Node(arr[index]);
					top.node.left = node;
					st.add(new Pair(node));
				}
				top.children++;
				index++;
				
			} else if(top.children == 1) {
				
				//System.out.println("In ->" + top.node.value);
				if(arr[index]!=null) {
					Node node = new Node(arr[index]);
					top.node.right = node;
					st.add(new Pair(node));
				}
				
				top.children++;
				index++;
				
			} else { // top.children == 2
				
				//System.out.println("Post ->" + top.node.value);
				st.pop();
				
			}
			
		}
		
		return rootNode;
		
	}
	
	public static void main(String args[]) {
		
		//Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, null, null};
		
		Integer[] arr = {1, 2, 3, null, 6, 8, null, null, null, 4, null, 7, 9, null, null, 10, null, null};
		Node rootNode = buildBinaryTree(arr);
		
		// System.out.println("Binary tree created successfully");
		
	}
}