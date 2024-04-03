
/* Problem Statement: Given a positive number, swap any two digits of number that have the same parity.
 * 					  Return the largest possible value of number after any number of swaps.
 * 
 * General Observations:
 * 
 * 		For n = 65875,
 * 
 * 			   {0 1 2 3 4}
 * 				6 5 8 7 5
 * 
 * 				6 5 8 7 5, -> i = 0, curr = 6 -> j = [2, 4], max = 8, max_idx = 2, swap(i, max_idx)
 * 				8 5 6 7 5, -> i = 1, curr = 5 -> j = [3], max = 7, max_idx = 3, swap(i, max_idx)
 * 				8 7 6 5 5, -> i = 2, cuur = 6 -> j = [4], max = 6, max_idx = 2, X
 * 			    
 * */



public class Demo1 {
	
	public static void swap(char[] arr, int i, int j) {
		char ch = arr[i];
		arr[i] = arr[j];
		arr[j] = ch;
	}
	
	public static int solve(int num) {
		
		char[] arr = Integer.toString(num).toCharArray();
		
		for(int i=0; i<arr.length-2; i++) {
			
			int max_idx = i;
			
			for(int j=i+2; j<arr.length; j+=2) {
				if((arr[j]-'0') > (arr[max_idx]-'0')) {
					max_idx = j;
				}
			}
			
			if(max_idx != i) {
				swap(arr, i, max_idx);
			}
		}
		
		return Integer.parseInt(new String(arr));
		
	}

	public static void main(String[] args) {
		
		int num = 65875;
		
		System.out.println(solve(num));
		
	}

}
