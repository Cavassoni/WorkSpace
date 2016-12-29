package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Pedido;
import entity.PedidoProduto;

public class PedidoProdutoDAO implements IDAO<PedidoProduto> {

	public Object salvar(PedidoProduto objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {

			sql = "insert into pedido_produto(cod_pedido, cod_produto) value(?, ?);";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodPedido());
			sqlParametro.setInt(2, objeto.getCodProduto());

			sqlParametro.execute();

			sql = "select last_insert_id() as cod_pedido_produto";
			sqlParametro = conexao.prepareStatement(sql);

			resultado = sqlParametro.executeQuery();
			if (resultado.next()) {
				objeto.setCodPedido(resultado.getInt("cod_pedido_produto"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			objeto.setResult(false);
			return objeto;
		}

		finally {
			try {
				sqlParametro.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
				objeto.setResult(false);
				return objeto;
			}
		}
		objeto.setResult(true);
		return objeto;
	}

	public List<PedidoProduto> listar(PedidoProduto objeto) {

		Connection conexao = new Conexao().geraConexao();
		List<PedidoProduto> lista = new ArrayList<PedidoProduto>();
		Statement consulta = null;
		ResultSet resultado = null;
		String sql;
		try {
			sql = "select * from cliente join endereco where cod_cliente = cod_cliente_endereco or cod_cliente = 0;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {

				objeto = new PedidoProduto();
				objeto.setCodPedido(resultado.getInt("cod_pedido"));
				objeto.setCodProduto(resultado.getInt("cod_produto"));

				lista.add(objeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public PedidoProduto buscarPorNome(String nome) {
		return null;

	}
	public PedidoProduto buscarPorCodigo(int codigo) {
		return null;
	}

	public boolean excluir(PedidoProduto objeto) {
		return false;
	}


}