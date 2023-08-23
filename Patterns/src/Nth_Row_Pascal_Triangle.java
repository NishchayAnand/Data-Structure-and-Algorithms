import java.util.ArrayList;
import java.util.List;

/* Problem Statement: Given n, return an ArrayList containing all the elements of the nth row of pascal's 
 * 					  triangle.
 * */

/* General Observations:

- For n = 4, 
             1       -> n = 1, number of digits = 1
             1 1     -> n = 2, number of digits = 2
             1 2 1   -> n = 3, number of digits = 3
             1 3 3 1 -> n = 4, number of digits = 4
             
 - First and last element of each row of pascal's triangle is equal to 1.
 
 - Brute Force: Generate next row using the previous row for (N-1) times.
 
 -           1(0C0)                      -> n = 1, number of digits = 1
             1(1C0) 1(1C1)               -> n = 2, number of digits = 2
             1(2C0) 2(2C1) 1(2C2)        -> n = 3, number of digits = 3
             1(3C0) 3(3C1) 3(3C2) 1(3C3) -> n = 4, number of digits = 4
             
 - nCr = n!/r!(n-r)! => n!/r!(n-r)(n-r-1)!
 
 - nCr+1 = n!/(r+1)!(n-r-1)! => n!/(r+1)r!(n-r-1)!
 
 - nCr+1/nCr = (n-r)/(r+1) => nCr = nCr-1*(n-r+1)/(r)

 - n-1Cr = n-1Cr-1*(n-1-r+1)/r -> (n-1Cr-1*(n-r))/(r)
 
*/

public class Nth_Row_Pascal_Triangle {
	
	private static List<Integer> generateNextRowUsingPrevious(List<Integer> prev){
        
        List<Integer> next = new ArrayList<Integer>();
        next.add(1);
        
        for(int i=1; i<prev.size(); i++){ // time complexity = O(N-1) ~ O(N)
            next.add((prev.get(i)+prev.get(i-1)));
        }
        
        next.add(1);
        
        return next; // space complexity = O(N+1) ~ O(N)
        
    }
    
	private static List<Integer> generateNextRowUsingBinomialCoefficients(int n){
        
        List<Integer> next = new ArrayList<Integer>();
        int element = 1;
        next.add(element);
        
        for(int r=1; r<=(n-1); r++){ // time complexity = O(N-1) ~ O(N)
            element = (element*(n-r))/r;
            next.add(element);
        }
           
        return next; // space complexity = O(N+1) ~ O(N)
        
    }

	public static void main(String[] args) {
		
		// input
		int numRows = 6;
		
		List<List<Integer>> rows = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);

        rows.add(row);
        
        for(int i=2; i<=numRows; i++){ // time complexity = O(N-1) ~ O(N)
            //row = generateNextRowUsingPrevious(row); // time complexity = O(N)
            row = generateNextRowUsingBinomialCoefficients(i); // time complexity = O(N)
            rows.add(row); // O(N*2)
        } // time complexity = O(N*2)
        
        System.out.println(rows);

	}

}
