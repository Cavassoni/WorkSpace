package bll;

import dao.ClienteDAO;
import entity.Cliente;
import java.util.List;

public class  ClienteBLL implements IBLL <Cliente> {

        @Override
	public int salvar(Cliente objeto) {
		ClienteDAO ClienteDAO = new ClienteDAO();
		return  ClienteDAO.salvar(objeto);
	}

}