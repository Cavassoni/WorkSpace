package enity;

public class Funcionario extends Pessoa{
	public Funcionario(String nome,int rg,int cpf,int telefone,
			String bairro,String cidade,String uf,String email) {
	}
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	private int  idFuncionario;
	private int idEmpresa;
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}	

}
