package binaryTreeQues;

import binaryTreeQues.BinaryTree.Node;

/* Problem Statement: You are given the root of a binary tree. We install cameras on the tree 
 * 					  nodes where each camera at a node can monitor its parent, itself, and its 
 * 					  immediate children.
 * 					
 * 					  Return the minimum number of cameras needed to monitor all nodes of the tree.
 * 
 * Observations:
 * 	- Install cameras on houses which offer maximum coverage.
 *  - While solving the problem, we can encounter houses in 3 states:
 *  		- has_camera
 *  		- covered
 *  		- uncovered 
 *  
 *  - We can solve this problem into either using bottom to top approach, i.e., thinking of the 
 *    current node and then moving to the child nodes or using top to bottom approach, i.e., first 
 *    thinking of the child nodes and then think of the current node.
 *    
 *    	- Lets take a tree containing 3 nodes, 1 root node and 2 child nodes.
 *    
 *      	- Bottom to top Approach: - We would need to install 2 cameras.
 *   		- Top to bottom Approach: - We would only need one camera.
 *   
 *   - Mapping of all possible combinations:
 *   			
 *   		LEFT_STATUS		RIGHT_STATUS		CURRENT_NODE_STATUS
 *   		
 *   1.		has_camera		has_camera			covered
 *   2. 	has_camera		covered				covered
 *   3.		has_camera		uncovered			has_camera
 *   4.		covered			has_camera			covered
 *   5. 	covered			covered				uncovered -> only one case
 *   6.		covered			uncovered			has_camera
 *   7. 	uncovered		has_camera			has_camera
 *   8. 	uncovered		covered				has_camera
 *   9. 	uncovered		uncovered			has_camera	
 *   
 *   - If left is covered && right is covered, then current is uncovered.
 *   
 *   - If any if left or right is uncovered, then current need to install camera.
 *   
 *   - else, the current will be covered.
 *   
 * Algorithm:
 * 
 * 	- We can set the status of the current node depending on the statuses of left and right child. 
 * 	- We can maintain a global variable that will be increment whenever we set the status of any node
 *   to has_camera
 * 	- Mapping corresponding to each status:
 * 			- has_camera : 0
 * 			- covered: 	1
 * 			- uncovered: -1
 * 
 * 	- Hypothesis: getStatus(node) will return the status of node.
 * 
 * 	- Recursive Step: 	1. left_status = getStatus(node.left)
 * 						2. right_status = getStatus(node.right)
 * 
 * 						if(left_status == 1 && right_status == 1) -> return -1
 * 						else if(left_status==-1 || right_status==-1) -> count++ -> return 0
 * 						else -> return 1
 * 
 * 	- Base Condition: if node == null, return 1;
 * 
 *  - If the status of root node return is -1, that means, we need a camera on the root node -> count++
 * 
 * */

public class BinaryTreeCameras {
	
	static int count;
	
	public static int getStatus(Node node) {
		
		if(node==null) {
			return 1;
		}
		
		int left_status = getStatus(node.left);
		int right_status = getStatus(node.right);
		
		if(left_status==1 && right_status == 1) {
			return -1;
		} else if(left_status == -1 || right_status == -1) {
			count++;
			return 0;
		} else {
			return 1;
		}
		
	}
	
	public static int minReqCameras(Node root) {
		
		count = 0;
		
		int rootStatus = getStatus(root);
		
		if(rootStatus == -1) {
			count++;
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] treePreOrder = {0, 0, 0, 0, null, 0, null, null, null, null, null};
		
		Node root = BinaryTree.buildBinaryTree(treePreOrder);
		
		int count = minReqCameras(root);
		
		System.out.println(count);

	}

}
