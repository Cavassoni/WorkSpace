package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Insere_adm extends JFrame {
	private JPanel contentPane;
	private JTextField text_nome;
	private JTextField text_rg;
	private JTextField text_cpf;
	private JTextField text_bairro;
	private JTextField text_uf;
	private JTextField text_cep;
	private JTextField text_cidade;
	private JTextField text_telefone;
	private JTextField text_email;
	private JTextField textsenha;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

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
	public Insere_adm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("CADASTRO ADMINISTRADORES");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(10, 11, 644, 33);
		contentPane.add(lblInsiraOsDados);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(44, 84, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setBounds(44, 129, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(317, 129, 23, 14);
		contentPane.add(lblCpf);
		
		text_nome = new JTextField();
		text_nome.setBounds(100, 81, 496, 20);
		contentPane.add(text_nome);
		text_nome.setColumns(10);
		
		text_rg = new JTextField();
		text_rg.setBounds(100, 126, 193, 20);
		contentPane.add(text_rg);
		text_rg.setColumns(10);
		
		text_cpf = new JTextField();
		text_cpf.setBounds(350, 126, 246, 20);
		contentPane.add(text_cpf);
		text_cpf.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setBounds(44, 170, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCi = new JLabel("CIDADE");
		lblCi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCi.setBounds(303, 170, 46, 14);
		contentPane.add(lblCi);
		
		JLabel lblNewLabel = new JLabel("UF");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(44, 213, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(161, 213, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(297, 213, 68, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(44, 259, 46, 14);
		contentPane.add(lblEmail);
		
		text_bairro = new JTextField();
		text_bairro.setBounds(100, 164, 193, 20);
		contentPane.add(text_bairro);
		text_bairro.setColumns(10);
		
		text_uf = new JTextField();
		text_uf.setBounds(100, 210, 35, 20);
		contentPane.add(text_uf);
		text_uf.setColumns(10);
		
		text_cep = new JTextField();
		text_cep.setBounds(186, 210, 107, 20);
		contentPane.add(text_cep);
		text_cep.setColumns(10);
		
		text_cidade = new JTextField();
		text_cidade.setBounds(360, 167, 236, 20);
		contentPane.add(text_cidade);
		text_cidade.setColumns(10);
		
		
		text_telefone = new JTextField();
		text_telefone.setBounds(375, 210, 221, 20);
		contentPane.add(text_telefone);
		text_telefone.setColumns(10);
		
		text_email = new JTextField();
		text_email.setBounds(100, 256, 193, 20);
		contentPane.add(text_email);
		text_email.setColumns(10);
		
		JButton btnConfirma = new JButton("CONFIRMA");
		btnConfirma.setAction(action);
		
		btnConfirma.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			
			}
		});
		btnConfirma.setBackground(new Color(50, 205, 50));
		btnConfirma.setForeground(new Color(0, 0, 0));
		btnConfirma.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		btnConfirma.setBounds(403, 338, 193, 48);
		contentPane.add(btnConfirma);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.setAction(action_1);
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
				
			}
		});
		btnNewButton.setBounds(100, 338, 193, 48);
		contentPane.add(btnNewButton);
		
		JComboBox selectempresa = new JComboBox();
		selectempresa.setModel(new DefaultComboBoxModel(new String[] {"---", "empresa 1", "empresa 2", "empresa 3"}));
		selectempresa.setBounds(375, 253, 221, 20);
		contentPane.add(selectempresa);
		
		JLabel lblEmpresa = new JLabel("EMPRESA");
		lblEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpresa.setBounds(317, 259, 46, 14);
		contentPane.add(lblEmpresa);
		
		JLabel lblSenhaDeAcesso = new JLabel("Senha de acesso");
		lblSenhaDeAcesso.setBounds(44, 298, 81, 14);
		contentPane.add(lblSenhaDeAcesso);
		
		textsenha = new JTextField();
		textsenha.setBounds(132, 295, 193, 20);
		contentPane.add(textsenha);
		textsenha.setColumns(10);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "CONFIRMA");
			putValue(SHORT_DESCRIPTION, "PARA FUNCIONAE TEM Q SETAR A AÇÃO");
		}
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "CANCELA");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("kkkkkkk");
		}
	}
}
