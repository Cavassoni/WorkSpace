package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entity.Cliente;
import entity.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PrincipalView extends JFrame {

	private JPanel contentPane;

	public PrincipalView(Login obj) {
		setTitle("Easy Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(202, 249, 156));
		setResizable(false);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoView frame = new PedidoView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		btnPedido.setBounds(236, 96, 130, 70);
		contentPane.add(btnPedido);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(94, 211, 231, 29);
		contentPane.add(btnSair);
		
		JButton btnPreferencia = new JButton("Preferencia");
		btnPreferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferenciaView frame = new PreferenciaView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		btnPreferencia.setBounds(53, 96, 130, 70);
		contentPane.add(btnPreferencia);
		
		JButton btnProduto = new JButton("Produto");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoView frame = new ProdutoView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		btnProduto.setEnabled(true);
		btnProduto.setBounds(59, 28, 120, 40);
		contentPane.add(btnProduto);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteView frame = new ClienteView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCliente.setEnabled(true);
		btnCliente.setBounds(238, 28, 120, 40);
		contentPane.add(btnCliente);
		
		
		
		
	}
}
