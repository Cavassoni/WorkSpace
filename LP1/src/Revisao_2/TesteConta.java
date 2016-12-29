package Revisao_2;

import java.util.Scanner;

public class TesteConta {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		String op;
		ContaCorrente cc=new ContaCorrente(500);
		System.out.println("Conta Corrente");
		System.out.println("seguro de vida? s/n");
		op=input.next();
		if(op.equalsIgnoreCase("s"))
			System.out.println("valor tributado:"+cc.calculaTributos(true));
		else 
			System.out.println("valor tributado:"+cc.calculaTributos(false));
		ContaPoupanca cp=new ContaPoupanca(1000);
		
		System.out.println("\n\nConta Poupança");
		System.out.println("seguro de vida? s/n");
		op=input.next();
		if(op.equalsIgnoreCase("s"))
			System.out.println("valor tributado:"+cp.calculaTributos(true));
		else 
			System.out.println("valor tributado:"+cp.calculaTributos(false));
	}
}
