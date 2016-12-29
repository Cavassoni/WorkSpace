package bll;

import java.util.List;

import dao.EncomendaDAO;
import dao.ProdutoDAO;
import entity.Produto;

public class ProdutoBLL implements IBLL<Produto>{

	@Override
	public Object salvar(Produto objeto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.salvar(objeto);
	}

	@Override
	public boolean excluir(Produto objeto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.excluir(objeto);
	}

	@Override
	public List<Produto> listar(Produto objeto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.listar(objeto);
	}
	
	public List<Produto> listarProduto(int codigo) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.listarProduto(codigo);
	}

	@Override
	public Produto buscarPorNome(String nome) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.buscarPorNome(nome);
	}
	
	public Produto buscarPorCodigo(int codigo) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.buscarPorCodigo(codigo);
	}
	
	
}
