package bll;

import java.util.List;

import dao.PreferenciaDAO;
import entity.Preferencia;

public class PreferenciaBLL implements IBLL<Preferencia> {

	@Override
	public Object salvar(Preferencia objeto) {
		PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
		return preferenciaDAO.salvar(objeto);
	}

	@Override
	public List<Preferencia> listar(Preferencia objeto) {
		PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
		return preferenciaDAO.listar(objeto);
	}

	@Override
	public boolean excluir(Preferencia objeto) {
		return false;
	}

	@Override
	public Preferencia buscarPorNome(String nome) {
		return null;
	}

	

}
