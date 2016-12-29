import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.bind.helpers.PrintConversionEventImpl;

public class Ex_Arquivos {

	public static void main(String[] args) {
		ArrayList<String> vet = new ArrayList<>();
		String caminho = "C:\\Users\\lkvas\\Downloads\\teste.txt";
		String linha = "";
		FileReader arquivo;
		BufferedReader leitor;
		int aux = 0;
		int palavra = 0;

		try {

			arquivo = new FileReader(caminho);
			leitor = new BufferedReader(arquivo);
			linha = leitor.readLine();

			while (linha != null) {
				adicionaPalavras(vet, linha);
				palavra += contaPalavras(linha);
				System.out.println(linha);
				for (int i = 0; i < linha.length(); i++) { // contando
															// caracteres sem
															// contar os espaços
					if (linha.charAt(i) != ' ') {
						aux++;
					}
				}
				linha = leitor.readLine();
//				vet.add(linha);
			}
			
			
			
			System.out.println("\nQuantidade de caracteres: " + aux);
			System.out.println("\nQuantidade de palavras: " + palavra);
			
			for(int i=0;i<vet.size();i++){
				System.out.println(vet.get(i)+" ");
			}
			
			leitor.close();

		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

	public static int contaPalavras(String linha) {
		int aux = 0;
		boolean lendopalavra = false;
		for (int i = 0; i < linha.length(); i++) {
			char c = linha.charAt(i);

			if (!Character.isLetter(c)) {
				if (lendopalavra == true) {
					aux++;
					lendopalavra = false;
				}

			} else {
				lendopalavra = true;
			}

		}
		if (lendopalavra == true) {
			aux++;
		}
		return aux;
	}

	public static ArrayList<String> adicionaPalavras(ArrayList<String> vet, String linha) {
		String palavra = "";
		int i=0;
		char ch;
		while(i<linha.length()){
			ch=linha.charAt(i);
			if(!Character.isSpaceChar(ch)){	
				while(!Character.isSpaceChar(ch)){
					if(Character.isLetter(ch))
					palavra+=ch;
					i++;
					if(i<linha.length())
						ch=linha.charAt(i);
					else break;
				}
			}else{
				i++;
			}
			if(!palavra.equals("")){
				if(!vet.contains(palavra))
				vet.add(palavra);
			}
				
			palavra="";
		}		

		System.out.println(palavra);
		return vet;

	}

}
