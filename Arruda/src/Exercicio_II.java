import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercicio_II {

	static Scanner dados = new Scanner(System.in);
	public static int registros = 0;
	public static int tamanho_reg = 0;

	public static void main(String[] args) {

		cadastrarDisciplina();
	}

	public static void cadastrarDisciplina() {
		int op = 0;
		String disciplina = "";
		System.out.println("Informe o nome da disciplina: ");
		disciplina = dados.next();
		File arquivo = new File(disciplina + ".txt");

		try {

			if (arquivo.exists()) { // se o arquivo existir
				System.out.println("Disciplina já existe. Deseja sobrescrevê-la?(1-S/2-N)");
				op = dados.nextInt();
				if (op == 1) {
					FileWriter writer = new FileWriter(disciplina + ".txt");
				} else if (op == 2) {
					menu();
				}
			}

			if (!arquivo.exists()) { // se não existir o arquivo
				arquivo.createNewFile(); // cria o arquivo
				System.out.println("Arquivo criado com sucesso!");
			}

		} catch (IOException erro) {
			System.out.println("Erro cadastro!" + "\n" + erro.toString());
		}
		cadastrarNotas(arquivo);
	}

	public static void menu() {

		System.out.println("-----------MENU-----------");
		System.out.println("1 - Cadastrar Disciplinas");
		System.out.println("2 - Listar Disciplinas");
		System.out.println("3 - Cadastrar Notas");
		System.out.println("4 - Listar Notas");
		System.out.println("5 - Alterar Nota");
		System.out.println("6 - Sair");
	}

	public static void listarDisciplina() {
		File file = new File("C:\\Users\\Lorena\\workspace\\Exercicio Avaliativo II");
		File[] arquivos = file.listFiles();

		System.out.println();
		System.out.println("\tDisciplinas Cadastradas: " + "\n");

		for (File fileTmp : arquivos) {
			if (fileTmp.getName().endsWith(".txt")) {
				System.out.println("\t" + fileTmp.getName());
			}
		}

	}

	public static void cadastrarNotas(File arquivo) {
		String d = "";
		String linha = "";
		int cod = 0, nota = 0;
		String nome;

		File teste; 
		do{
			System.out.println("Informe o nome da disciplina: ");
			d = dados.next() + ".txt";
			teste = new File(d);
			if (!arquivo.equals(teste)) {
				System.out.println("Arquivo não existe!");
			}
		} while(!arquivo.equals(teste));
		try {
			System.out.println("Informe o código do aluno: ");
			cod = dados.nextInt();
			System.out.println("Informe o nome do aluno: ");
			nome = dados.next();
			System.out.println("Informa a nota do aluno: ");
			nota = dados.nextInt();
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bf = new BufferedWriter(fw);
			bf.write(cod + " | " + nome + " | " + nota);
			bf.newLine();
			bf.flush();
			bf.close();
			fw.close();
			
		} catch (IOException e) {
			System.out.println("Erro notas!");
		}

	}

	public static void alterarNota(RandomAccessFile arq, int codigo) {
		String disciplina = "";
		int nova_nota = 0;

		System.out.println("Informe o nome da disciplina: ");
		disciplina = dados.next();
		System.out.println("Informe a nota nota: ");
		nova_nota = dados.nextInt();

		try {
			int posleitura;
			posleitura = codigo * tamanho_reg;
			posleitura = posleitura + 3;

			arq.seek(posleitura);
			arq.writeInt(nova_nota);

		} catch (IOException e) {
			System.out.println("Erro alterar!");
			System.exit(1);
		}
	}

	public static void fechaArquivo(RandomAccessFile arq) {

		try {
			arq.close();
		} catch (IOException e) {

		}
	}
}
