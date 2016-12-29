package bll;

import java.util.*;

import dao.FuncionarioDAO;
import entity.Funcionario;

public class FuncionarioBLL implements IBLL<Funcionario> {

	public int salvar(Funcionario objeto) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.salvar(objeto);
	}

	public boolean excluir(Funcionario objeto) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.excluir(objeto);
	}

	public List<Funcionario> listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.listar();
	}

	public Funcionario buscarPorCodigo(int codigo) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.buscarPorCodigo(codigo);
	}

}