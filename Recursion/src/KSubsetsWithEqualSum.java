
import java.util.*;

/* Problem Statement: Given an array containing n distinct integers and a number k, print all 
 * 					  possible configurations of dividing the given array into k subsets such that
 * 					  the sum of all subsets is same.
 * 
 * General Observations:
 * 	- First problem is to divide the array into k subsets.
 * 	- [1][2,3] is same as [2,3][1] -> ordering of subsets doesn't matter.
 * 	- [1,2][3] is same as [2,1][3] -> ordering inside a subset doesn't matter.
 * 	- The problem boils down to finding combinations of k subsets that can be made using the given 
 *    array.
 *  - Thinking in terms of recursion, for any given recursive step, we can select one of the 
 *    available integers from the given array and place it in one the available slots (subsets).
 *  - To check if the given array can be divided into k subsets having equal sum:
 *  		- Option 1: Maintaining a found flag and set it to true in the base condition when you 
 *  		  find a possible configuration.
 *  		- Option 2:  		 
 *  				- Sum of integers will always be an integer.
 *  				- If array can be divided into k subsets each having equal sum = sm, then, sum
 *  				  of each subset will be equal to sm/k which will be an integer.
 *  				- If (sum_of_all_elements_in_input_array)%k == 0, means that the input array can
 *  				  be divided into k subsets having equal sum.*  
 *    
 * Dry Run:
 * 								__/__/__, A = [1,2,3,4,5,6]
 * 
 * 									1. Select 1 from A.
 * 									2. 1 can only come in slot 1.
 * 
 * 								1/__/__, A = [2,3,4,5,6]
 * 
 * 									1. Select 2 from A.
 * 									2. 2 can come in slot 1 and slot 2.
 * 
 * 					12/__/__, A = [3,4,5,6]		1/2/__, A = [3,4,5,6]
 * 
 * 				1. Select 3 from A.					1. Select 3 from A.
 * 				2. 3 can come slot 1 and slot 2		2. 3 can come in slot 1, slot 2 and slot 3
 * 						...									...
 * 
 * Algorithm:
 * 
 * - At each recursive step, we will select an integer from the given array and place it in all the 
 *   non-empty slots and the first empty slot.
 * 
 * - Hypothesis: solution(arr, curr_el_index, slots_filled_so_far, total_slots, subsetSum, ans) will
 * 				 be able to print all possible configurations.
 * 
 * - Recursive Step: 1. Loop over ans, i.e, from i=0 to i=ans.size()-1:
 * 
 * 							2. slot = ans.get(i);
 * 
 * 							3. if slot is not empty:
 * 								4. slot.add(arr[curr_el_index]);
 * 								5. subsetSum[i] += arr[curr_el_index];
 * 								6. solution(arr, curr_el_index+1, slots_filled_so_far, total_slots, subsetSum, ans);
 * 								7. slot.remove(Integer.valueOf(arr[curr_el_index]));
 * 								8. subsetSum[i] -= arr[curr_el_index];
 * 
 * 							9. else -> if slot is empty:
 * 								10. slot.add(arr[curr_el_index]);
 * 								11. subsetSum[i] += arr[curr_el_index];
 * 								12. slots_filled_so_far++;
 * 								13. solution(arr, curr_el_index+1, slots_filled_so_far, total_slots, subsetSum, ans);
 * 								14. slot.remove(Integer.valueOf(arr[curr_el_index]));								
 * 								15. subsetSum[i] -= arr[curr_el_index];
 * 								16. slots_filled_so_far--;
 * 								17. break;
 * 
 * - Base Conditions: 1. if k == 1, then arr is the required answer.
 * 
 * 					  2. if curr_el_index == arr.length: (all integers in arr have been visited)
 * 							 3. if slots_filled_so_far == total_slots (k) and isSubsetSumEqual(subset):
 * 								4. found = true; (global variable to mark that we have found one possible configuration).	
 * 								5. print all subsets in ans.
 * 							 6. return;
 * 							
 * */

public class KSubsetsWithEqualSum {

    public static boolean isEql(int[] subsetSum){
        
        for(int i=0; i<subsetSum.length-1; i++){
            if(subsetSum[i]!=subsetSum[i+1]){
                return false;
            }
        }
        
        return true;
        
    }

	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
		
		//Base condition
		if(vidx>=n){
		    if(ssssf == k && isEql(subsetSum)){
		        for(ArrayList<Integer> a: ans){
		            System.out.print(a+" ");
		        }
		        System.out.println();
		    }
		    return;
		}
		
		// recursive steps
		for(int i=0; i<ans.size(); i++){
		    
		    ArrayList<Integer> slot = ans.get(i);
		    
		    if(slot.size()!=0){
		        slot.add(arr[vidx]);
		        subsetSum[i] += arr[vidx];
		        solution(arr, vidx+1, n, k, subsetSum, ssssf, ans);
		        slot.remove(Integer.valueOf(arr[vidx]));
		        subsetSum[i] -= arr[vidx];
		    } else {
		        slot.add(arr[vidx]);
		        subsetSum[i] += arr[vidx];
		        ssssf++;
		        solution(arr, vidx+1, n, k, subsetSum, ssssf, ans);
		        slot.remove(Integer.valueOf(arr[vidx]));
		        subsetSum[i] -= arr[vidx];
		        ssssf--;
		        break;
		    }
		    
		}
	
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			scn.close();
			return;
		}
		
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k.
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			scn.close();
			return;
		}
		
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
		
		scn.close();
		
	}
	
}