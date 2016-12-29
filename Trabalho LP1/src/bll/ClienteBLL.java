package bll;

import java.util.List;

import dao.ClienteDAO;
import enity.Cliente;

public class ClienteBLL implements IBLL<Cliente> {

	@Override
	public int salvar(Cliente objeto) {
		ClienteDAO clienteDAO=new ClienteDAO();
		return clienteDAO.salvar(objeto);
	}

	@Override
	public boolean excluir(Cliente objeto) {
		ClienteDAO clienteDAO=new ClienteDAO();
		return clienteDAO.excluir(objeto);
	}

	@Override
	public List<Cliente> listar() {
		ClienteDAO clienteDAO=new ClienteDAO();
		return clienteDAO.listar();
	}

	@Override
	public Cliente buscarPorCodigo(int codigo) {
		ClienteDAO clienteDAO=new ClienteDAO();
		return clienteDAO.buscarPorCodigo(codigo);
	}
	
}
