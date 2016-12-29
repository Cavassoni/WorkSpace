package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class Insere_Servicos extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
	public Insere_Servicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("CADASTRO DE SERVI\u00C7OS");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(10, 11, 644, 33);
		contentPane.add(lblInsiraOsDados);
		
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
		
		JLabel lblTipoDeServio = new JLabel("Tipo de Servi\u00E7o");
		lblTipoDeServio.setBounds(50, 77, 133, 19);
		contentPane.add(lblTipoDeServio);
		
		textField = new JTextField();
		textField.setBounds(139, 76, 457, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescrioDeAtividade = new JLabel("descri\u00E7\u00E3o de atividade");
		lblDescrioDeAtividade.setBounds(50, 138, 254, 14);
		contentPane.add(lblDescrioDeAtividade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 163, 457, 109);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
