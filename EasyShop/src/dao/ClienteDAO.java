package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Cliente;

public class ClienteDAO implements IDAO<Cliente> {

	public Object salvar(Cliente objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {

			sql = "insert into cliente(nome, email, cpf, telefone, senha) value(?, ?, ?, ?, ?);";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setString(1, objeto.getNome());
			sqlParametro.setString(2, objeto.getEmail());
			sqlParametro.setInt(3, objeto.getCpf());
			sqlParametro.setInt(4, objeto.getTelefone());
			sqlParametro.setString(5, objeto.getSenha());

			sqlParametro.execute();

			sql = "select last_insert_id() as cod_cliente";
			sqlParametro = conexao.prepareStatement(sql);

			resultado = sqlParametro.executeQuery();
			if (resultado.next()) {
				objeto.setCodCliente(resultado.getInt("cod_cliente"));
			}


			sql = "insert into endereco(cod_cliente_endereco, cidade, bairro, rua, estado, numero) value(?, ?, ?, ?, ?, ?);";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodCliente());
			sqlParametro.setString(2, objeto.getCidade());
			sqlParametro.setString(3, objeto.getBairro());
			sqlParametro.setString(4, objeto.getRua());
			sqlParametro.setString(5, objeto.getUf());
			sqlParametro.setInt(6, objeto.getNumero());

			sqlParametro.executeUpdate();

			sql = "select last_insert_id() as id_endereco";
			sqlParametro = conexao.prepareStatement(sql);

			resultado = sqlParametro.executeQuery();

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

	public boolean excluir(Cliente objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		try {
			sql = "delete from endereco where cod_cliente_endereco = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodCliente());
			sqlParametro.executeUpdate();

			sql = "delete from cliente where cod_cliente = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodCliente());
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

	public List<Cliente> listar(Cliente objeto) {

		Connection conexao = new Conexao().geraConexao();
		List<Cliente> lista = new ArrayList<Cliente>();
		Statement consulta = null;
		ResultSet resultado = null;
		String sql;
		try {
				sql = "select * from cliente join endereco where cod_cliente = cod_cliente_endereco;";
				consulta = conexao.createStatement();
				resultado = consulta.executeQuery(sql);
				
			while (resultado.next()) {
				
				objeto = new Cliente();
				
				objeto.setNome(resultado.getString("nome"));
				objeto.setEmail(resultado.getString("email"));
				objeto.setCpf(resultado.getInt("cpf"));
				objeto.setTelefone(resultado.getInt("telefone"));
				objeto.setSenha(resultado.getString("senha"));
				objeto.setCidade(resultado.getString("cidade"));
				objeto.setBairro(resultado.getString("bairro"));
				objeto.setRua(resultado.getString("rua"));
				objeto.setUf(resultado.getString("estado"));
				objeto.setNumero(resultado.getInt("numero"));

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

	public Cliente buscarPorNome(String nome) {

		Connection conexao = new Conexao().geraConexao();
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Cliente objeto = null;
		String sql;
		try {
			sql = "select * from cliente where nome = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setString(1, nome);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Cliente();

				objeto.setCodCliente(resultado.getInt("cod_cliente"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setEmail(resultado.getString("email"));
				objeto.setCpf(resultado.getInt("cpf"));
				objeto.setTelefone(resultado.getInt("telefone"));
				objeto.setSenha(resultado.getString("senha"));

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
	public Cliente buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Cliente objeto = null;
		String sql;
		try {
			sql = "select * from cliente where cod_cliente = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Cliente();

				objeto.setCodCliente(resultado.getInt("cod_cliente"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setEmail(resultado.getString("email"));
				objeto.setCpf(resultado.getInt("cpf"));
				objeto.setTelefone(resultado.getInt("telefone"));
				objeto.setSenha(resultado.getString("senha"));

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
}