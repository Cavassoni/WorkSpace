package bll;

import java.util.List;

import dao.ClienteDAO;
import dao.EncomendaDAO;
import dao.PedidoDAO;
import entity.Cliente;
import entity.Encomenda;
import entity.Pedido;

public class PedidoBLL implements IBLL<Pedido> {

	public Object salvar(Pedido objeto) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.salvar(objeto);
	}

	public boolean excluir(Pedido objeto) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.excluir(objeto);
	}

	public List<Pedido> listar(Pedido objeto) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.listar(objeto);
	}

	public Pedido buscarPorNome(String nome) {
		return null;
	}
	public Pedido buscarPorCodigo(int codigo) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.buscarPorCodigo(codigo);
	}
	public boolean alterar(Pedido objeto) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.alterar(objeto);
	}
}