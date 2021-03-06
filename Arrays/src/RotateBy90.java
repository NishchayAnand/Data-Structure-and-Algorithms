import java.util.Scanner;

public class RotateBy90 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter dimension of square matrix: ");
	    int n = scn.nextInt();

	    int[][] A = new int[n][n];
	    
	    for(int r=0; r<n; r++){
	        for(int c=0; c<n; c++){
	        	System.out.print(" Enter A["+r+"]["+c+"]: ");
	            A[r][c]=scn.nextInt();
	        }
	    }
	    
	    int temp;
	    for(int r=0; r<n; r++){
	        for(int c=0; c<r; c++){
	        	temp = A[r][c];
	        	A[r][c] = A[c][r];
	        	A[c][r] = temp;
	        }
	    }
	    
	    int start, end; 
	    for(int r=0; r<n; r++){
	    	
	        start = 0;
	        end = A[0].length-1;
	        
	        while(start<end) {
	        	temp = A[r][start];
	        	A[r][start] = A[r][end];
	        	A[r][end] = temp;
	        	
	        	start++;
	        	end--;
	        	
	        }
	        
	    }
	    
	    System.out.println("Rotated matrix by 90 degree is given below: ");
	    for(int r=0; r<n; r++){
	        for(int c=0; c<n; c++){
	        	System.out.print(A[r][c]+" ");
	        }
	        System.out.println();
	    }
	     
	}

}
