package dao;

import java.sql.*;
import config.Conexao;
import entity.Item;

public class ItemDAO implements IDAO<Item> {


	public int salvar(Item objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {
			
				
				sql = "insert into item(nome_item, fornecedor, descricao, codigo_de_barra, valor) value(?, ?, ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				
				sqlParametro.setString(1, objeto.getNomeItem());
				sqlParametro.setString(2, objeto.getFornecedor());
                sqlParametro.setString(3, objeto.getDescricao());
                sqlParametro.setInt(4, objeto.getCodigoDeBarra());
                sqlParametro.setDouble(5, objeto.getValor());
                
				sqlParametro.executeUpdate();
				
				sql = "select last_insert_id() as id_item";
				sqlParametro = conexao.prepareStatement(sql);
				
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("id_item");
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