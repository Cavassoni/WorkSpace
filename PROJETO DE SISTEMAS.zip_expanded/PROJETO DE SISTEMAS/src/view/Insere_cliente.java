package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insere_cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField clientebairro;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insere_cliente frame = new Insere_cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Insere_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("CADASTRO DE CLIENTE");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(10, 11, 644, 33);
		contentPane.add(lblInsiraOsDados);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(44, 84, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(44, 129, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(317, 129, 46, 14);
		contentPane.add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(100, 81, 496, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 126, 193, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(350, 126, 246, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setBounds(44, 170, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCi = new JLabel("CIDADE");
		lblCi.setBounds(317, 170, 46, 14);
		contentPane.add(lblCi);
		
		JLabel lblNewLabel = new JLabel("UF");
		lblNewLabel.setBounds(44, 213, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(161, 213, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setBounds(317, 213, 68, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(44, 259, 46, 14);
		contentPane.add(lblEmail);
		
		clientebairro = new JTextField();
		clientebairro.setBounds(100, 164, 193, 20);
		contentPane.add(clientebairro);
		clientebairro.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 210, 35, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(186, 210, 107, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(360, 167, 236, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(375, 210, 221, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(100, 256, 496, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnConfirma = new JButton("CONFIRMA");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConfirma.setBackground(new Color(50, 205, 50));
		btnConfirma.setForeground(new Color(0, 0, 0));
		btnConfirma.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		btnConfirma.setBounds(403, 316, 193, 48);
		contentPane.add(btnConfirma);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(100, 316, 193, 48);
		contentPane.add(btnNewButton);
	}
}
