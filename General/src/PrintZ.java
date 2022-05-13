
public class PrintZ {

	public static void main(String[] args) {
		
		int size = 5;
        for(int i=0; i<size;i++){
            if(i==0 || i==size-1){
                for(int j=0; j<size;j++){
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for(int j=0; j<size-i-1;j++){
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }

	}

}
