package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class CadastroClienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=71,19
	 */
	private final JLabel label_1 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClienteView frame = new CadastroClienteView();
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
	public CadastroClienteView() {
		label_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEasyShop = new JLabel("Easy Shop - Cadastro de Cliente");
		lblEasyShop.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblEasyShop.setBounds(96, 11, 341, 24);
		contentPane.add(lblEasyShop);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(21, 50, 65, 17);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(96, 48, 399, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 137, 158, 20);
		contentPane.add(textField_1);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(21, 137, 65, 20);
		contentPane.add(lblTelefone);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setBounds(283, 139, 44, 17);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMasculino.setBounds(335, 136, 89, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFeminino.setBounds(426, 136, 89, 23);
		contentPane.add(rdbtnFeminino);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(21, 93, 65, 17);
		contentPane.add(lblIdade);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 91, 96, 20);
		contentPane.add(textField_2);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(225, 93, 65, 17);
		contentPane.add(lblCpf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(300, 91, 195, 20);
		contentPane.add(textField_3);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(21, 179, 65, 17);
		contentPane.add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(96, 177, 399, 20);
		contentPane.add(textField_4);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(224, 305, -220, -57);
		contentPane.add(desktopPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 214, 484, 2);
		contentPane.add(separator);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(41, 214, 65, 21);
		contentPane.add(lblEndereo);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBairro.setBounds(31, 246, 65, 17);
		contentPane.add(lblBairro);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(106, 244, 221, 20);
		contentPane.add(textField_5);
		
		JLabel lblUf = new JLabel("Numero:");
		lblUf.setHorizontalAlignment(SwingConstants.CENTER);
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUf.setBounds(351, 246, 54, 17);
		contentPane.add(lblUf);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(415, 244, 65, 20);
		contentPane.add(textField_6);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCidade.setBounds(31, 280, 65, 17);
		contentPane.add(lblCidade);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(106, 278, 221, 20);
		contentPane.add(textField_7);
		
		JLabel label = new JLabel("UF:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(356, 280, 49, 17);
		contentPane.add(label);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(415, 278, 65, 20);
		contentPane.add(textField_8);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComplemento.setBounds(21, 316, 93, 17);
		contentPane.add(lblComplemento);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(124, 314, 356, 20);
		contentPane.add(textField_9);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(87, 363, 136, 23);
		contentPane.add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(310, 363, 136, 23);
		contentPane.add(btnCancelar);
	}
}
