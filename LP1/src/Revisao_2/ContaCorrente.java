package Revisao_2;

public class ContaCorrente implements Tributavel{
	private double saldo;
	public ContaCorrente(double saldo) {
		this.saldo=saldo;
	}
	@Override
	public double calculaTributos(boolean seguro) {
		if(seguro)
			return (saldo*0.0115)-32;
		else return saldo*0.0115;
	}
	
	

}
