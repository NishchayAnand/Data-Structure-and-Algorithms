
public class Look_And_Say {
	
	private static StringBuilder generateNextPattern(StringBuilder pattern){
		
        StringBuilder nextPattern = new StringBuilder("");
        
        int prevNum = pattern.charAt(0) - '0';
        int count = 1;
        
        for (int i=1; i<pattern.length(); i++) {
        	
        	int currNum = pattern.charAt(i) - '0'; 
        	
        	if(currNum == prevNum) {
        		count++;
        	} else {
        		nextPattern.append(count + "" + prevNum);
        		count = 1;
        		prevNum = currNum;
        	}
         
        }
        
        nextPattern.append(count+""+prevNum);
        
        return nextPattern;
    }
    
    private static String lookandsay(int n) {
        StringBuilder pattern = new StringBuilder("1");
        
        for(int i=1; i<n; i++){
            pattern = generateNextPattern(pattern);
        }
        
        return pattern.toString();
        
    }

	public static void main(String[] args) {
		
		System.out.println(lookandsay(5));

	}

}
