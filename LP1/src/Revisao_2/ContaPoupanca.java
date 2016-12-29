package Revisao_2;

public class ContaPoupanca implements Tributavel {

	private double saldo;

	public ContaPoupanca(double saldo) {
		this.saldo=saldo;
	}
	@Override
	public double calculaTributos(boolean seguro) {
		if(seguro)
			return saldo-32;
		else return saldo;
	}

}
