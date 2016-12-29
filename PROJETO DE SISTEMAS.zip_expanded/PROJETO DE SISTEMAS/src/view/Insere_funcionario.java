package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.ControllerEventListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bll.FuncionarioBLL;
import dao.FuncionarioDAO;
import enity.Funcionario;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JFormattedTextField;

public class Insere_funcionario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeFuncionario;
	private JTextField rgFuncionario;
	private JTextField cpfFuncionario;
	private JTextField bairroFuncionario;
	private JTextField ufFuncionario;
	private JTextField cep_Funcionario;
	private JTextField cidadeFuncionario;
	private JTextField telFuncionario;
	private JTextField emailFuncionario;
	private JTextField idEmpresa;

	/**
	 * Launch the application.
	 */
	FuncionarioBLL controle = new FuncionarioBLL();
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
	public Insere_funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("CADASTRO DE FUNCION\u00C1RIO");
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
		
		nomeFuncionario = new JTextField();
		nomeFuncionario.setBounds(100, 81, 496, 20);
		contentPane.add(nomeFuncionario);
		nomeFuncionario.setColumns(10);
		
		rgFuncionario = new JTextField();
		rgFuncionario.setBounds(100, 126, 193, 20);
		contentPane.add(rgFuncionario);
		rgFuncionario.setColumns(10);
		
		cpfFuncionario = new JTextField();
		cpfFuncionario.setBounds(350, 126, 246, 20);
		contentPane.add(cpfFuncionario);
		cpfFuncionario.setColumns(10);
		
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
		
		bairroFuncionario = new JTextField();
		bairroFuncionario.setBounds(100, 164, 193, 20);
		contentPane.add(bairroFuncionario);
		bairroFuncionario.setColumns(10);
		
		ufFuncionario = new JTextField();
		ufFuncionario.setBounds(100, 210, 35, 20);
		contentPane.add(ufFuncionario);
		ufFuncionario.setColumns(10);
		
		cep_Funcionario = new JTextField();
		cep_Funcionario.setBounds(186, 210, 107, 20);
		contentPane.add(cep_Funcionario);
		cep_Funcionario.setColumns(10);
		
		cidadeFuncionario = new JTextField();
		cidadeFuncionario.setBounds(360, 167, 236, 20);
		contentPane.add(cidadeFuncionario);
		cidadeFuncionario.setColumns(10);
		
		telFuncionario = new JTextField();
		telFuncionario.setBounds(375, 210, 221, 20);
		contentPane.add(telFuncionario);
		telFuncionario.setColumns(10);
		
		emailFuncionario = new JTextField();
		emailFuncionario.setBounds(100, 256, 193, 20);
		contentPane.add(emailFuncionario);
		emailFuncionario.setColumns(10);
		
		JButton btnConfirma = new JButton("CONFIRMA");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario obFuncionario = new Funcionario();
				obFuncionario.setNome(nomeFuncionario.getText());
				obFuncionario.setRg(Integer.parseInt(rgFuncionario.getText()));
				obFuncionario.setCpf(Integer.parseInt(cpfFuncionario.getText()));
				obFuncionario.setBairro(bairroFuncionario.getText());
				obFuncionario.setCidade(cidadeFuncionario.getText());
				obFuncionario.setUf(ufFuncionario.getText());
				obFuncionario.setTelefone(Integer.parseInt(telFuncionario.getText()));
				obFuncionario.setIdEmpresa(Integer.parseInt(idEmpresa.getText()));
			controle.salvar(obFuncionario);
			
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
		
		JLabel lblEmpresa = new JLabel("EMPRESA c\u00F3digo");
		lblEmpresa.setBounds(317, 259, 86, 14);
		contentPane.add(lblEmpresa);
		
		idEmpresa = new JTextField();
		idEmpresa.setBounds(413, 256, 183, 20);
		contentPane.add(idEmpresa);
		idEmpresa.setColumns(10);
	}
}
