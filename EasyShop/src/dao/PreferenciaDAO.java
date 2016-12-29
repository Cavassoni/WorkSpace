package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Conexao;
import entity.Cliente;
import entity.Encomenda;
import entity.Preferencia;
import entity.Produto;

public class PreferenciaDAO implements IDAO<Preferencia> {

	public Object salvar(Preferencia objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {

			sql = "insert into preferencia(modelo, cor, marca, valor_ate, cod_cliente) value (?, ?, ?, ?, ?);";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setString(1, objeto.getModelo());
			sqlParametro.setString(2, objeto.getCor());
			sqlParametro.setString(3, objeto.getMarca());
			sqlParametro.setFloat(4, objeto.getValorAte());
			sqlParametro.setInt(5, objeto.getCodCliente());

			sqlParametro.executeUpdate();

			sql = "select last_insert_id() as cod_preferencia";
			sqlParametro = conexao.prepareStatement(sql);

			resultado = sqlParametro.executeQuery();
			if (resultado.next()) {
				objeto.setCodPreferencia(resultado.getInt("cod_preferencia"));
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

	public List<Preferencia> listar(Preferencia objeto) {

		Connection conexao = new Conexao().geraConexao();
		List<Preferencia> lista = new ArrayList<Preferencia>();
		Statement consulta = null;
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		String sql;
		try {
			if (objeto.getCodCliente() != 0) {
				sql = "select * from preferencia where cod_cliente = ?;";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, objeto.getCodCliente());
				resultado = sqlParametro.executeQuery();
			} else {
				sql = "select * from preferencia";
				consulta = conexao.createStatement();
				resultado = consulta.executeQuery(sql);
			}
			while (resultado.next()) {

				objeto = new Preferencia();
				objeto.setCodPreferencia(resultado.getInt("cod_preferencia"));
				objeto.setModelo(resultado.getString("modelo"));
				objeto.setCor(resultado.getString("cor"));
				objeto.setMarca(resultado.getString("marca"));
				objeto.setValorAte(resultado.getFloat("valor_ate"));

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

	@Override
	public Preferencia buscarPorNome(String nome) {
		return null;
	}

	@Override
	public boolean excluir(Preferencia objeto) {
		return false;
	}

}