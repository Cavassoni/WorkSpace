package view;

import java.awt.EventQueue;

import bll.FuncionarioBLL;
import entity.Funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtFuncao;
	private JTextField txtSalario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarView frame = new CadastrarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Limpar() {
		txtNome.setText("");
		txtIdade.setText("");
		txtFuncao.setText("");
		txtSalario.setText("");
	}

	public CadastrarView() {
		setTitle("Cadastrar");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(27, 35, 343, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setBounds(27, 143, 150, 19);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 10, 70, 15);
		contentPane.add(lblNome);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(27, 118, 70, 15);
		contentPane.add(lblIdade);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario objeto = new Funcionario();
				objeto.setNome(txtNome.getText());
				objeto.setFuncao(txtFuncao.getText());
				objeto.setIdade(Integer.parseInt(txtIdade.getText()));
				objeto.setSalario(Double.parseDouble(txtSalario.getText()));

				FuncionarioBLL obj = new FuncionarioBLL();
				obj.salvar(objeto);
				Limpar();

				JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				PrincipalView frame = new PrincipalView();
				frame.setVisible(true);
				dispose();

			}
		});
		btnSalvar.setBounds(53, 173, 117, 25);
		contentPane.add(btnSalvar);

		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o");
		lblFuncao.setBounds(27, 64, 70, 15);
		contentPane.add(lblFuncao);

		txtFuncao = new JTextField();
		txtFuncao.setColumns(10);
		txtFuncao.setBounds(27, 89, 343, 19);
		contentPane.add(txtFuncao);

		JLabel lblSalario = new JLabel("Sal\u00E1rio");
		lblSalario.setBounds(220, 118, 70, 15);
		contentPane.add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(220, 143, 150, 19);
		contentPane.add(txtSalario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalView frame = new PrincipalView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(223, 174, 117, 25);
		contentPane.add(btnCancelar);
	}
}
