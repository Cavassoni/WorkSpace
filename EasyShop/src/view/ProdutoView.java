package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import bll.ProdutoBLL;
import entity.Encomenda;
import entity.Login;
import entity.ModeloTabela;
import entity.Produto;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class ProdutoView extends JFrame {

	Produto objeto = null;
	ProdutoBLL controle = new ProdutoBLL();
	List<Produto> lista = new ArrayList<Produto>();
	private JComboBox comboBox;
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTextField txtMarca;
	private JTextField txtCor;
	private JSpinner spinnerQtdEstoque;
	private JTextArea txtDescricao;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JPanel abaListar;
	private JScrollPane scrollPane_1;
	private JTable table;

	public ProdutoView(Login obj) {
		setTitle("Easy Shop - Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(202, 249, 156));
		setResizable(false);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalView frame = new PrincipalView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(360, 284, 89, 23);
		contentPane.add(btnVoltar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 8, 452, 265);
		contentPane.add(tabbedPane);
		
		JPanel abaCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, abaCadastrar, null);
		abaCadastrar.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome Produto");
		lblNome.setBounds(10, 20, 83, 15);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abaCadastrar.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(100, 18, 328, 20);
		abaCadastrar.add(txtNome);
		txtNome.setColumns(10);
		
		spinnerQtdEstoque = new JSpinner();
		spinnerQtdEstoque.setBounds(100, 94, 98, 20);
		abaCadastrar.add(spinnerQtdEstoque);
		
		JLabel lblQtdEstoque = new JLabel("Qtd Estoque");
		lblQtdEstoque.setBounds(23, 97, 70, 15);
		lblQtdEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abaCadastrar.add(lblQtdEstoque);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(66, 59, 27, 15);
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abaCadastrar.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(100, 56, 98, 20);
		txtValor.setColumns(10);
		abaCadastrar.add(txtValor);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(221, 59, 47, 15);
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abaCadastrar.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(278, 56, 150, 20);
		txtMarca.setColumns(10);
		abaCadastrar.add(txtMarca);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(42, 142, 51, 15);
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abaCadastrar.add(lblDescricao);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(234, 97, 34, 15);
		lblCor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abaCadastrar.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(278, 94, 150, 20);
		txtCor.setColumns(10);
		abaCadastrar.add(txtCor);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(182, 195, 83, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objeto = new Produto();
				
				objeto.setNomeProduto(txtNome.getText());
				objeto.setCor(txtCor.getText());
				objeto.setQtdEstoque(Integer.parseInt(spinnerQtdEstoque.getValue().toString()));
				objeto.setMarca(txtMarca.getText());
				objeto.setValor(Float.parseFloat(txtValor.getText()));
				objeto.setDescricao(txtDescricao.getText());
				
				Produto obj = (Produto) controle.salvar(objeto);
				if(obj.isResult())
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				else
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
				
				limparCampos();
				
				preencherTabela();
				
				comboBox.removeAllItems();
				if(!CarregarProdutos(comboBox))
					btnExcluir.setEnabled(false);
				else btnExcluir.setEnabled(true);
				
			}
		});
		abaCadastrar.add(btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 137, 328, 45);
		abaCadastrar.add(scrollPane);
		
		txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		txtDescricao.setBorder(UIManager.getBorder("EditorPane.border"));
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setTabSize(20);
		txtDescricao.setLineWrap(true);
		
		Thread teste = new Thread(){
		    public void run(){
		        while (true){
		            if(txtNome.getText().equals("") || txtValor.getText().equals("") || 
		            		txtMarca.getText().equals("") || txtCor.getText().equals("") ||
		            		txtDescricao.getText().equals("") ){
		            	btnSalvar.setEnabled(false);
		            } else {
		            	btnSalvar.setEnabled(true);
		            }
		            try {
		                sleep(250);
		            } catch (InterruptedException e) {}
		         }
		    }
		};
		teste.start();
		
		//-------------------------------------------------------------------
		
		abaListar = new JPanel();
		tabbedPane.addTab("Listar", null, abaListar, null);
		abaListar.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 427, 215);
		abaListar.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		
		// ----------------------------------------------------------------------------//
		
		JPanel abaExcluir = new JPanel();
		tabbedPane.addTab("Excluir", null, abaExcluir, null);
		abaExcluir.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				if(!CarregarProdutos(comboBox))
					btnExcluir.setEnabled(false);
				else btnExcluir.setEnabled(true);
			}
		});
		comboBox.setBounds(136, 63, 175, 23);
		abaExcluir.add(comboBox);
		CarregarProdutos(comboBox);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(179, 149, 89, 23);
		abaExcluir.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro ?", "Pergunta",
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					controle = new ProdutoBLL();
					objeto = new Produto();

					objeto = controle.buscarPorNome(String.valueOf(comboBox.getSelectedItem()));
					
					if (controle.excluir(objeto))
						JOptionPane.showMessageDialog(rootPane, "Registro Excuido com Sucesso");
					else
						JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado na operação");
					
					comboBox.removeAllItems();
					if(!CarregarProdutos(comboBox))
						btnExcluir.setEnabled(false);
					else btnExcluir.setEnabled(true);
					
					preencherTabela();
				}
			}
		});

		comboBox.removeAllItems();
		if(!CarregarProdutos(comboBox))
			btnExcluir.setEnabled(false);
		else btnExcluir.setEnabled(true);
		
		preencherTabela();
		
		if(obj.getCodigo() != 0){
			tabbedPane.setEnabledAt(2, false);
		}
		
	}
	
	private boolean CarregarProdutos(JComboBox<Object> comboBox) {
		lista = controle.listar(objeto);
		if(lista.size()>0){
			for (Produto p : lista) {
				comboBox.addItem(String.valueOf(p.getNomeProduto()));
			}
			return true;
		}else return false;
	}
	
	public void limparCampos(){
		txtNome.setText("");
		txtValor.setText("");
		txtMarca.setText("");
		txtCor.setText("");
		txtDescricao.setText("");
		spinnerQtdEstoque.setValue(0);
	}
	
	public void preencherTabela(){
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[]{"Código", "Produto", "Cor", "Marca", "Valor", "Quantidade","Descrição"};
		
		lista = controle.listar(objeto);

		for(Produto p : lista){
			dados.add(new Object[]{p.getCodProduto(), p.getNomeProduto(), p.getCor(),p.getMarca(), p.getValor(),p.getQtdEstoque(), p.getDescricao()});
		}
		ModeloTabela modelo = new ModeloTabela(dados, colunas);
		
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(300);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
