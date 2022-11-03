import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    
    class Pair implements Comparable<Pair> {
        
        int sp, ep;
        
        public Pair(int sp, int ep){
            this.sp = sp;
            this.ep = ep;
        }
        
        public int compareTo(Pair o){
            return this.sp - o.sp;
        }
        
    }
    
    public int[][] merge(int[][] intervals) {
        
        Pair[] int_vals = new Pair[intervals.length];
        for(int i=0; i<intervals.length; i++){
            int_vals[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(int_vals);
        
        // Arrays.sort(intervals, (a,b) -> {return a[0]-b[0];} );
        
        ArrayList<Pair> ans = new ArrayList<>();
        ans.add(int_vals[0]);
        // ans.add(intervals[0]);
        
        for(int i=1; i<int_vals.length; i++){
            
            Pair last_interval_in_ans = ans.get(ans.size()-1);
            // int[] last_interval_in_ans = ans.get(ans.size()-1);
            
            if(last_interval_in_ans.ep >= int_vals[i].sp){ //if(last_interval_in_ans[1] >= intervals[i][0]){
                
                last_interval_in_ans.ep = Math.max(last_interval_in_ans.ep, int_vals[i].ep);
                // last_interval_in_ans[1] = Math.max(last_interval_in_ans[1], intervals[i][0]);
                
            } else {
                ans.add(int_vals[i]);
                // ans.add(intervals[i]);
            }
        }
        
        int[][] finalAns = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++){
            finalAns[i][0] = ans.get(i).sp;
            finalAns[i][1] = ans.get(i).ep;
        }
        
        return finalAns;
        // return ans.toArray(new int[ans.size()][]);
        
    }
} 
