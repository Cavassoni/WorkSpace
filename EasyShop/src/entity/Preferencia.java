package entity;

public class Preferencia {
	private int codPreferencia, codCliente;
	private String modelo, cor, marca;
	private float valorAte;
	private boolean result;

	public int getCodPreferencia() {
		return codPreferencia;
	}

	public void setCodPreferencia(int codPreferencia) {
		this.codPreferencia = codPreferencia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getValorAte() {
		return valorAte;
	}

	public void setValorAte(float valorAte) {
		this.valorAte = valorAte;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
}
