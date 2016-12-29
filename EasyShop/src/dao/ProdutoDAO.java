package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Conexao;
import entity.Preferencia;
import entity.Produto;

public class ProdutoDAO implements IDAO<Produto>{

	@Override
	public Object salvar(Produto objeto) {
		
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		
		try {
			
		sql = "insert into produto(nome_produto, qtd_estoque, descricao, valor, cor, marca) value (?, ?, ?, ?, ?, ?);";
		sqlParametro = conexao.prepareStatement(sql);
		sqlParametro.setString(1, objeto.getNomeProduto());
		sqlParametro.setInt(2, objeto.getQtdEstoque());
		sqlParametro.setString(3, objeto.getDescricao());
		sqlParametro.setFloat(4, objeto.getValor());
		sqlParametro.setString(5, objeto.getCor());
		sqlParametro.setString(6, objeto.getMarca());
			
		sqlParametro.execute();
		
		sql = "select last_insert_id() as cod_produto";
		sqlParametro = conexao.prepareStatement(sql);
		
		resultado = sqlParametro.executeQuery();
		if(resultado.next()){
			objeto.setCodProduto(resultado.getInt("cod_produto"));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
			objeto.setResult(false);
			return objeto;
		} finally {
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

	@Override
	public boolean excluir(Produto objeto) {
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		try {
			sql = "delete from produto where cod_produto = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodProduto());
			sqlParametro.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Produto> listar(Produto objeto) {
		
		Connection conexao = new Conexao().geraConexao();
		List<Produto> lista = new ArrayList<Produto>();
		Statement consulta = null;
		ResultSet resultado = null;
		String sql;
		try {
			sql = "select * from produto;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				
				objeto = new Produto();
				
				objeto.setCodProduto(resultado.getInt("cod_produto"));
				objeto.setNomeProduto(resultado.getString("nome_produto"));
				objeto.setQtdEstoque(resultado.getInt("qtd_estoque"));
				objeto.setDescricao(resultado.getString("descricao"));
				objeto.setCor(resultado.getString("cor"));
				objeto.setMarca(resultado.getString("marca"));
				objeto.setValor(resultado.getFloat("valor"));
				
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
	public List<Produto> listarProduto(int codigo) {
		
		Connection conexao = new Conexao().geraConexao();
		List<Produto> lista = new ArrayList<Produto>();
		ResultSet resultado = null;
		PreparedStatement sqlParametro = null;
		Produto objeto = null;
		String sql;
		try {
			sql = "select * from pedido_produto pp join pedido p on pp.cod_pedido = p.cod_pedido join produto pr on pp.cod_produto = pr.cod_produto where p.cod_pedido = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, codigo);
			sqlParametro.execute();
			resultado = sqlParametro.executeQuery();
			while (resultado.next()) {
				
				objeto = new Produto();
				
				objeto.setCodProduto(resultado.getInt("cod_produto"));
				objeto.setNomeProduto(resultado.getString("nome_produto"));
				objeto.setValor(resultado.getFloat("valor"));
				
				lista.add(objeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public Produto buscarPorNome(String nome) {
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Produto objeto = null;
		String sql;
		try {
			sql = "select * from produto where nome_produto = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setString(1, nome);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Produto();
				objeto.setCodProduto(resultado.getInt("cod_produto"));
				objeto.setNomeProduto(resultado.getString("nome_produto"));
				objeto.setQtdEstoque(resultado.getInt("qtd_estoque"));
				objeto.setDescricao(resultado.getString("descricao"));
				objeto.setCor(resultado.getString("cor"));
				objeto.setMarca(resultado.getString("marca"));
				objeto.setValor(resultado.getFloat("valor"));
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
		return objeto;
	}
	
	public Produto buscarPorCodigo(int codigo) {
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Produto objeto = null;
		String sql;
		try {
			sql = "select * from produto where cod_produto = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Produto();
				objeto.setCodProduto(resultado.getInt("cod_produto"));
				objeto.setNomeProduto(resultado.getString("nome_produto"));
				objeto.setQtdEstoque(resultado.getInt("qtd_estoque"));
				objeto.setDescricao(resultado.getString("descricao"));
				objeto.setCor(resultado.getString("cor"));
				objeto.setMarca(resultado.getString("marca"));
				objeto.setValor(resultado.getFloat("valor"));
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
		return objeto;
	}

}
