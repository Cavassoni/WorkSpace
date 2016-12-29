package Revisao_2;

public class Triangulo implements AreaCalculavel {
	private double base,altura;
	
	public Triangulo(double altura,double base) {
		this.altura=altura;
		this.base=base;
	}
	@Override
	public double calcularArea() {
		return (base*altura)/2;
	}
	
}
