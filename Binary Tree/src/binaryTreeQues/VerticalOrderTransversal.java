package binaryTreeQues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import binaryTreeQues.BinaryTree.Node;

class VerticalOrderTransversal {
    
    class Pair{
        
        Node node;
        int vlevel;
        
        Pair(Node node, int vlevel){
            this.node = node;
            this.vlevel = vlevel;
        }
        
    }
    
    public List<List<Integer>> verticalTraversal(Node root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        HashMap<Integer, ArrayList<Integer>> tans = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        Queue<Pair> curr_level = new ArrayDeque<>();
        curr_level.add(new Pair(root, 0));
        
        while(curr_level.size()>0){
            
            Queue<Pair> next_level = new ArrayDeque<>();
            
            HashMap<Integer, PriorityQueue<Integer>> temp = new HashMap<>();
            
            while(curr_level.size()>0){
                
                Pair top = curr_level.remove();
                
                int key = top.vlevel;
                min = Math.min(min, key);
                max = Math.max(max, key);
                                
                PriorityQueue<Integer> pq;
                if(temp.containsKey(key)){
                    pq = temp.get(key);
                } else {
                    pq = new PriorityQueue<>();
                }
                pq.add(top.node.value);
                temp.put(key,pq);
                
                if(top.node.left!=null){
                    next_level.add( new Pair(top.node.left, top.vlevel-1) );
                }                 
                if(top.node.right!=null){
                    next_level.add( new Pair(top.node.right, top.vlevel+1) );
                }
                
            }
            
            for(int key: temp.keySet()){               
                ArrayList<Integer> list = tans.getOrDefault(key, new ArrayList<>());               
                PriorityQueue<Integer> pq = temp.get(key);                
                while(pq.size()>0){
                    list.add(pq.remove());
                }                
                tans.put(key,list);               
            }
            
            curr_level = next_level;
            
        }
        
        for(int key=min; key<=max; key++){
            ArrayList<Integer> list = tans.get(key);
            ans.add(list);
        }
        
        return ans;
         
    }
    
    public static void main(String args[]) {
    	
    }
    
}
