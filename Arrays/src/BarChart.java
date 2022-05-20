import java.util.Scanner;

/* Problem Statement: 
 * 	- You are given an array. For example, A=[3,1,0,7,5]
 * 	- Print the bar graph as shown below:
 * 								
 * 					_ _ _ * _
 * 					_ _ _ * _
 * 					_ _ _ * *
 * 					_ _ _ * *
 * 					* _ _ * *
 * 					* _ _ * *
 * 					* _ _ * *
 * 
 * General Observation:
 * 	- Treat the output (grid) as a community of buildings.
 *  - Each index on the x-axis of the grid represents a building and each index on the y-axis 
 *    represents the different levels of the buildings.
 *  - On each level, we need to print * for every building that has a floor on that level. 
 * 
 * */

public class BarChart {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size = scn.nextInt();
		
		// Populate the array by taking input from user and calculate the max value.
		int[] A = new int[size];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<size; i++) {
			System.out.print("Enter element "+(i+1) + ": ");
			A[i] = scn.nextInt();
			if(A[i]>max) {
				max = A[i];
			}
		}
		
		// the the required output 
		// NOTE: Treat max as the floor under consideration. Move from highest floor to lowest floor.
		System.out.println("\nRequired output:");
		while(max>0) {
			for(int i=0; i<size; i++) {
				if(A[i]>=max) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			max--;
			System.out.println();
		}
		
		scn.close();
	
	}

}
