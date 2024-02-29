
/* Problem Statment: 
 * 
 * 		- Given a 2-D array of size n x n filled with 0, 1, 2, 3 such that:
 * 
 * 			- a cell with value = '1' represent the 'source' cell.
 * 			- a cell with value = '2' represent the 'destination' cell.
 * 			- cells with value = '3' represent cells which can be traversed.
 * 			- cells with value = '0' represent cells which can't be traversed.
 * 
 * 		- Check if there is a path possible from the 'source' cell to the 'destination' cell.
 *  
 *  	- NOTE: 
 *  		- There is only 1 'source' cell and 1 'destination' cell in the entire input array.
 *  		- You can traverse 'up', 'down', 'right' and 'left', conditon being that the traversal is 
 *  		  possible.
 * 
 * General Observations:
 * 
 * 	- If 2 vertices of a graph are connected to each other (directly or indirectly), depth-first-search 
 *    from one of the vertex will surely visit the other vertex.
 * 
 * 	- Approach:
 * 		
 * 		- Perform Depth-First-Search on the 'source' cell to check see if we can reach the 'destination' 
 * 		  cell.
 * 
 *  - Hypothesis:
 *  	
 *  	- F(arr, r, c, visited)
 * 
 * 
 * */

public class FindWhetherPathExists {

	public static void main(String[] args) {
		

	}

}
