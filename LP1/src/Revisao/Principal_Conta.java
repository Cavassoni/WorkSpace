package Revisao;

import java.util.Scanner;

public class Principal_Conta {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Conta c = new Conta();
		System.out.println("Informe o nome: ");
		c.setNome(input.next());
		System.out.println("Informe o numero da Conta: ");
		c.setNumero(input.nextInt());
		System.out.println("Informe o saldo: ");
		c.setSaldo(input.nextDouble());
		int op = 0;
		do {
			System.out.println("----------MENU----------\n1 - Depositar\n2 - Sacar\n3 - Sair");
			op=input.nextInt();
			switch (op) {
			case 1:
				System.out.println("Informe o valor a ser depositado: ");
				c.depositar(input.nextDouble());
				break;
			case 2:
				System.out.println("Informe o valor que deseja sacar: ");
				c.sacar(input.nextDouble());
			default:
				break;
			}
		} while (op != 3);
	}
}
