
public class Look_And_Say {
	
	private static StringBuilder generateNextPattern(StringBuilder pattern){
		
		// next look and say pattern.
        StringBuilder nextPattern = new StringBuilder("");
        
        // get the first character in the current pattern.
        int prevNum = pattern.charAt(0) - '0';
        // set the frequency of the first character.
        int count = 1;
        
        for (int i=1; i<pattern.length(); i++) {
        	
        	// get the current character from the current pattern.
        	int currNum = pattern.charAt(i) - '0'; 
        	
        	// if the current character is equal to the previous character in the current pattern,
        	if(currNum == prevNum) {
        		count++; // just increase the frequency.
        	} else {
        		nextPattern.append(count + "" + prevNum); // append the frequency and character from the previous subsequence.
        		count = 1; // reset the frequency for the next subsequence.
        		prevNum = currNum; // make the current character as the previous character.
        	}
         
        }
        
        // append the frequency and character for the last subsequence.
        nextPattern.append(count+""+prevNum);
        
        return nextPattern;
    }
    
    private static String lookandsay(int n) {
    	// first look and say pattern.
        StringBuilder pattern = new StringBuilder("1");
        
        // run the loop for (n-1) times.
        for(int i=1; i<=n-1; i++){
            pattern = generateNextPattern(pattern);
        }
        
        return pattern.toString();
        
    }

	public static void main(String[] args) {
		
		System.out.println(lookandsay(5));

	}

}
