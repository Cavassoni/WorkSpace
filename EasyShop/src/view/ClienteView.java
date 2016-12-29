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

import bll.ClienteBLL;
import entity.Cliente;
import entity.Login;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClienteView extends JFrame {

	Cliente objeto = null;
	ClienteBLL controle = new ClienteBLL();
	List<Cliente> lista = new ArrayList<Cliente>();

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtUF;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JPasswordField txtSenha;
	private JComboBox comboBox;
	private JButton btnExcluir;

	public ClienteView(Login obj) {
		setTitle("Easy Shop - Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(202, 249, 156));
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(321, 333, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalView frame = new PrincipalView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 8, 412, 317);
		contentPane.add(tabbedPane);

		JPanel abaCadastro = new JPanel();
		tabbedPane.addTab("Cadastrar", null, abaCadastro, null);
		abaCadastro.setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setBounds(60, 136, 333, 19);
		abaCadastro.add(txtEmail);
		txtEmail.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(60, 12, 333, 19);
		abaCadastro.add(txtNome);
		txtNome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(60, 43, 170, 19);
		abaCadastro.add(txtCpf);
		txtCpf.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(60, 74, 170, 19);
		abaCadastro.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(60, 105, 170, 19);
		abaCadastro.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(10, 14, 51, 15);
		abaCadastro.add(lblNome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(14, 138, 47, 15);
		abaCadastro.add(lblEmail);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(13, 45, 48, 15);
		abaCadastro.add(lblCpf);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(9, 76, 52, 16);
		abaCadastro.add(lblTelefone);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(16, 106, 45, 16);
		abaCadastro.add(lblSenha);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setBounds(10, 190, 51, 15);
		abaCadastro.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(60, 187, 150, 19);
		abaCadastro.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setBounds(217, 190, 39, 15);
		abaCadastro.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(256, 187, 124, 19);
		abaCadastro.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setHorizontalAlignment(SwingConstants.CENTER);
		lblRua.setBounds(10, 227, 51, 15);
		abaCadastro.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(60, 224, 150, 19);
		abaCadastro.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00BA");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(225, 228, 31, 14);
		abaCadastro.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(256, 224, 51, 19);
		abaCadastro.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setHorizontalAlignment(SwingConstants.CENTER);
		lblUf.setBounds(306, 227, 31, 15);
		abaCadastro.add(lblUf);
		
		txtUF = new JTextField();
		txtUF.setBounds(341, 224, 39, 19);
		abaCadastro.add(txtUF);
		txtUF.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(145, 253, 117, 25);
		abaCadastro.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				objeto = new Cliente();
				objeto.setNome(txtNome.getText());
				objeto.setEmail(txtEmail.getText());
				objeto.setCpf(Integer.parseInt(txtCpf.getText()));
				objeto.setTelefone(Integer.parseInt(txtTelefone.getText()));
				objeto.setCidade(txtCidade.getText());
				objeto.setBairro(txtBairro.getText());
				objeto.setUf(txtUF.getText());
				objeto.setRua(txtRua.getText());
				objeto.setNumero(Integer.parseInt(txtNumero.getText()));
				objeto.setSenha(txtSenha.getText());

				Cliente objet = (Cliente) controle.salvar(objeto);				
				
				if (objet.isResult())
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				else
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
				limparCampos();
				comboBox.removeAllItems();
				if(!CarregarClientes(comboBox))
					btnExcluir.setEnabled(false);
				else btnExcluir.setEnabled(true);
			}
		});
		
		Thread teste = new Thread(){
		    public void run(){
		        while (true){
		            if(txtEmail.getText().equals("") || txtNome.getText().equals("") || 
		            		txtCpf.getText().equals("") || txtTelefone.getText().equals("") ||
		            		txtSenha.getText().equals("") || txtCidade.getText().equals("") ||
		            		txtBairro.getText().equals("") || txtRua.getText().equals("") || 
		            		txtNumero.getText().equals("") || txtUF.getText().equals("")){
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

		// ---------------------------------------------------------------------------------------//
		
		btnExcluir = new JButton("Excluir");

		JPanel abaExcluir = new JPanel();
		tabbedPane.addTab("Excluir", null, abaExcluir, null);
		abaExcluir.setLayout(null);
		
		
		comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				if(!CarregarClientes(comboBox))
					btnExcluir.setEnabled(false);
				else btnExcluir.setEnabled(true);
			}
		});
		comboBox.setBounds(116, 81, 175, 23);
		abaExcluir.add(comboBox);
		
		if(!CarregarClientes(comboBox))
			btnExcluir.setEnabled(false);
		else btnExcluir.setEnabled(true);
		
		btnExcluir.setBounds(159, 185, 89, 23);
		abaExcluir.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro ?", "Pergunta",
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					controle = new ClienteBLL();
					objeto = new Cliente();

					objeto = controle.buscarPorNome(String.valueOf(comboBox.getSelectedItem()));
					
					if (controle.excluir(objeto))
						JOptionPane.showMessageDialog(rootPane, "Registro Excuido com Sucesso");
					else
						JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado na operação");
					
					comboBox.removeAllItems();
					if(!CarregarClientes(comboBox))
						btnExcluir.setEnabled(false);
					else btnExcluir.setEnabled(true);
						
				}
			}
		});
		
		if(obj.getCodigo() != 0){
			tabbedPane.setEnabledAt(1, false);
		}
	}
	
	private boolean CarregarClientes(JComboBox<Object> comboBox) {
		lista = controle.listar(objeto);
		if(lista.size()>0){
			for (Cliente c : lista) {
				comboBox.addItem(String.valueOf(c.getNome()));
			}
			return true;
		}else return false;
	}
	
	public void limparCampos(){
		txtNome.setText("");
		txtEmail.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtUF.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtSenha.setText("");
	}
}
