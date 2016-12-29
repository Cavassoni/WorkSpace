package Revisao;

import java.util.Scanner;

public class Ex_4 {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		int num=0,cont=0,media=0;
		do{
			System.out.println("Insira o valor: ");
			num=input.nextInt();
			if(num>=0){
				media+=num;
				cont++;
			}
		}while(num>=0);
		System.out.println("media: "+media/cont+"\ntotal:"+cont);
	}
}