package a;

import java.util.Scanner;

public class prova {
	public static void main(String[] args) {
		int mat[][] = new int[10][10];
		int vet[] = new int [5];
		int maisAparece=0, menosAparece=0, vezes=0;
		Scanner entrada = new Scanner(System.in);
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				mat[i][j] = (int) (Math.random()*9+1);
			}
		}
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<5; i++){
			System.out.println("informe o valor: ");
			vet[i] = entrada.nextInt();
		}
		maisAparece = vet[0];
		menosAparece = vet[0];
		int a=0;
		do{
			vezes=0;
			for(int i=0; i<5; i++){
				for(int j=0; j<5; j++){
					if(mat[i][j]==vet[a]){
						vezes++;
					}
				}
			}
			if(vezes >= maisAparece){
				maisAparece = vet[a];
			}
			if(vezes <= menosAparece){
				menosAparece = vet[a];
			}
			System.out.println("o valor "+vet[a]+" apareceu "+vezes+" vezes");
			a++;
		}while(a<5);
		
		System.out.println("valor que mais aparece: "+maisAparece);
		System.out.println("valor que menos aparece: "+menosAparece);
		
		
		
	}
}
