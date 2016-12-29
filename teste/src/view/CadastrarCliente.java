package view;

import java.awt.EventQueue;

import bll.ClienteBLL;
import entity.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;
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

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					CadastrarCliente frame = new CadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Limpar(){
		txtNome.setText("");
		txtEmail.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtUF.setText("");
		txtRua.setText("");
		txtNumero.setText("");
	}
	
	public CadastrarCliente() {		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 43, 166, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(260, 83, 150, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(296, 43, 114, 19);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(77, 83, 114, 19);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 46, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(217, 86, 33, 15);
		contentPane.add(lblEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(253, 46, 33, 15);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(21, 85, 52, 16);
		contentPane.add(lblTelefone);
		
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
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
	            
	            controle.salvar(objeto);
	            Limpar();
	            
	            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
	          				
			}
		});
		
		btnSalvar.setBounds(165, 226, 117, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblCadastrarPessoa = new JLabel("Cadastrar Pessoa");
		lblCadastrarPessoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarPessoa.setBounds(27, 0, 212, 34);
		contentPane.add(lblCadastrarPessoa);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(21, 152, 39, 15);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(70, 149, 150, 19);
		contentPane.add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(235, 152, 51, 15);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(280, 148, 144, 19);
		contentPane.add(txtBairro);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(338, 181, 22, 15);
		contentPane.add(lblUf);
		
		txtUF = new JTextField();
		txtUF.setColumns(10);
		txtUF.setBounds(370, 178, 40, 19);
		contentPane.add(txtUF);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(27, 180, 33, 15);
		contentPane.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(70, 177, 150, 19);
		contentPane.add(txtRua);
				
		btnSalvar.setBounds(165, 226, 117, 25);
		contentPane.add(btnSalvar);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(288, 177, 40, 19);
		contentPane.add(txtNumero);
		
		JLabel lblNumero = new JLabel("N\u00BA");
		lblNumero.setBounds(256, 180, 22, 15);
		contentPane.add(lblNumero);
		
	}
}



