package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.PedidoBLL;
import bll.PedidoProdutoBLL;
import bll.ProdutoBLL;
import entity.Encomenda;
import entity.Login;
import entity.ModeloTabela;
import entity.Pedido;
import entity.PedidoProduto;
import entity.Preferencia;
import entity.Produto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PedidoView extends JFrame {

	private JPanel contentPane;
	private JTable tableProdutos;
	private JButton btnAdicionar;
	private JButton btnExcluir;
	Produto objeto = null;
	Pedido objetoPedido = new Pedido();
	ProdutoBLL controle = new ProdutoBLL();
	PedidoBLL controlePedido = new PedidoBLL();
	PedidoProdutoBLL pedidoProduto = new PedidoProdutoBLL();
	List<Produto> lista = new ArrayList<Produto>();
	List<Pedido> ped = new ArrayList<Pedido>();
	ArrayList<Object[]> dados = new ArrayList<Object[]>();
	ArrayList<Object> produtos = new ArrayList<Object>();
	ModeloTabela modelo = null;

	private boolean novoProduto = true;
	private float valorTotal;
	private JTable tableListar;

	public PedidoView(Login obj) {
		setTitle("Easy Shop - Pedido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(202, 249, 156));

		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setBounds(358, 329, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalView frame = new PrincipalView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCancelar);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 12, 497, 305);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastrar", null, panel, null);
		panel.setLayout(null);

		JComboBox<Object> comboBoxCadastrar = new JComboBox<Object>();
		comboBoxCadastrar.setBounds(16, 37, 142, 20);
		panel.add(comboBoxCadastrar);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objeto = new Produto();

				String codProd[] = String.valueOf(comboBoxCadastrar.getSelectedItem()).split(" - ");
				objeto = controle.buscarPorCodigo(Integer.parseInt(codProd[0]));

				dados.add(new Object[] { objeto.getCodProduto(), objeto.getNomeProduto(), objeto.getValor() });

				criarTabelaCadastro(dados);

				produtos.add(objeto);

			}
		});
		btnAdicionar.setBounds(43, 94, 89, 23);
		panel.add(btnAdicionar);

		comboBoxCadastrar.removeAllItems();
		if (!CarregarProdutos(comboBoxCadastrar))
			btnAdicionar.setEnabled(false);
		else
			btnAdicionar.setEnabled(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 11, 302, 255);
		panel.add(scrollPane);

		tableProdutos = new JTable();
		tableProdutos.setEnabled(false);
		scrollPane.setViewportView(tableProdutos);

		JComboBox comboBoxListar = new JComboBox();
		JComboBox comboBoxExcluir = new JComboBox();
		JButton btnListar = new JButton("Listar");

		JButton btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objetoPedido = new Pedido();
				objetoPedido.setCodCliente(obj.getCodigo());
				Pedido pedido = (Pedido) controlePedido.salvar(objetoPedido);
				PedidoProduto objt = null;
				PedidoProduto objetoPP = new PedidoProduto();
				dados = new ArrayList<Object[]>();
				for (int i = 0; i < produtos.size(); i++) {
					objeto = (Produto) produtos.get(i);
					objetoPP.setCodProduto(objeto.getCodProduto());
					objetoPP.setCodPedido(pedido.getCodPedido());
					valorTotal += objeto.getValor();

					objt = (PedidoProduto) pedidoProduto.salvar(objetoPP);
				}
				objetoPedido.setValorTotal(valorTotal);

				if (objt.isResult()) {
					if (controlePedido.alterar(objetoPedido))
						JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
					else
						JOptionPane.showMessageDialog(null, "Ocorreu um erro Inesperado durante a operação");
				}

				comboBoxExcluir.removeAllItems();
				if (!CarregarPedido(comboBoxExcluir, obj, pedido))
					btnExcluir.setEnabled(false);
				else
					btnExcluir.setEnabled(true);

				comboBoxListar.removeAllItems();
				if (!CarregarPedido(comboBoxListar, obj, pedido))
					btnListar.setEnabled(false);
				else
					btnListar.setEnabled(true);
				criarTabelaCadastro(dados);
			}
		});
		btnRealizarPedido.setBounds(25, 214, 125, 23);
		panel.add(btnRealizarPedido);

		JPanel abaListar = new JPanel();
		tabbedPane.addTab("Listar", null, abaListar, null);
		abaListar.setLayout(null);

		comboBoxListar.setBounds(21, 72, 89, 25);
		abaListar.add(comboBoxListar);

		comboBoxListar.removeAllItems();
		if (!CarregarPedido(comboBoxListar, obj, objetoPedido))
			btnListar.setEnabled(false);
		else
			btnListar.setEnabled(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(134, 11, 348, 255);
		abaListar.add(scrollPane_1);

		tableListar = new JTable();
		scrollPane_1.setViewportView(tableListar);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objetoPedido = new Pedido();
				objetoPedido.setCodCliente(obj.getCodigo());
				String codProd[] = String.valueOf(comboBoxListar.getSelectedItem()).split(" - ");
				objetoPedido = controlePedido.buscarPorCodigo(Integer.parseInt(codProd[0]));
				
				criarTabelaListagem(objetoPedido.getCodPedido());
			}
		});
		btnListar.setBounds(21, 164, 89, 23);
		abaListar.add(btnListar);

		JPanel AbaExcluir = new JPanel();
		tabbedPane.addTab("Excluir", null, AbaExcluir, null);
		AbaExcluir.setLayout(null);

		comboBoxExcluir.setBounds(149, 78, 194, 20);
		AbaExcluir.add(comboBoxExcluir);
		btnExcluir = new JButton("Excluir");

		comboBoxExcluir.removeAllItems();
		if (!CarregarPedido(comboBoxExcluir, obj, objetoPedido))
			btnExcluir.setEnabled(false);
		else
			btnExcluir.setEnabled(true);

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro ?", "Pergunta",
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					objetoPedido = new Pedido();
					objetoPedido.setCodCliente(obj.getCodigo());

					String codPed[] = String.valueOf(comboBoxExcluir.getSelectedItem()).split(" - ");
					objetoPedido = controlePedido.buscarPorCodigo(Integer.parseInt(codPed[0]));

					if (controlePedido.excluir(objetoPedido))
						JOptionPane.showMessageDialog(rootPane, "Registro Excuido com Sucesso");
					else
						JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado na operação");

					comboBoxExcluir.removeAllItems();
					if (!CarregarPedido(comboBoxExcluir, obj, objetoPedido))
						btnExcluir.setEnabled(false);
					else
						btnExcluir.setEnabled(true);

					comboBoxListar.removeAllItems();
					if (!CarregarPedido(comboBoxListar, obj, objetoPedido))
						btnListar.setEnabled(false);
					else
						btnListar.setEnabled(true);
					
					criarTabelaListagem(0);
				}
			}
		});
		btnExcluir.setBounds(201, 176, 89, 23);
		AbaExcluir.add(btnExcluir);

		JButton btnEncomenda = new JButton("Encomenda");
		btnEncomenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncomendaView frame = new EncomendaView(obj);
				frame.setVisible(true);
				dispose();
			}
		});
		btnEncomenda.setBounds(104, 329, 114, 23);
		contentPane.add(btnEncomenda);

		criarTabelaCadastro(dados);
		criarTabelaListagem(0);

		Thread teste = new Thread() {
			public void run() {
				while (true) {
					if (dados.size() == 0) {
						btnRealizarPedido.setEnabled(false);
					} else {
						btnRealizarPedido.setEnabled(true);
					}
					try {
						sleep(250);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		teste.start();

	}

	public void criarTabelaCadastro(ArrayList dados) {
		String[] colunas = new String[] { "Código", "Produto", "Valor" };

		modelo = new ModeloTabela(dados, colunas);

		tableProdutos.setModel(modelo);
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(49);
		tableProdutos.getColumnModel().getColumn(0).setResizable(false);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(190);
		tableProdutos.getColumnModel().getColumn(1).setResizable(false);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableProdutos.getColumnModel().getColumn(2).setResizable(false);
		tableProdutos.getTableHeader().setReorderingAllowed(false);
		tableProdutos.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);
		tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public void criarTabelaListagem(int codigo) {
		String[] colunas = new String[] { "Cod. Produto", "Produto", "Valor" };

		lista = controle.listarProduto(codigo);
		
		for (Produto p : lista) {
			dados.add(new Object[] { p.getCodProduto(), p.getNomeProduto(), p.getValor() });
		}

		modelo = new ModeloTabela(dados, colunas);

		tableListar.setModel(modelo);
		tableListar.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableListar.getColumnModel().getColumn(0).setResizable(false);
		tableListar.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableListar.getColumnModel().getColumn(1).setResizable(false);
		tableListar.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableListar.getColumnModel().getColumn(2).setResizable(false);
		tableListar.getTableHeader().setReorderingAllowed(false);
		tableListar.setAutoResizeMode(tableProdutos.AUTO_RESIZE_OFF);
		tableListar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dados = new ArrayList<Object[]>();
	}

	public ArrayList<Object[]> adicionarProduto() {
		lista = controle.listar(objeto);
		dados = new ArrayList<Object[]>();
		for (Produto p : lista) {
			dados.add(new Object[] { p.getCodProduto(), p.getNomeProduto(), p.getValor(), p.getQtdEstoque() });
		}
		return dados;
	}

	private boolean CarregarProdutos(JComboBox<Object> comboBox) {
		lista = controle.listar(objeto);
		if (lista.size() > 0) {
			for (Produto p : lista) {
				comboBox.addItem(String.valueOf(p.getCodProduto() + " - " + p.getNomeProduto()));
			}
			return true;
		} else
			return false;
	}

	private boolean CarregarPedido(JComboBox<Object> comboBox, Login obj, Pedido objetoPedido) {
		objetoPedido.setCodCliente(obj.getCodigo());
		ped = controlePedido.listar(objetoPedido);
		if (ped.size() > 0) {
			for (Pedido p : ped) {
				comboBox.addItem(String.valueOf(p.getCodPedido()));
			}
			return true;
		} else
			return false;
	}
}
