package fr.leopaul.mychat.server.vue.log;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowLog extends JFrame {

	private JPanel panel;
	private JTextArea txtaLog;
	private JButton butStart;
	private JButton butStop;
	private JTextField txtfPort;

	public WindowLog() {
		super("MyChat - Log server");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 150);
		this.setSize(700, 400);
		
		initComponents();
		
		this.getContentPane().add(panel);
		
//		this.pack();
		this.setVisible(true);
	}
	
	private void initComponents() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		txtaLog = new JTextArea();
		txtaLog.setEditable(false);
		panel.add(txtaLog, BorderLayout.CENTER);
		
		
		butStart = new JButton("Start");
		butStart.setActionCommand("start");
		
		butStop = new JButton("Stop");
		butStop.setActionCommand("stop");
		
		txtfPort = new JTextField(10);
		
		JPanel panControl = new JPanel();
		panControl.add(butStart);
		panControl.add(txtfPort);
		panControl.add(butStop);
		
		panel.add(panControl, BorderLayout.SOUTH);
	}

	public JTextArea getTxtaLog() {
		return txtaLog;
	}

	public JButton getButStart() {
		return butStart;
	}

	public JButton getButStop() {
		return butStop;
	}

	public JTextField getTxtfPort() {
		return txtfPort;
	}

}
