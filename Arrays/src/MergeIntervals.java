import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Problem Statement: Given an array of intervals where intervals[i] = [starti, endi], merge all 
 * 					  overlapping intervals, and return an array of the non-overlapping intervals that 
 * 					  cover all the intervals in the input.
 *  
 * General Observations:
 * 
 * 	- 
 *  
 * */


class MergeIntervals {

    class Interval {

        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public int[][] merge(int[][] intervals) {

        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval: intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(intervalList, (obj1, obj2) -> Integer.compare(obj1.start, obj2.start));

        List<Interval> mergedList = new ArrayList<>();
        mergedList.add(intervalList.get(0));

        for(int i=1; i<intervalList.size(); i++) {

            Interval currInterval = intervalList.get(i);
            Interval lastMerged = mergedList.get(mergedList.size()-1);

            if(lastMerged.end >= currInterval.start) {
                lastMerged.end = Math.max(lastMerged.end, currInterval.end);
            } else {
                mergedList.add(currInterval);
            }

        }

        int[][] output = new int[mergedList.size()][2];
        for(int i=0; i<mergedList.size(); i++) {
            output[i][0] = mergedList.get(i).start;
            output[i][1] = mergedList.get(i).end;
        }

        return output;

    }
}