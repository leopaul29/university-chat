package fr.leopaul.mychat.client.vue.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogConnexion extends JDialog {

	private JTextField hostName;
	private JTextField port;
	private JButton jbOK;
	private JButton jbClose;

	public DialogConnexion(JFrame parent, boolean modal) {
		super(parent, modal);
		this.setTitle("Connexion to ...");
		this.setSize(500, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());

		this.init();
	}

	private void init() {
		// Le nom
		JPanel panHost = new JPanel();
		panHost.setPreferredSize(new Dimension(220, 60));

		JLabel lbHostName = new JLabel("Hostname :");
		hostName = new JTextField("127.0.0.1", 20);
		panHost.add(lbHostName);
		panHost.add(hostName);

		JLabel lbPort = new JLabel("Port :");
		port = new JTextField(6);

		panHost.add(lbPort);
		panHost.add(port);
		
		this.getContentPane().add(panHost, BorderLayout.CENTER);
		
		JPanel panControl = new JPanel();
		jbOK = new JButton("OK");
		jbClose = new JButton("Close");

		panControl.add(jbOK);
		panControl.add(jbClose);

		this.getContentPane().add(panControl, BorderLayout.SOUTH);
	}
	
	public void showDialog() {
		this.setVisible(true);
	}
	
	public void close() {
		this.setVisible(false);
	}

	public JTextField getHostName() {
		return hostName;
	}

	public void setHostName(JTextField hostName) {
		this.hostName = hostName;
	}

	public JTextField getPort() {
		return port;
	}

	public void setPort(JTextField port) {
		this.port = port;
	}

	public JButton getJbOK() {
		return jbOK;
	}

	public void setJbOK(JButton jbOK) {
		this.jbOK = jbOK;
	}

	public JButton getJbClose() {
		return jbClose;
	}

	public void setJbClose(JButton jbClose) {
		this.jbClose = jbClose;
	}
}
