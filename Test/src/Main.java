import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// convert string to character array.
		String name = "Nishchay";
		char[] arr = name.toCharArray();
		
		
		// convert character array to string.
		String ans = new String(arr);
		System.out.println(ans);
		
		// convert character to integer.
		char ch1 = '2';
		int num =  ch1 - '0';
		System.out.println(num);
		
		// convert string to integer
		String str = "234";
		int num2 = Integer.parseInt(str);
		System.out.println(num2);
		
		// convert character to uppercase
		char upper = Character.toUpperCase('a');
		System.out.println(upper);
		
		// convert string to upper case.
		String upp = name.toUpperCase();
		System.out.println(upp);
		
		char ch2  = 'A' + 1;
		System.out.println(ch2);
		
		double i = 7*1.0/3;
		System.out.println(i);
	}

}
