package Revisao_2;

public class Teste {
	public static void main(String[] args) {
	Quadrado q=new Quadrado(10);
	Triangulo t=new Triangulo(5, 2);
	Retangulo r=new Retangulo(2, 5);
	System.out.println("Area do Quadrado: "+q.calcularArea());
	System.out.println("Area do Retangulo: "+r.calcularArea());
	System.out.println("Area do Triangulo: "+t.calcularArea());
	}
}
