package bll;

import java.util.List;

import dao.UsuarioDAO;
import entity.Usuario;

public class UsuarioBLL implements IBLL<Usuario> {

	public Object salvar(Usuario objeto) {
		UsuarioDAO ClienteDAO = new UsuarioDAO();
		return ClienteDAO.salvar(objeto);
	}

	public boolean excluir(Usuario objeto) {
		UsuarioDAO clienteDAO = new UsuarioDAO();
		return clienteDAO.excluir(objeto);
	}

	public List<Usuario> listar() {
		UsuarioDAO clienteDAO = new UsuarioDAO();
		return clienteDAO.listar();
	}

	public Usuario buscarPorCodigo(int codigo) {
		UsuarioDAO clienteDAO = new UsuarioDAO();
		return clienteDAO.buscarPorCodigo(codigo);
	}
	
	public Object alterar(Usuario objeto) {
		UsuarioDAO ClienteDAO = new UsuarioDAO();
		return ClienteDAO.alterar(objeto);
	}
}