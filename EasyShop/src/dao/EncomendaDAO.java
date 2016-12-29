package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Conexao;
import entity.Cliente;
import entity.Encomenda;
import entity.Login;

public class EncomendaDAO implements IDAO<Encomenda> {


	public Object salvar(Encomenda objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {
				sql = "insert into encomenda(cod_item, nome_item, cod_cliente, nome_cliente, descricao) value(?, ?, ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, objeto.getCodItem());
				sqlParametro.setString(2, objeto.getNomeItem());
				sqlParametro.setInt(3, objeto.getCodCliente());
				sqlParametro.setString(4, objeto.getNomeCliente());
                sqlParametro.setString(5, objeto.getDescricao());

                
				sqlParametro.executeUpdate();
				
				sql = "select last_insert_id() as cod_encomenda";
				sqlParametro = conexao.prepareStatement(sql);
				
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					objeto.setCodEncomenda(resultado.getInt("cod_encomenda"));
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
	
	public boolean excluir(Encomenda objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from encomenda where cod_encomenda = ? and cod_cliente = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodEncomenda());
			sqlParametro.setInt(2, objeto.getCodCliente());
			sqlParametro.executeUpdate();
		} catch (SQLException e) {
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

	public List<Encomenda>  listar(Encomenda objeto) {

		Connection conexao = new Conexao().geraConexao();
		List<Encomenda> lista = new ArrayList<Encomenda>();
		PreparedStatement sqlParametro = null;
		Statement consulta = null;
		ResultSet resultado = null;
		String sql;
		try {
			if (objeto.getCodCliente() != 0) {
			sql = "select * from encomenda where cod_cliente = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodCliente());
			resultado = sqlParametro.executeQuery();
			}else{
				sql = "select * from encomenda";
				consulta = conexao.createStatement();
				resultado = consulta.executeQuery(sql);
			}
			while (resultado.next()) {
				
				objeto = new Encomenda();
				objeto.setCodEncomenda(resultado.getInt("cod_encomenda"));
				objeto.setNomeItem(resultado.getString("nome_item"));
				objeto.setCodItem(resultado.getInt("cod_item"));
				objeto.setNomeCliente(resultado.getString("nome_cliente"));
				objeto.setDescricao(resultado.getString("descricao"));
				
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

	public Encomenda buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
        List<Encomenda> lista = new ArrayList<Encomenda>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Encomenda objeto = null;
		String sql;
		try {
			sql = "select * from encomenda where cod_encomenda = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Encomenda();
				
				objeto.setCodEncomenda(resultado.getInt("cod_encomenda"));
				objeto.setNomeItem(resultado.getString("nome_item"));
				objeto.setCodItem(resultado.getInt("cod_item"));
				objeto.setNomeCliente(resultado.getString("nome_cliente"));
				objeto.setCodCliente(resultado.getInt("cod_cliente"));
				objeto.setDescricao(resultado.getString("descricao"));
				
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

	@Override
	public Encomenda buscarPorNome(String nome) {
		return null;
	}

}