package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.UsuarioBLL;
import bll.LoginBLL;
import config.Conexao;
import entity.Usuario;
import entity.Login;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {
	
	Login objeto = null;
	LoginBLL controle = new LoginBLL();
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginView() {
		setTitle("EasyShop  - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("Calisto MT", lblUsuario.getFont().getStyle() & ~Font.BOLD & ~Font.ITALIC, lblUsuario.getFont().getSize() + 3));
		lblUsuario.setBounds(80, 59, 69, 23);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Calisto MT", lblSenha.getFont().getStyle() & ~Font.BOLD & ~Font.ITALIC, lblSenha.getFont().getSize() + 3));
		lblSenha.setBounds(80, 125, 69, 23);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(90, 94, 199, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(90, 159, 199, 20);
		contentPane.add(txtSenha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 26));
		lblLogin.setBounds(105, 11, 165, 43);
		contentPane.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				objeto = new Login();
				
				objeto.setNome(txtUsuario.getText());
				objeto.setSenha(txtSenha.getText());
				
				objeto = (Login) controle.Login(objeto);
				
				if(objeto.isResult()){
					UsuarioView frame = new UsuarioView(objeto);
					frame.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(rootPane, "Login Inválido! \nTente novamente!");
				}
			}
		});
		btnLogin.setBounds(143, 204, 89, 23);
		contentPane.add(btnLogin);
		
		Thread desabilitaLogin = new Thread(){
		    public void run(){
		        while (true){
		            if(txtUsuario.getText().equals("") || txtSenha.getText().equals("")){
		            	btnLogin.setEnabled(false);
		            } else {
		            	btnLogin.setEnabled(true);
		            }
		            try {
		                sleep(250);
		            } catch (InterruptedException e) {}
		         }
		    }
		};
		desabilitaLogin.start();
		
	}
}
