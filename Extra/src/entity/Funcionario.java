package entity;

public class Funcionario {

	private int cod_funcionario;
	private String nome;
	private String funcao;
	private int idade;
	private double salario;

	public int getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(int idfuncionario) {
		this.cod_funcionario = idfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
