package Revisao;

public class Pessoa {
	private String nome,email;
	private int tel,rg;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public void imprimirDados(){
		System.out.println("Nome: "+getNome());
		System.out.println("Email: "+getNome());
		System.out.println("telefone: "+getNome());
		System.out.println("RG: "+getNome());
	}
	
}
