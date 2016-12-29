package Revisao;

public class Funcionario {
	private String nome;
	private double valorHora=0;
	private double quantHora=0;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		if(verifica(valorHora)){
			this.valorHora = valorHora;
		}else{
			System.out.println("Valor inválido");
		}
	}
	public double getQuantHora() {
		return quantHora;
	}
	public void setQuantHora(double quantHora) {
		if(verifica(quantHora)){
			this.quantHora = quantHora;
		}else{
			System.out.println("Valor inválido");
		}
	}
	private boolean verifica(double hora){
		if(hora>=0)
		return true;
		else return false;
	}
	
}
