
public class Test1 {

	public static void main(String[] args) {

		int[] arr = {1,2,3};
		
		int[] copy = arr;
		
		arr = new int[3];
		
		for(int el: copy) {
			System.out.print(el+",");
		}
		System.out.println();
		
		for(int el: arr) {
			System.out.print(el+",");
		}
		
		

	}

}
