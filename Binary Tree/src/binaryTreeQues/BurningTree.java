package binaryTreeQues;

import java.util.ArrayList;
import java.util.List;

import binaryTreeQues.BinaryTree.Node;

public class BurningTree {
	
	public static List<Node> getNodeToRootPath(Node node, int target){
        
        if(node==null){
            return new ArrayList<>();
        }
        
        if(node.value == target){
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }
        
        List<Node> lans = getNodeToRootPath(node.left, target);
        if(!lans.isEmpty()){
            lans.add(node);
            return lans;
        }
        
        List<Node> rans = getNodeToRootPath(node.right, target);
        if(!rans.isEmpty()){
            rans.add(node);
            return rans;
        }
        
        return new ArrayList<>();
        
    }
    
    public static int height(Node node){
        
        if(node == null){
            return -1;
        }
        
        int left = height(node.left);
        int right = height(node.right);
        
        return Math.max(left, right) + 1;
        
    }
    
    public static int getTime(Node node, int cnftime, Node blockerNode){
        
        if(node==null){
            return 0;
        }
        
        // time required to burn a single node = 0 seconds, however the below code will return 1.
        if(node.left == null && node.right == null){
            return 0;
        }
        
        int leftTime = node.left == blockerNode ? 0: height(node.left);
        int rightTime = node.right == blockerNode ? 0: height(node.right);
        
        return Math.max(leftTime, rightTime) + cnftime + 1;
        
    }
    
    public static int minTime(Node root, int target) 
    {
        
        List<Node> list = getNodeToRootPath(root, target);
        
        if(list.isEmpty()){
            return 0;
        }
        
        int maxTime = Integer.MIN_VALUE;
        Node blockerNode = null;
        
        for(int i=0; i<list.size(); i++){
            int ptime = getTime(list.get(i), i, blockerNode);
            maxTime = Math.max(ptime, maxTime);
            blockerNode = list.get(i);
        }
        
        return maxTime;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
