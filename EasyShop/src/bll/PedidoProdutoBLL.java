package bll;

import java.util.List;

import dao.ClienteDAO;
import dao.EncomendaDAO;
import dao.PedidoDAO;
import dao.PedidoProdutoDAO;
import entity.Cliente;
import entity.Encomenda;
import entity.Pedido;
import entity.PedidoProduto;

public class PedidoProdutoBLL implements IBLL<PedidoProduto> {

	public Object salvar(PedidoProduto objeto) {
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		return pedidoProdutoDAO.salvar(objeto);
	}

	public boolean excluir(PedidoProduto objeto) {
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		return pedidoProdutoDAO.excluir(objeto);
	}

	public List<PedidoProduto> listar(PedidoProduto objeto) {
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		return pedidoProdutoDAO.listar(objeto);
	}

	public PedidoProduto buscarPorNome(String nome) {
		return null;
	}
	public PedidoProduto buscarPorCodigo(int codigo) {
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		return pedidoProdutoDAO.buscarPorCodigo(codigo);
	}
}