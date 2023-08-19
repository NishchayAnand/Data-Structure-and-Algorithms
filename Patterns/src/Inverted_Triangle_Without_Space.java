import java.util.Scanner;

/*
    Problem Statement: Given the number of row count, print an inverted triangle without any space.
    				   For n = 5,
    
            			********* -> i = 0, nsp = 0 [i], nst = 9 [(5-0)*2-1]  
            			_*******  -> i = 1, nsp = 1 [i], nst = 7 [(5-1)*2-1] 
            			__*****   -> i = 2, nsp = 2 [i], nst = 5 [(5-2)*2-1]  
            			___***    -> i = 3, nsp = 3 [i], nst = 3 [(5-3)*2-1] 
            			____*     -> i = 4, nsp = 4 [i], nst = 1 [(5-4)*2-1] 
            
    General Observation:
    1. We can set nsp = 0 and nst = 2*n-1 (nth odd number) in the start and [increment nsp by 1, decrement nst 
       by 2] in each iteration.
    2. Another approach is to use nsp = i and nst = 2*(n-i)-1 in each iteration. NOTE: For this, it is better 
       to start from i = 0.
*/

public class Inverted_Triangle_Without_Space {
	
	// utility function for approach 1.
	public static void printRow(int nsp, int nst){
        for(int j=1; j<=nsp; j++){
            System.out.print(" ");
        }
        for(int j=1; j<=nst; j++){
            System.out.print("*");
        }
        System.out.println();
    }

	// approach 1.
    public static void printTriangleApproach1(int n) {
        int nsp = 0, nst = 2*n-1;
        for(int i=1; i<=n; i++){
            printRow(nsp, nst);
            nsp++;
            nst-=2;
        }
    }
    
    // approach 2.
    public static void printTriangleApproach2(int n) {
        for(int i=0; i<n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=((n-i)*2-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter the number of rows: ");
		int n = scn.nextInt();
		System.out.println();
		
		// Approach 1
		// printTriangleApproach1(n);
		
		// Approach 2
		printTriangleApproach2(n);
		
		scn.close();

	}

}
