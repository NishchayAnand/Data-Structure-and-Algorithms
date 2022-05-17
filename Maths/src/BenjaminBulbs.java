import java.util.Scanner;

/* Problem statement: 
 * 	- You are given n number of bulbs in switched off state.
 * 	- Voltage fluctuation will toggle the bulbs n times in the following pattern:
 * 		- in the 1st fluctuation all bulbs are toggled.
 * 		- in the 2nd fluctuation every 2nd bulb is toggled
 * 		- in the 3rd fluctuation every 3rd bulb is toggled 
 * 		- and so on.
 * 	- Print all the bulbs that will be in the switched ON state after all the voltage fluctuations.
 * 
 * General Observations:
 * 	- All the bulbs toggled odd number of times will in the switched ON state.
 * 	- A perfect square has odd number of factors. 
 * 
 * */

public class BenjaminBulbs {
	
	public static void printOnBulbs(int n) {
		
		boolean[] arr = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = true;
        }

        for(int i=2; i<=n; i++){
            for(int j=i-1; j<n; j+=i){
                arr[j] = !arr[j];
            }
        }

        for(int i=0; i<n; i++){
            if(arr[i]){
                System.out.print((i+1)+" ");
            }
        }
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number of toggles: ");
        int n = scn.nextInt();
        
        System.out.print("Using Conventional method:");
        printOnBulbs(n);
        
        System.out.print("\nUsing Perfect square logic:");
        for(int i=1; i*i<=n; i++) {
        	System.out.print((i*i)+" ");
        }
        
        scn.close();

	}

}
