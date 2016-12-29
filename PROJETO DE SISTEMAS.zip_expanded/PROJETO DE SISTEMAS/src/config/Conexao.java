package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection geraConexao(){

		Connection conexao = null;
		
		try {
			
			
			String url = "jdbc:mysql://localhost/bd_projeto";
			String usuario = "root";
			String senha = "gigante2013";
			conexao = DriverManager.getConnection(url, usuario, senha);

		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexao;
	}

}
