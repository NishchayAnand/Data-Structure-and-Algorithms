package binaryTreeQues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

import binaryTreeQues.BinaryTree.Node;

public class TopView {
	
	static class Pair{
        
        Node node;
        int vlevel;
        
        Pair(Node node, int vlevel){
            this.node = node;
            this.vlevel = vlevel;
        }
        
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        
        Queue<Pair> curr_level = new ArrayDeque<>();
        curr_level.add(new Pair(root, 0));
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min_vlevel = Integer.MAX_VALUE;
        int max_vlevel = Integer.MIN_VALUE;
        
        while(curr_level.size()>0){
            
            Queue<Pair> next_level = new ArrayDeque<>();
            
            // processing the current level and generating the next level. 
            while(curr_level.size()>0){
                
                Pair top = curr_level.remove();
                
                // processing 1: updating the min_vlevel and max_vlevel based on current top.node's vertical level. 
                min_vlevel = Math.min(min_vlevel, top.vlevel);
                max_vlevel = Math.max(max_vlevel, top.vlevel);
                
                // processing 2: checking if top.node is the first node for top.vlevel vertical level
                if(!hm.containsKey(top.vlevel)){
                    hm.put(top.vlevel, top.node.value);
                }
                
                // creating the next level
                if(top.node.left!=null){
                    next_level.add(new Pair(top.node.left, top.vlevel-1));
                }
                if(top.node.right!=null){
                    next_level.add(new Pair(top.node.right, top.vlevel+1));
                }
                
            }
            
            // pointing the next level to current level for next iteration.
            curr_level = next_level;
            
        }
        
        for(int i=min_vlevel; i<=max_vlevel; i++){
            ans.add(hm.get(i));
        }
        
        return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
