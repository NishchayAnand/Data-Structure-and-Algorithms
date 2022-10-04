package binaryTreeQues;

import java.util.Stack;

import binaryTreeQues.BinaryTree.Node;

public class PreorderIterative {
	
	private static class Pair {
		
		Node node;
		int state;
		
		Pair(Node node){
			this.node = node;
			this.state = 1;
		}
		
	}
	
	public static void printPreOrderIterative(Node rootNode) {
		
		Stack<Pair> st = new Stack<>();
		
		st.add(new Pair(rootNode));
		
		while(!st.isEmpty()) {
			
			Pair top = st.peek();
			
			if(top.state == 1) {
				System.out.print(top.node.value + " ");
				if(top.node.left!=null) {
					st.add(new Pair(top.node.left));
				}
				top.state++;
			} else if (top.state == 2) {
				if(top.node.right!=null) {
					st.add(new Pair(top.node.right));
				}
				top.state++;
			} else {
				st.pop();
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {50, 20, 40, null, null, 30, null, null, 10, null, null};
		
		Node rootNode = BinaryTree.buildBinaryTree(arr);
		
		System.out.print("Preorder transversal using iterative approach: ");
		printPreOrderIterative(rootNode);

	}

}
