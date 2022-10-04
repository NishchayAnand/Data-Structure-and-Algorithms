package binaryTreeQues;

import java.util.Stack;

import binaryTreeQues.BinaryTree.Node;

public class Height {
	
	private static class Pair {
		
		Node node;
		int state;
		int lheight;
		int rheight;
		
		Pair(Node node){
			this.node = node;
			this.state = 1;
			this.lheight = -1;
			this.rheight = -1;
		}
		
	}
	
	public static int getHeightRecursive(Node node) {
		
		if(node==null) {
			return -1;
		}
		
		int lheight, rheight;
		lheight = getHeightRecursive(node.left);
		rheight = getHeightRecursive(node.right);
		
		return Math.max(lheight, rheight) + 1;
		
	}
	
	public static int getHeightIteratively(Node node) {
		
		int height = 0;
		
		Stack<Pair> st = new Stack<>();
		
		st.add(new Pair(node));
		
		while(st.size()>0) {
			
			Pair top = st.peek();
			
			if(top.state == 1) { // preorder state
				
				if(top.node.left!=null) {
					st.push(new Pair(top.node.left));
				}
				
				top.state++;
				
			} else if(top.state == 2) { // inorder state
				
				// left subproblem has been processed.
				if(top.node.left!=null) {
					top.lheight = height;
				}
				
				if(top.node.right!=null) {
					st.push(new Pair(top.node.right));
				}
				
				top.state++;
				
			} else {
				
				// right subproblem has also been processed.
				if(top.node.right!=null) {
					top.rheight = height;
				}
				
				height = Math.max(top.lheight, top.rheight) + 1;
				
				st.pop();
				
			}
			
		}
		
		return height;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {10, 20, 30, null, null, 40, null, null, 50, null, null};
		
		Node rootNode = BinaryTree.buildBinaryTree(arr);
		
		System.out.println("Height (Recursively): " + getHeightRecursive(rootNode));
		
		System.out.println("Height (Iteratively): " + getHeightIteratively(rootNode));

	}

}
