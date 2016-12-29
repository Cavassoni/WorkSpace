import java.util.Scanner;

public class Ex_1_21 {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		int l1,l2,l3;
		for(int i=0;i<5;i++){
			l1=lepositivo();
			l2=lepositivo();
			l3=lepositivo();
		
			System.out.println("0- não forma triangulo\n1- triangulo equilatero\n2- triangulo isósceles\n3- triangulo escaleno");
			System.out.println(tipoTriangulo(l1,l2,l3));
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

	public static int tipoTriangulo(int l1,int l2,int l3){
		if(!heTriangulo(l1,l2,l3))
			return 0;
		else if(l1==l2&&l1==l3&&l2==l3)
			return 1;
		else if(l1==l2&&l1!=l3||l1==l3&&l2!=l3)
			return 2;
		else return 3;
	}
	public static boolean heTriangulo(int l1,int l2,int l3){
		if(l1<(l2+l3)&&l2<(l1+l3)&&l3<(l1+l2))
			return true;
		else return false;
	}
}
