package view;

import java.awt.Color;
import java.awt.EventQueue;

import bll.ClienteBLL;
import entity.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class CadastrarClienteView extends JFrame {
	
	Cliente objeto = null;
    ClienteBLL controle = new ClienteBLL();

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

	public CadastrarClienteView() {
		setTitle("Easy Shop - Cadastro de Cliente");		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(202, 249, 156));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(66, 319, 117, 25);
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
	            
	            Cliente obj = (Cliente) controle.salvar(objeto);
	            
	            if(obj.isResult())
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				else
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
	            
	            LoginView frame = new LoginView();
				frame.setVisible(true);
				dispose();
	          				
			}
		});
		contentPane.add(btnSalvar);
		contentPane.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("Tree.editorBorder"));
		panel_1.setBackground(new Color(202, 249, 156));
		panel_1.setBounds(21, 37, 403, 167);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(60, 136, 333, 19);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 12, 333, 19);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(60, 43, 170, 19);
		panel_1.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(60, 74, 170, 19);
		panel_1.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(60, 105, 170, 19);
		panel_1.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 51, 15);
		panel_1.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 138, 47, 15);
		panel_1.add(lblEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(11, 45, 48, 15);
		panel_1.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(9, 75, 52, 16);
		panel_1.add(lblTelefone);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 106, 45, 16);
		panel_1.add(lblSenha);
		
		ImageIcon imagem = new ImageIcon(PrincipalView.class.getResource("/img/easyshop.jpg"));
		
		JLabel foto = new JLabel("");
		foto.setBounds(242, 8, 151, 144);
		panel_1.add(foto);
		Image img= imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
		
		foto.setIcon(new ImageIcon(img));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 215, 414, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 224, 404, 84);
		panel.setBorder(UIManager.getBorder("Tree.editorBorder"));
		panel.setBackground(new Color(202, 249, 156));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 18, 39, 15);
		panel.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(55, 15, 150, 19);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(214, 18, 51, 15);
		panel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(258, 15, 124, 19);
		panel.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 51, 33, 15);
		panel.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(56, 49, 150, 19);
		panel.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00BA");
		lblNumero.setBounds(225, 51, 31, 14);
		panel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(262, 49, 40, 19);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(317, 51, 22, 15);
		panel.add(lblUf);
		
		txtUF = new JTextField();
		txtUF.setBounds(347, 49, 33, 19);
		panel.add(txtUF);
		txtUF.setColumns(10);
		
		JButton btnCancelarCadastro = new JButton("Cancelar");
		btnCancelarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelarCadastro.setBounds(249, 320, 117, 25);
		contentPane.add(btnCancelarCadastro);
		
		
	}
}



