package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.EncomendaBLL;
import entity.Encomenda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastrarEncomenda extends JFrame {

	Encomenda objeto = null;
    EncomendaBLL controle = new EncomendaBLL();
    
	private JPanel contentPane;
	private JTextField txtCodigoItem;
	private JTextField txtCodigoCliente;
	private JTextField txtDescricao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEncomenda frame = new CadastrarEncomenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Limpar(){
		txtCodigoItem.setText("");
		txtCodigoCliente.setText("");
		txtDescricao.setText("");
		
	}
	
	public CadastrarEncomenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarEncomenda = new JLabel("Cadastrar Encomenda");
		lblCadastrarEncomenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarEncomenda.setBounds(10, 11, 212, 34);
		contentPane.add(lblCadastrarEncomenda);
		
		JLabel lblCodigoItem = new JLabel("Codigo Item");
		lblCodigoItem.setBounds(45, 67, 68, 14);
		contentPane.add(lblCodigoItem);
		
		txtCodigoItem = new JTextField();
		txtCodigoItem.setBounds(137, 64, 255, 20);
		contentPane.add(txtCodigoItem);
		txtCodigoItem.setColumns(10);
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		lblCodigoCliente.setBounds(36, 104, 91, 14);
		contentPane.add(lblCodigoCliente);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setBounds(137, 101, 255, 20);
		contentPane.add(txtCodigoCliente);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(59, 157, 68, 14);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(137, 146, 255, 37);
		contentPane.add(txtDescricao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				objeto = new Encomenda();		
	            objeto.setId_item(Integer.parseInt(txtCodigoItem.getText()));
	            objeto.setId_cliente(Integer.parseInt(txtCodigoCliente.getText()));
	            objeto.setDescricao(txtDescricao.getText());
	            
	            controle.salvar(objeto);
	            Limpar();
	            
	            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
	          				
			}
		});
		
		btnSalvar.setBounds(178, 212, 89, 23);
		contentPane.add(btnSalvar);
	}
}
