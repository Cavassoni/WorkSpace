package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Cliente;
import entity.Encomenda;

public class EncomendaDAO implements IDAO<Encomenda> {


	public int salvar(Encomenda objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {
			
//				sql="select id_cliente from cliente where nome like(?)";
//				sqlParametro = conexao.prepareStatement(sql);
			
				sql = "insert into encomenda(id_item, id_cliente, descricao) value(?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, objeto.getId_item());
				sqlParametro.setInt(2, objeto.getId_cliente());
                sqlParametro.setString(3, objeto.getDescricao());

                
				sqlParametro.executeUpdate();
				
				sql = "select last_insert_id() as id_encomenda";
				sqlParametro = conexao.prepareStatement(sql);
				
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("id_encomenda");
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