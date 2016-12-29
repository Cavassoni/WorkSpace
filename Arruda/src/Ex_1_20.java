import java.util.Scanner;

public class Ex_1_20 {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		int n1,n2;
		for(int i=0;i<5;i++){
			n1=lepositivo();
			n2=lepositivo();
			if(saoAmigos(n1,n2))
				System.out.println(n1+" e "+n2+" São Amigos");
			else 
				System.out.println(n1+" e "+n2+" Não São Amigos");
		}
	}
	public static int lepositivo(){
		int val;
		do{
			System.out.println("Informe o valor:");
			val=input.nextInt();
		}while(val<0);
		return val;
	}
	public static boolean saoAmigos(int n1,int n2){
		int soma1=0, soma2=0;
		for(int i=1;i<n1;i++){
			if(n1%i==0)
				soma1+=i;
		}
		for(int i=1;i<n2;i++){
			if(n2%i==0)
				soma2+=i;
		}
		if(n1==soma2&&n2==soma1)
			return true;
		else return false;
	}
}
