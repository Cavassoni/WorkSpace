package Revisao;

public class Ex_3 {
	public static void main(String[] args) {
		int vet[]=new int[10],media=0,c=0,b=0;
		for(int i=0;i<10;i++){
			vet[i]=(int)(Math.random()*100);
			media+=vet[i];
			if(vet[i]>=60){
				c++;
			}else{
				b++;
			}
		}
		System.out.println("Media: "+media/10+"\nNotas Azuis: "+c+"\nNotas Vermelhas: "+b);
	}
}
