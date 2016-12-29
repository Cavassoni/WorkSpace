package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalView() {
		setTitle("Gest\u00E3o Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarView frame = new AlterarView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnAlterar.setBounds(258, 39, 198, 40);
		contentPane.add(btnAlterar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarView frame = new CadastrarView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(28, 39, 200, 40);
		contentPane.add(btnCadastrar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(325, 227, 131, 23);
		contentPane.add(btnSair);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirView frame = new ExcluirView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnExcluir.setBounds(28, 139, 200, 40);
		contentPane.add(btnExcluir);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarView frame = new ListarView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnListar.setBounds(256, 139, 200, 40);
		contentPane.add(btnListar);

	}
}
