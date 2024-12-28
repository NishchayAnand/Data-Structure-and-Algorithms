import java.util.ArrayList;
import java.util.Arrays;

// insert an element into a sorted array

public class Insertion {
	
	public static void insert(ArrayList<Integer> arr, int num){
		
		if( arr.size()==0 || arr.get(0)>=num) {
			arr.add(0, num);
			return;
		}
		
		int temp = arr.remove(0);
		insert(arr, num);
		arr.add(0, temp);
		
	}
	
	public static void main(String args[]) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[] {0,2,7,10}));
		insert(arr, 5);
		System.out.println(arr);
		
	}

}
