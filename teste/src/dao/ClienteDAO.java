package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Cliente;

public class ClienteDAO implements IDAO<Cliente> {


	public int salvar(Cliente objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {
			
				
				sql = "insert into cliente(nome, email, cidade, bairro, rua, uf, cpf, telefone, numero) value(?, ?, ?, ?, ?, ?, ?, ?, ? );";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setString(1, objeto.getNome());
				sqlParametro.setString(2, objeto.getEmail());
                sqlParametro.setString(3, objeto.getCidade());
				sqlParametro.setString(4, objeto.getBairro());
                sqlParametro.setString(5, objeto.getRua());
                sqlParametro.setString(6, objeto.getUf());
                sqlParametro.setInt(7, objeto.getCpf());
                sqlParametro.setInt(8, objeto.getTelefone());
                sqlParametro.setInt(9, objeto.getNumero());
				
				
				sqlParametro.executeUpdate();
				
				sql = "select last_insert_id() as id_cliente";
				sqlParametro = conexao.prepareStatement(sql);
				
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("id_cliente");
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
}