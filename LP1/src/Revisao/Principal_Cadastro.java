package Revisao;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal_Cadastro {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Pessoa> dados = new ArrayList<Pessoa>();
		int op = 5;
		String nome;
		do {
			System.out.println("Informe a opção desejada:\n" + "1 - para criar uma nova pessoa;\n"
					+ "2 - para exibir os dados de todas as pessoas cadastradas;\n"
					+ "3 - para consultar os dados de uma pessoa;\n" + "4 - para excluir uma pessoa.\n5 - Sair");
			op = input.nextInt();
			switch (op) {
			case 1:
				novoCadastro(dados);
				break;
			case 2:
				exibir(dados);
				break;
			case 3:
				System.out.println("Informe o nome a ser exibido: ");
				nome=input.next();
				consultar(dados,nome);
				break;
			case 4:
				System.out.println("Informe o nome a ser exibido: ");
				nome=input.next();
				excluir(dados,nome);
				break;
			}
		} while (op != 5);

	}

	public static void novoCadastro(ArrayList<Pessoa> dados) {
		Pessoa p=new Pessoa();
		
		System.out.print("Nome: ");
		p.setNome(input.next());
		
		System.out.print("Email: ");
		p.setEmail(input.next());
		
		System.out.print("RG: ");
		p.setRg(input.nextInt());
		
		System.out.print("Telefone: ");
		p.setTel(input.nextInt());
		
		dados.add(p);
	}

	public static void exibir(ArrayList<Pessoa> dados){
		for(int i=0;i<dados.size();i++){
			Pessoa p;
			p=dados.get(i);
			System.out.println("Nome: "+p.getNome());
			System.out.println("Email: "+p.getEmail());
			System.out.println("RG: "+p.getEmail());
			System.out.println("Telefone: "+p.getTel());
		}
	}
	public static void consultar(ArrayList<Pessoa> dados,String nome){
		for(int i=0;i<dados.size();i++){
			Pessoa p;
			p=dados.get(i);
			if(nome.equalsIgnoreCase(p.getNome())){
			System.out.println("Nome: "+p.getNome());
			System.out.println("Email: "+p.getEmail());
			System.out.println("RG: "+p.getEmail());
			System.out.println("Telefone: "+p.getTel());
			}
		}
	}
	public static void excluir(ArrayList<Pessoa> dados,String nome){
		for(int i=0;i<dados.size();i++){
			Pessoa p;
			p=dados.get(i);
			if(nome.equalsIgnoreCase(p.getNome())){
				dados.remove(i);
			}
		}
	}
}
