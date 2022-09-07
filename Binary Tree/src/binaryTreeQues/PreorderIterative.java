package binaryTreeQues;

import java.util.Stack;

import binaryTreeQues.BinaryTree.Node;

public class PreorderIterative {
	
	private static class NodeInfo {
		
		Node node;
		boolean isPrinted;
		int processedChildren;
		
		NodeInfo(Node node){
			this.node = node;
			this.isPrinted = false;
			this.processedChildren = 0;
		}
		
	}
	
	public static void printPreOrderIterative(Node rootNode) {
		
		Stack<NodeInfo> st = new Stack<>();
		
		st.add(new NodeInfo(rootNode));
		
		while(!st.isEmpty()) {
			
			NodeInfo topNodeInfo = st.peek();
			
			// print the top of the stack if it is not printed before.
			if(topNodeInfo.isPrinted==false) {
				System.out.print(topNodeInfo.node.getValue()+" ");
				topNodeInfo.isPrinted=true;
			}
			
			topNodeInfo.processedChildren++;
			
			// removing node from stack if both children have been visited
			if(topNodeInfo.processedChildren == 2) {
				st.pop();
			}
			
			// adding left/right child node to the stack.
			if(topNodeInfo.processedChildren == 1 && topNodeInfo.node.getLeftNode()!=null) {
				st.add(new NodeInfo(topNodeInfo.node.getLeftNode()));
			} else if(topNodeInfo.processedChildren == 2 && topNodeInfo.node.getRightNode()!=null) {
				st.add(new NodeInfo(topNodeInfo.node.getRightNode()));
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {10, 20, 30, null, null, 40, null, null, 50, null, null};
		
		Node rootNode = BinaryTree.buildBinaryTree(arr);
		
		System.out.print("Preorder transversal using iterative approach: ");
		printPreOrderIterative(rootNode);

	}

}
