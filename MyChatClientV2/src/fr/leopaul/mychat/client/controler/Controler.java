package fr.leopaul.mychat.client.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import fr.leopaul.mychat.client.model.reseau.Client;
import fr.leopaul.mychat.client.vue.menu.DialogConnexion;
import fr.leopaul.mychat.client.vue.menu.WindowChat;

public class Controler implements ActionListener, Observer {

	private WindowChat vue;
	private Client client;
	private DialogConnexion dialogConnexion;

	public Controler() {
		this.vue = new WindowChat();
		this.dialogConnexion = new DialogConnexion(vue, true);

		this.addListeners();
	}

	private void addListeners() {
		this.vue.getStartConnexion().addActionListener(this);
		this.vue.getStopConnexion().addActionListener(this);
		this.vue.getQuit().addActionListener(this);

		this.vue.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stopClient();
			}
		});

		this.vue.getTextMsg().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					writeMsg();
				}
			}
		});

		this.dialogConnexion.getJbOK().addActionListener(this);
		this.dialogConnexion.getJbClose().addActionListener(this);
	}

	private void startClient(String hostname, int port) {
		this.client = new Client(hostname, port);
		this.client.addObserver(this);
		this.client.start();
	}

	protected void stopClient() {
		if (this.client != null && this.client.isAlive()) {
			this.client.stop();
			this.client.write("exit");
			this.client.deleteObserver(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vue.getStartConnexion()) {
			this.dialogConnexion.showDialog();
		}

		else if (e.getSource() == this.vue.getStopConnexion()) {
			stopClient();
		}

		else if (e.getSource() == this.vue.getQuit()) {
			stopClient();
			System.exit(0);
		}

		else if (e.getSource().equals(this.dialogConnexion.getJbOK())) {
			String hostname = this.dialogConnexion.getHostName().getText();
			int port = 45000;
			try {
				port = Integer.parseInt(this.dialogConnexion.getPort().getText());
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}

			this.startClient(hostname, port);

			this.dialogConnexion.close();
		}

		else if (e.getSource().equals(this.dialogConnexion.getJbClose())) {
			this.dialogConnexion.close();
		}
	}

	private void writeMsg() {
		if(this.client == null || !this.client.isAlive()) return;
		
		String text = this.vue.getTextMsg().getText();

		if (text != null && text.trim().length() != 0) {
			this.client.write(text);
			clearTextMsg();
		}
	}

	private void readMsg(String text) {
		this.vue.getTextZone().append(text + "\n");
	}

	private void clearTextMsg() {
		this.vue.getTextMsg().setText("");
	}

	@Override
	public void update(Observable client, Object o) {
		String text = (String) o;
		readMsg(text);
	}

}
