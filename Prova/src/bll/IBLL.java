package bll;

import java.util.List;

public interface IBLL <Entity> {

	public abstract Object salvar(Entity objeto);
	
	public abstract boolean excluir(Entity objeto);
	
	public abstract List<Entity> listar();
	
	public abstract Entity buscarPorCodigo(int codigo);
	
	public abstract Object alterar(Entity objeto);
}
