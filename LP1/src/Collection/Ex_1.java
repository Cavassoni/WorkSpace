package Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex_1 {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList dados=new ArrayList<>();
		String op="s";
		while(op.equalsIgnoreCase("s")){
			System.out.println("Informe nome: ");
			dados.add(input.next());
			System.out.println("Novo nome (s/n)?");
			op=input.next();
		}
		
		Iterator it=dados.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("Digite um nome: ");
		String nome=input.next();
		int pos=0;
		it=dados.iterator();
		while(it.hasNext()){
			if(nome.equalsIgnoreCase(it.toString())){
				System.out.println("Nome= "+it.next()+"\nPosição= "+pos);
			}
			it.next();
			pos++;
		}
	}
}
