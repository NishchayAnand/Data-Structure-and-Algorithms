
// Problem Statement: For a given value N, print reverse character bridge pattern.

/* General Observations:
    
        - For n = 5,
        
                0 1 2 3 4 5 6 7 8, columns = 2*n-1
                
                A B C D E D C B A  -> i = 0, noch = 5 (n-i)
                A B C D _ D C B A  -> i = 1, noch = 4 (n-i)
                A B C _ _ _ C B A  -> i = 2, noch = 3 (n-i)
                A B _ _ _ _ _ B A  -> i = 3, .
                A _ _ _ _ _ _ _ A  -> i = 4  .
                
        - Define the startCh = 'A'.
        - For each row, start with a character array initialized with ' '.
        - For kth row,
            - Loop from col_idx = [0, noch), put row[col_idx] = row[(columns - 1) - col_idx] = startCh + col_idx 
        
*/

public class Reverse_Character_bridge {
	
	private static String[] revCharBridge(int N) {
        
        String[] output = new String[N];
        
        int cols = 2*N-1;
        
        char[] row = new char[cols];
        
        char firstCh = 'A';
        
        for(int i=0; i<N; i++){
            
            for(int col_idx = 0; col_idx < cols; col_idx++){
                row[col_idx] = ' ';
            }
            
            int noch = (N-i);
            
            for(int col_idx = 0; col_idx < noch; col_idx++){
                row[col_idx] = row[(cols-1)-col_idx] = (char)(firstCh+col_idx);
            }
            
            output[i] = new String(row);
            
        }
        
        return output;
        
    }

	public static void main(String[] args) {
		
		String[] output = revCharBridge(5);
		
		for(int i = 0; i< output.length; i++) {
			System.out.println(output[i]);
		}

	}

}
