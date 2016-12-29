package view;

import java.awt.List;
import java.util.Scanner;

import bll.ClienteBLL;
import enity.Cliente;

public class ClienteView {
	public void gerenciar(){
		int op=0, codigo;
		
		Scanner input=new Scanner(System.in);
		List dados=null;
		Cliente objeto=null;
		ClienteBLL controle =new ClienteBLL();
	
		do{
			System.out.println("Gerenciar Cliente");
			System.out.println("1- Cadastrar");
			System.out.println("2- Alterar");
			System.out.println("3- Listar");
			System.out.println("4- Excluir");
			System.out.println("0- Sair");
			op = input.nextInt();
			
			switch (op) {
			case 1:
				objeto = new Cliente();
				
				System.out.println("Nome: ");
				objeto.setNome(input.next());
				
				System.out.println("Idade: ");
				objeto.setIdade(input.nextInt());
				
				System.out.println("Sexo: ");
				objeto.setSexo(input.next());	
				
				System.out.println("Telefone: ");
				objeto.setTelefone(input.nextInt());
				
				System.out.println("Email: ");
				objeto.setEmail(input.next());	
				
				System.out.println("CPF: ");
				objeto.setCpf(input.nextInt());	
				
				controle.salvar(objeto);
				break;
			}
			
			
		}while(op!=0);
	}
}
