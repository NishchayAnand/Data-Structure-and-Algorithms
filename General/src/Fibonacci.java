import java.util.Scanner;

public class Fibonacci {
	
	/*
	public static int fibo(int num) {
		
		if(num==1 || num == 2) {
			System.out.print((num-1)+" ");
			return (num-1);
		}
		
		int next = fibo(num-1) + fibo(num-2);
		System.out.print(next+" ");
		return next;
		
	}
	*/
	
	public static void printFibonacci(int num) {
		
		int first = 0;
		int second = 1;
		int next;
		System.out.print(first + " " + second + " ");
		
		for(int i=3; i<=num; i++) {
			
			next = first + second;
			System.out.print(next+" ");
			first = second;
			second = next;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.print("Enter the number of elements you want to display in fibonacci series: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println("Using Iterative method");
		printFibonacci(num);
		
		System.out.println("\nUsing Recursive method");
		
		sc.close();
	}

}
