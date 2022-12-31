package fr.leopaul.mychat.client.vue.menu;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class WindowChat extends JFrame {

	private JPanel panel;

	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem startConnexion = new JMenuItem("Start connexion");
	private JMenuItem stopConnexion = new JMenuItem("Stop connexion");

	private TextField textMsg;

	private TextArea textZone;

	public WindowChat() {
		super("Chatroom");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 150);
		this.setSize(700, 400);

		init();
		initMenu();

		this.getContentPane().add(this.panel);

		this.setVisible(true);
	}

	private void initMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu connexion = new JMenu("Connexion");
		
		connexion.add(startConnexion);
		connexion.add(stopConnexion);
		connexion.addSeparator();
		connexion.add(quit);
		
		menuBar.add(connexion);
		
		startConnexion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
	}

	private void init() {
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());

		textZone = new TextArea();
		textZone.setEditable(false);
		
		this.panel.add(textZone, BorderLayout.CENTER);

		JPanel panControl = new JPanel();
		panControl.setLayout(new BorderLayout());

		textMsg = new TextField();
		textMsg.requestFocus();
		panControl.add(textMsg, BorderLayout.CENTER);

		this.panel.add(panControl, BorderLayout.SOUTH);
	}

	public TextArea getTextZone() {
		return textZone;
	}

	public void setTextZone(TextArea textZone) {
		this.textZone = textZone;
	}

	public TextField getTextMsg() {
		return textMsg;
	}

	public void setTextMsg(TextField textMsg) {
		this.textMsg = textMsg;
	}

	public JMenuItem getQuit() {
		return quit;
	}

	public void setQuit(JMenuItem quit) {
		this.quit = quit;
	}

	public JMenuItem getStartConnexion() {
		return startConnexion;
	}

	public void setStartConnexion(JMenuItem startConnexion) {
		this.startConnexion = startConnexion;
	}

	public JMenuItem getStopConnexion() {
		return stopConnexion;
	}

	public void setStopConnexion(JMenuItem stopConnexion) {
		this.stopConnexion = stopConnexion;
	}
}
