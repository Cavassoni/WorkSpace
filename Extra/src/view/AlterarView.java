package view;

import java.awt.EventQueue;

import entity.Funcionario;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.FuncionarioBLL;

import javax.swing.JTextField;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarView extends JFrame {

	List<Funcionario> objetosFuncionarios = null;
	FuncionarioBLL controleFuncionario = new FuncionarioBLL();

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtFuncao;
	private JTextField txtIdade;
	private JTextField txtSalario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarView frame = new AlterarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void CarregarFuncionario(JComboBox<Object> comboBox) {
		objetosFuncionarios = controleFuncionario.listar();
		objetosFuncionarios.forEach((f) -> {
			comboBox.addItem(String.valueOf(f.getCod_funcionario()) + " - " + f.getNome());
		});

	}

	public AlterarView() {
		setTitle("Alterar");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<Object> comboBox = new JComboBox<Object>();
		CarregarFuncionario(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario obFuncionario = new Funcionario();
				FuncionarioBLL busca = new FuncionarioBLL();

				String idfun[] = String.valueOf(comboBox.getSelectedItem()).split(" - ");

				obFuncionario = busca.buscarPorCodigo(Integer.parseInt(idfun[0]));

				txtNome.setText(obFuncionario.getNome());
				txtFuncao.setText(obFuncionario.getFuncao());
				txtIdade.setText(String.valueOf(obFuncionario.getIdade()));
				txtSalario.setText(String.valueOf(obFuncionario.getSalario()));
			}

		});
		comboBox.setBounds(149, 11, 258, 20);
		contentPane.add(comboBox);

		JLabel lblFuncionario = new JLabel("Funcion\u00E1rio");
		lblFuncionario.setBounds(39, 14, 85, 14);
		contentPane.add(lblFuncionario);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 41, 414, 118);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 2, 64, 25);
		panel.add(lblNome);

		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o");
		lblFuncao.setBounds(10, 56, 64, 25);
		panel.add(lblFuncao);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(227, 2, 64, 25);
		panel.add(lblIdade);

		JLabel lblSalario = new JLabel("Sal\u00E1rio");
		lblSalario.setBounds(227, 56, 64, 25);
		panel.add(lblSalario);

		txtNome = new JTextField();
		txtNome.setBounds(20, 29, 156, 25);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtFuncao = new JTextField();
		txtFuncao.setColumns(10);
		txtFuncao.setBounds(20, 83, 156, 25);
		panel.add(txtFuncao);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(237, 29, 156, 25);
		panel.add(txtIdade);

		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(237, 83, 156, 25);
		panel.add(txtSalario);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario obFuncionario = new Funcionario();
				FuncionarioBLL busca = new FuncionarioBLL();

				String idfun[] = String.valueOf(comboBox.getSelectedItem()).split(" - ");

				obFuncionario = busca.buscarPorCodigo(Integer.parseInt(idfun[0]));
				obFuncionario.setNome(txtNome.getText());
				obFuncionario.setFuncao(txtFuncao.getText());
				obFuncionario.setIdade(Integer.parseInt(txtIdade.getText()));
				obFuncionario.setSalario(Double.parseDouble(txtSalario.getText()));
				busca.salvar(obFuncionario);

				JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
				PrincipalView frame = new PrincipalView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnAlterar.setBounds(66, 175, 117, 25);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalView frame = new PrincipalView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(249, 174, 117, 25);
		contentPane.add(btnCancelar);
	}
}
