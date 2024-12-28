import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {
	
	public static void sort(ArrayList<Integer> arr) {
		
		if(arr.size() == 1) {
			return;
		}
		
		int temp = arr.remove(arr.size()-1);
		sort(arr);
		Insertion.insert(arr, temp);
	}

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[] {7,5,2,10,1}));
		sort(arr);
		System.out.println(arr);
	}

}
