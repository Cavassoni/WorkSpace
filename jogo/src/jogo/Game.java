package jogo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private ServerSocket serverSocket = null;
	private Socket sockets = null;
	private ObjectInputStream entrada = null;
	private ObjectOutputStream saida = null;
	private String[] jogo = { "", "", "", "", "", "", "", "", "" };
	private String xo = "";
	private String nick1;
	private String nick2;
	private String msg;
	private boolean sinal;
	private boolean pararSinal = true;
	private int numPartidas = 0;
	private int numJogadas = 0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton create;
	private JTextField ip;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JButton join;
	private JTextField message;
	private JButton newGame;
	private JTextField nick;
	private JTextField port;
	private JScrollPane sp;
	private JTextArea textArea;

	public Game() {
		initComponents();
		setSize(499, 407);
		setTitle("Jogo da Velha");
		setResizable(false);
		setLocationRelativeTo(this);
		inicia();

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

	private void initComponents() {
		ip = new JTextField();
		port = new JTextField();
		nick = new JTextField();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jPanel1 = new JPanel();
		newGame = new JButton();
		create = new JButton();
		join = new JButton();
		jPanel2 = new JPanel();
		sp = new JScrollPane();
		textArea = new JTextArea();
		message = new JTextField();
		jPanel3 = new JPanel();
		b3 = new JButton();
		b2 = new JButton();
		b1 = new JButton();
		b4 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();
		b6 = new JButton();
		b5 = new JButton();

		setDefaultCloseOperation(3);
		getContentPane().setLayout(null);
		
		
		ip.setText("jTextField1");
		getContentPane().add(ip);
		ip.setBounds(40, 20, 140, 30);

		port.setText("jTextField2");
		getContentPane().add(port);
		port.setBounds(230, 20, 70, 30);

		nick.setText("jTextField3");
		getContentPane().add(nick);
		nick.setBounds(340, 20, 140, 30);

		jLabel1.setText("Nick:");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(310, 20, 30, 30);

		jLabel2.setText("IP:");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(20, 20, 14, 30);

		jLabel3.setText("Porta:");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(190, 20, 40, 30);

		jPanel1.setLayout(null);

		newGame.setText("Recomeçar");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newGameActionPerformed(evt);
			}
		});
		jPanel1.add(newGame);
		newGame.setBounds(340, 60, 140, 30);

		create.setText("Criar");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				createActionPerformed(evt);
			}
		});
		jPanel1.add(create);
		create.setBounds(140, 60, 90, 30);

		join.setText("Entrar");
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				joinActionPerformed(evt);
			}
		});
		jPanel1.add(join);
		join.setBounds(40, 60, 90, 30);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 520, 100);

		jPanel2.setLayout(null);

		textArea.setColumns(20);
		textArea.setLineWrap(true);
		textArea.setRows(5);
		sp.setViewportView(textArea);

		jPanel2.add(sp);
		sp.setBounds(20, 30, 470, 96);

		getContentPane().add(jPanel2);
		jPanel2.setBounds(0, 360, 520, 240);

		jPanel3.setLayout(null);

		b3.setText("jButton1");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b3ActionPerformed(evt);
			}
		});
		jPanel3.add(b3);
		b3.setBounds(300, 10, 90, 80);

		b2.setText("jButton1");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b2ActionPerformed(evt);
			}
		});
		jPanel3.add(b2);
		b2.setBounds(210, 10, 90, 80);

		b1.setText("jButton1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b1ActionPerformed(evt);
			}
		});
		jPanel3.add(b1);
		b1.setBounds(120, 10, 90, 80);

		b4.setText("jButton1");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b4ActionPerformed(evt);
			}
		});
		jPanel3.add(b4);
		b4.setBounds(120, 90, 90, 80);

		b7.setText("jButton1");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b7ActionPerformed(evt);
			}
		});
		jPanel3.add(b7);
		b7.setBounds(120, 170, 90, 80);

		b8.setText("jButton1");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b8ActionPerformed(evt);
			}
		});
		jPanel3.add(b8);
		b8.setBounds(210, 170, 90, 80);

		b9.setText("jButton1");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b9ActionPerformed(evt);
			}
		});
		jPanel3.add(b9);
		b9.setBounds(300, 170, 90, 80);

		b6.setText("jButton1");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b6ActionPerformed(evt);
			}
		});
		jPanel3.add(b6);
		b6.setBounds(300, 90, 90, 80);

		b5.setText("jButton1");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b5ActionPerformed(evt);
			}
		});
		jPanel3.add(b5);
		b5.setBounds(210, 90, 90, 80);

		getContentPane().add(jPanel3);
		jPanel3.setBounds(0, 100, 520, 260);

		pack();
	}

	private void b1ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b1.setText(xo);
			enviarMensagem(xo + "1");
			enviarMensagem("true");
			sinal = false;
			b1.setEnabled(false);
			if (xo.equals("X")) {
				jogo[0] = "X";
			} else {
				jogo[0] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b2ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b2.setText(xo);
			enviarMensagem(xo + "2");
			enviarMensagem("true");
			sinal = false;
			b2.setEnabled(false);
			if (xo.equals("X")) {
				jogo[1] = "X";
			} else {
				jogo[1] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b3ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b3.setText(xo);
			enviarMensagem(xo + "3");
			enviarMensagem("true");
			sinal = false;
			b3.setEnabled(false);
			if (xo.equals("X")) {
				jogo[2] = "X";
			} else {
				jogo[2] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b4ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b4.setText(xo);
			enviarMensagem(xo + "4");
			enviarMensagem("true");
			sinal = false;
			b4.setEnabled(false);
			if (xo.equals("X")) {
				jogo[3] = "X";
			} else {
				jogo[3] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b5ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b5.setText(xo);
			enviarMensagem(xo + "5");
			enviarMensagem("true");
			sinal = false;
			b5.setEnabled(false);
			if (xo.equals("X")) {
				jogo[4] = "X";
			} else {
				jogo[4] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b6ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b6.setText(xo);
			enviarMensagem(xo + "6");
			enviarMensagem("true");
			sinal = false;
			b6.setEnabled(false);
			if (xo.equals("X")) {
				jogo[5] = "X";
			} else {
				jogo[5] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b7ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b7.setText(xo);
			enviarMensagem(xo + "7");
			enviarMensagem("true");
			sinal = false;
			b7.setEnabled(false);
			if (xo.equals("X")) {
				jogo[6] = "X";
			} else {
				jogo[6] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b8ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b8.setText(xo);
			enviarMensagem(xo + "8");
			enviarMensagem("true");
			sinal = false;
			b8.setEnabled(false);
			if (xo.equals("X")) {
				jogo[7] = "X";
			} else {
				jogo[7] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void b9ActionPerformed(ActionEvent evt) {
		if (sinal) {
			b9.setText(xo);
			enviarMensagem(xo + "9");
			enviarMensagem("true");
			sinal = false;
			b9.setEnabled(false);
			if (xo.equals("X")) {
				jogo[8] = "X";
			} else {
				jogo[8] = "O";
			}
			numJogadas += 1;
			checaJogo();
		}
	}

	private void newGameActionPerformed(ActionEvent evt) {
		enviarMensagem("novojogo");

		numPartidas += 1;
		for (int i = 0; i < jogo.length; i++) {
			jogo[i] = "";
		}
		if (numPartidas % 2 == 0) {
			sinal = true;
			textArea.append("X joga primeiro!\n");
			ScrollToBottom();
			enviarMensagem("false");
			enviarMensagem("X joga primeiro!");
		} else {
			sinal = false;
			enviarMensagem("true");
			textArea.append("O joga primeiro!\n");
			ScrollToBottom();
			enviarMensagem("O joga primeiro!");
		}
		buttonDefault();
		estadoButton(true);
		newGame.setEnabled(false);
	}

	private void joinActionPerformed(ActionEvent evt) {
		try {
			if ((nick.getText().equals("")) || (nick.getText().equals(" "))) {
				try {
					JOptionPane.showMessageDialog(null, "Você nao colocou seu nick!");
				} catch (ExceptionInInitializerError exc) {
				}
				return;
			}
			sockets = new Socket(ip.getText(), Integer.parseInt(port.getText()));

			saida = new ObjectOutputStream(sockets.getOutputStream());
			saida.flush();
			entrada = new ObjectInputStream(sockets.getInputStream());

			msg = ((String) entrada.readObject());
			textArea.append(msg + "\n");
			ScrollToBottom();

			xo = "O";
			sinal = false;

			nick2 = nick.getText();

			msg = ((String) entrada.readObject());
			nick1 = ("" + msg);

			enviarMensagem(nick2);

			estadoButton(true);
			message.setEditable(true);

			ip.setEnabled(false);
			port.setEnabled(false);
			nick.setEnabled(false);

			textArea.append("X joga primeiro!\n");
			ScrollToBottom();

			join.setEnabled(false);
			create.setEnabled(false);
			ip.setEnabled(false);
			port.setEnabled(false);
			nick.setEnabled(false);

			new recebeMensagem("Recebe");
		} catch (Exception e) {
			encerrarTudo();
			executarTudo();
			try {
				JOptionPane.showMessageDialog(null, "Erro server esta offline: \n" + e);
			} catch (ExceptionInInitializerError exc) {
			}
		}
	}

	private void createActionPerformed(ActionEvent evt) {
		if ((nick.getText().equals("")) || (nick.getText().equals(" "))) {
			try {
				JOptionPane.showMessageDialog(null, "Você nao colocou seu nick!");
			} catch (ExceptionInInitializerError exc) {
			}
			return;
		}
		new criarThread("CreateButton");
	}


	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Game().setVisible(true);
			}
		});
	}

	public void inicia() {
		b1.setText("");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		b5.setText("");
		b6.setText("");
		b7.setText("");
		b8.setText("");
		b9.setText("");
		port.setText("5000");
		nick.setText("");
		textArea.setEditable(false);
		estadoButton(false);
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

	private void checaJogo() {
		if (((jogo[0].equals("X")) && (jogo[1].equals("X")) && (jogo[2].equals("X")))
				|| ((jogo[3].equals("X")) && (jogo[4].equals("X")) && (jogo[5].equals("X")))
				|| ((jogo[6].equals("X")) && (jogo[7].equals("X")) && (jogo[8].equals("X")))
				|| ((jogo[0].equals("X")) && (jogo[3].equals("X")) && (jogo[6].equals("X")))
				|| ((jogo[1].equals("X")) && (jogo[4].equals("X")) && (jogo[7].equals("X")))
				|| ((jogo[2].equals("X")) && (jogo[5].equals("X")) && (jogo[8].equals("X")))
				|| ((jogo[0].equals("X")) && (jogo[4].equals("X")) && (jogo[8].equals("X")))
				|| ((jogo[2].equals("X")) && (jogo[4].equals("X")) && (jogo[6].equals("X")))) {
			numJogadas = 0;
			estadoButton(false);
			JOptionPane.showMessageDialog(null, nick1 + " ganhou!");
			if (xo.equals("X")) {
				newGame.setEnabled(true);
			}
		} else if (((jogo[0].equals("O")) && (jogo[1].equals("O")) && (jogo[2].equals("O")))
				|| ((jogo[3].equals("O")) && (jogo[4].equals("O")) && (jogo[5].equals("O")))
				|| ((jogo[6].equals("O")) && (jogo[7].equals("O")) && (jogo[8].equals("O")))
				|| ((jogo[0].equals("O")) && (jogo[3].equals("O")) && (jogo[6].equals("O")))
				|| ((jogo[1].equals("O")) && (jogo[4].equals("O")) && (jogo[7].equals("O")))
				|| ((jogo[2].equals("O")) && (jogo[5].equals("O")) && (jogo[8].equals("O")))
				|| ((jogo[0].equals("O")) && (jogo[4].equals("O")) && (jogo[8].equals("O")))
				|| ((jogo[2].equals("O")) && (jogo[4].equals("O")) && (jogo[6].equals("O")))) {
			numJogadas = 0;
			estadoButton(false);
			JOptionPane.showMessageDialog(null, nick2 + " ganhou!");
			if (xo.equals("X")) {
				newGame.setEnabled(true);
			}
		} else if (numJogadas >= 9) {
			numJogadas = 0;
			enviarMensagem("desenha!");
			JOptionPane.showMessageDialog(null, "Empate!");
			if (xo.equals("X")) {
				newGame.setEnabled(true);
			}
		}
	}

	private void estadoButton(boolean b) {
		b1.setEnabled(b);
		b2.setEnabled(b);
		b3.setEnabled(b);
		b4.setEnabled(b);
		b5.setEnabled(b);
		b6.setEnabled(b);
		b7.setEnabled(b);
		b8.setEnabled(b);
		b9.setEnabled(b);
	}

	private void buttonDefault() {
		b1.setText("");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		b5.setText("");
		b6.setText("");
		b7.setText("");
		b8.setText("");
		b9.setText("");
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
					msg = "";
					msg = ((String) entrada.readObject());
					if (rmsg.equals("Recebe")) {
						if (msg.equalsIgnoreCase("true")) {
							sinal = true;
						} else if (msg.equalsIgnoreCase("false")) {
							sinal = false;
						} else if (msg.equalsIgnoreCase("desenha!")) {
							JOptionPane.showMessageDialog(null, "Empate!");
						} else if (msg.equalsIgnoreCase("novojogo!")) {
							for (int i = 0; i < jogo.length; i++) {
								jogo[i] = "";
							}
							sinal = true;
							buttonDefault();
							estadoButton(true);
						} else if (msg.equalsIgnoreCase("X1")) {
							b1.setText("X");
							jogo[0] = "X";
							b1.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X2")) {
							b2.setText("X");
							jogo[1] = "X";
							b2.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X3")) {
							b3.setText("X");
							jogo[2] = "X";
							b3.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X4")) {
							b4.setText("X");
							jogo[3] = "X";
							b4.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X5")) {
							b5.setText("X");
							jogo[4] = "X";
							b5.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X6")) {
							b6.setText("X");
							jogo[5] = "X";
							b6.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X7")) {
							b7.setText("X");
							jogo[6] = "X";
							b7.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X8")) {
							b8.setText("X");
							jogo[7] = "X";
							b8.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("X9")) {
							b9.setText("X");
							jogo[8] = "X";
							b9.setEnabled(false);
							checaJogo();
						} else {
							textArea.append(nick1 + ":" + msg + "\n");
							ScrollToBottom();
						}
					} else if (rmsg.equals("recebeData")) {
						if (msg.equalsIgnoreCase("true")) {
							sinal = true;
						} else if (msg.equalsIgnoreCase("O1")) {
							b1.setText("O");
							jogo[0] = "O";
							b1.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O2")) {
							b2.setText("O");
							jogo[1] = "O";
							b2.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O3")) {
							b3.setText("O");
							jogo[2] = "O";
							b3.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O4")) {
							b4.setText("O");
							jogo[3] = "O";
							b4.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O5")) {
							b5.setText("O");
							jogo[4] = "O";
							b5.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O6")) {
							b6.setText("O");
							jogo[5] = "O";
							b6.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O7")) {
							b7.setText("O");
							jogo[6] = "O";
							b7.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O8")) {
							b8.setText("O");
							jogo[7] = "O";
							b8.setEnabled(false);
							checaJogo();
						} else if (msg.equalsIgnoreCase("O9")) {
							b9.setText("O");
							jogo[8] = "O";
							b9.setEnabled(false);
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
		buttonDefault();
		estadoButton(false);

		msg = "";
		xo = "";
		pararSinal = true;
		numJogadas = 0;
		numPartidas = 0;
		for (int i = 0; i < jogo.length; i++) {
			jogo[i] = "";
		}
		ip.setEnabled(true);
		port.setEnabled(true);
		nick.setEnabled(true);
		create.setEnabled(true);
		join.setEnabled(true);

		newGame.setEnabled(false);
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
