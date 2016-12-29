package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.SwingConstants;

public class ViewJogo extends JFrame {

	boolean Jogador1Ativo = true;
	boolean Jogador2Ativo = false;

	int VitoriaDoJogador1 = 0;
	int VitoriaDoJogador2 = 0;
	int PartidasEmpatadas = 0;
	static String pos[];
	static boolean ganhador = false;
	static JLabel lblNmeroDeVitoriasX;
	static JLabel lblNmeroDeVitoriasO;
	static JLabel lblNmeroDeEmpates;
	static JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

	private int numJogadas = 0;
	private String xo = "";
	private JButton newGame;
	private JTextField message;
	private ServerSocket serverSocket = null;
	private Socket sockets = null;
	private String nick1;
	private String nick2;
	private JScrollPane sp;
	private JTextField ip;
	private JButton join;
	private JTextField nick;
	private JTextField port;
	private boolean sinal;
	private ObjectInputStream entrada = null;
	private ObjectOutputStream saida = null;
	private JPanel contentPane;
	private boolean pararSinal = true;
	private JButton create;
	private String msg;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iniciarValores();
					ViewJogo frame = new ViewJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void iniciarValores() {
		pos = new String[9];

		for (int i = 0; i < 9; i++) {
			pos[i] = "";
		}

		lblNmeroDeVitoriasX = new JLabel();
		lblNmeroDeVitoriasO = new JLabel();
		lblNmeroDeEmpates = new JLabel();

		btn1 = new JButton("");
		btn2 = new JButton("");
		btn3 = new JButton("");
		btn4 = new JButton("");
		btn5 = new JButton("");
		btn6 = new JButton("");
		btn7 = new JButton("");
		btn8 = new JButton("");
		btn9 = new JButton("");
		estadoButton(false);
	}

	private void checaJogo() {
		if (((pos[0].equals("X")) && (pos[1].equals("X")) && (pos[2].equals("X")))
				|| ((pos[3].equals("X")) && (pos[4].equals("X")) && (pos[5].equals("X")))
				|| ((pos[6].equals("X")) && (pos[7].equals("X")) && (pos[8].equals("X")))
				|| ((pos[0].equals("X")) && (pos[3].equals("X")) && (pos[6].equals("X")))
				|| ((pos[1].equals("X")) && (pos[4].equals("X")) && (pos[7].equals("X")))
				|| ((pos[2].equals("X")) && (pos[5].equals("X")) && (pos[8].equals("X")))
				|| ((pos[0].equals("X")) && (pos[4].equals("X")) && (pos[8].equals("X")))
				|| ((pos[2].equals("X")) && (pos[4].equals("X")) && (pos[6].equals("X")))) {
			estadoButton(false);
			JOptionPane.showMessageDialog(null, nick1 + " ganhou!");
			if (xo.equals("X")) {
				newGame.setEnabled(true);
			}
		} else if (((pos[0].equals("O")) && (pos[1].equals("O")) && (pos[2].equals("O")))
				|| ((pos[3].equals("O")) && (pos[4].equals("O")) && (pos[5].equals("O")))
				|| ((pos[6].equals("O")) && (pos[7].equals("O")) && (pos[8].equals("O")))
				|| ((pos[0].equals("O")) && (pos[3].equals("O")) && (pos[6].equals("O")))
				|| ((pos[1].equals("O")) && (pos[4].equals("O")) && (pos[7].equals("O")))
				|| ((pos[2].equals("O")) && (pos[5].equals("O")) && (pos[8].equals("O")))
				|| ((pos[0].equals("O")) && (pos[4].equals("O")) && (pos[8].equals("O")))
				|| ((pos[2].equals("O")) && (pos[4].equals("O")) && (pos[6].equals("O")))) {
			estadoButton(false);
			JOptionPane.showMessageDialog(null, nick2 + " ganhou!");
			if (xo.equals("X")) {
				newGame.setEnabled(true);
			}
		} else if (numJogadas >= 9) {
			enviarMensagem("desenha!");
			JOptionPane.showMessageDialog(null, "Empate!");
			if (xo.equals("X")) {
				newGame.setEnabled(true);
			}
		}
	}

	private static void estadoButton(boolean b) {
		btn1.setEnabled(b);
		btn2.setEnabled(b);
		btn3.setEnabled(b);
		btn4.setEnabled(b);
		btn5.setEnabled(b);
		btn6.setEnabled(b);
		btn7.setEnabled(b);
		btn8.setEnabled(b);
		btn9.setEnabled(b);
		
	}

//	public void Vencedor(String JogadorVencedor) {
//
//		if (JogadorVencedor.equals("Jogador 1")) {
//			JOptionPane.showMessageDialog(ViewJogo.this, "Parabéns Jogador 1. Você venceu o Jogo!");
//			VitoriaDoJogador1++;
//			lblNmeroDeVitoriasX.setText("N\u00FAmero de vit\u00F3rias: " + VitoriaDoJogador1);
//		}
//
//		if (JogadorVencedor.equals("Jogador 2")) {
//			JOptionPane.showMessageDialog(ViewJogo.this, "Parabéns Jogador 2. Você venceu o Jogo!");
//			VitoriaDoJogador2++;
//			lblNmeroDeVitoriasO.setText("N\u00FAmero de vit\u00F3rias: " + VitoriaDoJogador2);
//		}
//
//		if (JogadorVencedor.equals("Empate")) {
//			JOptionPane.showMessageDialog(ViewJogo.this, "Jogo Empatado! Joguem Novamente!");
//			PartidasEmpatadas++;
//			lblNmeroDeEmpates.setText("Número de Empates: " + PartidasEmpatadas);
//		}
//
//	}

	public ViewJogo() {
		
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 349, 351);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btn1.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Jogador1Ativo) {
					if (btn1.getText().equals("")) {
						btn1.setText("X");
						pos[0] = btn1.getText();
					}
				} else {
					if (btn1.getText().equals("")) {
						btn1.setText("O");
						pos[0] = btn1.getText();
					}
				}
			}
		});
		btn1.setBounds(12, 12, 100, 100);
		panel_1.add(btn1);

		btn2.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn2.getText().equals("")) {
						btn2.setText("X");
						pos[1] = btn2.getText();
					}
				} else {
					if (btn2.getText().equals("")) {
						btn2.setText("O");
						pos[1] = btn2.getText();
					}
				}
			}
		});
		btn2.setBounds(124, 12, 100, 100);
		panel_1.add(btn2);

		btn3.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn3.getText().equals("")) {
						btn3.setText("X");
						pos[2] = btn3.getText();
					}
				} else {
					if (btn3.getText().equals("")) {
						btn3.setText("O");
						pos[2] = btn3.getText();
					}
				}
			}
		});
		btn3.setBounds(236, 12, 100, 100);
		panel_1.add(btn3);

		btn4.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn4.getText().equals("")) {
						btn4.setText("X");
						pos[3] = btn4.getText();
					}
				} else {
					if (btn4.getText().equals("")) {
						btn4.setText("O");
						pos[3] = btn4.getText();
					}
				}
			}
		});
		btn4.setBounds(12, 124, 100, 100);
		panel_1.add(btn4);

		btn5.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn5.getText().equals("")) {
						btn5.setText("X");
						pos[4] = btn5.getText();
					}
				} else {
					if (btn5.getText().equals("")) {
						btn5.setText("O");
						pos[4] = btn5.getText();
					}
				}
			}
		});
		btn5.setBounds(124, 124, 100, 100);
		panel_1.add(btn5);

		btn6.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn6.getText().equals("")) {
						btn6.setText("X");
						pos[5] = btn6.getText();
					}
				} else {
					if (btn6.getText().equals("")) {
						btn6.setText("O");
						pos[5] = btn6.getText();
					}
				}
			}
		});
		btn6.setBounds(236, 124, 100, 100);
		panel_1.add(btn6);

		btn7.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn7.getText().equals("")) {
						btn7.setText("X");
						pos[6] = btn7.getText();
					}
				} else {
					if (btn7.getText().equals("")) {
						btn7.setText("O");
						pos[6] = btn7.getText();
					}
				}
			}
		});
		btn7.setBounds(12, 236, 100, 100);
		panel_1.add(btn7);

		btn8.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn8.getText().equals("")) {
						btn8.setText("X");
						pos[7] = btn8.getText();
					}
				} else {
					if (btn8.getText().equals("")) {
						btn8.setText("O");
						pos[7] = btn8.getText();
					}
				}
			}
		});
		btn8.setBounds(124, 236, 100, 100);
		panel_1.add(btn8);

		btn9.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Jogador1Ativo) {
					if (btn9.getText().equals("")) {
						btn9.setText("X");
						pos[8] = btn9.getText();
					}
				} else {
					if (btn9.getText().equals("")) {
						btn9.setText("O");
						pos[8] = btn9.getText();
					}
				}
			}
		});
		btn9.setBounds(236, 236, 100, 100);
		panel_1.add(btn9);

		JPanel panel = new JPanel();
		panel.setBounds(369, 11, 189, 230);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblJogadorX = new JLabel("Jogador 1 - Simbolo: X");
		lblJogadorX.setBounds(10, 169, 169, 14);
		panel.add(lblJogadorX);

//		lblNmeroDeVitoriasX.setText("N\u00FAmero de vit\u00F3rias: 0");
//		lblNmeroDeVitoriasX.setBounds(10, 71, 169, 14);
//		panel.add(lblNmeroDeVitoriasX);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 153, 169, 2);
		panel.add(separator);

		JLabel lblJogadorO = new JLabel("Jogador 2 - Simbolo: O");
		lblJogadorO.setBounds(10, 197, 169, 14);
		panel.add(lblJogadorO);

//		lblNmeroDeVitoriasO.setText("N\u00FAmero de vit\u00F3rias: 0");
//		lblNmeroDeVitoriasO.setBounds(10, 130, 169, 14);
//		panel.add(lblNmeroDeVitoriasO);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 155, 169, -1);
		panel.add(separator_1);

//		lblNmeroDeEmpates.setText("N\u00FAmero de empates: 0");
//		lblNmeroDeEmpates.setBounds(10, 166, 169, 14);
//		panel.add(lblNmeroDeEmpates);

		JLabel lblIp = new JLabel("IP");
		lblIp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIp.setBounds(10, 17, 38, 14);
		panel.add(lblIp);

		ip = new JTextField();
		ip.setBounds(48, 14, 131, 20);
		panel.add(ip);
		ip.setColumns(10);

		JLabel lblNewLabel = new JLabel("Porta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 51, 38, 14);
		panel.add(lblNewLabel);

		port = new JTextField();
		port.setColumns(10);
		port.setBounds(48, 48, 131, 20);
		panel.add(port);

		JLabel lblNick = new JLabel("Nick");
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setBounds(10, 85, 38, 14);
		panel.add(lblNick);

		nick = new JTextField();
		nick.setColumns(10);
		nick.setBounds(48, 82, 131, 20);
		panel.add(nick);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(13, 116, 74, 23);
		panel.add(btnEntrar);

		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((nick.getText().equals("")) || (nick.getText().equals(" "))) {
					try {
						JOptionPane.showMessageDialog(null, "Você nao colocou seu nick!");
					} catch (ExceptionInInitializerError exc) {
					}
					return;
				}
				new criarThread("CreateButton");
			}
		});
		btnCriar.setBounds(100, 116, 74, 23);
		panel.add(btnCriar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Controle Do Jogo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(369, 252, 187, 99);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNovoJogo.setBounds(10, 17, 167, 23);
		panel_2.add(btnNovoJogo);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		btnSair.setBounds(10, 57, 167, 23);
		panel_2.add(btnSair);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 368, 548, 99);
		contentPane.add(scrollPane);

		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent event) {
				try {
					InetAddress thisIp = InetAddress.getLocalHost();
					ip.setText(thisIp.getHostAddress());
				} catch (Exception e) {
					ip.setText("127.0.0.1");
				}
			}

			public void windowClosing(WindowEvent event) {
				if (sockets != null) {
					enviarMensagem("Offline!");
				}
				encerrarTudo();
			}
		});

	}

	private class criarThread implements Runnable {
		public criarThread(String name) {
			new Thread(this, name).start();
		}

		public void run() {
			try {
				join.setEnabled(false);
				create.setEnabled(false);
				port.setEnabled(false);
				nick.setEnabled(false);

				serverSocket = new ServerSocket(Integer.parseInt(port.getText()));

				textArea.append("Esperando cliente...\n");
				ScrollToBottom();
				sockets = serverSocket.accept();

				saida = new ObjectOutputStream(sockets.getOutputStream());
				saida.flush();
				entrada = new ObjectInputStream(sockets.getInputStream());
				enviarMensagem(nick.getText() + ": conectado com sucesso!");
				textArea.append("Cliente conectado com sucesso!\n");
				ScrollToBottom();

				xo = "X";
				sinal = true;

				nick1 = nick.getText();

				enviarMensagem(nick1);

				msg = ((String) entrada.readObject());
				nick2 = ("" + msg);

				estadoButton(true);
				message.setEditable(true);
				ip.setEnabled(false);

				textArea.append("X joga primeiro!\n");
				ScrollToBottom();
				new recebeMensagem("recebeData");
			} catch (Exception e) {
				encerrarTudo();
				executarTudo();
				try {
					JOptionPane.showMessageDialog(null, "Erro ao criar o jogo:\n" + e);
				} catch (ExceptionInInitializerError exc) {
				}
			}
		}
	}

	private void enviarMensagem(String p) {
		try {
			if (pararSinal) {
				saida.writeObject(p);
				saida.flush();
			}
		} catch (SocketException e) {
			if (pararSinal) {
				pararSinal = false;
				encerrarTudo();
				executarTudo();
			}
		} catch (Exception e) {
			if (pararSinal) {
				pararSinal = false;
				encerrarTudo();
				executarTudo();
				try {
					JOptionPane.showMessageDialog(null, "Fluxo de dados desconectado:\n" + e);
				} catch (ExceptionInInitializerError exc) {
				}
			}
		}
	}

	private class recebeMensagem implements Runnable {
		private boolean auxsinal;
		private String rmsg;

		public recebeMensagem(String i) {
			auxsinal = true;
			rmsg = i;
			new Thread(this, rmsg).start();
		}

		public void run() {
			while (auxsinal) {
				try {
					if (rmsg.equals("Recebe")) {
						if (msg.equalsIgnoreCase("true")) {
							sinal = true;
						} else if (msg.equalsIgnoreCase("false")) {
							sinal = false;
						} else if (msg.equalsIgnoreCase("desenha!")) {
							JOptionPane.showMessageDialog(null, "Empate!");
						} else if (msg.equalsIgnoreCase("novojogo!")) {
							for (int i = 0; i < pos.length; i++) {
								pos[i] = "";
							}
							sinal = true;
							estadoButton(true);
						} else if (msg.equalsIgnoreCase("X1")) {
							btn1.setText("X");
							pos[0] = "X";
							btn1.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X2")) {
							btn2.setText("X");
							pos[1] = "X";
							btn2.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X3")) {
							btn3.setText("X");
							pos[2] = "X";
							btn3.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X4")) {
							btn4.setText("X");
							pos[3] = "X";
							btn4.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X5")) {
							btn5.setText("X");
							pos[4] = "X";
							btn5.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X6")) {
							btn6.setText("X");
							pos[5] = "X";
							btn6.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X7")) {
							btn7.setText("X");
							pos[6] = "X";
							btn7.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X8")) {
							btn8.setText("X");
							pos[7] = "X";
							btn8.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X9")) {
							btn9.setText("X");
							pos[8] = "X";
							btn9.setEnabled(false);
							checaJogo();
						} else {
							textArea.append(nick1 + ":" + msg + "\n");
							ScrollToBottom();
						}
					} else if (rmsg.equals("recebeData")) {
						if (msg.equalsIgnoreCase("true")) {
							sinal = true;
						} else if (msg.equalsIgnoreCase("O1")) {
							// access$4604(this);
							btn1.setText("O");
							pos[0] = "O";
							btn1.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O2")) {
							btn2.setText("O");
							pos[1] = "O";
							btn2.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O3")) {
							btn3.setText("O");
							pos[2] = "O";
							btn3.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O4")) {
							btn4.setText("O");
							pos[3] = "O";
							btn4.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O5")) {
							btn5.setText("O");
							pos[4] = "O";
							btn5.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O6")) {
							btn6.setText("O");
							pos[5] = "O";
							btn6.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O7")) {
							btn7.setText("O");
							pos[6] = "O";
							btn7.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O8")) {
							// access$4604(this);
							btn8.setText("O");
							pos[7] = "O";
							btn8.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O9")) {
							// access$4604(this);
							btn9.setText("O");
							pos[8] = "O";
							btn9.setEnabled(false);
							checaJogo();
						} else {
							textArea.append(nick2 + ":" + msg + "\n");
							ScrollToBottom();
						}
					}
				} catch (Exception e) {
					auxsinal = false;
					encerrarTudo();
					executarTudo();
					try {
						JOptionPane.showMessageDialog(null, "Receiving Data Failed/Disconnect:\n" + e);
					} catch (ExceptionInInitializerError exc) {
					}
				}
			}
		}
	}

	private void executarTudo() {
		pararSinal = true;
		for (int i = 0; i < pos.length; i++) {
			pos[i] = "";
		}
		ip.setEnabled(true);
		port.setEnabled(true);
		nick.setEnabled(true);
		create.setEnabled(true);
		join.setEnabled(true);

		setEnabled(false);
		message.setEditable(false);
	}

	private void encerrarTudo() {
		try {
			saida.flush();
		} catch (Exception e) {
		}
		try {
			saida.close();
		} catch (Exception e) {
		}
		try {
			entrada.close();
		} catch (Exception e) {
		}
		try {
			serverSocket.close();
		} catch (Exception e) {
		}
		try {
			sockets.close();
		} catch (Exception e) {
		}
	}

	public void ScrollToBottom() {
		textArea.setCaretPosition(textArea.getText().length());
	}

}
