package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import bll.UsuarioBLL;
import entity.Login;
import entity.ModeloTabela;
import entity.Usuario;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UsuarioView extends JFrame {

	Usuario objeto = null;
	UsuarioBLL controle = new UsuarioBLL();
	List<Usuario> lista = new ArrayList<Usuario>();

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNomeEdicao;
	private JPasswordField txtSenha;
	private JTextField txtSenhaEdicao;
	private JTextField txtCodigo;
	private JButton btnExcluir;
	private JTable table;
	private JLabel lblNome;
	private JLabel lblNomeEdicao;
	private JLabel lblSenha;
	private JLabel lblSenhaEdicao;
	private JButton btnSalvar;
	private JButton btnAlterar;
	ArrayList<Object[]> dados = new ArrayList<Object[]>();
	String[] colunas = new String[]{"Código", "Usuário"};
	private ModeloTabela modelo = new ModeloTabela(dados, colunas);
	private JLabel lblCodigo;

	public UsuarioView(Login obj) {
		setTitle("Easy Shop - usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(321, 333, 89, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSair);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 8, 412, 317);
		contentPane.add(tabbedPane);

		JPanel abaCadastro = new JPanel();
		tabbedPane.addTab("Cadastrar", null, abaCadastro, null);
		abaCadastro.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(62, 70, 314, 19);
		abaCadastro.add(txtNome);
		txtNome.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(62, 143, 170, 19);
		abaCadastro.add(txtSenha);
		txtSenha.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(16, 44, 51, 15);
		abaCadastro.add(lblNome);

		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(22, 116, 45, 16);
		abaCadastro.add(lblSenha);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(139, 226, 129, 52);
		abaCadastro.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				objeto = new Usuario();
				objeto.setNome(txtNome.getText());
				objeto.setSenha(txtSenha.getText());

				Usuario obj = (Usuario) controle.salvar(objeto);				
				
				if (obj.isResult())
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				else
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
				limparCampos();
				preencherTabela();
			}
		});

		// ---------------------------------------------------------------------------------------//
		
		btnExcluir = new JButton("Excluir");

		JPanel abaExcluir = new JPanel();
		tabbedPane.addTab("Excluir", null, abaExcluir, null);
		abaExcluir.setLayout(null);
		
		btnExcluir.setBounds(159, 252, 89, 23);
		abaExcluir.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 387, 226);
		abaExcluir.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro ?", "Pergunta",
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					controle = new UsuarioBLL();
					objeto = new Usuario();
					
					int linhaSel = table.getSelectedRow();   
					
					objeto = controle.buscarPorCodigo((int) modelo.getValueAt(linhaSel, 0));
					
					if (controle.excluir(objeto))
						JOptionPane.showMessageDialog(rootPane, "Registro Excuido com Sucesso");
					else
						JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado na operação");
					
					preencherTabela();
					
				}
			}
		});
		
		
		JPanel abaEditar = new JPanel();
		tabbedPane.addTab("Editar", null, abaEditar, null);
		abaEditar.setLayout(null);
		tabbedPane.setEnabledAt(2, false);
		
		txtNomeEdicao = new JTextField();
		txtNomeEdicao.setBounds(62, 70, 314, 19);
		abaEditar.add(txtNomeEdicao);
		txtNomeEdicao.setColumns(10);

		lblNomeEdicao = new JLabel("Nome");
		lblNomeEdicao.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeEdicao.setBounds(16, 44, 51, 15);
		abaEditar.add(lblNomeEdicao);

		lblSenhaEdicao = new JLabel("Senha");
		lblSenhaEdicao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaEdicao.setBounds(22, 116, 45, 16);
		abaEditar.add(lblSenhaEdicao);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(139, 226, 129, 52);
		abaEditar.add(btnAlterar);
		
		txtSenhaEdicao = new JTextField();
		txtSenhaEdicao.setBounds(62, 143, 164, 20);
		abaEditar.add(txtSenhaEdicao);
		txtSenhaEdicao.setColumns(10);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setBounds(240, 116, 45, 16);
		abaEditar.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(282, 143, 94, 20);
		abaEditar.add(txtCodigo);
		txtCodigo.setEnabled(false);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objeto = new Usuario();
				objeto.setNome(txtNomeEdicao.getText());
				objeto.setSenha(txtSenhaEdicao.getText());
				objeto.setCodigo(Integer.parseInt(txtCodigo.getText()));

				Usuario obj = (Usuario) controle.alterar(objeto);				
				
				if (obj.isResult())
					JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
				else
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
				limparCampos();
				preencherTabela();
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setEnabledAt(2, false);
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		if(obj.getCodigo()== 1)
			btnEditar.setVisible(true);
		else btnEditar.setVisible(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSel = table.getSelectedRow();   
				
				objeto = controle.buscarPorCodigo((int) modelo.getValueAt(linhaSel, 0));
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setSelectedIndex(2);
				
				txtNomeEdicao.setText(objeto.getNome());
				txtSenhaEdicao.setText(objeto.getSenha());
				txtCodigo.setText(Integer.toString(objeto.getCodigo()));
			}
		});
		btnEditar.setBounds(308, 252, 89, 23);
		
		abaExcluir.add(btnEditar);
		
		Thread desabilita = new Thread(){
		    public void run(){
		        while (true){
		            if(txtNome.getText().equals("") || txtSenha.getText().equals("")){
		            	btnSalvar.setEnabled(false);
		            } else {
		            	btnSalvar.setEnabled(true);
		            }
		            try {
		            	sleep(250);
		            } catch (InterruptedException e) {}
		            if(modelo.getRowCount()==0 || table.getSelectedRow() == -1){
		            	btnExcluir.setEnabled(false);
		            	btnEditar.setEnabled(false);
		            }else{
		            	btnExcluir.setEnabled(true);
		            	btnEditar.setEnabled(true);
		            }
		         }
		    }
		};
		desabilita.start();
		
		preencherTabela();

	}
	
	public void preencherTabela(){
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		
		lista = controle.listar();

		for(Usuario  c: lista){
			dados.add(new Object[]{c.getCodigo(), c.getNome()});
		}
		modelo = new ModeloTabela(dados, colunas);
		
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(294);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void limparCampos(){
		txtNome.setText("");
		txtSenha.setText("");
	}
}
