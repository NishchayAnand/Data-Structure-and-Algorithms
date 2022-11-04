import java.util.ArrayList;

public class InsertInterval {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // adding new interval to intervals
        int[][] output = new int[intervals.length+1][2];
           
        int index=-1;
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0]<newInterval[0]){
                output[i] = intervals[i];
            } else {
                index = i;
                break;
            }
        }
            
        if(index==-1){
            output[output.length-1] = newInterval;
        } else {
            output[index] = newInterval;
            for(int i = index; i<intervals.length; i++){
                output[i+1] = intervals[i];
            }
        }
            
        
        // merging the overlapping intervals
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> firstInterval = new ArrayList<>();
        firstInterval.add(output[0][0]);
        firstInterval.add(output[0][1]);        
        ans.add(firstInterval);
            
        for(int i=1; i<output.length; i++){
            ArrayList<Integer> lastInAns = ans.get(ans.size()-1);
            if(lastInAns.get(1) >= output[i][0]){
                lastInAns.set(1, Math.max(lastInAns.get(1), output[i][1]));
            } else {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(output[i][0]);
                interval.add(output[i][1]);        
                ans.add(interval);
            }
        }
        
        // creating the final answer
        int[][] finalAns = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++){
            finalAns[i][0] = ans.get(i).get(0);
            finalAns[i][1] = ans.get(i).get(1);
        }
        
        return finalAns;
        
    }
}