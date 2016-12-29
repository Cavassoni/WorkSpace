package view;

import java.awt.EventQueue;
import bll.FuncionarioBLL;
import entity.Funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExcluirView extends JFrame {

	List<Funcionario> objetosFuncionarios = null;
	FuncionarioBLL controleFuncionario = new FuncionarioBLL();

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirView frame = new ExcluirView();
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

	public ExcluirView() {
		setTitle("Excluir");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFuncionario = new JLabel("Funcion\u00E1rio");
		lblFuncionario.setBounds(55, 45, 127, 15);
		contentPane.add(lblFuncionario);

		JComboBox comboBox = new JComboBox();
		CarregarFuncionario(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario obFuncionario = new Funcionario();
				FuncionarioBLL busca = new FuncionarioBLL();

				String idfun[] = String.valueOf(comboBox.getSelectedItem()).split(" - ");

				obFuncionario = busca.buscarPorCodigo(Integer.parseInt(idfun[0]));
			}

		});
		comboBox.setBounds(55, 71, 159, 20);
		contentPane.add(comboBox);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro ?", "Pergunta",
//						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.out.println("entrou");

					Funcionario obFuncionario = new Funcionario();
					FuncionarioBLL busca = new FuncionarioBLL();

					String idfun[] = String.valueOf(comboBox.getSelectedItem()).split(" - ");

					obFuncionario = busca.buscarPorCodigo(Integer.parseInt(idfun[0]));
					
					if(busca.excluir(obFuncionario))
						JOptionPane.showMessageDialog(rootPane, "Registro Excuido com Sucesso");
					else
						JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado na operação");
						
					dispose();
//				}else 
//					System.out.println("saiu");

			}
		});
		btnRemover.setBounds(262, 72, 117, 25);
		contentPane.add(btnRemover);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalView frame = new PrincipalView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(262, 145, 117, 25);
		contentPane.add(btnCancelar);
	}
}
