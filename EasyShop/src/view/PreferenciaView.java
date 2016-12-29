package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import bll.PreferenciaBLL;
import entity.Cliente;
import entity.Login;
import entity.ModeloTabela;
import entity.Preferencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PreferenciaView extends JFrame {

	private PreferenciaBLL controle = new PreferenciaBLL();
	private Preferencia objeto = new Preferencia();
	List<Preferencia> lista = new ArrayList<Preferencia>();
	
	private JPanel contentPane;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JTextField txtValorAte;
	private JButton btnVoltar;
	private JTable table;
	private JScrollPane jscrollPane;
	
	public PreferenciaView(Login obj) {
		setTitle("Easy Shop - Prefer\u00EAncia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(202, 249, 156));

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(310, 225, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalView frame = new PrincipalView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 12, 414, 201);
		contentPane.add(tabbedPane);
		
		JPanel tabCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, tabCadastrar, null);
		tabCadastrar.setLayout(null);
		
		JLabel lblModelo = new JLabel("Produto/Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 14, 90, 15);
		tabCadastrar.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(110, 11, 268, 20);
		tabCadastrar.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCor.setBounds(82, 45, 18, 15);
		tabCadastrar.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(110, 42, 268, 20);
		tabCadastrar.add(txtCor);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(69, 76, 31, 15);
		tabCadastrar.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(110, 73, 268, 20);
		tabCadastrar.add(txtMarca);
		
		JLabel lblValorAte = new JLabel("Valor At\u00E9");
		lblValorAte.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorAte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorAte.setBounds(49, 107, 51, 15);
		tabCadastrar.add(lblValorAte);
		
		txtValorAte = new JTextField();
		txtValorAte.setColumns(10);
		txtValorAte.setBounds(110, 104, 268, 20);
		tabCadastrar.add(txtValorAte);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objeto = new Preferencia();
				
				objeto.setMarca(txtMarca.getText());
				objeto.setModelo(txtModelo.getText());
				objeto.setCor(txtCor.getText());
				objeto.setValorAte(Float.parseFloat(txtValorAte.getText()));
				objeto.setCodCliente(obj.getCodigo());
				
				Preferencia obj = (Preferencia) controle.salvar(objeto);
				if(obj.isResult())
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				else
					JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
				
				limparCampos();
				preencherTabela(objeto);
				
			}
		});
		btnSalvar.setBounds(159, 135, 90, 23);
		tabCadastrar.add(btnSalvar);
		
		
		Thread teste = new Thread(){
		    public void run(){
		        while (true){
		            if(txtMarca.getText().equals("") || txtModelo.getText().equals("") || 
		            		txtCor.getText().equals("") || txtValorAte.getText().equals("")){
		            	btnSalvar.setEnabled(false);
		            } else {
		            	btnSalvar.setEnabled(true);
		            }
		            try {
		                sleep(250);
		            } catch (InterruptedException e) {}
		         }
		    }
		};
		teste.start();
		
		JPanel tabListar = new JPanel();
		tabbedPane.addTab("Listar", null, tabListar, null);
		tabListar.setLayout(null);

		table = new JTable();
		table.setBorder(UIManager.getBorder("FormattedTextField.border"));
		table.setBounds(24, 22, 387, 179);
		
		jscrollPane = new JScrollPane(table);
		jscrollPane.setBounds(0, 0, 409, 173);
		tabListar.add(jscrollPane);
		
		objeto.setCodCliente(obj.getCodigo());
		preencherTabela(objeto);
	}
	
	public void limparCampos(){
		txtMarca.setText("");
		txtModelo.setText("");
		txtValorAte.setText("");
		txtCor.setText("");
	}
	
	public void preencherTabela(Preferencia objeto){
		ArrayList<Object[]> dados = new ArrayList<Object[]>();
		String[] colunas = new String[]{"Código", "Modelo", "Cor", "Marca", "Valor Até"};
		
		lista = controle.listar(objeto);

		for(Preferencia p : lista){
			dados.add(new Object[]{p.getCodPreferencia(), p.getModelo(), p.getCor(), p.getMarca(), p.getValorAte()});
		}
		ModeloTabela modelo = new ModeloTabela(dados, colunas);
		
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(76);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}


}
