package fr.leopaul.mychat.client.vue.menu;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowMenu extends JFrame {

	private JPanel panel;
	
	public WindowMenu() {
		super("ChatManager");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 300);
		
		init();
		
		this.getContentPane().add(panel);
		
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(1, 3));

		JPanel panIP = new JPanel();
		Label labelIP = new Label("IP : ");
		TextField tfIP = new TextField();
		try {
			tfIP.setText(InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panIP.add(labelIP);
		panIP.add(tfIP);
		
		JPanel panPort = new JPanel();
		Label labelPort = new Label("Port : ");
		TextField tfPort = new TextField(6);
		panPort.add(labelPort);
		panPort.add(tfPort);
		
		JPanel panControl = new JPanel();
		JButton jbStart = new JButton("Start");
		
		jbStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ip = tfIP.getText();
				System.out.println("ip:"+ip);
				
				int port = Integer.parseInt(tfPort.getText());
				System.out.println("port:"+port);
				
				
			}
		});

		JButton jbStop = new JButton("Stop");
		jbStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		panControl.add(jbStart);
		panControl.add(jbStop);
		
		this.panel.add(panIP);
		this.panel.add(panPort);
		this.panel.add(panControl);
	}

}
