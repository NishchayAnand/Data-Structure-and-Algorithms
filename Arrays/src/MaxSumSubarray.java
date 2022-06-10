import java.util.Scanner;

public class MaxSumSubarray {
	
	public static void approach1(int[] A, int size) {
		
		int globalmax = Integer.MIN_VALUE;
		int spos=-1, epos=-1;
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<=size; j++) {
				int localmax = 0;
				for(int k=i; k<j; k++) {
					localmax+=A[k];
				}
				if(localmax>globalmax) {
					spos = i;
					epos = j-1;
					globalmax = localmax;
				}
			}
		}
		
		System.out.println("Max sum:"+globalmax);
		System.out.println("Starting index:"+spos);
		System.out.println("Ending index: "+epos);
		
	}
	
	public static void approach2(int[] A, int size) {
		
		int globalmax = Integer.MIN_VALUE;
		int spos=-1, epos=-1;
		
		for(int i=0; i<size; i++) {
			
			int localmax = 0;
			for(int j=i; j<size; j++) {
				
				localmax+=A[j];
				
				if(localmax>globalmax) {
					spos = i;
					epos = j;
					globalmax = localmax;
				}
				
			}
			
		}
		
		System.out.println("Max sum:"+globalmax);
		System.out.println("Starting index:"+spos);
		System.out.println("Ending index: "+epos);
		
	}
	
	public static void approach3(int[] A, int size) {
		
		int globalmax = A[0];
		int localmax = A[0];
		int[] lpos = {0, 0};
		int[] gpos = {0, 0};
		//int[] gpos = lpos; -> this will cause the gpos to point at memory location of lpos
							//  hence, it will give local max coordinates rather than the global 
							//  max coordinates
		
		for(int i=1; i<size; i++) {
			
			int subArraySum = localmax+A[i];
				
			if(subArraySum>A[i]) {
				localmax = subArraySum;
				lpos[1] = i;
			} else {
				localmax = A[i];
				lpos[0] = i;
				lpos[1] = i;
			}
			
			if(localmax>globalmax) {
				globalmax = localmax;
				gpos[0] = lpos[0];
				gpos[1] = lpos[1];
			}
				
		}
		
		System.out.println("Max sum:"+globalmax);
		System.out.println("Starting index:"+gpos[0]);
		System.out.println("Ending index: "+gpos[1]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scn.nextInt();
		
		System.out.println();
		int[] A = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter Element at index "+i+": ");
			A[i] = scn.nextInt();
		}
		
		// O(n^3) solution
		System.out.println();
		approach1(A, size);
		
		// O(n^2) solution
		System.out.println();
		approach2(A, size);
		
		// O(n) solution (kadane's algorithm)
		System.out.println();
		approach3(A, size);
		
		scn.close();
		
	}

}
