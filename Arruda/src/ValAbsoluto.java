import java.util.Scanner;

public class ValAbsoluto {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println("Informe o numero: ");
			System.out.println(valAbsoluto(input.nextInt()));
			
		}
	}
	public static int valAbsoluto(int val){
		return Math.abs(val);
	}
}
