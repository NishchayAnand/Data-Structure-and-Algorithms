package binaryTreeQues;

import java.util.ArrayDeque;
import java.util.Queue;

import binaryTreeQues.BinaryTree.Node;

public class KLevelDown {
	
	public static void recursiveApproach1(Node node, int level, int k) {

	    if(node==null){
	      return;
	    }

	    if(level==k){
	      System.out.println(node.value);
	      return;
	    }

	    recursiveApproach1(node.left, level+1, k);
	    recursiveApproach1(node.right, level+1, k);
	    
	 }
	
	public static void recursiveApproach2(Node node, int k) {
		
		if(node==null){
			return;
	    }

	    if(k==0){
	    	System.out.println(node.value);
	    	return;
	    }

	    recursiveApproach2(node.left, k-1);
	    recursiveApproach2(node.right, k-1);
		
	}

	  public static void IterativeApproachLevelOrder(Node node, int k){

	    Queue<Node> curr_level = new ArrayDeque<>();

	    if(node!=null){
	      curr_level.add(node);
	    }

	    while(curr_level.size()>0){
	    	
	    	// got the correct level.
		    if(k==0){
		    	
		    	while(curr_level.size()>0){
		    		Node top = curr_level.remove();
		    		System.out.println(top.value);
		    	}
		
		  } else {
			  
			  Queue<Node> next_level = new ArrayDeque<>();
		
			  while(curr_level.size()>0){				  
				  Node top = curr_level.remove();
				  if(top.left!=null){
					  next_level.add(top.left);
				  }
				  if(top.right!=null){
					  next_level.add(top.right);
		          }
		      }
		
			  curr_level = next_level;
		      k--;
		
		  }
		  
	    }

	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
