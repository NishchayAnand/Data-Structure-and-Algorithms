
/*
    Problem Statement: Given a number N, for example N = 3, print:
        
         j = 0   1   2   3   4
            ___________________
     i = 0 | 3 | 3 | 3 | 3 | 3 |
           |___|___|___|___|___|
         1 | 3 | 2 | 2 | 2 | 3 |
           |___|___|___|___|___|
         2 | 3 | 2 | 1 | 2 | 3 |
           |___|___|___|___|___|
         3 | 3 | 2 | 2 | 2 | 3 |
           |___|___|___|___|___|
         4 | 3 | 3 | 3 | 3 | 3 |
           |___|___|___|___|___|
           
    General Observations: 
    
    - Number of rows = number of columns = dimension = 2*N-1 (Nth odd number).
    
    - value at (i,j) = N - min(rows_above_i, rows_below_i, cols_to_left_of_j, cols_to_right_of_j) = N - min(i, dimension-i-1, j, dimension-j-1)
           
*/


public class Spiral_Number_Pattern {
	
	private static void printPattern(int N){
        int dim = 2*N-1;
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                int value = N - Math.min(Math.min(Math.min(i, dim-i-1), j), dim-j-1);
                System.out.print(value);
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
		printPattern(3);
	}

}
