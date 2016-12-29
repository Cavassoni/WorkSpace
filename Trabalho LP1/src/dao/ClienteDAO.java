package dao;

import java.sql.*;
import java.util.*;

import config.Conexao;
import enity.Cliente;

public class ClienteDAO {
	
	public int salvar(Cliente objeto) {
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro=null;
		ResultSet resultado=null;
		int codigo=0;
		String sql;
		try {
			if(objeto.getId()==0){
				sql="insert into cliente (nome, idade, sexo, telefone, email, cpf) values (?,?,?,?,?,?)";
				sqlParametro= conexao.prepareStatement(sql);
				
				sqlParametro.setString(1,objeto.getNome());
				sqlParametro.setInt(2, objeto.getIdade());
				sqlParametro.setString(3, objeto.getSexo());
				sqlParametro.setInt(4, objeto.getTelefone());
				sqlParametro.setString(5, objeto.getEmail());
				sqlParametro.setInt(6, objeto.getCpf());
				
				sqlParametro.executeUpdate();
				
				sql="select last_insert_id() as idCliente";
				sqlParametro=conexao.prepareStatement(sql);
				
				resultado= sqlParametro.executeQuery();
				
				if(resultado.next()){
					codigo=resultado.getInt("idCliente");
				}
			}else{
				sql="update cliente set nome=?, "
						+ "idade=?, "
						+ "sexo=?, "
						+ "telefone=?, "
						+ "email=?, "
						+ "cpf=?"
						+ "where idCliente = ?;";
				
				sqlParametro = conexao.prepareStatement(sql);
				
				sqlParametro.setString(1,objeto.getNome());
				sqlParametro.setInt(2, objeto.getIdade());
				sqlParametro.setString(3, objeto.getSexo());
				sqlParametro.setInt(4, objeto.getTelefone());
				sqlParametro.setString(5, objeto.getEmail());
				sqlParametro.setInt(6, objeto.getCpf());
				
				sqlParametro.executeUpdate();
				codigo = objeto.getId();
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				sqlParametro.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		return codigo;
	}
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean excluir(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	public Cliente buscarPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
