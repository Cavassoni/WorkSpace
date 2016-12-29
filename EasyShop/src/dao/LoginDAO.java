package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Conexao;
import entity.Cliente;
import entity.Login;

public class LoginDAO {

	public Object login(Login objeto) {

		Connection conexao = new Conexao().geraConexao();
        List<Login> lista = new ArrayList<Login>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		String sql;
		try {
			sql = "select * from cliente where nome = ? and senha = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setString(1, objeto.getNome());
			consulta.setString(2, objeto.getSenha());
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto.setCodigo(resultado.getInt("cod_cliente"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setSenha(resultado.getString("senha"));
				objeto.setResult(true);
				lista.add(objeto);
			}else
				objeto.setResult(false);
		} catch (SQLException e) {
			e.printStackTrace();
			objeto.setResult(false);
			return objeto;
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
				objeto.setResult(false);
				return objeto;
			}
		}
		return objeto;
	}
}