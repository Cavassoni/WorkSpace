package view;

import java.awt.EventQueue;

import entity.Funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bll.FuncionarioBLL;

import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ListarView extends JFrame {

	private FuncionarioBLL funcionarioBLL = new FuncionarioBLL();
	List<Funcionario> lista = null;
	private DefaultTableModel modelo = new DefaultTableModel();
	private final String colunas[]={"Código","Nome","Função", "Idade", "Salário"};
	
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarView frame = new ListarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void criaJTable() {

		modelo.addColumn("Codigo");
		modelo.addColumn("Nome");
		modelo.addColumn("Função");
		modelo.addColumn("Idade");
		modelo.addColumn("Salario");

	}

	public void preencher() {
		modelo.setNumRows(0);

		lista = funcionarioBLL.listar();
		for (Funcionario f : lista) {
			modelo.addRow(
					new Object[] { f.getCod_funcionario(), f.getNome(), f.getFuncao(), f.getIdade(), f.getSalario() });
		}

	}

	public ListarView() {
		setTitle("Listagem");

		criaJTable();

		preencher();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalView frame = new PrincipalView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 283, 89, 23);
		contentPane.add(btnVoltar);
		
		table = new JTable();
		table.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		table.setBounds(10, 32, 414, 237);
		contentPane.add(table);
		table.setModel(modelo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(4, 0, 78, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(86, 0, 78, 14);
		panel.add(lblNome);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o");
		lblFuno.setBounds(168, 0, 78, 14);
		panel.add(lblFuno);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(250, 0, 78, 14);
		panel.add(lblIdade);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(332, 0, 78, 14);
		panel.add(lblSalrio);
		modelo.setColumnIdentifiers(colunas);

	}
}
