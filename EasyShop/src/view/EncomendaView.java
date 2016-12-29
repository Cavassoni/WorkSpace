package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.ClienteBLL;
import bll.EncomendaBLL;
import bll.ProdutoBLL;
import entity.Cliente;
import entity.Encomenda;
import entity.Login;
import entity.ModeloTabela;
import entity.Preferencia;
import entity.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class EncomendaView extends JFrame {

	Encomenda objeto = new Encomenda();
    EncomendaBLL controle = new EncomendaBLL();
    ProdutoBLL controleP = new ProdutoBLL();
    ClienteBLL controleC = new ClienteBLL();
    Cliente objC = null;
    Produto objP = null;
	List<Produto> listaP = new ArrayList<Produto>();
	List<Encomenda> listaE = new ArrayList<Encomenda>();
	List<Cliente> listaC = new ArrayList<Cliente>();
    
	private JPanel contentPane;
	private JTextArea txtDescricao;
	private JScrollPane scrollPane;
	private JButton btnExcluir;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBoxItem;
	private JButton btnSalvar;
	
	private boolean cliente=false, produto=false;
	private JTable table;

	public EncomendaView(Login obj) {
		setTitle("Easy Shop - Cadastro de Encomenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(202, 249, 156));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(248, 225, 120, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoView frame = new PedidoView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 203);
		contentPane.add(tabbedPane);
		
		JPanel abaCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, abaCadastrar, null);
		abaCadastrar.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(8, 25, 56, 14);
		abaCadastrar.add(lblProduto);
		lblProduto.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(8, 110, 66, 14);
		abaCadastrar.add(lblDescricao);
		
		comboBoxItem = new JComboBox();
		comboBoxItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxItem.removeAllItems();
				if(!CarregarProdutos(comboBoxItem, objP))
					produto=false;
				else produto=true;
			}
		});
		comboBoxItem.setBounds(72, 22, 128, 20);
		abaCadastrar.add(comboBoxItem);
		
		CarregarProdutos(comboBoxItem, objP);
			
		scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 83, 328, 68);
		abaCadastrar.add(scrollPane);
		
		txtDescricao = new JTextArea();
		txtDescricao.setLocation(0, 113);
		scrollPane.setViewportView(txtDescricao);
		txtDescricao.setBorder(UIManager.getBorder("EditorPane.border"));
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setTabSize(20);
		txtDescricao.setLineWrap(true);
		
		comboBox = new JComboBox();
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(64, 225, 120, 25);
		
		if(!cliente||!produto)
			btnSalvar.setEnabled(false);;
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				objeto = new Encomenda();		
				objeto.setCodCliente(obj.getCodigo());
				
	            controleP = new ProdutoBLL();
				objP = new Produto();

				String codPro[] = String.valueOf(comboBoxItem.getSelectedItem()).split(" - ");
				objP = controleP.buscarPorCodigo(Integer.parseInt(codPro[0]));
				objeto.setCodItem(objP.getCodProduto());
				objeto.setNomeItem(objP.getNomeProduto());
				objeto.setNomeCliente(obj.getNome());
				objeto.setCodCliente(obj.getCodigo());
				
				objeto.setDescricao(txtDescricao.getText());
				controle.salvar(objeto);
	            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
	           
	            limparCampos();
	            preencherTabela(objeto);
	            
	            comboBox.removeAllItems();
				if(!CarregarEncomenda(comboBox, objeto))
					btnExcluir.setEnabled(false);
				else btnExcluir.setEnabled(true);
	          				
			}
		});
		contentPane.add(btnSalvar);
		
		
		// -----------------------------------------------------------------
		
		JPanel abaListar = new JPanel();
		tabbedPane.addTab("Listar", null, abaListar, null);
		abaListar.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 389, 153);
		abaListar.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);

		objeto.setCodCliente(obj.getCodigo());
		preencherTabela(objeto);
		
		
		
		
		// -----------------------------------------------------------------
		
		JPanel abaExcluir = new JPanel();
		tabbedPane.addTab("Excluir", null, abaExcluir, null);
		abaExcluir.setLayout(null);
		
		comboBox.setBounds(105, 44, 198, 20);
		abaExcluir.add(comboBox);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro ?", "Pergunta",
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					controle = new EncomendaBLL();
					objeto = new Encomenda();
					
					String codEnc[] = String.valueOf(comboBox.getSelectedItem()).split(" - ");
					objeto = controle.buscarPorCodigo(Integer.parseInt(codEnc[0]));
					
					if (controle.excluir(objeto))
						JOptionPane.showMessageDialog(rootPane, "Registro Excuido com Sucesso");
					else
						JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado na operação");
					
					comboBox.removeAllItems();
					if(!CarregarEncomenda(comboBox, objeto))
						btnExcluir.setEnabled(false);
					else btnExcluir.setEnabled(true);
					
					objeto.setCodCliente(obj.getCodigo());
					preencherTabela(objeto);
						
				}
				
			}
		});
		btnExcluir.setBounds(160, 108, 89, 23);
		abaExcluir.add(btnExcluir);
		
		comboBox.removeAllItems();
		if(!CarregarEncomenda(comboBox, objeto))
			btnExcluir.setEnabled(false);
		else btnExcluir.setEnabled(true);
		
		Thread desabilita = new Thread(){
		    public void run(){
		        while (true){
		            if(txtDescricao.getText().equals("")){
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
		desabilita.start();
	}
	
	private boolean CarregarProdutos(JComboBox<Object> comboBox, Produto obj) {
		listaP = controleP.listar(obj);
		if(listaP.size()>0){
			for (Produto p : listaP) {
				comboBox.addItem(String.valueOf(p.getCodProduto()+" - "+p.getNomeProduto()) );
			}
			return true;
		}else return false;
	}
	private boolean CarregarClientes(JComboBox<Object> comboBox, Cliente obj) {
		listaC = controleC.listar(obj);
		if(listaC.size()>0){
			for (Cliente c : listaC) {
				comboBox.addItem(String.valueOf(c.getCodCliente()+" - "+c.getNome()));
			}
			return true;
		}else return false;
	}
	private boolean CarregarEncomenda(JComboBox<Object> comboBox, Encomenda obj) {
		listaE = controle.listar(obj);
		if(listaE.size()>0){
			for (Encomenda e : listaE) {
				comboBox.addItem(String.valueOf(e.getCodEncomenda()+" - "+e.getDescricao()));
			}
			return true;
		}else return false;
	}
	
	public void preencherTabela(Encomenda obj){
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[]{"Código", "Produto", "Cliente", "Descrição"};
		
		listaE = controle.listar(obj);

		for(Encomenda p : listaE){
			dados.add(new Object[]{p.getCodEncomenda(), p.getNomeItem(), p.getNomeCliente(), p.getDescricao()});
		}
		ModeloTabela modelo = new ModeloTabela(dados, colunas);
		
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(260);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void limparCampos(){
		txtDescricao.setText("");
	}
}
