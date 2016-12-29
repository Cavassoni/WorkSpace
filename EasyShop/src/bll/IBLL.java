package bll;

import java.util.List;

public interface IBLL <Entity> {

	public abstract Object salvar(Entity objeto);
	
	public abstract boolean excluir(Entity objeto);
	
	public abstract List<Entity> listar(Entity objeto);
	
	public abstract Entity buscarPorNome(String nome);	
}
