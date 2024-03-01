
/* Problem Statement: 
 * 
 * 	- Given an m x n input array where:
 * 
 * 		 - "left" and "top" edges mark the Pacific Ocean
 * 		 - "right" and "bottom" edges mark the Atlantic Ocean. 
 * 
 * 	- Each cell in the input array represent is a piece of island. The value in each cell denotes the 
 * 	  height of that piece of land above sea level.
 * 
 * 	- From a given 'cell', rain water can flow to its neighboring cells (i.e., cells "up", "below", 
 *    "right" and "left" of the current 'cell') if:
 *    		- "neighboring cell's value" <= "current cell's value". 
 * 
 * 	- Return a 2-D list of coordinates from where rain water can flow, i.e., "connected" to both the 
 * 	  Pacific and Atlantic Oceans.
 * 
 * General Observations:
 * 
 * 	- Approach 1:
 * 
 * 		- For any 'cell':
 *  		- use DFS to check if any of its neighbour is connected to both the Pacific and Atlantic 
 *  		  Oceans, 
 *  		- then the 'cell' is connected to both the Pacific and Atlantic Oceans.
 *  
 *  - Approach 2 (think of it as a Graph problem):
 * 
 * 		- All cells on the "left" and "top" edge are connected to the Pacific Ocean.
 * 
 * 		- All cells on the "right" and "bottom" edge are connected to the Atlantic Ocean. 
 *    
 *  	- A cell is connected to both Pacific and Atlantic Oceans if it is connected (directly/indirectly)
 *  	  to [a ("left" || "top") edge cell] && [a ("right" || "bottom") edge cell].
 *    
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  - Can we check if a cell is connected to a [("left" || "top") edge cell] && 
 *    [("right" || "bottom") edge cell] simultaneously?
 *   
 *    
 *  - Brute Force Approach:
 *  
 *  	- Iterate over each cell:
 *  
 *  		- isPacificReachable = DFStoPacific(cell);
 *  		- isAtlanticReachable = DFStoAtlantic(cell);
 *  
 *  		- if isPacificReachable == TRUE && isAtlanticReachable == TRUE:
 *  			- output.add(cell);
 *    
 *  - Approach:
 *  
 *  	- Iterate over input and check what all cells can reach the pacific ocean.
 *  	- Iterate over input and check what all cells can reach the atlantic ocean.
 *  	- Take the itersection of above 2 checks. 
 * 
 * */




public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {

	}

}
