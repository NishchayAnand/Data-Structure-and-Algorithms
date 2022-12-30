
public class BSTImpl {

	private class Node {
		int key;
		Node leftChild;
		Node rightChild;

		public Node(int key) {
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	private Node root;

	public BSTImpl() {
		this.root = null;
	}

	public Node findMin() {
		if(root == null) {
			System.out.println("BST is empty.");
			return null;
		}
		return findMin(root);
	}

	private Node findMin(Node node) {
		// base condition...
		if(node.leftChild == null) {
			return node;
		} 
		// recursive steps...
		Node min = findMin(node.leftChild);
		return min;
	}

	public Node findMax() {
		if(root == null) {
			System.out.println("BST is empty.");
			return null;
		}
		return findMax(root);
	}

	private Node findMax(Node node) {
		if(node.rightChild == null) {
			return node;
		}
		Node max = findMax(node.rightChild);
		return max;
	}

	public boolean contains(int key) {
		if(root == null) {
			System.out.println("BST is empty.");
			return false;
		}
		return contains(root, key);
	}

	private boolean contains(Node curr, int key) {

		if(curr == null) {
			return false;
		}

		if(curr.key == key) {
			return true;
		} else if(curr.key > key) {
			return contains(curr.leftChild, key);
		} else { // curr.key < key
			return contains(curr.rightChild, key);
		}
	}

	public void add(int key) {
		if(root == null) {
			root = new Node(key);
			return;
		}
		add(root, key);
	}

	private void add(Node curr, int key) {
		
		if(curr == null) {
			return;
		}
		
		if(curr.key>key) {
			
			if(curr.leftChild == null) {
				curr.leftChild = new Node(key);
			} else {
				add(curr.leftChild, key);
			}
			
		} else if(curr.key<key){
			
			if(curr.rightChild == null) {
				curr.rightChild = new Node(key);
			} else {
				add(curr.rightChild, key);
			}
			
		}

	}

	public Node remove(int key) {
		if(root == null) {
			System.out.println("BST is empty.");
			return null;
		}
		return remove(root, key);
	}
	
	private Node remove(Node curr, int key) {
		
		// will only be reached in case the key to be deleted wasn't found.
		if(curr == null) {
			return null;
		}
		
		// key lies in the right subtree of the current node.
		if(key > curr.key) {
			
			curr.rightChild = remove(curr.rightChild, key);
			
		} else if(key < curr.key) { // key lies in the left subtree of the current node.
			
			curr.leftChild = remove(curr.leftChild, key);
			
		} else { // current node is the key (node) to be deleted. 
			
			// current node has 2 children.
			if(curr.leftChild!=null && curr.rightChild!=null) {
				Node rightMin = findMin(curr.rightChild);
				curr.key = rightMin.key;
				curr.rightChild = remove(curr.rightChild, rightMin.key);
			} else if (curr.leftChild!=null) { // current node has 1 child.
				return curr.leftChild;
			} else if (curr.rightChild!=null) { // current node has 1 child.
				return curr.rightChild;
			} else { // current node is a leaf node.
				return null;
			}
			
		} 
		
		return curr;
		
	}

}
