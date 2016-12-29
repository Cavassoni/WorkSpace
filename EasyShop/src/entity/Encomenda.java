package entity;

public class Encomenda {
	private String descricao, nomeItem, nomeCliente;
	private int codItem, codCliente, codEncomenda;
	private boolean result;

	public int getCodItem() {
		return codItem;
	}

	public void setCodItem(int idItem) {
		this.codItem = idItem;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int idCliente) {
		this.codCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getCodEncomenda() {
		return codEncomenda;
	}

	public void setCodEncomenda(int codEncomenda) {
		this.codEncomenda = codEncomenda;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
