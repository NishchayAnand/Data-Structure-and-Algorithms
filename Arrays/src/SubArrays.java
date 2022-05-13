import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {
	
	public static ArrayList<List<Integer>> getSubArrays(ArrayList<Integer> arr) {
		
		ArrayList<List<Integer>> output = new ArrayList<List<Integer>>();
		
		for(int start=0;start<arr.size(); start++) {
			for(int end=start+1; end<=arr.size();end++) {
				output.add(arr.subList(start, end));
			}	
			
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3}));
		System.out.println(getSubArrays(arr));
		
	}

}
