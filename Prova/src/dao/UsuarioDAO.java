package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Usuario;

public class UsuarioDAO implements IDAO<Usuario> {

	public Object salvar(Usuario objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {

			sql = "insert into usuario(nome, senha) value(?, ?);";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setString(1, objeto.getNome());
			sqlParametro.setString(2, objeto.getSenha());

			sqlParametro.execute();

			sql = "select last_insert_id() as cod_usuario";
			sqlParametro = conexao.prepareStatement(sql);

			resultado = sqlParametro.executeQuery();
			if (resultado.next()) {
				objeto.setCodigo(resultado.getInt("cod_usuario"));
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

	public boolean excluir(Usuario objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		try {
			sql = "delete from usuario where cod_usuario = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCodigo());
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

	public List<Usuario> listar() {

		Connection conexao = new Conexao().geraConexao();
		List<Usuario> lista = new ArrayList<Usuario>();
		Statement consulta = null;
		ResultSet resultado = null;
		Usuario objeto = null;
		String sql;
		try {
			sql = "select * from usuario where cod_usuario <> 1;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {

				objeto = new Usuario();
				objeto.setCodigo(resultado.getInt("cod_usuario"));
				objeto.setNome(resultado.getString("nome"));
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
		return lista;
	}

	public Usuario buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Usuario objeto = null;
		String sql;
		try {
			sql = "select * from usuario where cod_usuario = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Usuario();

				objeto.setCodigo(resultado.getInt("cod_usuario"));
				objeto.setNome(resultado.getString("nome"));
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
	
	public Object alterar(Usuario objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		try {

			sql = "update usuario set nome = ?, senha = ? where cod_usuario = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setString(1, objeto.getNome());
			sqlParametro.setString(2, objeto.getSenha());
			sqlParametro.setInt(3, objeto.getCodigo());

			sqlParametro.execute();

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
}