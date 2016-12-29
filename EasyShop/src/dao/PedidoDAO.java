package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Pedido;

public class PedidoDAO implements IDAO<Pedido> {

	public Object salvar(Pedido objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {

			sql = "insert into pedido(cod_cliente) value (?);";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodCliente());
			sqlParametro.execute();

			sql = "select last_insert_id() as cod_pedido";
			sqlParametro = conexao.prepareStatement(sql);

			resultado = sqlParametro.executeQuery();
			if (resultado.next()) {
				objeto.setCodPedido(resultado.getInt("cod_pedido"));
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

	// ----------------------------------------------------------//

	public boolean excluir(Pedido objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from pedido_produto where cod_pedido = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodPedido());
			sqlParametro.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} try{
			sql = "delete from pedido where cod_pedido = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodPedido());
			sqlParametro.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
				teste = true;
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return teste;
	}

	public List<Pedido> listar(Pedido objeto) {

		Connection conexao = new Conexao().geraConexao();
		List<Pedido> lista = new ArrayList<Pedido>();
		PreparedStatement sqlParametro = null;
		Statement consulta = null;
		ResultSet resultado = null;
		String sql;
		try {
			if(objeto.getCodCliente() != 0){
			sql = "select * from pedido p join pedido_produto pp on p.cod_pedido = pp.cod_pedido where p.cod_cliente = ? group by p.cod_pedido order by p.cod_pedido;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodCliente());
			resultado = sqlParametro.executeQuery();
			}else{
				sql = "select * from pedido p join pedido_produto pp on p.cod_pedido = pp.cod_pedido group by p.cod_pedido order by p.cod_pedido;";
				consulta = conexao.createStatement();
				resultado = consulta.executeQuery(sql);
			}
			while (resultado.next()) {

				objeto = new Pedido();
				objeto.setCodPedido(resultado.getInt("cod_pedido"));
				objeto.setCodProduto(resultado.getInt("cod_produto"));
				objeto.setValorTotal(resultado.getFloat("valor_total"));

				lista.add(objeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (objeto.getCodCliente() != 0) {
				try {
					sqlParametro.close();
					conexao.close();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			} else {
				try {
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
		return lista;
	}

	public Pedido buscarPorNome(String nome) {

		Connection conexao = new Conexao().geraConexao();
		List<Pedido> lista = new ArrayList<Pedido>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Pedido objeto = null;
		String sql;
		try {
			sql = "select * from pedido where nome = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setString(1, nome);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Pedido();

				objeto.setCodPedido(resultado.getInt("cod_pedido"));
				objeto.setCodCliente(resultado.getInt("cod_cliente"));
				objeto.setCodProduto(resultado.getInt("cod_produto"));
				objeto.setValorTotal(resultado.getFloat("valor_total"));

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
		return objeto;
	}
	public Pedido buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		List<Pedido> lista = new ArrayList<Pedido>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Pedido objeto = null;
		String sql;
		try {
			sql = "select * from pedido where cod_Pedido = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Pedido();

				objeto.setCodPedido(resultado.getInt("cod_pedido"));
				objeto.setCodCliente(resultado.getInt("cod_cliente"));
				objeto.setValorTotal(resultado.getFloat("valor_total"));

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
		return objeto;
	}

	public boolean alterar(Pedido objeto) {
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		try {

			sql = "update pedido set valor_total = ? where cod_pedido = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setFloat(1, objeto.getValorTotal());
			sqlParametro.setInt(2, objeto.getCodPedido());

			sqlParametro.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
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

}