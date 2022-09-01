import java.util.Stack;

public class BinaryTree {
	
	public static class Node {
		
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	
	public static class Pair {
		
		Node node;
		int noc; // noc represents the number of children.
		
		Pair(Node node, int noc){
			this.node = node;
			this.noc = noc;
		}
		
	}
	
	public static Node constructBinaryTree(Integer[] arr) {
		
		Node root = new Node(arr[0], null, null);
		
		Pair pr = new Pair(root, 0); 
		Stack<Pair> st = new Stack<Pair>();
		st.push(pr);
		
		int idx = 1;
		while( !st.isEmpty()) {
			
			Pair top = st.peek();
			
			if(top.noc == 0) {
				
				if(arr[idx]!=null) {
					Node node = new Node(arr[idx], null, null);
					top.node.left = node;
					
					Pair p = new Pair(node, 0);
					st.push(p);	
				} else {
					top.node.left = null;
				}
				
				top.noc++;
				idx++;
				
			} else if(top.noc == 1) {
				
				if(arr[idx]!=null) {
					Node node = new Node(arr[idx], null, null);
					top.node.right = node;
					
					Pair p = new Pair(node, 0);
					st.push(p);
				} else {
					top.node.right = null;
				}
				
				top.noc++;
				idx++;
				
			} else {
				st.pop();
			}
			
		}
		
		return root;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
