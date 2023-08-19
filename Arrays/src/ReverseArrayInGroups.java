import java.util.ArrayList;

public class ReverseArrayInGroups {

	void reverseSubArray(ArrayList<Integer> arr, int start, int end) {
		while(start<end) {
			int temp = arr.get(start);
			arr.set(start, arr.get(end));
			arr.set(end, temp);

			start++;
			end--;
		}
	}

	// Function to reverse every sub-array group of size k.
	void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		int start = 0;
		int end = start + (k-1);
		while(end<n) {
			reverseSubArray(arr, start, end);
			start = start + k;
			end = start + (k-1);
		}
		if(start<n-1) {
			reverseSubArray(arr, start, n-1);
		}
	}
	
}