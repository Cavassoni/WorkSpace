package view;

import java.util.List;
import java.util.Scanner;

import bll.FuncionarioBLL;
import enity.Funcionario;


public class FuncionarioView{
	
	public void Gerenciar(){
		int opcao, codigo;
	
		Scanner teclado = new Scanner(System.in);
		List<Funcionario> objetos = null;
		Funcionario objeto = null;
		FuncionarioBLL controle = new FuncionarioBLL();
				
		do 
		{ 
			System.out.println("Gerenciar Funcionario");
			System.out.println("Opções");		
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Alterar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Listar");
			System.out.println("0 - Voltar");
			System.out.println("\nDigite sua opção: ");
			opcao = teclado.nextInt();
			
			switch (opcao)
			{
				
				case 1:  
					
					objeto = new Funcionario();
					
					System.out.println("Nome: ");
					objeto.setNome(teclado.next());
					System.out.println("RG: ");
					objeto.setRg(teclado.nextInt());	
					System.out.println("CPF: ");
					objeto.setCpf(teclado.nextInt());	
					System.out.println("Bairro ");
					objeto.setBairro(teclado.next());
					System.out.println("Cidade");
					objeto.setCidade(teclado.next());
					System.out.println("Estado");
					objeto.setUf(teclado.next());
					System.out.println("Telefone");
					objeto.setTelefone(teclado.nextInt());
					System.out.println("email");
					objeto.setEmail(teclado.next());
					
					
					controle.salvar(objeto);
					
					
					break;
						
					
				case 2: 
					
					
					break;
					
					
				case 3:
								
					break;					
					
				case 4:
				
					break;
					
				default:
					System.out.println("Opção inválida.");
				break;					
			}
			
			

		} 
		while (opcao != 0);
	}
}
