package dao;

import java.sql.*;
import java.util.*;

import config.Conexao;
import enity.Funcionario;
public class FuncionarioDAO implements IDAO<Funcionario> {


	public int salvar(Funcionario objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {

			if(objeto.getIdFuncionario() == 0){
				
				sql = "insert into funcionario ("
						+ "nom_funcionario = ?,"
						+ " rg_funcionario = ?,"
						+ " cpf_funcionario = ?,"
						+ "bai_funcionario = ?"
						+ "cid_funcionario = ?"
						+ "uf_funcionario = ?"
						+ "tel_funcionario = ?"
						+ "email_funcionario = ?"
						+ "id_empresa = ?"
						+ " values (?,?,?,?,?,?,?,?,?);";
				sqlParametro = conexao.prepareStatement(sql);
				
				sqlParametro.setString(1, objeto.getNome());
				sqlParametro.setInt(2, objeto.getRg());
				sqlParametro.setInt(3, objeto.getCpf());
				sqlParametro.setString(4, objeto.getBairro());
				sqlParametro.setString(5, objeto.getCidade());
				sqlParametro.setString(6, objeto.getUf());
				sqlParametro.setInt(7, objeto.getTelefone());
				sqlParametro.setString(8, objeto.getEmail());
				sqlParametro.setInt(9, objeto.getIdEmpresa());
				
				sqlParametro.executeUpdate();
				
				sql = "select last_insert_id() as idfuncionario";
				sqlParametro = conexao.prepareStatement(sql);
				
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("idfuncionario");
				}
			}
			else{
				
				sql = "update funcionario set "
						+ "nom_funcionario = ?,"
						+ " rg_funcionario = ?,"
						+ " cpf_funcionario = ?,"
						+ "bai_funcionario = ?"
						+ "cid_funcionario = ?"
						+ "uf_funcionario = ?"
						+ "tel_funcionario = ?"
						+ "email_funcionario = ?"
						+ "id_empresa = ?"
						+ " where idfuncionario = ?;";
				
				sqlParametro = conexao.prepareStatement(sql);
				
				
				sqlParametro.setString(1, objeto.getNome());
				sqlParametro.setInt(2, objeto.getRg());
				sqlParametro.setInt(3, objeto.getCpf());
				sqlParametro.setString(4, objeto.getBairro());
				sqlParametro.setString(5, objeto.getCidade());
				sqlParametro.setString(6, objeto.getUf());
				sqlParametro.setInt(7, objeto.getTelefone());
				sqlParametro.setString(8, objeto.getEmail());
				sqlParametro.setInt(9, objeto.getIdEmpresa());
				sqlParametro.setInt(10, objeto.getIdFuncionario());
				
				sqlParametro.executeUpdate();
				codigo = objeto.getIdFuncionario();
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
			sql = "delete from funcionario where idfuncionario = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, objeto.getIdFuncionario());
			
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
	
	
	
	public List<Funcionario>  listar() {

		Connection conexao = new Conexao().geraConexao();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Statement consulta = null;
		ResultSet resultado = null;
		Funcionario objeto = null;
		String sql;
		try {
			sql = "select * from funcionario order by nom_funcionario;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				objeto = new Funcionario();
				objeto.setIdFuncionario(resultado.getInt("id_funcionario"));
				objeto.setNome(resultado.getString("nom_funcionario"));
				objeto.setRg(resultado.getInt("rg_funcionario"));
				objeto.setCpf(resultado.getInt("cpf_funcionario"));
				objeto.setBairro(resultado.getString("bai_funcionario"));
				objeto.setCidade(resultado.getString("cid_cliente"));
				objeto.setUf(resultado.getString("uf_funcionario"));
				objeto.setTelefone(resultado.getInt("tel_funcionario"));
				objeto.setEmail(resultado.getString("email_funcionario"));
				objeto.setIdEmpresa(resultado.getInt("id_empresa"));
				
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
	
	
	public Funcionario  buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Funcionario objeto = null;
		String sql;
		try {
			sql = "select * from funcionario where idfuncionario = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Funcionario();
				objeto.setIdFuncionario(resultado.getInt("id_funcionario"));
				objeto.setNome(resultado.getString("nom_funcionario"));
				objeto.setRg(resultado.getInt("rg_funcionario"));
				objeto.setCpf(resultado.getInt("cpf_funcionario"));
				objeto.setBairro(resultado.getString("bai_funcionario"));
				objeto.setCidade(resultado.getString("cid_cliente"));
				objeto.setUf(resultado.getString("uf_funcionario"));
				objeto.setTelefone(resultado.getInt("tel_funcionario"));
				objeto.setEmail(resultado.getString("email_funcionario"));
				objeto.setIdEmpresa(resultado.getInt("id_empresa"));
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

