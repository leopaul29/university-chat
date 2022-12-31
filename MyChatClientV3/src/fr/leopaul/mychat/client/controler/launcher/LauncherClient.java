package fr.leopaul.mychat.client.controler.launcher;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.leopaul.mychat.client.model.reseau.Client;

public class LauncherClient extends JFrame {

	public static void main(String[] args) {
		
		Client client = new Client("localhost", 45000);
		
		new LauncherClient(client);
	}

	private JPanel panel;
	private TextArea textZone;
	private TextField textMsg;
	private Client client;
	
	public LauncherClient(Client client) {
		super("MyChat - Client");
		
		this.client = client;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 150);
		this.setSize(700, 400);

		init();

		this.getContentPane().add(this.panel);

		this.setVisible(true);
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
		textMsg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panControl.add(textMsg, BorderLayout.CENTER);

		this.panel.add(panControl, BorderLayout.SOUTH);
	}
}
