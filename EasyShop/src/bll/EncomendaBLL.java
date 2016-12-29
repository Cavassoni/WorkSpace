package bll;

import dao.EncomendaDAO;
import entity.Encomenda;
import entity.Login;

import java.util.List;

public class EncomendaBLL implements IBLL<Encomenda> {

	@Override
	public Object salvar(Encomenda objeto) {
		EncomendaDAO encomendaDAO = new EncomendaDAO();
		return encomendaDAO.salvar(objeto);
	}

	public boolean excluir(Encomenda objeto) {
		EncomendaDAO encomendaDAO = new EncomendaDAO();
		return encomendaDAO.excluir(objeto);
	}

	public List<Encomenda> listar(Encomenda objeto) {
		EncomendaDAO encomendaDAO = new EncomendaDAO();
		return encomendaDAO.listar(objeto);
	}

	public Encomenda buscarPorCodigo(int codigo) {
		EncomendaDAO encomendaDAO = new EncomendaDAO();
		return encomendaDAO.buscarPorCodigo(codigo);
	}

	@Override
	public Encomenda buscarPorNome(String nome) {
		EncomendaDAO encomendaDAO = new EncomendaDAO();
		return encomendaDAO.buscarPorNome(nome);
	}

}