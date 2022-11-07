import java.util.ArrayList;

public class IntervalListIntersection {
	
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        int i=0, j=0;
        
        while(i<firstList.length && j<secondList.length){
            
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
            
            if (s1<=e2 && e1>=s2){
                int[] intersection = new int[2];
                intersection[0] = Math.max(s1, s2);
                intersection[1] = Math.min(e1, e2);
                ans.add(intersection);
            }
            
            if(e1<e2){
                i++;
            } else if(e2<e1){
                j++;
            } else {
                i++;
                j++;
            }
            
        }
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}