package Revisao;

public class Conta {
	private String nome;
	private int numero;
	private double saldo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double d) {
		this.saldo = d;
	}
	public double sacar(double valor){
		if(valor<=this.saldo){
			System.out.println("Saque efetuado com sucesso!");
			return this.saldo-valor;
		}else{
			return 0;
		}
	}
	public double depositar(double valor){
		return this.saldo+valor;
	}
	
}
