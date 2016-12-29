package Revisao_2;

public class Retangulo implements AreaCalculavel {
	private double base,altura;
	public Retangulo(double base,double altura) {
		this.base=base;
		this.altura=altura;
	}
	@Override
	public double calcularArea() {
		return base*altura;
	}

}
