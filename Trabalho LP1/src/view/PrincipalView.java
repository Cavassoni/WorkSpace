package view;

import java.util.Scanner;

public class PrincipalView {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int op=0;
	
		
		do 
		{ 
			System.out.println("Controle da Empresa");
			System.out.println("1 - Gerenciar Cliente");	
			System.out.println("0 - Sair");
			System.out.println("\nDigite sua opção: ");
			op = input.nextInt();
			
			switch (op)
			{  
				case 1:  
					ClienteView cliente = new ClienteView();
					cliente.gerenciar();
					break;
					
				default:
					System.out.println("Opção Inválida.");
				break;					
			}

		} 
		while (op != 0);
	
	}
}
