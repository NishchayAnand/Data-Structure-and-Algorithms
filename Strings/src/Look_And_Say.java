/*

    Problem Statement:
    
    - Given an integer N, for example N = 5, return the Nth row of the following pattern,
    
            1
            11
            21
            1211
            111221 -> return as a string.
            
    General Observations:
    
    - No way to straight away get the Nth row. 
    
    - We need the (N-1)th row to find Nth row. Hence, we may need to generate (N-1) rows before we can generate the Nth row.
    
    - The value of first row will always be "1".
    
    - Algorithm to generate the next row:
        - set output = ""
        - set prev_ch = str[0];
        - count = 1;
        - Loop over row characters from i = [1, size):
            - if curr_ch == prev_ch:
                - if yes, count++;
                - if no, append(count,prev_ch) to output, reset count=1, update prev_ch=curr_ch;
        - append(count, prev_ch) to output;
                
    - Debugging algorithm for 1 2 1 1:
        - i=1, output="", prev_ch="1", curr_ch="2", count=1 -> prev_ch != curr_ch -> output = "11", prev_ch="2", count=1;
        - i=2, output="11", prev_ch="2", curr_ch="1", count=1 -> prev_ch != curr_ch -> output = "1112", prev_ch="1", count=1;
        - i=3, output="1112", prev_ch="1", curr_ch="1", count=1 -> prev_ch == curr_ch -> count=2;
        - output="111221";

*/

public class Look_And_Say {
	
	private static String generateNextRow(String row){
        StringBuilder next_row = new StringBuilder("");
        char prev_ch = row.charAt(0);
        int freq = 1;
        for(int i=1; i<row.length(); i++){
            char curr_ch = row.charAt(i);
            if(curr_ch == prev_ch){
                freq++;
            } else {
                next_row.append(freq+""+prev_ch);
                prev_ch=curr_ch;
                freq=1;
            }
        }
        next_row.append(freq+""+prev_ch);
        return next_row.toString();
    }
    
    private static String lookandsay(int n) {
        String row = "1";
        for(int i=1; i<n; i++){
            row = generateNextRow(row);
        }
        
        return row;
    }

	public static void main(String[] args) {
		
		System.out.println(lookandsay(5));

	}

}
