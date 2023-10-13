
/* Problem Statement: Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The 
 * 					  objective of the puzzle is to move the entire stack from rod A to rod B using rod C
 * 					  as an auxiliary rod, obeying the following simple rules:
 * 
 *						1. Only one disk can be moved at a time.
 *						2. A disk can only be moved if it is the uppermost disk on a stack.
 *						3. No disk may be placed on top of a smaller disk. 
 *
 * General Observations:
 * 
 * 	- Hypothesis: toh(n, A, B, C) will move n disks from rod A to rod B using rod C as auxiliary rod.
 * 
 *  - Recursive Steps: Considering only 1 disk can be moved at a time (largest disk),
 *  
 *   						- perform toh(n-1, A, C, B) to move the top (n-1) disks from rod A to auxiliary
 *   						  rod C using rod B (as auxiliary).
 *   
 *    						- move nth disk from rod 1 to rod 2.
 *    
 *    						- perform toh(n-1, C, B, A) to move back the (n-1) disks from auxiliary rod C
 *    						  to rod B using rod A (as auxiliary).
 *    
 *    - Base Condition: n = 0, i.e., when no disks are left to be moved.  
 * 
 * */


public class TowerOfHanoi {
	
	private static long count=0;
    
    private static void move(int N, char from, char to, char aux){
        if(N==0){
            return;
        }
        move(N-1, from, aux, to);
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        count++;
        move(N-1, aux, to, from);
    } 

	public static void main(String[] args) {
		move(3, 'A', 'B', 'C');
        System.out.println("Number of moves performed: "+count);
	}

}
