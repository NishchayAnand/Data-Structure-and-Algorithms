import java.util.ArrayList;

public class PermutationsWithSpaces {
	
	public static void getPermutations(String input, String permutation, ArrayList<String> output) {
		
		if(input.length()==0) {
			output.add(permutation);
			return;
		}
		
		getPermutations(input.substring(1), permutation + input.charAt(0), output);
		getPermutations(input.substring(1), permutation + " " + input.charAt(0), output);
		
	}

	public static void main(String[] args) {
		
		// Initialization
		String input = "ABC";
		ArrayList<String> permutations = new ArrayList<String>();

		// Processing
		String output = input.substring(0,1);
		input = input.substring(1);
		
		// get all possible permutations
		getPermutations(input, output, permutations);
		
		// print the possible permutations
		System.out.println(permutations);
		
	}

}
