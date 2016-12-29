package entity;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	private ArrayList linhas = null;
	private String[] colunas = null;

	public ModeloTabela(ArrayList lin, String[] col) {
		setLinhas(lin);
		setColunas(col);
	}

	public ArrayList getLinhas() {
		return linhas;
	}

	public void setLinhas(ArrayList linhas) {
		this.linhas = linhas;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	// Método que monta a tabela/ adiciona as linhas na tabela
	@Override
	public Object getValueAt(int numLin, int numCol) {
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}

	public String getColumnName(int numCol) {
		return colunas[numCol];
	}
	
	 public ArrayList getAllItems(){
	       int row = getRowCount();
	       int col = getColumnCount();
	       ArrayList<Object> dados =new ArrayList();
	       for(int i=0;i<row;i++){
	        dados.add(getValueAt(i, 0));
	   }
		return dados;
	 }
}
