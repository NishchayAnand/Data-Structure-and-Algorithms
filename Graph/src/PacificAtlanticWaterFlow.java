
/* Problem Statement: 
 * 
 * 	- Given an m x n input array where:
 * 		 - "left" and "top" edges mark the Pacific Ocean
 * 		 - "right" and "bottom" edges mark the Atlantic Ocean. 
 * 
 * 	- Each cell in the input array represent is a piece of island. The value in each cell denotes the 
 * 	  height of that piece of land above sea level.
 * 
 * 	- Rain water can flow to neighboring cells directly {"up", "bottom", "right", "left"} if the 
 *    neighboring cell's value is less than or equal to the current cell's value. 
 * 
 * 	- Return a list of coordinates from where rain water can flow to both the Pacific and Atlantic oceans.
 * 
 * General Observations:
 *    
 *  - Water can flow from a 'cell' to both the Pacific and and Atlantic Oceans only if water can flow 
 *    from any of its adjacent cells to both the Pacific and and Atlantic Oceans. 
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
