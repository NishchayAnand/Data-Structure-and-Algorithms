package binaryTreeQues;

import java.util.ArrayList;
import java.util.HashSet;

import binaryTreeQues.BinaryTree.Node;

public class ConstructUsingInorderLevelOrder {
	
	Node buildTree(int inord[], int level[])
    {
        //your code here
        ArrayList<Integer> levelorder = new ArrayList<>();
        for(int el: level){
            levelorder.add(el);
        }
        
        return construct(levelorder, inord, 0, inord.length-1);
        
    }
    
    Node construct(ArrayList<Integer> levelorder, int[] inorder, int inStart, int inEnd){
        
        if(inStart>inEnd){
            return null;
        }
        
        int root_val = levelorder.get(0);
        
        Node root = new Node(root_val);
        
        int inorder_root_index=-1;
        HashSet<Integer> hs = new HashSet<>();
        // this will help us avoid the use of HashMap for getting the inorder_root_index.
        for(int i=inStart; i<=inEnd; i++){
            if(inorder[i]!=root_val){
                hs.add(inorder[i]);
            } else {
                inorder_root_index = i;
                break;
            }
        }
        
        ArrayList<Integer> left_subtree_levelorder = new ArrayList<>();
        ArrayList<Integer> right_subtree_levelorder = new ArrayList<>();
        
        // creating left and right subtree's level-order transversal.
        for(int i=1; i<levelorder.size(); i++){
            int el = levelorder.get(i);
            if(hs.contains(el)){
                left_subtree_levelorder.add(el);
            } else {
                right_subtree_levelorder.add(el);
            }
        }
        
        root.left = construct(left_subtree_levelorder, inorder, inStart, inorder_root_index-1);
        root.right = construct(right_subtree_levelorder, inorder, inorder_root_index+1, inEnd);
        
        return root;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
