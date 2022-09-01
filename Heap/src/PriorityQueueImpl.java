import java.io.*;
import java.util.*;

public class PriorityQueueImpl {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    private void swap(int pidx, int idx){
      int temp = data.get(pidx);
      data.set(pidx, data.get(idx));
      data.set(idx, temp);
    }

    private void max_heapify(int idx){

      if(idx == 0){
        return; 
      }

      int parent_idx = (idx-1)/2;
      if(data.get(parent_idx) > data.get(idx)){
        swap(parent_idx, idx);
        max_heapify(parent_idx);
      }

    }

    public void add(int val) {
      // write your code here
      data.add(val);
      max_heapify(size()-1);
    }

    private void min_heapify(int index){

      int min_index = index;

      int left_child_index = 2*index+1;
      if(left_child_index < size() && data.get(left_child_index)<data.get(min_index)){
        min_index = left_child_index;
      }

      int right_child_index = 2*index + 2;
      if(right_child_index < size() && data.get(right_child_index)<data.get(min_index)){
        min_index = right_child_index;
      }

      if(min_index != index){
        swap(min_index, index);
        min_heapify(min_index);
      }
      
    }

    public int remove() {
      // write your code here
      if(size()==0){
        System.out.println("Underflow");
        return -1;
      }

      int min_el = peek();

      swap(0, size()-1);
      data.remove(size()-1);
      min_heapify(0);

      return min_el;

    }

    public int peek() {
      // write your code here
      if(size() > 0){
        return data.get(0);
      } 
      System.out.println("Underflow");
      return -1;
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}