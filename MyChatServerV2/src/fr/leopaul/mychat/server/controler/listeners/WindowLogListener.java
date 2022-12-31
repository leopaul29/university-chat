package fr.leopaul.mychat.server.controler.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.leopaul.mychat.server.controler.Controler;

public class WindowLogListener implements ActionListener {

	private Controler controler;

	public WindowLogListener(Controler controler) {
		this.controler = controler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("start")) {
			controler.startServer();
		}
		
		else if(e.getActionCommand().equals("stop")) {
			controler.stopServer();
		}
	}

}
