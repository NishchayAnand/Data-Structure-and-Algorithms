import java.util.Scanner;

public class LastAndFirstIndexBInarySearch {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = scn.nextInt();
		
		int[] A = new int[size];
		System.out.println("\nPlease provide the elements of the array.");
		for(int i=0; i<size; i++) {
			System.out.print("Enter element "+(i+1)+" :");
			A[i] = scn.nextInt();
		}
		
		System.out.print("\nEnter a number: ");
		int n = scn.nextInt();
		
		int fpos=-1, lpos=-1;
		
		// finding first occurrence
		int start=0, end=size-1, mid;
		while(start<=end) {
			
			mid=(start+end)/2;
			
			if(n>A[mid]) { // means it will lie ahead of mid
				start=mid+1;
			} else if(n<A[mid]) { // means it will lie behind the mid
				end=mid-1;
			} else {
				fpos=mid;
				end=mid-1;
			}
		}
		
		// finding last occurrence
		start=0;
		end=size-1;
		while(start<=end) {
			
			mid=(start+end)/2;
			
			if(n>A[mid]) { // means it will lie ahead of mid
				start=mid+1;
			} else if(n<A[mid]) { // means it will lie behind the mid
				end=mid-1;
			} else {
				lpos=mid;
				start=mid+1;
			}
		}
		
		System.out.println("\nFirst occurrence of "+n+" :"+fpos);
		System.out.println("Last occurrence of "+n+" :"+lpos);
		
		scn.close();

	}

}
