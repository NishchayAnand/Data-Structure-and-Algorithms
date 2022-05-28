import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter no. of rows of matrix 1: ");
	    int n1 = scn.nextInt();
	    System.out.print("Enter no. of columns of matrix 1: ");
	    int m1 = scn.nextInt();

	    int[][] A = new int[n1][m1];
	    for(int r=0; r<n1; r++){
	        for(int c=0; c<m1; c++){
	        	System.out.print(" Enter A["+r+"]["+c+"]: ");
	            A[r][c]=scn.nextInt();
	        }
	    }

	    System.out.print("\nEnter no. of rows of matrix 2: ");
	    int n2 = scn.nextInt();
	    System.out.print("Enter no. of columns of matrix 2: ");
	    int m2 = scn.nextInt();

	    if(m1!=n2){
	        System.out.println("\nInvalid input (row-column mismatch)");
	        scn.close();
	        return;
	    }

	    int[][] B = new int[n2][m2];
	    for(int r=0; r<n2; r++){
	        for(int c=0; c<m2; c++){
	        	System.out.print(" Enter B["+r+"]["+c+"]: ");
	            B[r][c]=scn.nextInt();
	        }
	    }
	    
	    int[][] C = new int[n1][m2];
	    for(int r=0; r<n1; r++) {
	    	for(int c=0; c<m2; c++) {
	    		C[r][c]=0;
	    		for(int i=0; i<m1; i++) {
	    			C[r][c]+=A[r][i]*B[i][c];
	    		}
	    	}
	    }
	    
	    System.out.println("\nElements of C are:");
	    for(int r=0; r<n1; r++) {
	    	for(int c=0; c<m2; c++) {
	    		System.out.print(C[r][c]+" ");
	    	}
	    	System.out.println();
	    }
	    
	    scn.close();

	}

}
