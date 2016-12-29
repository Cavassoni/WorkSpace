package dao;

import java.sql.*;
import java.util.*;

import entity.Funcionario;
import config.Conexao;

public class FuncionarioDAO implements IDAO<Funcionario> {

	public int salvar(Funcionario objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {

			if (objeto.getCod_funcionario() == 0) {

				sql = "insert into funcionario (nome,funcao,idade,salario) values (?,?,?,?);";
				sqlParametro = conexao.prepareStatement(sql);

				sqlParametro.setString(1, objeto.getNome());
				sqlParametro.setString(2, objeto.getFuncao());
				sqlParametro.setInt(3, objeto.getIdade());
				sqlParametro.setDouble(4, objeto.getSalario());

				sqlParametro.executeUpdate();

				sql = "select last_insert_id() as cod_funcionario";
				sqlParametro = conexao.prepareStatement(sql);

				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("cod_funcionario");
				}
			} else {

				sql = "update funcionario set nome = ?, funcao = ?, idade = ?, salario = ? where cod_funcionario = ?;";

				sqlParametro = conexao.prepareStatement(sql);

				sqlParametro.setString(1, objeto.getNome());
				sqlParametro.setString(2, objeto.getFuncao());
				sqlParametro.setInt(3, objeto.getIdade());
				sqlParametro.setDouble(4, objeto.getSalario());
				sqlParametro.setDouble(5, objeto.getCod_funcionario());

				sqlParametro.executeUpdate();
				codigo = objeto.getCod_funcionario();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return codigo;
	}

	public boolean excluir(Funcionario objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from funcionario where cod_funcionario = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getCod_funcionario());
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

	public List<Funcionario> listar() {

		Connection conexao = new Conexao().geraConexao();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Statement consulta = null;
		ResultSet resultado = null;
		Funcionario objeto = null;
		String sql;
		try {
			sql = "select * from funcionario order by nome;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				objeto = new Funcionario();
				objeto.setCod_funcionario(resultado.getInt("cod_funcionario"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setIdade(resultado.getInt("idade"));
				objeto.setFuncao(resultado.getString("funcao"));
				objeto.setSalario(resultado.getDouble("salario"));
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

	public Funcionario buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Funcionario objeto = null;
		String sql;
		try {
			sql = "select * from funcionario where cod_funcionario = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Funcionario();
				objeto.setCod_funcionario(resultado.getInt("cod_funcionario"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setIdade(resultado.getInt("idade"));
				objeto.setFuncao(resultado.getString("funcao"));
				objeto.setSalario(resultado.getDouble("salario"));
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
