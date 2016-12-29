package view;

import java.util.Scanner;


public class PrincipalView {

	public static void main(String[] args) {
		int opcao;
		
		Scanner teclado = new Scanner(System.in);
		
		do 
		{ 
			System.out.println("Controle da Empresa");
			System.out.println("Opções");		
			System.out.println("1 - Gerenciar Funcionario");	
			System.out.println("0 - Sair");
			System.out.println("\nDigite sua opção: ");
			opcao = teclado.nextInt();
			
			switch (opcao)
			{  
				case 1:  
					FuncionarioView funcionario = new FuncionarioView();
					funcionario.Gerenciar();
					break;
					
				default:
					System.out.println("Opção inválida.");
				break;					
			}

		} 
		while (opcao != 0);
		
	}
}




