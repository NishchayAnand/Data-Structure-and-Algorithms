import java.util.ArrayList;

public class Subsets {
	
	public static void stringSubsets(String input, String subset, ArrayList<String> subsets) {
		
		if(input.length()==0) {
			subsets.add(subset);
			return;
		}
		
		stringSubsets(input.substring(1), subset, subsets);
		stringSubsets(input.substring(1), subset+input.charAt(0), subsets);
	}

	public static void main(String[] args) {
		
		String str = "abc";
		ArrayList<String> subsets = new ArrayList<String>();
		stringSubsets(str, "", subsets);
		System.out.println(subsets);
		
	}

}
