package Revisao;

import java.util.Scanner;

public class Principal {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		Funcionario func=new Funcionario();
		System.out.print("Informe nome do funcion�rio: ");
		func.setNome(input.next());
		do{
		System.out.print("Informe valor da Hora: ");
		func.setValorHora(input.nextDouble());
		}while(func.getValorHora()==0);
		do{
		System.out.print("Informe quantidade de horas: ");
		func.setQuantHora(input.nextDouble());
		}while(func.getQuantHora()==0);
		
		System.out.println("O sal�rio do funcio�rio "+func.getNome()+" � R$ "+func.getQuantHora()*func.getValorHora());
	}
}
