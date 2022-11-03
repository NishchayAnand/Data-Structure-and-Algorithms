import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MeetingRooms {
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        Collections.sort(A, (a,b) -> {return a.get(0)-b.get(0);} );
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(A.get(0).get(1));
        
        for(int i=1; i<A.size(); i++){
            ArrayList<Integer> currentMeeting = A.get(i);
            int quickestMeetingEndTime = pq.peek();
            if(quickestMeetingEndTime <= currentMeeting.get(0)){
                pq.remove();
            }
            pq.add(currentMeeting.get(1));
        }
        
        return pq.size();
        
    }
}