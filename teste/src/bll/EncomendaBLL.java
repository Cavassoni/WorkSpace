package bll;

import dao.EncomendaDAO;
import entity.Encomenda;

import java.util.List;

public class  EncomendaBLL implements IBLL <Encomenda> {

        @Override
	public int salvar(Encomenda objeto) {
		EncomendaDAO encomendaDAO = new EncomendaDAO();
		return  encomendaDAO.salvar(objeto);
	}

}