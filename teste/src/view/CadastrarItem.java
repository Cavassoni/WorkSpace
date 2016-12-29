package view;

import java.awt.EventQueue;

import bll.ItemBLL;
import entity.Item;

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

public class CadastrarItem extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Item objeto = null;
    ItemBLL controle = new ItemBLL();

	private JPanel contentPane;
	private JTextField txtNomeItem;
	private JTextField txtFornecedor;
	private JTextField txtCodigoDeBarra;
	private JTextField txtValor;
	private JTextField txtDescricao;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					CadastrarItem frame = new CadastrarItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Limpar(){
		txtNomeItem.setText("");
		txtFornecedor.setText("");
		txtCodigoDeBarra.setText("");
		txtValor.setText("");
		txtDescricao.setText("");
	}
	
	public CadastrarItem() {		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeItem = new JTextField();
		txtNomeItem.setBounds(20, 60, 189, 19);
		contentPane.add(txtNomeItem);
		txtNomeItem.setColumns(10);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(231, 120, 193, 19);
		contentPane.add(txtFornecedor);
		txtFornecedor.setColumns(10);
		
		txtCodigoDeBarra = new JTextField();
		txtCodigoDeBarra.setBounds(20, 120, 189, 19);
		contentPane.add(txtCodigoDeBarra);
		txtCodigoDeBarra.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(231, 60, 193, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNomeItem = new JLabel("Nome Item");
		lblNomeItem.setBounds(20, 35, 70, 15);
		contentPane.add(lblNomeItem);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(231, 90, 79, 18);
		contentPane.add(lblFornecedor);
		
		JLabel lblCodigoDeBarra = new JLabel("codigo de barras");
		lblCodigoDeBarra.setBounds(20, 90, 101, 19);
		contentPane.add(lblCodigoDeBarra);
		
		JLabel lblValor = new JLabel("valor");
		lblValor.setBounds(231, 33, 43, 16);
		contentPane.add(lblValor);
		
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(165, 243, 117, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				objeto = new Item();		
	            objeto.setNomeItem(txtNomeItem.getText());
	            objeto.setFornecedor(txtFornecedor.getText());
	            objeto.setCodigoDeBarra(Integer.parseInt(txtCodigoDeBarra.getText()));
	            objeto.setValor(Double.parseDouble(txtValor.getText()));
	            objeto.setDescricao(txtDescricao.getText());
	            
	            controle.salvar(objeto);
	            Limpar();
	            
	            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
	          				
			}
		});
		contentPane.add(btnSalvar);
		
		JLabel lblCadastrarItem = new JLabel("Cadastrar Item");
		lblCadastrarItem.setBounds(27, 0, 212, 34);
		lblCadastrarItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCadastrarItem);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 183, 396, 49);
		txtDescricao.setColumns(10);
		contentPane.add(txtDescricao);
		contentPane.add(btnSalvar);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(20, 153, 81, 19);
		contentPane.add(lblDescricao);
		
	}
}



