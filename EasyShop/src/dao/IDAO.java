package dao;

import java.util.List;

import entity.Pedido;

public interface IDAO<Entity> {

	public abstract Object salvar(Entity objeto);
	
	public abstract boolean excluir(Entity objeto);
	
	public abstract List<Entity> listar(Entity objeto);
	
	public abstract Entity buscarPorNome(String nome);
		
}
