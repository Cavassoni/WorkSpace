package bll;

import java.util.List;

import dao.ClienteDAO;
import entity.Cliente;

public class ClienteBLL implements IBLL<Cliente> {

	public Object salvar(Cliente objeto) {
		ClienteDAO ClienteDAO = new ClienteDAO();
		return ClienteDAO.salvar(objeto);
	}

	public boolean excluir(Cliente objeto) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.excluir(objeto);
	}

	public List<Cliente> listar(Cliente objeto) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listar(objeto);
	}

	public Cliente buscarPorNome(String nome) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscarPorNome(nome);
	}
	public Cliente buscarPorCodigo(int codigo) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscarPorCodigo(codigo);
	}
}